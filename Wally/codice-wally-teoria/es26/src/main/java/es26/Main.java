package es26;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      ESERCIZIO 26: JAVA COLLECTIONS FRAMEWORK   ");
        System.out.println("=================================================\n");

        // 1. Collections, List, Set, Map, Iterator e rimozione fail-fast
        es26.pkg1.MainCollectionsIterable.main(args);
        System.out.println();

        // 2. Ordinamento List con Comparable e Comparator (3 modi)
        es26.pkg2.Main.main(args);
        System.out.println();

        // 3. Ordinamento Array con Arrays.sort(Object[]) e Comparable
        es26.pkg3.Main.main(args);
        System.out.println();

        // 4. Ordinamento Array Type-Safe con Arrays.sort(T[], Comparator<? super T>) (3 modi)
        es26.pkg4.Main.main(args);
        System.out.println();

        System.out.println("=================================================");
        System.out.println("          TUTTI GLI ESEMPI COMPLETATI            ");
        System.out.println("=================================================");
    }
}
