package es21.pkg1;

import es21.pkg1.Outer.*;

public class StessoPackage {
    void test() {
        Outer Outer = new Outer();

        // Inner Classes
        // Outer.InnerPrivate ip = Outer.new InnerPrivate(); // ERRORE! private
        Outer.InnerDefault id = Outer.new InnerDefault();      // OK (Caso 4, 7)
        Outer.InnerProtected ipr = Outer.new InnerProtected(); // OK (Caso 5, 7)
        Outer.InnerPublic ipu1 = Outer.new InnerPublic();      // OK (Caso 6, 7)
        // Non posso accedere direttamente neanche se importo le Inner
        // InnerPublic ipu2 = new InnerPublic(); // ERRORE! non è permesso

        // Static Nested Classes
        // Outer.NestedPrivate np = new Outer.NestedPrivate(); // ERRORE! private
        Outer.NestedDefault nd = new Outer.NestedDefault();      // OK (Caso 4, 7)
        Outer.NestedProtected npr = new Outer.NestedProtected(); // OK (Caso 5, 7)
        Outer.NestedPublic npu1 = new Outer.NestedPublic();      // OK (Caso 6, 7)
        // Se importo la classe Nested posso accedere direttamente
        NestedPublic npu2 = new NestedPublic(); // OK (Caso 6, 7)
    }
}