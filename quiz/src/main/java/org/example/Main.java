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
            System.out.println("Menu");
            System.out.println("1.Pokaż wyniki");
            System.out.println("2.Pokaż podstawowe statystyki");
            System.out.println("3.Pokaż unikalne wyniki");
            System.out.println("4.Pokaż częstotliwość i najczęstsze wyniki");
            System.out.println("5.Popraw wynik uczestnika");
            System.out.println("0.Zakończ");
            int choice = onlyInt(scanner);
            switch (choice) {
                case 1 -> showResults(result);
                case 2 -> showStatistics(result);
                case 3 -> showUnique(result);
                case 4 -> showFrequencies(result);
                case 5 -> changeScore(result, scanner);
                case 0 -> running = false;
                default -> System.out.println("Błędna opcja");
            }
        }
    }
}
