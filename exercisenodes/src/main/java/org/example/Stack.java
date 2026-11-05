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

    public boolean contains(int value) {
        Node temp = head;

        while (temp != null) {

            if (temp.getValue() == value) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void remove(int value){
        if(head == null){
            return;
        }

        if(head.getValue() == value){
            head = head.getNext();
            return;
        }

        Node temp = head;

        while(temp.getNext() != null){
            if (temp.getNext().getValue() == value){
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
    }
}
//chcemy dodać do naszego stacku metode remove(3)  usunie nawet z wnętrza stacku noda z wartością 3
