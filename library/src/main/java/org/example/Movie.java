package org.example;

public class Movie extends LibraryItem{

    public Movie(String title , String director, boolean borrowed, int durationTime) {
        super(title, borrowed);
    }
}
