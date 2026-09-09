package es21.pkg1;

public class Figlia extends Outer {
    void test() {
        // Eredita e vede le Inner Class protected e public
        InnerProtected ipr = this.new InnerProtected(); // notazione per instanziarle
        InnerPublic ipu = this.new InnerPublic();

        // Eredita e vede le Static Nested Class protected e public (usabili direttamente)
        NestedProtected npr = new NestedProtected();
        NestedPublic npu = new NestedPublic();
    }
}