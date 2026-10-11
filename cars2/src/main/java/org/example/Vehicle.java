package org.example;

abstract class Vehicle {
    String brand;
    String model;
    FuelType fuelType;
    int year;
    double fuelLeft = 0;
    double maxFuel = 60;
    double cost;

    public Vehicle(String brand, String model, FuelType fuelType, int year, double fuelLeft) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.year = year;
        this.fuelLeft = fuelLeft;
    }

    void displayInfo() {
        System.out.printf("  Marka %s %n  Model: %s %n  Rok produkcji: %d %n  Rodzaj paliwa: %s %n  Stan paliwa: %.2f %n",
                brand, model, year, fuelType, fuelLeft);
    }

    void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Błędna ilość paliwa");
        } else if (fuelLeft + liters <= maxFuel) {
            System.out.println("Mozna zatankowac");
            fuelLeft += liters;
            cost = fuelType.getPrice() * liters;
            System.out.println("Zalano: " +liters);
            System.out.printf("Paliwo kosztowało: %.2f %n   ", cost);
        } else {
            System.out.println("Przekroczona pojemnosc zbiornika");
        }
    }
}
