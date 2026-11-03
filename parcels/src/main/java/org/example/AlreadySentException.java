package org.example;

public class AlreadySentException extends Exception{
    public AlreadySentException(String message) {
        super(message);
    }
}