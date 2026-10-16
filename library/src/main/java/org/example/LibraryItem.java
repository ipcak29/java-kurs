package org.example;

public abstract class LibraryItem {
    private String title;
    private boolean borrowed;

    public LibraryItem(String title, boolean borrowed) {
        this.title = title;
        this.borrowed = borrowed;
    }

    public String displayInfo() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public boolean isReturned() {
        return borrowed = false;
    }

    public void borrow() {
        borrowed = true;

    }

    public void returnItem() {
        borrowed = false;
    }

    public void showInfo() {

    }
}
