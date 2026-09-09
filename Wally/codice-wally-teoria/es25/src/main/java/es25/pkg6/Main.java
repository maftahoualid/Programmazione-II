package es25.pkg6;

public class Main {

    /**
     * Metodo generico con Bounded Type Parameter: <T extends Person>
     *
     * - Dichiara esplicitamente una variabile di tipo T a livello di metodo.
     * - È necessario quando T deve essere correlato con il tipo di ritorno o con altri parametri:
     *   es. <T extends Person> T getFirstElement(Pair<T> p)
     *   oppure <T extends Person> void copy(Pair<T> dest, Pair<T> src)
     */
    public static <T extends Person> void printPairTypeParam(Pair<T> p) {
        System.out.println("printPairTypeParam: " + p.getFirst().getName() + " e " + p.getSecond().getName());
    }

    /**
     * Metodo con Bounded Wildcard: Pair<? extends Person>
     *
     * - Più conciso e pulito: non introduce una variabile di tipo fittizia (T) che non viene riutilizzata.
     * - È la soluzione preferita e idiomatica in Java quando la struttura generica è usata solo in lettura ("Producer").
     *
     * NOTA DIDATTICA SUL TYPE ERASURE:
     * Non è possibile chiamare entrambi i metodi 'printPair' con la stessa firma nella stessa classe!
     * Entrambi verrebbero compilati in bytecode con la cancellazione di tipo 'printPair(Pair)',
     * causando l'errore: "name clash: have the same erasure".
     */
    public static void printPairWildcard(Pair<? extends Person> p) {
        System.out.println("printPairWildcard: " + p.getFirst().getName() + " e " + p.getSecond().getName());
    }

    public static void main(String[] args) {
        System.out.println("=== es25.pkg6: Approfondimento Wildcard in Java ===");

        // =========================================================================
        // 1. Invarianza dei Generics vs Principio di Sostituzione di Liskov
        // =========================================================================
        System.out.println("\n--- 1. Invarianza dei Generics ---");
        Student s = new Student("Sam", 123);
        Person p = s; // ✅ OK: Principio di sostituzione di Liskov (Student è un sottotipo di Person)
        System.out.println("p.getName(): " + p.getName());

        Pair<Student> pairS = new Pair<>(s, new Student("Paul", 456));

        // Pair<Person> pairP = pairS; 
        // ❌ COMPILE-TIME ERROR: Incompatible types!
        // Spiegazione: In Java i Generics sono INVARIANTI.
        // Anche se Student <: Person, Pair<Student> NON è un sottotipo di Pair<Person>.
        // Se fosse permesso, potremmo eseguire pairP.setFirst(new Person("Luigi")),
        // inserendo una Person generica in quello che in realtà è un Pair<Student>!

        // =========================================================================
        // 2. Unbounded Wildcard: Pair<?>
        // =========================================================================
        System.out.println("\n--- 2. Unbounded Wildcard (Pair<?>) ---");
        Pair<?> pairUnbounded = pairS; // ✅ OK: Pair<?> è il supertipo di Pair<T> per qualsiasi T
        System.out.println("pairUnbounded: " + pairUnbounded);

        // Possiamo LEGGERE, ma solo come Object:
        Object obj = pairUnbounded.getFirst(); // ✅ OK: in lettura restituisce Object
        System.out.println("Lettura come Object: " + obj);

        // Student st = pairUnbounded.getFirst();
        // ❌ COMPILE-TIME ERROR: Incompatible types: Object cannot be converted to Student

        // pairUnbounded.getFirst().getName();
        // ❌ COMPILE-TIME ERROR: cannot find symbol method getName() in class Object!
        // Il compilatore sa solo che è un Object, non sa che è una Person o uno Student.

        // NON possiamo SCRIVERE:
        // pairUnbounded.setFirst(s);
        // ❌ COMPILE-TIME ERROR: setFirst(capture# of ?) cannot be applied to Student!
        // pairUnbounded.setFirst(new Object());
        // ❌ COMPILE-TIME ERROR: non accetta nemmeno Object! L'unico valore scrivibile è 'null'.
        // REGOLA: Con Pair<?> possiamo LEGGERE (come Object), ma NON possiamo SCRIVERE.

        // =========================================================================
        // 3. Upper-Bounded Wildcard: Pair<? extends Person>
        // =========================================================================
        System.out.println("\n--- 3. Upper-Bounded Wildcard (Pair<? extends Person>) ---");
        Pair<? extends Person> pairExtends = pairS; // ✅ OK: Pair<Student> è sottotipo di Pair<? extends Person>

        // Chiamata corretta a getName():
        Person firstPerson = pairExtends.getFirst(); // ✅ OK: garantito essere almeno Person
        System.out.println("Nome primo studente via getFirst().getName(): " + pairExtends.getFirst().getName());
        System.out.println("Nome secondo studente via getSecond().getName(): " + pairExtends.getSecond().getName());

        // Anche con ? extends Person NON possiamo SCRIVERE (PECS: Producer Extends):
        // pairExtends.setFirst(s);
        // ❌ COMPILE-TIME ERROR: capture# of ? extends Person cannot be applied to Student!
        // Il compilatore non può sapere a runtime quale sottotipo specifico di Person contenga il Pair.

        // =========================================================================
        // 4. Come cambiano i metodi: <T extends Person> vs <? extends Person>
        // =========================================================================
        System.out.println("\n--- 4. Metodi: <T extends Person> vs <? extends Person> ---");

        // Chiamata metodo 1: con Type Parameter
        printPairTypeParam(pairS);

        // Chiamata metodo 2: con Wildcard
        printPairWildcard(pairS);

        // Funziona anche con Pair<Person>
        Pair<Person> pairOnlyPerson = new Pair<>(new Person("Mario"), new Person("Luigi"));
        printPairTypeParam(pairOnlyPerson);
        printPairWildcard(pairOnlyPerson);
    }
}
