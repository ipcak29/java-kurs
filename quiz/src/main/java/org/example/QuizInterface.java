package org.example;

import java.util.*;

public class QuizInterface {

    static int[] getUsers(int users, Scanner scanner) {
        while (users < 1 || users > 20) {
            System.out.println("Błędna ilość uczestników");
            users = onlyInt(scanner);
        }
        System.out.println("Ilosc uzytkownikow zgodna");
        return new int[users];
    }

    static int sum(int[] results) {
        int sum = 0;
        for (int result : results) {
            sum += result;
        }
        return sum;
    }

    static double average(int[] results) {
        double average;
        average = (double) sum(results) / results.length;
        return average;
    }

    static void changeScore(int[] result, Scanner scanner) {
        System.out.println("Dla jakiego uczestnika zmienić wynik?");
        int participantNumber = onlyInt(scanner);
        while (participantNumber < 1 || participantNumber > result.length) {
            System.out.println("Błędny numer");
            participantNumber = onlyInt(scanner);
        }
        System.out.println("Podaj nowy wynik: ");
        int newScore = onlyInt(scanner);
        while (newScore < 0 || newScore > 100) {
            System.out.println("Błędny wynik");
            newScore = onlyInt(scanner);
        }
        result[participantNumber - 1] = newScore;
    }

    static void rateAverage(double average) {
        if (average < 50) {
            System.out.println("Do powtórki");
        } else if (average < 80) {
            System.out.println("Dobry wynik");
        } else {
            System.out.println("Bardzo dobry wynik");
        }
    }

    static int countPassed(int[] results) {
        int passed = 0;
        for (int result : results) {
            if (result >= 50) {
                passed++;
            }
        }
        return passed;
    }

    static int min(int[] results) {
        int min = results[0];
        for (int result : results) {
            if (result < min) {
                min = result;
            }
        }
        return min;
    }

    static int max(int[] results) {
        int max = results[0];
        for (int result : results) {
            if (result > max) {
                max = result;
            }
        }
        return max;
    }

    static void showResults(int[] results) {
        for (int i = 0; i < results.length; i++) {
            System.out.printf("Użytkownik nr: %s  wynik: %s ", (i + 1), results[i]);
            if (results[i] >= 50) {
                System.out.printf("Przeszedł dalej nr: %s, z wynikiem: %s%n", (i + 1), results[i]);
            } else {
                System.out.printf("Nie zaliczył użytkownik nr: %s , z wynikiem: %s%n", (i + 1), results[i]);
            }
        }
    }

    static void showStatistics(int[] results) {
        int sum = sum(results);
        double average = average(results);
        int min = min(results);
        int max = max(results);
        int passed = countPassed(results);
        int notPassed = results.length - passed;

        System.out.printf("Suma wyników: %s%n Średnia wyników: %s%n" +
                " Wynik minimalny: %s%n Wynik maksymalny: %s%n Przeszli dalej: %s%n" +
                "Nie przeszli dalej: %s%n", sum, average, min, max, passed, notPassed);
        rateAverage(average);
    }

    static void showUnique(int[] results) {
        Set<Integer> unique = uniqueValues(results);
        System.out.printf("Unikalne wyniki: %s%n Ilość unikalnych wyników: %s%n", unique, unique.size());
    }

    static void showFrequencies(int[] results) {
        Map<Integer, Integer> frequencies = frequencies(results);
        System.out.printf("Częstotliwości: %s%n", frequencies);
        mostFrequent(frequencies);
    }

    static int onlyInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Wymagana liczba, błędny typ!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static Set<Integer> uniqueValues(int[] results) {
        Set<Integer> unique = new HashSet<>();
        for (int result : results) {
            unique.add(result);
        }
        return unique;
    }

    static Map<Integer, Integer> frequencies(int[] results) {
        Map<Integer, Integer> frequent = new HashMap<>();
        for (int result : results) {
            int count = frequent.getOrDefault(result, 0);
            frequent.put(result, count + 1);
        }
        return frequent;
    }

    static void mostFrequent(Map<Integer, Integer> frequent) {
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

    static void getScore(int[] result, Scanner scanner) {
        for (int i = 0; i < result.length; i++) {
            System.out.printf("Uczestniku nr: %s,  podaj wynik(0-100)", (i + 1));
            result[i] = onlyInt(scanner);

            while (result[i] < 0 || result[i] > 100) {
                System.out.println("Błędny wynik, spróbuj ponownie");
                result[i] = onlyInt(scanner);
            }
        }
    }

    static void menuOptions() {
        String textMenu = """
                Menu
                1.Pokaż wyniki
                2.Pokaż podstawowe statystyki
                3.Pokaż unikalne wyniki
                4.Pokaż częstotliwość i najczęstsze wyniki
                5.Popraw wynik uczestnika
                0.Zakończ
                """;
        System.out.print(textMenu);
    }
}
