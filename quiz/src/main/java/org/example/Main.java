package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe użytkowników ");
        int users = onlyInt(scanner);

        int[] result = getUsers(users, scanner);

        getScore(result, scanner);
        Set<Integer> unique = uniqueValues(result);
        int sum = sum(result);
        double average = average(result);
        int min = min(result);
        int max = max(result);
        int passed = countPassed(result);
        int notPassed = getNotPassed(result, passed);

        showResults(result);

        rateAverage(average);

        String texts = """
                Suma wyników wynosi: %s
                Średnia wyników wynosi: %s
                Podana minimalna wartość: %s
                Podana maksymalna wartość: %s
                Ilość użytkowników, którzy przeszli dalej: %s
                Ilość użytkowników, którzy nie przeszli dalej: %s
                Unikalność: %s
                Ilość unikalności: %s
                """.formatted(sum, average, min, max, passed, notPassed, unique, unique.size());
        System.out.print(texts);
    }

    private static int[] getUsers(int users, Scanner scanner) {
        while (users < 1 || users > 20) {
            System.out.println("Błędna ilość uczestników");
            users = onlyInt(scanner);
        }
        System.out.println("Ilosc uzytkownikow zgodna");
        return new int[users];
    }

    private static void getScore(int[] result, Scanner scanner) {
        for (int i = 0; i < result.length; i++) {
            System.out.println("Uczestniku nr: " + (i + 1) + "  podaj wynik(0-100)");
            result[i] = onlyInt(scanner);

            while (result[i] < 0 || result[i] > 100) {
                System.out.println("Błędny wynik, spróbuj ponownie");
                result[i] = onlyInt(scanner);
            }
        }
    }

    private static void rateAverage(double average) {
        if (average < 50) {
            System.out.println("Do powtórki");
        } else if (average < 80) {
            System.out.println("Dobry wynik");
        } else {
            System.out.println("Bardzo dobry wynik");
        }
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

    static int countPassed(int[] results) {
        int passed = 0;
        for (int result : results) {
            if (result >= 50) {
                passed++;
            }
        }
        return passed;
    }

    private static int getNotPassed(int[] result, int passed) {
        return result.length - passed;
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
            System.out.println("Użytkownik nr: " + (i + 1) + " wynik: " + results[i]);
            if (results[i] >= 50) {
                System.out.println("Przeszedł dalej nr: " + (i + 1) + ", z wynikiem: " + results[i]);
            } else {
                System.out.println("Nie zaliczył użytkownik nr: " + (i + 1) + ", z wynikiem: " + results[i]);
            }
        }
    }

    static int onlyInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Wymagana liczba, podałes litere!");
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
}
