package org.example;

public class Laptop extends ElectronicDevice {
    private final int ramSize;

    @Override
    protected void displayInfo() {
        super.displayInfo();
        System.out.println("Ilość pamięci ram: " + ramSize);
    }

    public Laptop(String brand, String model, int year, DeviceType deviceType,
                  int batteryLevel, int batteryCapacity, int ramSize) {
        super(brand, model, year, deviceType, batteryLevel, batteryCapacity);
        this.ramSize = ramSize;
    }
}

