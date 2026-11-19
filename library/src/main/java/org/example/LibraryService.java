package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

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
        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .filter(item -> item.isBorrowed() == borrowed)
                .toArray(LibraryItem[]::new);
    }

    public void borrowItem(String title) throws TitleNotFoundException {
        LibraryItem item = findByTitle(title).orElseThrow(() ->
                new TitleNotFoundException("Nie znaleziono tytułu: " + title));

        item.borrow();
    }

    public void returnItem(String title) throws AlreadyReturnedException {
        LibraryItem item = findByTitle(title).orElseThrow(() ->
                new RuntimeException("Nie znaleziono tytułu: " + title));

        item.returnItem();
    }

    private Optional<LibraryItem> findByTitle(String title) {
        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .filter(item -> item.getTitle().equals(title))
                .findFirst();
    }
}