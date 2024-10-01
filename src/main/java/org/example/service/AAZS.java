package org.example.service;

import org.example.request.Client;

import java.util.HashMap;

public class AAZS extends FuelStation {
    public AAZS() {
        fuelStationType = FuelStationType.AAZS;
        vault = initVault();
        prices = initPrices();
    }


    public HashMap<FuelType, Fuel> initVault() {
        HashMap<FuelType, Fuel> vault = new HashMap<>();

        Fuel fuel95 = new Fuel(FuelType.F95, 15000);
        vault.put(fuel95.type, fuel95);

        Fuel fuel92 = new Fuel(FuelType.F92, 30000);
        vault.put(fuel92.type, fuel92);

        return vault;
    }
    HashMap<FuelType, Double> initPrices() {
        HashMap<FuelType, Double> prices = new HashMap<>();
        prices.put(FuelType.F95, 48.2);
        prices.put(FuelType.F92, 45.6);
        return prices;
    }

}
