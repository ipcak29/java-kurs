package org.example;

public class Smartphone extends ElectronicDevice {
    private final int cameraMegapixels;

    @Override
    protected void displayInfo() {
        super.displayInfo();
        System.out.println("Ilość megapikseli: " + cameraMegapixels);
    }

    public Smartphone(String brand, String model, int year, DeviceType deviceType,
                      int batteryLevel, int batteryCapacity, int cameraMegapixels) {
        super(brand, model, year, deviceType, batteryLevel, batteryCapacity);
        this.cameraMegapixels = cameraMegapixels;
    }
}
