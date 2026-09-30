package org.example;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Podaj wysokość: ");
//        int height = scanner.nextInt();
//
//        System.out.print("Podaj szerokość: ");
//        int width = scanner.nextInt();
//
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//
//                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//        System.out.println();
//        }

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Podaj wysokość:");
//        int height = scanner.nextInt();
//
//        for (int i = 0; i < height; i++) {
//
//            for (int spaces = 0; spaces < height - i - 1; spaces++) {
//                System.out.print(" ");
//            }
//
//            for (int stars = 0; stars < 2 * i + 1; stars++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nowe hasło: ");
        String password = scanner.nextLine();

        boolean unique = true;

        for (int i = 0; i+1 < password.length(); i++) {

            for (int j = i+1; j < password.length(); j++) {

                if (password.charAt(i) == password.charAt(j) && i != j) {
                    unique = false;
                    System.out.println("Nieunikalne");
                    break;
                }
            }

            if (!unique) {
                break;
            }
        }

        if (unique) {
            System.out.println("Unikalne");
        }
    }
}

