package org.example;

public class Node<F> {
    private final F value;
    private Node<F> next;

    public Node(F value) {
        this.value = value;
        this.next = null;
    }

    public F getValue() {
        return value;
    }

    public Node<F> getNext() {
        return next;
    }

    public void setNext(Node<F> next) {
        this.next = next;
    }
}