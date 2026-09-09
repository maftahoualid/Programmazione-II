package es21.pkg1;
// COSA VEDE LA CLASSE ESTERNA VERSO LA CLASSE INTERNA E NESTED

class OuterToInner {

    void test() {
        // Inner Class: la classe Outer deve creare un'istanza
        Inner inner = new Inner();
        System.out.println(inner.campoPrivatoInner); // OK: legge campo private di Inner

        // Static Nested Class: accesso a membro statico e di istanza
        System.out.println(Nested.campoStaticoPrivato); // OK: legge campo statico private
        Nested nested = new Nested();
        System.out.println(nested.campoIstanzaPrivato); // OK: legge campo d'istanza private
    }

    class Inner {
        private String campoPrivatoInner = "Privato Inner";
    }

    static class Nested {
        private static String campoStaticoPrivato = "Statico Privato Nested";
        private String campoIstanzaPrivato = "Istanza Privato Nested";
    }
}
