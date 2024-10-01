package org.example.request;

import org.example.service.FuelType;

import java.util.ArrayList;

public class HeavyCarAZSGenerator extends Generator {
    public HeavyCarAZSGenerator(int frequencyBound, int fuelBound, int fuelOffset) {
        super(ClientType.heavy, frequencyBound, fuelBound, fuelOffset);

        availableFuelTypes = new ArrayList<>();
        availableFuelTypes.add(FuelType.DT);
        availableFuelTypes.add(FuelType.F92);

        makeNewRandomTimeToNextClient();
    }
}
