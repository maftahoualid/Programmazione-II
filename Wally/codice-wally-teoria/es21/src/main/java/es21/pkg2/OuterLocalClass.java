package es21.pkg2;


class OuterLocalClass {
    private String campoOuterPrivato = "Campo Outer Privato";

    void metodoA(int parametroMetodo) {
        int variabileLocale = 10;
        int variabileModificata = 20;
        variabileModificata = 30; // Non è più "effectively final"

        // Local Class: definita dentro il metodo
        class LocalClass {
            void stampa() {
                // Accesso ai campi private dell'Outer: OK
                System.out.println(campoOuterPrivato);

                // Accesso a parametri e variabili locali effectively final: OK
                System.out.println("Parametro: " + parametroMetodo);
                System.out.println("Variabile locale: " + variabileLocale);

                // ERRORE DI COMPILAZIONE! La variabile è stata modificata nel metodo
                // System.out.println(variabileModificata);
            }
        }

        // Il metodo può istanziare la Local Class SOLO DOPO la sua definizione
        LocalClass local = new LocalClass();
        local.stampa();
    }

    void metodoB() {
        // LocalClass lc = new LocalClass(); // ERRORE! Invisibile in altri metodi
    }

    private static String campoStatico = "Dati Statici";
    static void metodoStatico() {
        class LocalInStatico {
            void test() {
                // System.out.println(campoIstanza); 
                // ERRORE: Il metodo contenitore è statico, non esiste nessun Outer.this!

                System.out.println(campoStatico); // OK: Accede solo a membri statici
            }
        }
    }
}

class AltraClasse {
    void test() {
        // Outer.LocalClass lc = new Outer.LocalClass(); // ERRORE! Invisibile a tutte le altre classi
    }
}