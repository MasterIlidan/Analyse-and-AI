package org.example.vault;

import org.example.service.FuelStationType;
import org.example.service.FuelType;

import java.util.HashMap;

public abstract class Vault {

    public static HashMap<FuelStationType,HashMap<FuelType,Integer>> vaults;
    //private static HashMap<FuelType, Integer> vault;


    public static void initVaults(int AZSCapacity, int AAZSCapacity) {
        vaults = new HashMap<>();
        vaults.put(FuelStationType.AZS, initAZSVault(AZSCapacity));
        vaults.put(FuelStationType.AAZS, initAAZSVault(AAZSCapacity));
    }

    private static HashMap<FuelType, Integer> initAZSVault(int capacity) {
        HashMap<FuelType, Integer> vault = new HashMap<>();

        vault.put(FuelType.F98, capacity);
        vault.put(FuelType.F95, capacity);
        vault.put(FuelType.F92, capacity);
        vault.put(FuelType.DT, capacity);

        return vault;
    }
    private static HashMap<FuelType, Integer> initAAZSVault(int capacity) {
        HashMap<FuelType, Integer> vault = new HashMap<>();

        vault.put(FuelType.F95, capacity);
        vault.put(FuelType.F92, capacity);

        return vault;
    }

    public static int refill(FuelStationType fuelStationType,FuelType fuelType,int count) {
        int currentCapacity = vaults.get(fuelStationType).get(fuelType);
        int returnValue;

        if (currentCapacity <= 0) {
            System.out.printf("No fuel %s in main vault\n", fuelType);
            return 0;
        }

        if (currentCapacity <= count) {
            returnValue = currentCapacity;
            vaults.get(fuelStationType).put(fuelType, 0);
            return returnValue;
        }
        if (currentCapacity > count) {
            returnValue = count;
            vaults.get(fuelStationType).put(fuelType, currentCapacity - count);
            return returnValue;
        }
        throw new RuntimeException("Fuel station type " + fuelStationType + " is out of bounds");
    }
    public static int getCurrentFuel(FuelStationType fuelStationType, FuelType fuelType) {
        return vaults.get(fuelStationType).get(fuelType);
    }
}
