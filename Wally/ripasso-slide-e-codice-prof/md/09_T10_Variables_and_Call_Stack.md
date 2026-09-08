# 📌 Blocco 9: Lezione 10 / Slide T10 — *Variables and Call Stack* & Il Debutto di `MavenDate`

In questo blocco analizziamo in profondità il modello di memoria della JVM (Stack vs Heap), il passaggio dei parametri per valore, gli oggetti immutabili e i tipi wrapper ([T10 - Java Variables and Call Stack.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T10%20-%20Java%20Variables%20and%20Call%20Stack.pdf)).
Sul fronte pratico analizziamo il **grande spartiacque architetturale del corso**: il passaggio dal progetto manuale a pacchetti [`SimpleDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/SimpleDate) al progetto ufficiale **[`MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate)** con Apache Maven, file [`pom.xml`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/pom.xml), layout `src/main/java` e collisione di nomi tra package diversi.

---

### 1. 📖 Concetti Teorici dalle Slide (Slide T10)

#### A. Il Modello di Memoria della JVM: Stack vs Heap (Slide 1–11)
La memoria a disposizione di un processo Java è partizionata in tre aree principali:
1. **Call Stack (Stack dei Thread)**:
   - Memoria estremamente veloce, gestita a politica LIFO (Push/Pop).
   - È suddivisa in **Stack Frame** (o record di attivazione): ogni invocazione di metodo crea un nuovo frame nello stack contenente:
     - La tabella delle variabili locali.
     - I parametri formali passati al metodo.
     - Lo stack degli operandi (per i calcoli intermedi della CPU/bytecode).
     - I riferimenti alla costante del metodo e l'indirizzo di ritorno.
   - Quando il metodo termina (con `return` o eccezione), il frame viene rimosso istantaneamente dallo Stack e tutte le sue variabili locali vengono distrutte.
2. **Heap (Memoria Dinamica degli Oggetti)**:
   - Memoria globale condivisa da tutti i thread dell'applicazione.
   - Ospita tutti gli **oggetti** istanziati con `new`, inclusi gli **array**.
   - I dati nello Heap non si deallocano all'uscita dal metodo: sopravvivono finché esiste almeno un riferimento attivo nello Stack o in altri oggetti che punta ad essi. Quando diventano irraggiungibili (*unreachable*), vengono eliminati dal Garbage Collector.
3. **Method Area / Metaspace (Memoria di Classe)**:
   - Ospita il bytecode compilato delle classi caricate dal ClassLoader, i metadati di tipo e le **variabili statiche** (`static`).
- **Blocco di Inizializzazione Statica (`static { ... }`)**:
  - Blocco speciale eseguito **una sola volta** nel ciclo di vita dell'applicazione, al momento in cui la classe viene caricata in memoria dalla JVM:
    ```java
    static int[] arr;
    static {
        arr = new int[3];
        arr[0] = 1; arr[1] = 2; arr[2] = 0;
    }
    ```
  - Si usa per inizializzare strutture statiche complesse che richiedono cicli o controlli prima dell'uso.

---

#### B. Immutabilità e Passaggio Parametri: Pass-by-Value (Slide 15–25)
- **Oggetti Immutabili (*Immutable Objects*)**:
  - Un oggetto il cui stato interno non può essere modificato dopo la costruzione (es. `String`, `Integer`, `Date` da Lezione 09).
  - *Regole per creare una classe immutabile*:
    1. Rendere tutti i campi `private final`.
    2. Non fornire metodi mutatori (nessun setter).
    3. Dichiarare la classe `final` (per impedire che le sottoclassi violino l'immutabilità con override malevoli).
    4. Se l'oggetto contiene riferimenti a strutture mutabili (es. un array o un'altra data mutabile), eseguire copie difensive (*defensive copy*) nel costruttore e nei getter.
  - *Vantaggi*: Immuni da side-effects da aliasing, intrinsecamente *thread-safe* (possono essere condivisi tra thread concorrenti senza sincronizzazione o lock).
