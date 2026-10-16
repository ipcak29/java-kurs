package org.example;

public abstract class LibraryItem {
    private String title;
    private boolean borrowed;

    public LibraryItem(String title, boolean borrowed) {
        this.title = title;
        this.borrowed = borrowed;
    }

    String displayInfo(){
        return title;
    }

    boolean isBorrowed(){
        return borrowed = true;
    }

    boolean isReturned(){
        return borrowed = false;
    }

    void borrow(){

    }

    void returnItem(){

    }

    void showInfo(){

    }
}
