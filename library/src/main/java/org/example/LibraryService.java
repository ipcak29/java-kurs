package org.example;

public class LibraryService {
    private static final int MAX_ITEMS = 50;
    private final LibraryItem[] items = new LibraryItem[MAX_ITEMS];
    private int count = 0;

    public void addItem(LibraryItem item) {
        if (count < MAX_ITEMS) {
            items[count++] = item;
            return;
        }
        System.out.println("Biblioteka zapelniona");
    }

    public LibraryItem[] listItems(boolean borrowed) {
        LibraryItem[] result = new LibraryItem[MAX_ITEMS];

        int i = 0;
        for (LibraryItem item : items) {
            if (item == null) {
                continue;
            }

            if (item.isBorrowed() == borrowed) {
                result[i] = item;
                i++;
            }
        }
        return result;
    }

    public void borrowItem(String title) {
        for (LibraryItem item : items) {
            if (item != null && item.getTitle().equals(title)) {
                item.borrow();
            }
        }
    }

    public void returnItem(String title) {
        for (LibraryItem item : items) {
            if (item != null && item.getTitle().equals(title)) {
                item.returnItem();
            }
        }
    }


}

