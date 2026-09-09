package es25.pkg1;

/**
 * Slide 15 (T15 - Generic Types)
 * Unbounded Type Parameter: Pair<T>
 *
 * Qui T non ha vincoli (equivale a Object per Type Erasure).
 * All'interno della classe NON è possibile chiamare metodi specifici di Person come getName(),
 * perché T potrebbe essere qualsiasi tipo (String, Integer, ecc.).
 */
public class Pair<T> {
    private T first, second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    /*
    // ERRORE DI COMPILAZIONE
    // "cannot find symbol: method getName() in type T"
    // Il compilatore non sa se T possiede il metodo getName().
    public String getFirstName() {
        return first.getName();
    }
    */
}
