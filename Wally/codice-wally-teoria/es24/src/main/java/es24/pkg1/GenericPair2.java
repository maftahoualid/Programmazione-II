package es24.pkg1;

public class GenericPair2<T1,T2> {
    private T1 first;
    private T2 second;
    public GenericPair2(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    public T1 getFirst() { return first; }
    public T2 getSecond() { return second; }
}
