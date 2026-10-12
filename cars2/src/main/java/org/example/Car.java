package org.example;

public class Car extends Vehicle implements Driveable {
    public static void main(String[] args) {
        Car car1 = new Car("bmw", "e46", FuelType.DIESEL, 2001, 5, 1);
        car1.drive();
        car1.displayInfo();
    }

    int doors;

    void displayInfo() {
        super.displayInfo();
        System.out.println("  Ilosc drzwi: " + doors);
    }

    public Car(String brand, String model, FuelType fuelType, int year, int doors, double fuelLeft) {
        super(brand, model, fuelType, year, fuelLeft);
        this.doors = doors;
    }

    @Override
    public void drive() {
        if (fuelLeft >= 2) {
            System.out.println("Start jazdy");
            fuelLeft -= 2;
        } else {
            System.out.println("  Brak paliwa, zatankuj");
        }
    }
}
