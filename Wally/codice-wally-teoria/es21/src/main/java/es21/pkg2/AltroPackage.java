package es21.pkg2;

import es21.pkg1.Outer;
import es21.pkg1.Outer.NestedPublic; // Import diretto della Nested Class

public class AltroPackage {
    void test() {
        Outer Outer = new Outer();

        // Inner Class: visibile solo se public (Caso 6, 8)
        Outer.InnerPublic ipu = Outer.new InnerPublic();

        // Static Nested Class: visibile solo se public (Caso 6, 8)
        Outer.NestedPublic npu1 = new Outer.NestedPublic();
        NestedPublic npu2 = new NestedPublic(); // OK con import diretto
    }
}