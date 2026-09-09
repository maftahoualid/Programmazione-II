#!/usr/bin/env bash
if [[ "${BASH_SOURCE[0]}" == "${0}" ]]; then
    set -e
fi

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
POM_FILE="$ROOT_DIR/pom.xml"

# Colori per il terminale
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
BOLD='\033[1m'
NC='\033[0m' # No Color

# Funzione ausiliaria per sed portabile (Linux GNU e macOS BSD)
function sed_i() {
    if [[ "$OSTYPE" == "darwin"* ]]; then
        sed -i '' "$@"
    else
        sed -i "$@"
    fi
}

function print_header() {
    echo -e "${BLUE}${BOLD}=== Raccolta Esercizi Java ===${NC}\n"
}

function get_modules() {
    if [ ! -f "$POM_FILE" ]; then
        return
    fi
    # Rimuove commenti XML (anche su più righe) prima di cercare i moduli
    if command -v perl >/dev/null 2>&1; then
        perl -0777 -pe 's/<!--.*?-->//gs' "$POM_FILE" | grep -oP '(?<=<module>)[^<]+' | tr -d ' \t\r' || true
    else
        sed -e 's/<!--.*-->//g' "$POM_FILE" | grep -oP '(?<=<module>)[^<]+' | tr -d ' \t\r' || true
    fi
}

function get_parent_info() {
    local group_id=""
    local artifact_id=""
    local version=""

    if [ -f "$POM_FILE" ]; then
        group_id=$(grep -m1 -oP '(?<=<groupId>)[^<]+' "$POM_FILE" | tr -d ' \t\r' || true)
        artifact_id=$(grep -m1 -oP '(?<=<artifactId>)[^<]+' "$POM_FILE" | tr -d ' \t\r' || true)
        version=$(grep -m1 -oP '(?<=<version>)[^<]+' "$POM_FILE" | tr -d ' \t\r' || true)
    fi

    echo "${group_id:-it.esercizi} ${artifact_id:-raccolta-esercizi} ${version:-1.0-SNAPSHOT}"
}

