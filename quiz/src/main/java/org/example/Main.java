package org.example;

import java.util.*;

import static org.example.QuizInterface.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe użytkowników ");
        int users = onlyInt(scanner);

        int[] result = getUsers(users, scanner);

        getScore(result, scanner);

        boolean running = true;
        while (running) {
            menuOptions();
            int choice = onlyInt(scanner);
            switch (choice) {
                case 1 -> showResults(result);
                case 2 -> showStatistics(result);
                case 3 -> showUnique(result);
                case 4 -> showFrequencies(result);
                case 5 -> changeScore(result, scanner);
                case 6 -> showRanges(result);
                case 0 -> running = false;
                default -> System.out.println("Błędna opcja");
            }
        }
    }
}