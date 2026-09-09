package es27.pkg4;

/**
 * Dimostrazione del pattern "Dirty Trick" (Slide T17):
 *
 * Le eccezioni Checked (come MyException) obbligano il programmatore a gestirle
 * o a dichiararle nella firma con 'throws MyException', propagandosi a cascata
 * lungo tutta la gerarchia di chiamate ("come un virus").
 *
 * Per evitare di inquinare le firme dei metodi ad alto livello:
 * Si intercetta l'eccezione checked e la si rilancia incapsulata all'interno
 * di una RuntimeException (Unchecked Exception), che il compilatore Java NON
 * obbliga a dichiarare con 'throws'.
 */
public class Dummy {

    // Metodo originale con eccezione Checked: obbligatorio 'throws MyException'
    public void foo() throws MyException {
        throw new MyException("Errore di basso livello generato in foo()");
    }

    // "Dirty Trick": nessuna dichiarazione 'throws' necessaria nella firma!
    public void bar() {
        try {
            foo();
        } catch (MyException e) {
            // Rilancia come Unchecked RuntimeException mantenendo la causa originale
            throw new RuntimeException("Eccezione incapsulata da bar()", e);
        }
    }
}
