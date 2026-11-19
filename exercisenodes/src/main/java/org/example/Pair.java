package org.example;

public class Pair<T, E> {
    private final T key;
    private final E value;

    public Pair(T firstElem, E secondElem) {
        this.key = firstElem;
        this.value = secondElem;
    }

    @Override
    public String toString(){
        return "(" + key + " " + value + ")";
    }
}