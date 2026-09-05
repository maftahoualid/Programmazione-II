package it.oop.core;

import it.oop.exception.OrderdPairException;

public class OrderedPair <T extends Comparable<T>> {
    private final T first;
    private final T second;

    public OrderedPair(T first, T second) throws OrderdPairException {
        this.first = first;
        this.second = second;
        if (first.compareTo(second) > 0)
            throw new OrderdPairException("Not orderd pair");
    }

    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
}
