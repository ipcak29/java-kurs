package org.example;

public class Book extends LibraryItem{

    public Book(String title, String author, boolean borrowed, int pages, int count) {
        super(title, borrowed);
    }
}
