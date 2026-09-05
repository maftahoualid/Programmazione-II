package it.oop.core;

public class OrderedPair <T extends Comparable<T>> {
    private final T first;
    private final T second;

    public OrderedPair(T first, T second) {
        this.first = first;
        this.second = second;
        if (first.compareTo(second) > 0)
            System.out.println("Pair not ordered!");
    }

    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
}
