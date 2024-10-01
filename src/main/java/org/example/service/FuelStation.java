package org.example.service;

import org.example.request.Client;
import org.example.vault.Vault;

import java.util.HashMap;

public class FuelStation {
    FuelStationType fuelStationType;
    HashMap<FuelType, Fuel> vault;
    private final int critical = 2000;
    double income = 0;
    int clients = 0;
    int servicedClients = 0;

    HashMap<FuelType, Double> prices;

    public boolean service(Client client) {
        clients++;
        System.out.println(client.getClientType().getType() + " client want " + client.getFuelType().fuelType + ", count: " + client.getCountOfFuel());
        boolean success = vault.get(client.getFuelType()).refillClientCar(client.getCountOfFuel());
        if (success) {
            servicedClients++;
            income += prices.get(client.getFuelType());
            if (vault.get(client.getFuelType()).getValue() < critical) {
                Fuel refillingFuel = vault.get(client.getFuelType());
                int currentValue = refillingFuel.getValue();
                System.out.printf("Low fuel in vault. Now %d, refilling...", currentValue);
                int newValue = currentValue + Vault.refill(fuelStationType, refillingFuel.type,6000);
                refillingFuel.setValue(refillingFuel.getValue() + newValue);

                vault.put(refillingFuel.type, refillingFuel);
                System.out.printf(" now %d\n", newValue);
            }
        }
        System.out.println("Current income " + income);
        return success;
    }
    public double getIncome() {
        return income;
    }
}