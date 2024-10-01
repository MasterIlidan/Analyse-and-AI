package org.example.service;

import java.util.HashMap;

public class AZS extends FuelStation {
    static int counter = 1;

    public AZS() {
        name = "AZS " + counter++;
        fuelStationType = FuelStationType.AZS;
        vault = initVault();
        prices = initPrices();
    }


    public HashMap<FuelType, Fuel> initVault() {
        HashMap<FuelType, Fuel> vault = new HashMap<>();

        Fuel fuel98 = new Fuel(FuelType.F98, 16000);
        vault.put(fuel98.type, fuel98);

        Fuel fuel95 = new Fuel(FuelType.F95, 16000);
        vault.put(fuel95.type, fuel95);

        Fuel fuel92 = new Fuel(FuelType.F92, 30000);
        vault.put(fuel92.type, fuel92);

        Fuel fuelDT = new Fuel(FuelType.DT, 30000);
        vault.put(fuelDT.type, fuelDT);

        return vault;
    }

    HashMap<FuelType, Double> initPrices() {
        HashMap<FuelType, Double> prices = new HashMap<>();
        prices.put(FuelType.F98, 50.3);
        prices.put(FuelType.F95, 48.2);
        prices.put(FuelType.F92, 45.6);
        prices.put(FuelType.DT, 51.5);
        return prices;
    }

}
