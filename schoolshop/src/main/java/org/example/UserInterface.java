package org.example;

import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    ShopManager shopManager = new ShopManager();

    private int onlyInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Podaj liczbę");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void showCatalog() {
        for (Product product : shopManager.getAllProducts()) {
            System.out.printf("%s %s %.2f zł stan: %d%n",
                    product.getCode(),
                    product.getName(),
                    product.getPriceInGrosze() / 100.0,
                    product.getStock()
            );
        }
    }

    public void handleAddToCart(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj kod produktu: ");
        String code = scanner.nextLine();

        System.out.println("Podaj ilość: ");
        int quantity = onlyInt(scanner);

        boolean added = shopManager.addToCart(code, quantity);

        if (added) {
            System.out.println("Produkt dodano do koszyka");
        } else {
            System.out.println("Nie udało się dodać produktu");
        }
    }

    public void handleRemoveFromCart(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj kod produktu: ");
        String code = scanner.nextLine();

        System.out.println("Podaj ilość: ");
        int quantity = onlyInt(scanner);

        boolean removed = shopManager.removeFromCart(code, quantity);

        if (removed) {
            System.out.println("Produkt usunięto do koszyka");
        } else {
            System.out.println("Nie udało się usunąć produktu");
        }
    }

    public void handleFindProduct(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj kod produktu: ");
        String code = scanner.nextLine();
        Product product = shopManager.findProduct(code);

        if (product == null) {
            System.out.println("Nie znaleziono produktu");
        } else {
            System.out.printf("Kod: %s%nNazwa: %s%nCena: %d gr%nStan: %d szt.%n",
                    product.getCode(), product.getName(), product.getPriceInGrosze(), product.getStock());
        }
    }

    public void handleClearCart() {
        shopManager.clearCart();
        System.out.println("Koszyk został wyczyszczony");
    }

    private void showCart() {
        Map<String, Integer> cartItems = shopManager.getCartItems();
        if (cartItems.isEmpty()) {
            System.out.println("Koszyk jest pusty");
            return;
        }
        for (String code : cartItems.keySet()) {
            Product product = shopManager.findProduct(code);
            int quantity = cartItems.get(code);
            int itemValue = product.getPriceInGrosze() * quantity;

            System.out.printf("%s (%s): %d szt. * %d gr/szt. = %d gr%n",
                    product.getName(), code, quantity, product.getPriceInGrosze(), itemValue);
        }
        int totalPriceInGrosze = shopManager.getTotalPriceInGrosze();
        System.out.printf("Razem: %d,%02d zł%n", totalPriceInGrosze / 100, totalPriceInGrosze % 100);
    }

    public void handlePurchase() {
        boolean purchase = shopManager.purchase();

        if (purchase) {
            System.out.println("Zakupiono rzeczy");
        } else {
            System.out.println("Koszyk jest pusty lub jest za mało produktów");
        }
    }

    public void showMenu() {
        String textMenu = """
                1.Katalog
                2.Znajdź produkt
                3.Dodaj do koszyka
                4.Usuń sztuki
                5.Koszyk
                6.Kup
                7.Wyczyść koszyk bez zakupu
                0.Wyjście
                """;
        System.out.println(textMenu);
    }

    public void startMenu(Scanner scanner) {
        int choice = -1;

        while (choice != 0) {
            showMenu();
            choice = onlyInt(scanner);

            switch (choice) {
                case 1 -> showCatalog();
                case 2 -> handleFindProduct(scanner);
                case 3 -> handleAddToCart(scanner);
                case 4 -> handleRemoveFromCart(scanner);
                case 5 -> showCart();
                case 6 -> handlePurchase();
                case 7 -> handleClearCart();
                case 0 -> System.out.println("Źegnam cocot");
                default -> System.out.println("Błędna opcja");
            }
        }
    }
}