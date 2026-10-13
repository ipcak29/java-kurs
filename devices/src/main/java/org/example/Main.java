package org.example;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Dell", "A317", 2025, DeviceType.LAPTOP, 80, 100, 32);

        Smartphone smartphone = new Smartphone("Nokia", "3310", 1917, DeviceType.SMARTPHONE, 60, 100, 3);

        ElectronicDevice[] devices = {
                laptop,
                smartphone
        };

        for (ElectronicDevice device : devices) {
            device.displayInfo();
            device.use(2);
            System.out.println("************");
            device.displayInfo();
            device.charge(80);
            System.out.println("************");
            device.displayInfo();
        }
    }
}
