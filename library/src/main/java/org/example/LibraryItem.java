package org.example;

public abstract class LibraryItem {
    private final String title;
    private boolean borrowed;

    public LibraryItem(String title, boolean borrowed) {
        this.title = title;
        this.borrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public String displayInfo() {
        return title;
    }

    public boolean isReturned() {
        return borrowed = false;
    }

    public void borrow() {
        if (borrowed == true) {
            System.out.println("Element jest wypozyczony");
            return;
        }
        System.out.printf("Wypozyczono %s%n", title);
        borrowed = true;
    }

    public void returnItem() {
        if(borrowed == false){
            System.out.println("Zwrócony element");
            return;
        }
        System.out.printf("Zwrócono %s%n", title);
        borrowed = false;
    }

    public void showInfo() {

    }
}

