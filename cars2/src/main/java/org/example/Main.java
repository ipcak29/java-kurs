package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Działanie samochodu: ");
        Car car1 = new Car("bmw", "e46", FuelType.DIESEL, 2001, 5, 20);
        car1.displayInfo();
        car1.refuel(15);
        car1.drive();
        car1.displayInfo();
        System.out.println();

        System.out.println("Działanie motoru:");
        Motorcycle moto1 = new Motorcycle("Kawasaki", "Ninja", FuelType.PETROL, 2005, 2, 5);
        moto1.displayInfo();
        moto1.refuel(10);
        moto1.drive();
        moto1.displayInfo();

    }
}
