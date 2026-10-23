package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe użytkowników ");
        int users = onlyInt(scanner);

        int[] result = getUsers(users, scanner);

        getScore(result, scanner);
        Set<Integer> unique = uniqueValues(result);
        Map<Integer, Integer> frequent = frequencies(result);

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
                Częstotliwość: %s
                """.formatted(sum, average, min, max, passed, notPassed, unique, unique.size(), frequent);
        System.out.print(texts);
        mostFrequent(frequent);
    }

    private static void mostFrequent(Map<Integer, Integer> frequent) {
        int maxFreq = 0;
        for (int count : frequent.values()) {
            if (count > maxFreq) {
                maxFreq = count;
            }
        }
        for (Integer score : frequent.keySet()) {
            if (frequent.get(score) == maxFreq) {
                System.out.printf("Najczęstszy wynik: %s , ile razy wystąpiło: %s", score, maxFreq);
            }
        }
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
            System.out.printf("Uczestniku nr: %s,  podaj wynik(0-100)", (i + 1));
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
            System.out.printf("Użytkownik nr: %s  wynik: %s ", (i + 1), results[i]);
            if (results[i] >= 50) {
                System.out.printf("Przeszedł dalej nr: %s, z wynikiem: %s%n", (i + 1), results[i]);
            } else {
                System.out.printf("Nie zaliczył użytkownik nr: %s , z wynikiem: %s%n", (i + 1), results[i]);
            }
        }
    }

    static int onlyInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Wymagana liczba, błędny typ!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static Set<Integer> uniqueValues(int[] results) {////tu sie zatrzymalem, czasu braklo
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

}
