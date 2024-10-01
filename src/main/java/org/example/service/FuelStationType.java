package org.example.service;

public class FuelStationType {
    public final String type;
    public static FuelStationType AZS = new FuelStationType("AZS");
    public static FuelStationType AAZS = new FuelStationType("AAZS");

    private FuelStationType(String type) {
        this.type = type;
    }

}
