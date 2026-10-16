package org.example;

public class Book extends LibraryItem{
    private String author;
    private int pages;

    public Book(String title, boolean borrowed, String author, int pages) {
        super(title, borrowed);
        this.author = author;
        this.pages = pages;
    }
}
