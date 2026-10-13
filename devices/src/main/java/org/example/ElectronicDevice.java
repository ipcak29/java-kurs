package org.example;

public abstract class ElectronicDevice implements Usable {
    protected String brand;
    protected String model;
    protected int year;
    protected DeviceType deviceType;
    protected int batteryLevel;
    protected int batteryCapacity;

    protected ElectronicDevice(String brand, String model, int year,
                               DeviceType deviceType, int batteryLevel, int batteryCapacity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.deviceType = deviceType;
        this.batteryLevel = batteryLevel;
        this.batteryCapacity = batteryCapacity;
    }

    protected void displayInfo() {
        System.out.printf(
                "Marka: %s%nModel: %s%nRok produkcji: %d%nRodzaj urządzenia: " +
                        "%s%nPoziom baterii: %d%nMaksymalna pojemność baterii: %d%n"
                , brand, model, year, deviceType, batteryLevel, batteryCapacity);
    }

    protected void charge(double amount) {
        if (amount <= 0) {
            System.out.println("Ilość ładowania musi być powyżej zera");
            return;
        }

        if (batteryLevel + amount > batteryCapacity) {
            System.out.println(
                    "Podana ilość ładowania jest zbyt duża, bateria doładuje sie do maksymalnej pojemności");
        }
        System.out.println("Ładowanie baterii o: " + amount);
        batteryLevel = (int) Math.min(batteryCapacity, batteryLevel + amount);
    }

    @Override
    public void use(double hours) {
        if (hours <= 0) {
            System.out.println("Błędny czas pracy");
            return;
        }
        if (batteryLevel <= 0) {
            System.out.println("Bateria rozładowana, podłącz do ładowarki");
            return;
        }

        System.out.printf("Praca laptopa przez: %.1f godziny %n", hours);

        double consumption = deviceType.calculateConsumption(hours);

        if (batteryLevel < consumption) {
            System.out.println("Zbyt mało baterii, na okreslony czas pracy");
        }
        batteryLevel -= (int) consumption;

        if (batteryLevel < 0) {
            batteryLevel = 0;
        }
    }
}


