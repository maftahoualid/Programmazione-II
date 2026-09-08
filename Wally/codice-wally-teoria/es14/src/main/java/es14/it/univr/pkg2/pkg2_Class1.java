package es14.it.univr.pkg2;

// javac -d bin/ -classpath bin/ -sourcepath  it/pkg1/*.java it/pkg1/subpkg1/*.java it/univr/pkg2/*.java

/* APRI FILE COMPILATI */
// java -cp bin/ es14.it.univr.pkg2.pkg2_Class1

/* GENERA JAR SENZA MAIN CLASS E POI ESEGUI SPECIFICANDOLA */
// jar cvf J.jar -C bin/ es14/
// java -cp J.jar it/univr/pkg2/pkg2_Class1.java

/* GENERA JAR CON MAIN CLASS E POI ESEGUI */
// jar cvfm JJ.jar manifest.txt -C bin/ it/
// java -jar JJ.jar 

public class pkg2_Class1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

/*
 * ESEMPIO
 * javac -d bin \
 * -sourcepath src \
 * -cp "lib/*" \
 * --release 21 \
 * -Xlint:all \
 * -Werror \
 * -verbose \
 * src/it/azienda/app/Main.java
 * 
 * java -cp "bin:lib/*" \
 * -Xms1024m \
 * -Xmx4096m \
 * -XX:+UseG1GC \
 * it.azienda.app.Main
 */