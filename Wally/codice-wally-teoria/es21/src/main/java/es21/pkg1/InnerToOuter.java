package es21.pkg1;
// COSA VEDE LA CLASSE INTERNA E NESTED VERSO LA CLASSE OUTER

class InnerToOuter {
    private String msgIstanza = "Istanza Outer";
    private static String msgStatico = "Statico Outer";

    class Inner {
        void test() {
            System.out.println(msgIstanza); // OK: accesso a campi d'istanza private
            System.out.println(msgStatico); // OK: accesso a campi statici private
        }
    }

    static class Nested {
        void test() {
            // System.out.println(msgIstanza); // ERRORE: non può accedere all'istanza senza un oggetto
            System.out.println(msgStatico); // OK: accesso solo ai membri statici private
            System.out.println(new InnerToOuter().msgIstanza); // OK: solo creando un'istanza esplicita
        }
    }
}