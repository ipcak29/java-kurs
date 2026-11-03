package org.example;

public class AlreadyBorrowedException extends  RuntimeException{
    public AlreadyBorrowedException(String message) {
        super(message);
    }
}
