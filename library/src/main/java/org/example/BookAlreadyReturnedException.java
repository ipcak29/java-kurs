package org.example;

public class BookAlreadyReturnedException extends Exception {
    public BookAlreadyReturnedException(String message) {
        super(message);
    }
}
