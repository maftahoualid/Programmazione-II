package es25;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      ESERCIZIO 25: BOUNDS E WILDCARDS IN JAVA   ");
        System.out.println("=================================================\n");

        // 1. Unbounded Type Parameter: Pair<T>
        es25.pkg1.Main.main(args);
        System.out.println();

        // 2. Upper Bound con 1 tipo: Pair<T extends Person>
        es25.pkg2.Main.main(args);
        System.out.println();

        // 3. Multiple Bounds con 2 tipi: Pair<T extends Person & Comparable<T>>
        es25.pkg3.Main.main(args);
        System.out.println();

        // 4. Lower-Bounded Wildcard con super 1 tipo: Pair<? super Student>
        es25.pkg4.Main.main(args);
        System.out.println();

        // 5. Approfondimenti didattici: Multiple Upper Bound (3 vincoli) e Lower Bound (super Padre)
        es25.pkg5.Main.main(args);
        System.out.println();

        // 6. Approfondimenti didattici: Wildcard, Invarianza, Lettura/Scrittura e firme dei metodi
        es25.pkg6.Main.main(args);
        System.out.println();

        // 7. Approfondimento didattico: Principio PECS (Producer Extends, Consumer Super)
        es25.pkg7.Main.main(args);
        System.out.println();

        System.out.println("=================================================");
        System.out.println("          TUTTI GLI ESEMPI COMPLETATI            ");
        System.out.println("=================================================");
    }
}
