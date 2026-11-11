package org.example;

public class Stack<M> {
    Node<M> head;

    public Stack() {
        head = null;
    }

    public void push(M value) {
        Node<M> newNode = new Node<>(value);

        newNode.setNext(head);
        head = newNode;
    }

    public M pop() {
        if (head == null) {
            throw new IllegalStateException("Stack jest pusty");
        }

        M value = head.getValue();
        head = head.getNext();

        return value;
    }

    public boolean contains(M value) {
        Node<M> temp = head;

        while (temp != null) {

            if (temp.getValue() == value) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void remove(M value) {
        if (head == null) {
            return;
        }

        if (head.getValue() == value) {
            head = head.getNext();
            return;
        }

        Node<M> temp = head;

        while (temp.getNext() != null) {
            if (temp.getNext().getValue() == value) {
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
    }

    public void printAll() {
        Node<M> temp = head;

        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void addFirst(M value) {
        Node<M> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
    }

    public void removeAll(M value) {
        while (head != null && head.getValue() == value) {
            head = head.getNext();
        }

        Node<M> temp = head;

        while (temp != null && temp.getNext() != null) {
            if (temp.getNext().getValue() == value) {
                temp.setNext(temp.getNext().getNext());
            } else {
                temp = temp.getNext();
            }
        }
    }
}