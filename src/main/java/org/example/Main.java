package org.example;

import org.example.request.*;
import org.example.service.AAZS;
import org.example.service.AZS;
import org.example.service.FuelStationType;
import org.example.service.FuelType;
import org.example.vault.Vault;

import java.util.ArrayList;

public class Main {
    static ArrayList<LightCarAZSGenerator> lightCarAZSClients = new ArrayList<>();
    static ArrayList<HeavyCarAZSGenerator> heavyCarAZSClients = new ArrayList<>();
    static ArrayList<AZS> fuelAZSStations = new ArrayList<>();

    static ArrayList<LightCarAAZSGenerator> lightCarAAZSClients = new ArrayList<>();
    static ArrayList<HeavyCarAAZSGenerator> heavyCarAAZSClients = new ArrayList<>();
    static ArrayList<AAZS> fuelAAZSStations = new ArrayList<>();


    public static void main(String[] args) {
        init();

        //model loop
        for (int i = 0; i < 14400; i++) {
            makeAZSTick();
            makeAAZSTick();
        }

        makeResults();
    }

    private static void init() {
        for (int i = 0; i < 14; i++) {
            lightCarAZSClients.add(new LightCarAZSGenerator(6, 40, 10));
            heavyCarAZSClients.add(new HeavyCarAZSGenerator(13, 270, 30));
            fuelAZSStations.add(new AZS());
        }
        for (int i = 0; i < 16; i++) {
            lightCarAAZSClients.add(new LightCarAAZSGenerator(6, 40, 10));
            heavyCarAAZSClients.add(new HeavyCarAAZSGenerator(13, 270, 30));
            fuelAAZSStations.add(new AAZS());
        }
        Vault.initVaults(42000, 24000);
    }

    public static void makeAZSTick() {
        for (int i = 0; i < fuelAZSStations.size(); i++) {

            Client lightClient = lightCarAZSClients.get(i).makeNewClient();
            if (lightClient == null) {
                continue;
            }
            if (fuelAZSStations.get(i).service(lightClient)) {

                System.out.println("Service!\n");
            } else {
                System.out.println("not enough fuel!\n");
            }

            Client heavyClient = heavyCarAZSClients.get(i).makeNewClient();
            if (heavyClient == null) {
                continue;
            }
            if (fuelAZSStations.get(i).service(heavyClient)) {

                System.out.println("Service!\n");
            } else {
                System.out.println("not enough fuel!\n");
            }


        }

    }

    public static void makeAAZSTick() {
        for (int i = 0; i < fuelAAZSStations.size(); i++) {

            Client lightClient = lightCarAAZSClients.get(i).makeNewClient();
            if (lightClient == null) {
                continue;
            }
            if (fuelAAZSStations.get(i).service(lightClient)) {

                System.out.println("Service!\n");
            } else {
                System.out.println("not enough fuel!\n");
            }

            Client heavyClient = heavyCarAAZSClients.get(i).makeNewClient();
            if (heavyClient == null) {
                continue;
            }
            if (fuelAAZSStations.get(i).service(heavyClient)) {

                System.out.println("Service!\n");
            } else {
                System.out.println("not enough fuel!\n");
            }

        }
    }

    public static void makeResults() {
        System.out.println("----------RESULTS----------");

        //----------FUEL REMAINING----------

        double income = 0;
        for (AZS azs : fuelAZSStations) {
            System.out.printf("%s fuel remaining 92: %d, 95: %d, 98: %d, DT: %d\n", azs.getName(), azs.getCurrentFuel(FuelType.F92), azs.getCurrentFuel(FuelType.F95), azs.getCurrentFuel(FuelType.F98), azs.getCurrentFuel(FuelType.DT));
            income += azs.getIncome();
        }
        for (AAZS azs : fuelAAZSStations) {
            System.out.printf("%s fuel remaining 92: %d, 95: %d\n", azs.getName(), azs.getCurrentFuel(FuelType.F92), azs.getCurrentFuel(FuelType.F95));
            income += azs.getIncome();
        }
        System.out.printf("""
                Fuel remaining in main vaults:
                \tAZS:
                92: %d
                95: %d
                98: %d
                DT: %d
                \tAAZS:
                92: %d
                95: %d
                """, Vault.getCurrentFuel(FuelStationType.AZS, FuelType.F92), Vault.getCurrentFuel(FuelStationType.AZS, FuelType.F95), Vault.getCurrentFuel(FuelStationType.AZS, FuelType.F98), Vault.getCurrentFuel(FuelStationType.AZS, FuelType.DT), Vault.getCurrentFuel(FuelStationType.AAZS, FuelType.F92), Vault.getCurrentFuel(FuelStationType.AAZS, FuelType.F95));

        //----------SERVICE----------

        for (AZS azs : fuelAZSStations) {
            System.out.printf("%s clients %d, serviced %d, %2f%s\n", azs.getName(), azs.getClients(), azs.getServicedClients(), ((double) azs.getServicedClients() / azs.getClients()) * 100, "%");
        }
        for (AAZS azs : fuelAAZSStations) {
            System.out.printf("%s clients %d, serviced %d, %2f%s\n", azs.getName(), azs.getClients(), azs.getServicedClients(), ((double) azs.getServicedClients() / azs.getClients()) * 100, "%");
        }

        System.out.printf("Income : %2f", income);
    }
}