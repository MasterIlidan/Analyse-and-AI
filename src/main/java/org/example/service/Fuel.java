package org.example.service;

public class Fuel {
    public FuelType type;
    private int value;

    public Fuel(FuelType type, int value) {
        this.type = type;
        this.value = value;
    }

    /**
     *
     * @param countOfFuel
     * количество топлива, которое хочет заправить клиент
     * @return
     * true - заправка успешна
     * false - недостаточно топлива на заправке, клиенту отказано
     */
    public boolean refillClientCar(int countOfFuel) {
        System.out.println("Remaining Fuel + " + type.fuelType + ": " + value);
        if ((value - countOfFuel) >= 0) {
            value = value - countOfFuel;
            return true;
        } else {
            return false;
        }
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
