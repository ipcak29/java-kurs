package org.example;

public enum FuelType {
    PETROL(8.30),
    DIESEL(9.20),
    ELECTRIC(3.20);

    private final double price;

    FuelType(double price) {
        this.price = price;
    }

    double getPrice() {
        return price;
    }
}
