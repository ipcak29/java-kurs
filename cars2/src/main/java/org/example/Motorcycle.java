package org.example;

public class Motorcycle extends Vehicle implements Driveable {
    public static void main(String[] args) {
        Motorcycle moto1 = new Motorcycle("Kawasaki", "Ninja", FuelType.PETROL, 2005, 2, 0);
        moto1.displayInfo();
        moto1.refuel(10);
        moto1.drive();
    }

    int seats;

    void displayInfo() {
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


