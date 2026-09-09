package es25.pkg2;

/**
 * Slide 16-17 (T15 - Generic Types)
 * Upper Bound con extends: Pair<T extends Person>
 *
 * T è vincolato ad essere Person o un suo sottotipo.
 * Di conseguenza, dentro Pair è perfettamente lecito invocare tutti i metodi
 * della superclasse Person (come getName()) senza errori né cast.
 */
public class Pair<T extends Person> {
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

    // NESSUN ERRORE: T extends Person garantisce a compile-time che first e second
    // possiedono il metodo getName()!
    public String getFirstName() {
        return first.getName();
    }

    public String getSecondName() {
        return second.getName();
    }
}
