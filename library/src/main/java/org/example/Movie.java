package org.example;

public class Movie extends LibraryItem{
private final String director;
private final int durationTime;
private static int totalMovies;

    public Movie(String title , String director, boolean borrowed, int durationTime) {
        super(title, borrowed);
        this.director = director;
        this.durationTime = durationTime;
        totalMovies++;
    }

    @Override
    public String displayInfo() {
        return "Film " + getTitle()
                + "reżyser: " + director
                + "długość filmu: " + durationTime
                + " status: " + (isBorrowed() ? "wypożyczony" : "dostępny");
    }

    public static int getTotalMovies(){
        return totalMovies;
    }
}