- **Come Java passa i parametri ai metodi: SEMPRE Strictly Pass-by-Value**:
  - In Java **non esiste il passaggio per riferimento del C++ (`int& x`)**.
  - **Per i tipi primitivi (`int`, `double`)**: il metodo riceve una copia del valore binario. Qualsiasi modifica locale sul parametro non ha alcun effetto sulla variabile del chiamante.
  - **Per i tipi reference (oggetti/array)**: il metodo riceve **una copia per valore del riferimento** (dell'indirizzo puntato):
    - *Caso 1 (Mutazione dell'oggetto)*: se usiamo il riferimento ricevuto per chiamare un metodo mutatore (`p.setAge(25)`), l'oggetto puntato nello Heap viene effettivamente modificato per il chiamante!
    - *Caso 2 (Riassegnamento del puntatore — Il tranello d'esame)*:
      ```java
      void reset(Person p) {
          p = new Person("Bob"); // Assegna un nuovo oggetto al puntatore locale!
      }
      ```
      All'esterno, la variabile del chiamante **non cambia affatto**! Ha semplicemente mutato la copia locale del puntatore nel proprio stack frame.

---

#### C. Classi Wrapper, Autoboxing e i loro Trabocchetti (Slide 26–35)
- Per ciascuno degli 8 tipi primitivi, Java mette a disposizione una corrispondente **Wrapper Class** nel package `java.lang`:
  - `byte` $\rightarrow$ `Byte`
  - `short` $\rightarrow$ `Short`
  - `int` $\rightarrow$ `Integer`
  - `long` $\rightarrow$ `Long`
  - `float` $\rightarrow$ `Float`
  - `double` $\rightarrow$ `Double`
  - `char` $\rightarrow$ `Character`
  - `boolean` $\rightarrow$ `Boolean`
- Tutte le classi wrapper sono **immutabili**.
- **Autoboxing e Unboxing (Java 5+)**:
  - *Autoboxing*: conversione automatica da primitivo a wrapper (`Integer x = 5;` $\implies$ compilato come `Integer.valueOf(5)`).
  - *Unboxing*: estrazione automatica del valore primitivo dal wrapper (`int y = x;` $\implies$ compilato come `x.intValue()`).
- ⚠️ **I Due Grandi Pericoli delle Wrapper Classes**:
  1. **Il Trabocchetto dell'Integer Cache ($-128 \dots +127$)**:
     ```java
     Integer a = 100, b = 100;
     System.out.println(a == b); // TRUE! (La JVM ricicla lo stesso oggetto cacheato)

     Integer c = 200, d = 200;
     System.out.println(c == d); // FALSE! (Fuori range [-128, 127], alloca 2 oggetti distinti nello Heap!)
     ```
     Conclusione: **Mai usare `==` per confrontare i wrapper**, usare sempre `.equals()`!
  2. **Crash da Unboxing su `null`**:
     ```java
     Integer obj = null;
     int val = obj; // RUNTIME ERROR: NullPointerException!
     ```
     La JVM tenta di invocare `obj.intValue()`, fallendo rovinosamente se `obj` è nullo.

---

### 2. 💻 Evoluzione del Codice: Il Passaggio a `MavenDate`

In [`Lezione10`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10), il docente archivia il vecchio progetto non strutturato e adotta lo standard industriale **Apache Maven**.

#### 1. Riorganizzazione dei Package
Il progetto viene suddiviso in due package distinti:
- **`it.oop.core`**: il dominio applicativo (le classi di modello: [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/core/Date.java), [`Language.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/core/Language.java), [`BirthDay.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/core/BirthDay.java)).
- **`it.oop.ui`**: l'interfaccia utente contenente il `main` ([`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/ui/MainDate.java)).

#### 2. Il Test Didattico sulla Collisione dei Nomi di Package
Nel package `it.oop.ui`, il docente aggiunge appositamente una seconda classe:
[`it/oop/ui/Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/ui/Date.java):
```java
package it.oop.ui;

class Date { // Visibilità package-private
    public int time;
    private int start = 0;

    public Date(int time) { this.time = time; }
}
```
E in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/ui/MainDate.java) mostra come la JVM risolve l'ambiguità:
```java
package it.oop.ui;

import it.oop.core.Date; // 1. L'import esplicito ha la precedenza!

public class MainDate {
    public static void main(String[] args) {
        Date d1 = new Date(7, 1, 2025); // Istanzia it.oop.core.Date!

        // 2. Per istanziare la classe Date del package it.oop.ui,
        // è obbligatorio usare il Fully Qualified Name (FQN):
        it.oop.ui.Date d = new it.oop.ui.Date(12345);
        System.out.println(d.time);      // OK: 'time' è public
        // System.out.println(d.start);  // COMPILE-TIME ERROR: 'start' è private!
    }
}
```

#### 3. Anatomia del [`pom.xml`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/pom.xml) di `MavenDate`
```xml
<project ...>
    <modelVersion>4.0.0</modelVersion>
    <groupId>it.oop</groupId>
    <artifactId>MavenDate</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <build>
        <plugins>
            <!-- Plugin per creare il JAR eseguibile con dipendenze -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.7.1</version>
                <configuration>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <!-- Entrypoint del JAR -->
                            <mainClass>it.oop.ui.MainDate</mainClass>
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
        </plugins>
    </build>
</project>
```
Questo file è il prototipo esatto che hai esteso in tutti i moduli del tuo workspace `esercizi-wally-25-26`:
- `compile`: compila da `src/main/java` verso `target/classes`.
- `test`: compila ed esegue i test da `src/test/java` verso `target/test-classes`.
- `package`: genera il JAR auto-eseguibile con `META-INF/MANIFEST.MF` configurato con `Main-Class: it.oop.ui.MainDate`.

---

### 3. 🔄 Corrispondenza con i Tuoi Moduli Workspace

Nel tuo repository [`esercizi-wally-25-26`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26):
- **`es08`**: [`Memory.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es08/src/main/java/es08/Memory.java) implementa l'allocazione Stack vs Heap e il blocco `static { ... }`.
- **`es10`**: [`ImmutablePerson.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es10/src/main/java/es10/ImmutablePerson.java) applica formalmente tutte le regole di immutabilità di T10 (`final class`, campi `final`, validazione e assenza di setter).

---

> [!NOTE]
> Con la **Lezione 10** abbiamo completato l'intero quadro su memoria, call stack, tipi wrapper e la transizione a Maven.
> 
> Il prossimo blocco è la **Lezione 11 / Slide T11: *Packages and Class Visibility***:
> - Tassonomia gerarchica dei package e convenzioni DNS invertite (`it.univr...`).
> - Regole di visibilità e accessibilità inter-package: membri `public`, `protected`, package-private e `private`.
> - Evoluzione di `MavenDate`:
>   - Refactoring dell'algoritmo Gregoriano: introduzione definitiva del **calcolo dell'anno bisestile (`isLeapYear`)** in `Date.java`!
>   - Integrazione di `isLeapYear(year)` in `daysPerMonth(month, year)` e fine dei mesi errati per Febbraio!

**Dammi conferma per procedere alla Lezione 11 / T11!**
