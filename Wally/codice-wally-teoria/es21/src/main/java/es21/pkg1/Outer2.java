package es21.pkg1;

class Outer2 {
    class Inner {}
    static class Nested {}
}

// Estendere un'Inner Class richiede un'istanza dell'Outer passata al costruttore
class EstendeInner extends Outer2.Inner {
    public EstendeInner(Outer2 outerInstance) {
        outerInstance.super(); // Sintassi obbligatoria per collegare l'istanza Outer
    }
}

// Estendere una Static Nested Class equivale a estendere una classe standard
class EstendeNested extends Outer2.Nested {
    public EstendeNested() {
        super(); // Chiamata standard al costruttore super
    }
}
