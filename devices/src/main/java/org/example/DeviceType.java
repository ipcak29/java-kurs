package org.example;

public enum DeviceType {
    LAPTOP(50),
    SMARTPHONE(10),
    TABLET(20);

    private final int wattsPerHour;

    DeviceType(int wattsPerHour) {
        this.wattsPerHour = wattsPerHour;
    }

    public double calculateConsumption(double hours) {
        return wattsPerHour * hours;
    }
}
