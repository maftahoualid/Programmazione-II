package es24.pkg1;

public class GenericPair<T> {
    private T first, second;
    public GenericPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() { return first; }
    public T getSecond() { return second; }
}