function get_next_exercise_name() {
    local modules=($(get_modules))
    if [ ${#modules[@]} -eq 0 ]; then
        echo "es01"
        return
    fi

    local max_num=0
    local width=2
    local prefix="es"

    for mod in "${modules[@]}"; do
        if [[ "$mod" =~ ^(.*[^0-9]|)([0-9]+)$ ]]; then
            local pfx="${BASH_REMATCH[1]}"
            local num_str="${BASH_REMATCH[2]}"
            local num=$((10#$num_str))
            prefix="$pfx"
            if [ $num -gt $max_num ]; then
                max_num=$num
                if [ ${#num_str} -ge $width ]; then
                    width=${#num_str}
                fi
            fi
        fi
    done

    local next_num=$((max_num + 1))
    printf "%s%0*d\n" "$prefix" "$width" "$next_num"
}

function sanitize_pkg() {
    local raw="$1"
    echo "$raw" | tr '[:upper:]' '[:lower:]' | sed -e 's/[^a-z0-9]/_/g' -e 's/^_*//' -e 's/_*$//'
}

function find_main_classes_in_dir() {
    local dir="$1"
    if [ ! -d "$dir" ]; then
        return
    fi
    find "$dir" -type f -name "*.java" | sort | while read -r file; do
        # Esclude righe commentate con //, /* o * per evitare falsi positivi
        if grep -v '^\s*//' "$file" | grep -v '^\s*/\*' | grep -v '^\s*\*' | grep -qP '(public\s+static|static\s+public)\s+void\s+main'; then
            local pkg=""
            pkg=$(grep -m1 -oP '^\s*package\s+\K[^;\s]+' "$file" || true)
            local cls=$(basename "$file" .java)
            if [ -n "$pkg" ]; then
                echo "${pkg}.${cls}"
            else
                echo "$cls"
            fi
        fi
    done
}

function find_junit_test_classes_in_dir() {
    local dir="$1"
    if [ ! -d "$dir" ]; then
        return
    fi
    find "$dir" -type f -name "*.java" | sort | while read -r file; do
        if grep -qP 'import\s+org\.junit\.' "$file" || grep -q '@Test' "$file"; then
            local pkg=""
            pkg=$(grep -m1 -oP '^\s*package\s+\K[^;\s]+' "$file" || true)
            local cls=$(basename "$file" .java)
            if [ -n "$pkg" ]; then
                echo "${pkg}.${cls}"
            else
                echo "$cls"
            fi
        fi
    done
}

function sync_pom_main_class() {
    local mod="$1"
    local main_class="$2"
    local pom="$ROOT_DIR/$mod/pom.xml"

    if [ -f "$pom" ] && [ -n "$main_class" ]; then
        if grep -q "<exec.mainClass>" "$pom"; then
            sed_i "s|<exec.mainClass>.*</exec.mainClass>|<exec.mainClass>${main_class}</exec.mainClass>|g" "$pom"
        elif grep -q "<properties>" "$pom"; then
            sed_i "/<properties>/a \        <exec.mainClass>${main_class}</exec.mainClass>" "$pom"
        fi

        if grep -q "<mainClass>" "$pom"; then
            if grep -q "<exec.mainClass>" "$pom"; then
                sed_i "s|<mainClass>[^<]*</mainClass>|<mainClass>\${exec.mainClass}</mainClass>|g" "$pom"
            else
                sed_i "s|<mainClass>.*</mainClass>|<mainClass>${main_class}</mainClass>|g" "$pom"
            fi
        fi
    fi
}

function find_main_classes() {
    local mod="$1"
    find_main_classes_in_dir "$ROOT_DIR/$mod/src/main/java"
}

function find_test_classes() {
    local mod="$1"
    local mains=($(find_main_classes_in_dir "$ROOT_DIR/$mod/src/test/java"))
    local junits=($(find_junit_test_classes_in_dir "$ROOT_DIR/$mod/src/test/java"))
    local all=()
    for m in "${mains[@]}"; do
        all+=("$m")
    done
    for j in "${junits[@]}"; do
        local found=false
        for a in "${all[@]}"; do
            if [ "$a" = "$j" ]; then
                found=true
                break
            fi
        done
        if [ "$found" = false ]; then
            all+=("$j")
        fi
    done
    echo "${all[@]}"
}

function is_junit_test() {
    local mod="$1"
    local test_class="$2"
    local rel_path=$(echo "$test_class" | tr '.' '/')
    local file="$ROOT_DIR/$mod/src/test/java/${rel_path}.java"

    if [ ! -f "$file" ]; then
        local simple_name="${test_class##*.}"
        file=$(find "$ROOT_DIR/$mod/src/test/java" -type f -name "${simple_name}.java" 2>/dev/null | head -n 1 || true)
    fi

    if [ -n "$file" ] && [ -f "$file" ]; then
        if grep -qP 'import\s+org\.junit\.' "$file" || grep -q '@Test' "$file"; then
            return 0
        fi
    fi
    return 1
}

function cmd_list() {
    echo -e "${BOLD}Esercizi registrati in pom.xml:${NC}"
    local modules=($(get_modules))
    if [ ${#modules[@]} -eq 0 ]; then
        echo -e "  ${YELLOW}(Nessun esercizio presente)${NC}"
        echo -e "  Usa ${BOLD}./esercizi.sh new${NC} per crearne uno."
        return
    fi

    local idx=1
    for mod in "${modules[@]}"; do
        local mains=($(find_main_classes "$mod"))
        local main_info=""
        if [ ${#mains[@]} -gt 0 ]; then
            main_info=" (main: ${GREEN}${mains[*]}${NC})"
        fi

        local tests=($(find_test_classes "$mod"))
        local test_info=""
        if [ ${#tests[@]} -gt 0 ]; then
            test_info=" (test: ${YELLOW}${tests[*]}${NC})"
        fi

        echo -e "  ${GREEN}${idx})${NC} ${BOLD}${mod}${NC}${main_info}${test_info}"
        ((idx++))
    done
    echo ""
}

function cmd_new() {
    local name="$1"
    if [ -z "$name" ]; then
        name="$(get_next_exercise_name)"
        echo -e "${YELLOW}Nessun nome specificato: prossimo esercizio -> ${BOLD}${name}${NC}"
    fi

    name="$(echo "$name" | tr '[:upper:]' '[:lower:]' | tr ' ' '-')"
    local target_dir="$ROOT_DIR/$name"

    if [ -d "$target_dir" ]; then
        echo -e "${RED}Errore: la cartella '$name' esiste già!${NC}"
        exit 1
    fi

    local pkg_name="$(sanitize_pkg "$name")"
    local src_pkg_dir="$target_dir/src/main/java/$pkg_name"
    mkdir -p "$src_pkg_dir"

    # Genera Main.java di base
    cat << JAVA_EOF > "$src_pkg_dir/Main.java"
package ${pkg_name};

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Avvio: ${name} ===");
    }
}
JAVA_EOF

    # Ricava dinamicamente i dati del genitore dal pom.xml radice
    read -r parent_grp parent_art parent_ver <<< "$(get_parent_info)"

    local junit_dep=""
    if grep -q "junit-jupiter" "$POM_FILE" 2>/dev/null; then
        junit_dep="
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>"
    fi

    # Genera pom.xml coerente con il progetto padre
    cat << POM_EOF > "$target_dir/pom.xml"
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>${parent_grp}</groupId>
        <artifactId>${parent_art}</artifactId>
        <version>${parent_ver}</version>
    </parent>

    <artifactId>${name}</artifactId>
${junit_dep}
    <properties>
        <maven.compiler.release>17</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <exec.mainClass>${pkg_name}.Main</exec.mainClass>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <mainClass>\${exec.mainClass}</mainClass>
                        </manifest>
                    </archive>
                </configuration>
                <executions>
                    <execution>
                        <id>assemble-all</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <configuration>
                    <mainClass>\${exec.mainClass}</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
POM_EOF

    # Registra il modulo in pom.xml radice
    if grep -q "</modules>" "$POM_FILE"; then
        sed_i "/<\/modules>/i \        <module>${name}<\/module>" "$POM_FILE"
    fi

    echo -e "${GREEN}✓ Esercizio '${name}' creato con successo!${NC}"
    echo -e "  Cartella modulo:  ${BOLD}${name}/${NC}"
    echo -e "  File sorgente:    ${BOLD}${name}/src/main/java/${pkg_name}/Main.java${NC}"
    echo -e "  POM modulo:       ${BOLD}${name}/pom.xml${NC}"
    echo -e "  Per eseguirlo:    ${BOLD}./esercizi.sh run ${name}${NC}"
    echo -e "  Per il JAR:       ${BOLD}./esercizi.sh package ${name}${NC}\n"
}

function resolve_target() {
    local target="$1"
    local modules=($(get_modules))

    if [ ${#modules[@]} -eq 0 ]; then
        echo ""
        return
    fi

    if [ -z "$target" ]; then
        if [ ${#modules[@]} -eq 1 ]; then
            echo "${modules[0]}"
            return
        fi
        echo -e "${BOLD}Seleziona l'esercizio:${NC}" >&2
        local idx=1
        for mod in "${modules[@]}"; do
            echo -e "  ${GREEN}${idx})${NC} ${mod}" >&2
            ((idx++))
        done
        read -rp "Numero o nome: " choice
        if [[ "$choice" =~ ^[0-9]+$ ]] && [ "$choice" -ge 1 ] && [ "$choice" -le ${#modules[@]} ]; then
            echo "${modules[$((choice - 1))]}"
            return
        else
            target="$choice"
        fi
    fi

    if [[ "$target" =~ ^[0-9]+$ ]]; then
        local num=$((10#$target))
        local formatted=$(printf "es%02d" "$num")
        if [ -d "$ROOT_DIR/$formatted" ]; then
            echo "$formatted"
            return
        elif [ "$target" -ge 1 ] && [ "$target" -le ${#modules[@]} ]; then
            echo "${modules[$((target - 1))]}"
            return
        fi
    fi

    # Normalizza prefisso + numero (es. 'es1' -> 'es01') se esiste
    if [ ! -d "$ROOT_DIR/$target" ] && [[ "$target" =~ ^([a-zA-Z_-]+)([0-9]+)$ ]]; then
        local pfx="${BASH_REMATCH[1]}"
        local num=$((10#${BASH_REMATCH[2]}))
        local formatted=$(printf "%s%02d" "$pfx" "$num")
        if [ -d "$ROOT_DIR/$formatted" ]; then
            echo "$formatted"
            return
        fi
    fi

    echo "$target"
}

function cmd_run() {
    local target=""
    local selected_main=""
    local exec_args=""
    local parsing_args=false

    # Parsing argomenti con supporto separatore '--'
    for arg in "$@"; do
        if [ "$arg" = "--" ]; then
            parsing_args=true
            continue
        fi
        if [ "$parsing_args" = true ]; then
            if [ -z "$exec_args" ]; then
                exec_args="$arg"
            else
                exec_args="$exec_args $arg"
            fi
        else
            if [ -z "$target" ]; then
                target="$arg"
            elif [ -z "$selected_main" ]; then
                selected_main="$arg"
            fi
        fi
    done

    target="$(resolve_target "$target")"

    if [ -z "$target" ] || [ ! -d "$ROOT_DIR/$target" ]; then
        echo -e "${RED}Errore: esercizio '$target' non trovato.${NC}"
        exit 1
    fi

    local mains=($(find_main_classes "$target"))
    if [ ${#mains[@]} -eq 0 ]; then
        echo -e "${RED}Errore: nessuna classe con 'public static void main' trovata in '$target'.${NC}"
        exit 1
    fi

    local main_class=""
    if [ -n "$selected_main" ]; then
        main_class="$selected_main"
    elif [ ${#mains[@]} -eq 1 ]; then
        main_class="${mains[0]}"
    else
        echo -e "${BOLD}Trovate più classi con main in ${target}:${NC}"
        local m_idx=1
        for m in "${mains[@]}"; do
            echo -e "  ${GREEN}${m_idx})${NC} ${m}"
            ((m_idx++))
        done
        read -rp "Quale classe vuoi eseguire? [1]: " m_choice
        m_choice="${m_choice:-1}"
        if [[ "$m_choice" =~ ^[0-9]+$ ]] && [ "$m_choice" -ge 1 ] && [ "$m_choice" -le ${#mains[@]} ]; then
            main_class="${mains[$((m_choice - 1))]}"
        else
            main_class="$m_choice"
        fi
    fi

    sync_pom_main_class "$target" "$main_class"

    local args_info=""
    if [ -n "$exec_args" ]; then
        args_info=" [args: ${YELLOW}${exec_args}${NC}]"
    fi

    echo -e "${BLUE}▶ Esecuzione di ${BOLD}${target}${NC} (${main_class})${args_info}...\n"
    if [ -n "$exec_args" ]; then
        mvn compile exec:java -pl ":$target" -Dexec.mainClass="$main_class" -Dexec.args="$exec_args" -q
    else
        mvn compile exec:java -pl ":$target" -Dexec.mainClass="$main_class" -q
    fi
}

function cmd_package() {
    local target="$(resolve_target "$1")"
    local selected_main="$2"

    if [ -z "$target" ] || [ ! -d "$ROOT_DIR/$target" ]; then
        echo -e "${RED}Errore: esercizio '$target' non trovato.${NC}"
        exit 1
    fi

    local mains=($(find_main_classes "$target"))
    local main_class=""
    if [ ${#mains[@]} -gt 0 ]; then
        if [ -n "$selected_main" ]; then
            main_class="$selected_main"
        elif [ ${#mains[@]} -eq 1 ]; then
            main_class="${mains[0]}"
        else
            echo -e "${BOLD}Trovate più classi con main in ${target}:${NC}"
            local m_idx=1
            for m in "${mains[@]}"; do
                echo -e "  ${GREEN}${m_idx})${NC} ${m}"
                ((m_idx++))
            done
            read -rp "Quale classe impostare come Main nel JAR? [1]: " m_choice
            m_choice="${m_choice:-1}"
            if [[ "$m_choice" =~ ^[0-9]+$ ]] && [ "$m_choice" -ge 1 ] && [ "$m_choice" -le ${#mains[@]} ]; then
                main_class="${mains[$((m_choice - 1))]}"
            else
                main_class="$m_choice"
            fi
        fi
        sync_pom_main_class "$target" "$main_class"
    fi

    echo -e "${BLUE}Packaging del modulo ${BOLD}${target}${NC}...${NC}"
    if [ -n "$main_class" ]; then
        mvn clean package -pl ":$target" -DskipTests -Dexec.mainClass="$main_class"
    else
        mvn clean package -pl ":$target" -DskipTests
    fi

    # Rileva il JAR generato (cerca prima JAR con dipendenze, poi JAR standard del modulo)
    local jar_file=""
    jar_file=$(find "$ROOT_DIR/$target/target" -maxdepth 1 -name "*jar-with-dependencies.jar" 2>/dev/null | head -n 1 || true)
    if [ -z "$jar_file" ] || [ ! -f "$jar_file" ]; then
        jar_file=$(find "$ROOT_DIR/$target/target" -maxdepth 1 -name "${target}-*.jar" ! -name "*-sources.jar" ! -name "*-javadoc.jar" 2>/dev/null | head -n 1 || true)
    fi
    if [ -z "$jar_file" ] || [ ! -f "$jar_file" ]; then
        jar_file=$(find "$ROOT_DIR/$target/target" -maxdepth 1 -name "*.jar" ! -name "*-sources.jar" ! -name "*-javadoc.jar" 2>/dev/null | head -n 1 || true)
    fi

    if [ -n "$jar_file" ] && [ -f "$jar_file" ]; then
        echo -e "\n${GREEN}✓ JAR creato:${NC} ${BOLD}${jar_file}${NC}\n"
        echo -e "${BLUE}▶ Esecuzione tramite 'java -jar':${NC}\n"
        java -jar "$jar_file"
    else
        echo -e "${YELLOW}File JAR eseguibile non trovato. Controlla la cartella $target/target/${NC}"
    fi
}

function cmd_test() {
    local target="$(resolve_target "$1")"
    local selected_test="$2"

    if [ -z "$target" ] || [ ! -d "$ROOT_DIR/$target" ]; then
        echo -e "${RED}Errore: esercizio '$target' non trovato.${NC}"
        exit 1
    fi

    local tests=($(find_test_classes "$target"))
    if [ ${#tests[@]} -eq 0 ]; then
        echo -e "${YELLOW}Nessuna classe di test trovata in '$target/src/test/java'.${NC}"
        exit 0
    fi

    local test_class=""
    if [ -n "$selected_test" ]; then
        test_class="$selected_test"
    elif [ ${#tests[@]} -eq 1 ]; then
        test_class="${tests[0]}"
    else
        echo -e "${BOLD}Trovate più classi di test in ${target}:${NC}"
        local t_idx=1
        for t in "${tests[@]}"; do
            echo -e "  ${GREEN}${t_idx})${NC} ${t}"
            ((t_idx++))
        done
        read -rp "Quale test vuoi eseguire? [1]: " t_choice
        t_choice="${t_choice:-1}"
        if [[ "$t_choice" =~ ^[0-9]+$ ]] && [ "$t_choice" -ge 1 ] && [ "$t_choice" -le ${#tests[@]} ]; then
            test_class="${tests[$((t_choice - 1))]}"
        else
            test_class="$t_choice"
        fi
    fi

    # Gestione ibrida: verifica se è un test JUnit o un test standalone con 'assert'
    if is_junit_test "$target" "$test_class"; then
        echo -e "${BLUE}▶ Esecuzione test JUnit di ${BOLD}${target}${NC} (${test_class})...\n"
        mvn test -pl ":$target" -Dtest="$test_class"
    else
        echo -e "${BLUE}▶ Compilazione ed esecuzione test con asserzioni (-ea) di ${BOLD}${target}${NC} (${test_class})...\n"
        mvn test-compile -pl ":$target" -q
        local cp="$ROOT_DIR/$target/target/test-classes:$ROOT_DIR/$target/target/classes"
        
        # Disattiva set -e per catturare l'eventuale AssertionError della JVM senza crashare
        set +e
        java -ea -cp "$cp" "$test_class"
        local exit_code=$?
        set -e

        if [ $exit_code -eq 0 ]; then
            echo -e "${GREEN}✓ Test terminato con successo!${NC}\n"
        else
            echo -e "${RED}✗ Test fallito (AssertionError, exit code: ${exit_code})${NC}\n"
            return $exit_code
        fi
    fi
}

function cmd_rename() {
    local old_name="$1"
    local new_name="$2"
    local modules=($(get_modules))

    if [ -z "$old_name" ]; then
        echo -e "${BOLD}Seleziona l'esercizio da rinominare:${NC}"
        local idx=1
        for mod in "${modules[@]}"; do
            echo -e "  ${GREEN}${idx})${NC} ${mod}"
            ((idx++))
        done
        read -rp "Numero o nome: " choice
        if [[ "$choice" =~ ^[0-9]+$ ]] && [ "$choice" -ge 1 ] && [ "$choice" -le ${#modules[@]} ]; then
            old_name="${modules[$((choice - 1))]}"
        else
            old_name="$choice"
        fi
    fi

    if [ ! -d "$ROOT_DIR/$old_name" ]; then
        echo -e "${RED}Errore: esercizio '$old_name' non trovato.${NC}"
        exit 1
    fi

    if [ -z "$new_name" ]; then
        read -rp "Nuovo nome per '$old_name': " new_name
    fi
    new_name="$(echo "$new_name" | tr '[:upper:]' '[:lower:]' | tr ' ' '-')"

    if [ -d "$ROOT_DIR/$new_name" ]; then
        echo -e "${RED}Errore: la cartella '$new_name' esiste già!${NC}"
        exit 1
    fi

    local old_pkg="$(sanitize_pkg "$old_name")"
    local new_pkg="$(sanitize_pkg "$new_name")"

    mv "$ROOT_DIR/$old_name" "$ROOT_DIR/$new_name"

    # Aggiorna cartelle del package se corrispondenti
    if [ -d "$ROOT_DIR/$new_name/src/main/java/$old_pkg" ] && [ "$old_pkg" != "$new_pkg" ]; then
        mv "$ROOT_DIR/$new_name/src/main/java/$old_pkg" "$ROOT_DIR/$new_name/src/main/java/$new_pkg"
        find "$ROOT_DIR/$new_name/src/main/java" -type f -name "*.java" -exec sed_i "s/package ${old_pkg};/package ${new_pkg};/g" {} +
        find "$ROOT_DIR/$new_name/src/main/java" -type f -name "*.java" -exec sed_i "s/import ${old_pkg}\./import ${new_pkg}\./g" {} +
    fi

    # Aggiorna pom.xml modulo
    if [ -f "$ROOT_DIR/$new_name/pom.xml" ]; then
        sed_i "s/<artifactId>${old_name}<\/artifactId>/<artifactId>${new_name}<\/artifactId>/g" "$ROOT_DIR/$new_name/pom.xml"
        sed_i "s/<mainClass>${old_pkg}\./<mainClass>${new_pkg}\./g" "$ROOT_DIR/$new_name/pom.xml"
    fi

    # Aggiorna pom.xml radice
    sed_i "s/<module>${old_name}<\/module>/<module>${new_name}<\/module>/g" "$POM_FILE"

    echo -e "${GREEN}✓ Esercizio '${old_name}' rinominato con successo in '${new_name}'.${NC}\n"
}

function cmd_remove() {
    local force=false
    local targets=()

    for arg in "$@"; do
        if [ "$arg" = "-y" ] || [ "$arg" = "--yes" ] || [ "$arg" = "-f" ]; then
            force=true
        else
            targets+=("$arg")
        fi
    done

    if [ ${#targets[@]} -eq 0 ]; then
        local modules=($(get_modules))
        if [ ${#modules[@]} -eq 0 ]; then
            echo -e "${YELLOW}(Nessun esercizio da rimuovere)${NC}"
            return
        fi
        echo -e "${BOLD}Seleziona l'esercizio da rimuovere:${NC}"
        local idx=1
        for mod in "${modules[@]}"; do
            echo -e "  ${GREEN}${idx})${NC} ${mod}"
            ((idx++))
        done
        read -rp "Numero o nome: " choice
        if [[ "$choice" =~ ^[0-9]+$ ]] && [ "$choice" -ge 1 ] && [ "$choice" -le ${#modules[@]} ]; then
            targets=("${modules[$((choice - 1))]}")
        elif [ -n "$choice" ]; then
            targets=("$choice")
        else
            return
        fi
    fi

    for target in "${targets[@]}"; do
        local resolved="$(resolve_target "$target")"
        if [ -z "$resolved" ] || [ ! -d "$ROOT_DIR/$resolved" ]; then
            echo -e "${RED}Errore: esercizio '$target' non trovato.${NC}"
            continue
        fi

        if [ "$force" = false ]; then
            echo -ne "${YELLOW}Sei sicuro di voler eliminare DEFINITIVAMENTE '${resolved}'? [s/N]: ${NC}"
            read -rp "" confirm
            case "$confirm" in
                s|S|y|Y|si|Si|SI|yes|Yes|YES) ;;
                *) echo "Operazione annullata per '${resolved}'."; continue ;;
            esac
        fi

        sed_i "/<module>${resolved}<\/module>/d" "$POM_FILE"
        rm -rf "$ROOT_DIR/$resolved"
        echo -e "${GREEN}✓ Esercizio '${resolved}' rimosso.${NC}\n"
    done
}

function cmd_build() {
    local target="$1"
    if [ -n "$target" ]; then
        target="$(resolve_target "$target")"
        if [ -z "$target" ] || [ ! -d "$ROOT_DIR/$target" ]; then
            echo -e "${RED}Errore: esercizio '$target' non trovato.${NC}"
            exit 1
        fi
        local mains=($(find_main_classes "$target"))
        if [ ${#mains[@]} -eq 1 ]; then
            sync_pom_main_class "$target" "${mains[0]}"
        fi
        echo -e "${BLUE}Compilazione del modulo ${BOLD}${target}${NC} (sorgenti e test)..."
        mvn test-compile -pl ":$target"
    else
        echo -e "${BLUE}Compilazione di tutti gli esercizi (sorgenti e test)...${NC}"
        for mod in $(get_modules); do
            local mains=($(find_main_classes "$mod"))
            if [ ${#mains[@]} -eq 1 ]; then
                sync_pom_main_class "$mod" "${mains[0]}"
            fi
        done
        mvn test-compile
    fi
}

function cmd_clean() {
    echo -e "${BLUE}Pulizia della directory target/ di tutti i moduli...${NC}"
    mvn clean
}

function cmd_completion() {
    echo -e "${BOLD}=== Configurazione Autocompletamento Bash ===${NC}\n"
    echo -e "Per abilitare il completamento automatico con il tasto ${BOLD}[TAB]${NC} per questa sessione:"
    echo -e "  ${GREEN}source ./esercizi.sh${NC}\n"
    echo -e "Per renderlo ${BOLD}permanente${NC} per il tuo utente, esegui una volta sola:"
    echo -e "  ${YELLOW}echo 'source \"$ROOT_DIR/esercizi.sh\"' >> ~/.bashrc${NC}\n"
}

function cmd_help() {
    print_header
    echo -e "Uso: ${BOLD}./esercizi.sh <comando> [argomenti]${NC}\n"
    echo -e "Comandi disponibili:"
    echo -e "  ${GREEN}new [nome]${NC}                     Crea un nuovo modulo con il pom.xml coerente al parent"
    echo -e "  ${GREEN}run [nome] [classe] [-- args]${NC}  Esegue il main (supporta argomenti CLI dopo '--')"
    echo -e "  ${GREEN}package [nome] [classe]${NC}        Genera il JAR auto-eseguibile con dipendenze e lo avvia"
    echo -e "  ${GREEN}test [nome] [classe]${NC}           Esegue i test (supporta sia 'assert' con -ea sia JUnit)"
    echo -e "  ${GREEN}list${NC}                           Elenca tutti gli esercizi e le classi main/test"
    echo -e "  ${GREEN}rename <vecchio> <nuovo>${NC}        Rinomina un modulo e aggiorna i file pom.xml"
    echo -e "  ${GREEN}remove <nomi...> [-y]${NC}          Elimina uno o più esercizi dal progetto"
    echo -e "  ${GREEN}build [nome]${NC}                   Compila sorgenti e test con Maven (tutti o uno specifico)"
    echo -e "  ${GREEN}clean${NC}                          Pulisce i file compilati (target/)"
    echo -e "  ${GREEN}completion${NC}                     Mostra come abilitare l'autocompletamento Bash"
    echo -e "  ${GREEN}help${NC}                           Mostra questo aiuto\n"
}

# Funzione per l'autocompletamento Bash con TAB
function _esercizi_bash_completion() {
    local cur="${COMP_WORDS[COMP_CWORD]}"
    local prev="${COMP_WORDS[COMP_CWORD-1]}"
    local cmds="new run package test list rename remove build clean completion help"

    if [ "$COMP_CWORD" -eq 1 ]; then
        COMPREPLY=($(compgen -W "$cmds" -- "$cur"))
    elif [[ "$prev" =~ ^(run|package|test|rename|remove|build)$ ]]; then
        local mods=""
        if [ -f "$POM_FILE" ]; then
            mods=$(sed -e 's/<!--.*-->//g' "$POM_FILE" 2>/dev/null | grep -oP '(?<=<module>)[^<]+' | tr -d ' \t\r')
        fi
        COMPREPLY=($(compgen -W "$mods" -- "$cur"))
    fi
}

# Se lo script viene richiamato con "source ./esercizi.sh", registra l'autocompletamento
if [[ "${BASH_SOURCE[0]}" != "${0}" ]]; then
    complete -F _esercizi_bash_completion ./esercizi.sh esercizi.sh
    return 0 2>/dev/null || exit 0
fi

# Gestione comandi
case "$1" in
    new|nuovo|create|add)
        cmd_new "$2"
        ;;
    run|esegui)
        shift
        cmd_run "$@"
        ;;
    package|jar)
        cmd_package "$2" "$3"
        ;;
    test)
        cmd_test "$2" "$3"
        ;;
    list|ls)
        cmd_list
        ;;
    rename|mv|rinomina|move)
        cmd_rename "$2" "$3"
        ;;
    remove|rm|delete|rimuovi|elimina)
        shift
        cmd_remove "$@"
        ;;
    build|compile)
        cmd_build "$2"
        ;;
    clean)
        cmd_clean
        ;;
    completion|autocomplete)
        cmd_completion
        ;;
    help|--help|-h|"")
        cmd_help
        ;;
    *)
        echo -e "${RED}Comando sconosciuto: $1${NC}\n"
        cmd_help
        exit 1
        ;;
esac
