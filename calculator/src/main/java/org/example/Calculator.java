package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lastResult;

        while (true) {
            System.out.println("Podaj działanie: ");
            String input = scanner.nextLine();
            String[] elements = input.split(" ");
            if (elements.length > 3){
                System.out.println("Błąd danych, podaj np. 1 + 1");
                continue;
            }

            double a = Double.parseDouble(elements[0]);
            char operator = elements[1].charAt(0);
            double b = Double.parseDouble(elements[2]);


            double result = switch (operator) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> {
                    if (b == 0) {
                        System.out.println("Błąd, dzielenie przez zero");
                        yield Double.NaN;
                    }
                    yield a / b;
                }
                case '%' -> a % b;
                case '^' -> Math.pow(a, b);
                default -> {
                    System.out.println("Błedny operator");
                    yield Double.NaN;
                }
            };
            if (Double.isNaN(result)) {
                continue;
            }
            System.out.println(a + " " + operator + " " + b + " = " + result);

            System.out.println("Czy chcesz wykonać kolejne działanie? y/n ");
            char choice = scanner.nextLine().charAt(0);
            if (choice == 'n') {
                System.out.println("Koniec programu");
                lastResult = result;
                break;
            }
        }
        if (lastResult % 2 == 0) {
            System.out.println("Wynik był parzysty");
        } else {
            System.out.println("Wynik byl nieparzysty");
        }

        String positiveOrNegative = lastResult > (-1)
                ? "Wynik był dodatni"
                : "Wynik był ujemny";
        System.out.println(positiveOrNegative);
    }
}