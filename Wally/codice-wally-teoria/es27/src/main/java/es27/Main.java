package es27;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  ESERCIZIO 27: ERROR HANDLING WITH EXCEPTIONS   ");
        System.out.println("=================================================\n");

        // 1. Gestione errori tradizionale (senza eccezioni: codici e valori speciali)
        es27.pkg1.Main.main(args);
        System.out.println("\n-------------------------------------------------\n");

        // 2. Generazione e intercettazione eccezioni custom (EmptyStackException)
        es27.pkg2.Main.main(args);
        System.out.println("\n-------------------------------------------------\n");

        // 3. Flusso di esecuzione con blocchi catch multipli (FileError, IOError)
        es27.pkg3.Main.main(args);
        System.out.println("\n-------------------------------------------------\n");

        // 4. Propagazione e "Dirty Tricks" (Checked vs Unchecked wrapping)
        es27.pkg4.Main.main(args);
        System.out.println("\n-------------------------------------------------\n");

        // 5. Posizionamento del try-catch nei cicli (Try dentro vs Try fuori)
        es27.pkg5.Main.main(args);
        System.out.println("\n-------------------------------------------------\n");

        // 6. I 3 casi di gestione delle eccezioni per il chiamante (Slide 17-18-19)
        es27.pkg6.Main.main(args);
        System.out.println("\n-------------------------------------------------\n");

        // 7. Eccezioni e cicli: try dentro vs fuori dal ciclo (Slide 27-28)
        es27.pkg7.Main.main(args);
        System.out.println();

        System.out.println("=================================================");
        System.out.println("          TUTTI GLI ESEMPI COMPLETATI            ");
        System.out.println("=================================================");
    }
}
