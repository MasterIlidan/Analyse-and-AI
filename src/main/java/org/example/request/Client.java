package org.example.request;

import org.example.service.FuelType;


public class Client {
    private final ClientType clientType;
    private final FuelType fuelType;
    private final int countOfFuel;

    Client(ClientType clientType, FuelType fuelType, int countOfFuel) {
        this.clientType = clientType;
        this.fuelType = fuelType;
        this.countOfFuel = countOfFuel;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getCountOfFuel() {
        return countOfFuel;
    }

    public ClientType getClientType() {
        return clientType;
    }


}
