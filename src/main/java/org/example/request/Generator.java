package org.example.request;

import org.example.service.FuelType;

import java.util.ArrayList;
import java.util.Random;

public abstract class Generator {
    Random rand = new Random();
    final int frequencyBound;
    final int fuelBound;
    final int fuelOffset;
    final ClientType clientType;

    int timeToNextClient = 0;

    ArrayList<FuelType> availableFuelTypes;
    public Generator(ClientType clientType,int frequencyBound, int fuelBound, int fuelOffset) {
        this.clientType = clientType;
        this.frequencyBound = frequencyBound;
        this.fuelBound = fuelBound;
        this.fuelOffset = fuelOffset;

    }
    public Client makeNewClient() {
        if (timeToNextClient == 0) {
            makeNewRandomTimeToNextClient();
            FuelType fuelType = availableFuelTypes.get(rand.nextInt(availableFuelTypes.size()));
            int countOfFuel = rand.nextInt(fuelBound) + fuelOffset;
            return new Client(clientType,fuelType, countOfFuel);
        } else {
            timeToNextClient--;
            return null;
        }
    }
    public void makeNewRandomTimeToNextClient() {
        timeToNextClient = rand.nextInt(frequencyBound);
    }
}
