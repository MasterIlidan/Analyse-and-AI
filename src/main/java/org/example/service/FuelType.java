package org.example.service;

public final class FuelType {
    public final String fuelType;
    public final static FuelType F92 = new FuelType("92");
    public final static FuelType F98 = new FuelType("98");
    public final static FuelType F95 = new FuelType("95");
    public final static FuelType DT = new FuelType("DT");

    private FuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
