package org.example;

public class Movie extends LibraryItem {
    private final String director;
    private final int durationTime;
    private static int totalMovies;

    public Movie(String title, String director, boolean borrowed, int durationTime) {
        super(title, borrowed);
        this.director = director;
        this.durationTime = durationTime;
        totalMovies++;
    }

    @Override
    public String toString() {
        return String.format("Film: %s%n " +
                "reżyser: %s%n " +
                "długość filmu: %s%n" +
                " status: %b%n", title, director, durationTime, (borrowed ? "wypożyczony" : "dostępny"));
    }

    public static int getTotalMovies() {
        return totalMovies;
    }
}
