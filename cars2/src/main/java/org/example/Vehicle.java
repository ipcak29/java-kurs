package org.example;

import java.math.BigDecimal;

abstract class Vehicle {
    protected String brand;
    protected String model;
    protected FuelType fuelType;
    protected int year;
    protected double fuelLeft;
    protected double maxFuel = 60;

    public Vehicle(String brand, String model, FuelType fuelType, int year, double fuelLeft) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.year = year;
        this.fuelLeft = fuelLeft;
    }

    protected void displayInfo() {
        System.out.printf("  Marka %s %n  Model: %s %n  Rok produkcji: %d %n  Rodzaj paliwa: %s %n  Stan paliwa: %.2f %n",
                brand, model, year, fuelType, fuelLeft);
    }

    protected void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Błędna ilość paliwa");
        } else if (fuelLeft + liters <= maxFuel) {
            System.out.println("Mozna zatankowac");
            fuelLeft += liters;
            System.out.println("Zalano: " + liters);
            System.out.printf("Paliwo kosztowało: %.2f %n   "
                    , fuelType.refuelPrice(BigDecimal.valueOf(liters)));
        } else {
            System.out.println("Przekroczona pojemnosc zbiornika");
        }
    }
}
