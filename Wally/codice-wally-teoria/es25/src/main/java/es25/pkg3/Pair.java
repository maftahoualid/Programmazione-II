package es25.pkg3;

/**
 * Multiple Bounds con extends: Pair<T extends Person & Comparable<T>>
 *
 * Esempio di extends con 2 tipi:
 * 1° tipo (classe): Person (deve comparire per prima nella dichiarazione)
 * 2° tipo (interfaccia): Comparable<T> (separata con '&')
 *
 * T garantisce a compile-time:
 * - Tutti i metodi di Person (come getName())
 * - Tutti i metodi di Comparable<T> (come compareTo(T other))
 */
public class Pair<T extends Person & Comparable<T>> {
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

    // Metodo consentito dal 1° bound (Person):
    public String getFirstName() {
        return first.getName();
    }

    // Metodi consentiti dal 2° bound (Comparable<T>):
    public T getMax() {
        return first.compareTo(second) >= 0 ? first : second;
    }

    public T getMin() {
        return first.compareTo(second) <= 0 ? first : second;
    }
}
