package org.example;

public class Stack {
    private Node head;

    public Stack(Node head) {
        this.head = head;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        newNode.setNext(head);
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            throw new IllegalStateException("Stack jest pusty");
        }

        int value = head.getValue();
        head = head.getNext();

        return value;
    }
}