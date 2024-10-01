package org.example.request;

import org.example.service.FuelType;

import java.util.ArrayList;

public class LightCarAZSGenerator extends Generator {


    public LightCarAZSGenerator(int frequencyBound, int fuelBound, int fuelOffset) {
        super(ClientType.light, frequencyBound, fuelBound, fuelOffset);

        availableFuelTypes = new ArrayList<>();
        availableFuelTypes.add(FuelType.DT);
        availableFuelTypes.add(FuelType.F92);
        availableFuelTypes.add(FuelType.F95);
        availableFuelTypes.add(FuelType.F98);
        makeNewRandomTimeToNextClient();
    }
}
