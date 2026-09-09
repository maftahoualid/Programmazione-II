package es25.pkg5;

// Gerarchia di prova
class Animale {}

interface Volante {
    void vola();
}

interface Nuotatore {
    void nuota();
}

class Anatra extends Animale implements Volante, Nuotatore {
    @Override
    public void vola() {
        System.out.println("L'anatra vola");
    }

    @Override
    public void nuota() {
        System.out.println("L'anatra nuota");
    }
}

class Cane extends Animale {} // Animale, ma NON vola né nuota

// CLASSE GENERICA CON UPPER BOUND MULTIPLO
// T deve essere un Animale E implementare SIA Volante CHE Nuotatore
class GabbiaSpeciale<T extends Animale & Volante & Nuotatore> {
    private T animale;

    public GabbiaSpeciale(T animale) { 
        this.animale = animale; 
    }

    public T getAnimale() {
        return animale;
    }

    public void faiAgire() {
        // Il compilatore sa che T ha sia i metodi di Volante che di Nuotatore
        animale.vola();  // OK!
        animale.nuota(); // OK!
    }
}

public class TestUpper {
    public static void main(String[] args) {
        System.out.println("=== es25.pkg5: TestUpper (Multiple Upper Bound con 3 vincoli: 1 classe + 2 interfacce) ===");
        GabbiaSpeciale<Anatra> g1 = new GabbiaSpeciale<>(new Anatra()); // ✅ OK: Anatra soddisfa tutto
        g1.faiAgire();

        // GabbiaSpeciale<Cane> g2 = new GabbiaSpeciale<>(new Cane()); 
        // ❌ ERRORE: Cane è Animale, ma non implementa Volante e Nuotatore!
    }
}
