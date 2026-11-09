package org.example;

public class Pair<T, E> {
    private final T key;
    private final E value;

    public Pair(T firstElem, E secondElem) {
        this.key = firstElem;
        this.value = secondElem;
    }

    public T getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "(" + key + " " + value + ")";
    }
}