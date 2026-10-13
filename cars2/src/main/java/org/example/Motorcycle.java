package org.example;

public class Motorcycle extends Vehicle implements Driveable {
    private final int seats;

    protected void displayInfo() {
        super.displayInfo();
        System.out.println("  Ilość siedzeń: " + seats);
    }

    public Motorcycle(String brand, String model, FuelType fuelType, int year, int seats, double fuelLeft) {
        super(brand, model, fuelType, year, fuelLeft);
        this.seats = seats;
    }

    @Override
    public void drive() {
        if (fuelLeft > 0) {
            System.out.println("Start jazdy");
            fuelLeft -= 1;
        } else {
            System.out.println("Brak paliwa, zatankuj");
        }
    }
}


