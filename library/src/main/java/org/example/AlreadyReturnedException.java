package org.example;

public class AlreadyReturnedException extends Exception {
    public AlreadyReturnedException(String message) {
        super(message);
    }
}