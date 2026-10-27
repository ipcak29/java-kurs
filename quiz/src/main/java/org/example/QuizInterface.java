package org.example;

import java.util.*;

public class QuizInterface {

    public int[] getUsers(int users, Scanner scanner) {
        while (users < 1 || users > 20) {
            System.out.println("Błędna ilość uczestników");
            users = onlyInt(scanner);
        }
        System.out.println("Ilosc uzytkownikow zgodna");
        return new int[users];
    }

    private void changeScore(Quiz quiz, Scanner scanner) {
        System.out.println("Dla jakiego uczestnika zmienić wynik?");
        int participantNumber = onlyInt(scanner);

        while (participantNumber < 1 || participantNumber > quiz.getParticipantCount()) {
            System.out.println("Błędny numer");
            participantNumber = onlyInt(scanner);
        }
        System.out.println("Podaj nowy wynik: ");
        int newScore = onlyInt(scanner);

        while (newScore < 0 || newScore > 100) {
            System.out.println("Błędny wynik");
            newScore = onlyInt(scanner);
        }
        quiz.changeScore(participantNumber, newScore);
    }

    public void rateAverage(double average) {
        if (average < 50) {
            System.out.println("Do powtórki");
        } else if (average < 80) {
            System.out.println("Dobry wynik");
        } else {
            System.out.println("Bardzo dobry wynik");
        }
    }

    public void showResults(Quiz quiz) {
        for (int i = 0; i < quiz.getParticipantCount(); i++) {
            int score = quiz.getScore(i + 1);

            System.out.printf("Użytkownik nr: %s  wynik: %s ", i + 1, score);
            if (score >= 50) {
                System.out.printf("Przeszedł dalej nr: %s, z wynikiem: %s%n", i + 1, score);
            } else {
                System.out.printf("Nie zaliczył użytkownik nr: %s , z wynikiem: %s%n", i + 1, score);
            }
        }
    }

    public void showStatistics(Quiz quiz) {
        int sum = quiz.sum();
        double average = quiz.average();
        int min = quiz.min();
        int max = quiz.max();
        int passed = quiz.countPassed();
        int notPassed = quiz.getParticipantCount() - passed;

        System.out.printf("Suma wyników: %s%n Średnia wyników: %s%n" +
                " Wynik minimalny: %s%n Wynik maksymalny: %s%n Przeszli dalej: %s%n" +
                "Nie przeszli dalej: %s%n", sum, average, min, max, passed, notPassed);
        rateAverage(average);
    }

    public void showUnique(Quiz quiz) {
        Set<Integer> unique = quiz.uniqueValues();
        System.out.printf("Unikalne wyniki: %s%n Ilość unikalnych wyników: %s%n", unique, unique.size());
    }

    public void showFrequencies(Quiz quiz) {
        Map<Integer, Integer> frequencies = quiz.frequencies();
        System.out.printf("Częstotliwości: %s%n", frequencies);
        mostFrequent(frequencies);
    }

    public int onlyInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Wymagana liczba, błędny typ!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void mostFrequent(Map<Integer, Integer> frequent) {
        int maxFreq = 0;
        for (int count : frequent.values()) {
            if (count > maxFreq) {
                maxFreq = count;
            }
        }
        for (Integer score : frequent.keySet()) {
            if (frequent.get(score) == maxFreq) {
                System.out.printf("Najczęstszy wynik: %s , ile razy wystąpiło: %s%n", score, maxFreq);
            }
        }
    }

    public void getScore(int[] result, Scanner scanner) {
        for (int i = 0; i < result.length; i++) {
            System.out.printf("Uczestniku nr: %s,  podaj wynik(0-100)", (i + 1));
            result[i] = onlyInt(scanner);

            while (result[i] < 0 || result[i] > 100) {
                System.out.println("Błędny wynik, spróbuj ponownie");
                result[i] = onlyInt(scanner);
            }
        }
    }

    public void menuOptions() {
        String textMenu = """
                Menu
                1.Pokaż wyniki
                2.Pokaż podstawowe statystyki
                3.Pokaż unikalne wyniki
                4.Pokaż częstotliwość i najczęstsze wyniki
                5.Popraw wynik uczestnika
                6.Raport przedziałów i % zaliczeń
                0.Zakończ
                """;
        System.out.print(textMenu);
    }

    public void showRanges(Quiz quiz) {
        int lowRange = quiz.countInRange(0, 49);
        int midRange = quiz.countInRange(50, 79);
        int highRange = quiz.countInRange(80, 100);
        System.out.printf("""
                0-49, liczba osób: %d
                50-79, liczba osób: %d
                80-100, liczba osób: %d""", lowRange, midRange, highRange);

        double usersPass = quiz.countPassed() * 100.0 / quiz.getParticipantCount();
        System.out.printf("%nProcent zaliczeń: %.1f%%%n", usersPass);
    }

    public void start(Scanner scanner) {
        boolean running = true;

        System.out.println("Podaj liczbe użytkowników ");
        int users = onlyInt(scanner);

        int[] result = getUsers(users, scanner);
        getScore(result, scanner);
        Quiz quiz = new Quiz(result);

        while (running) {
            menuOptions();
            int choice = onlyInt(scanner);

            switch (choice) {
                case 1 -> showResults(quiz);
                case 2 -> showStatistics(quiz);
                case 3 -> showUnique(quiz);
                case 4 -> showFrequencies(quiz);
                case 5 -> changeScore(quiz, scanner);
                case 6 -> showRanges(quiz);
                case 0 -> running = false;
                default -> System.out.println("Błędna opcja");
            }
        }
    }
}