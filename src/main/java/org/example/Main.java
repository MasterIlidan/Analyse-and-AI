package org.example;

import org.example.request.*;
import org.example.service.AAZS;
import org.example.service.AZS;
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
        double income = 0;
        init();
        Vault.initVaults(42000, 24000);

        //model loop
        for (int i = 0; i < 14400; i++) {
            makeAZSTick();
            makeAAZSTick();
        }

        for (AZS azs : fuelAZSStations) {
            income += azs.getIncome();
        }
        for (AAZS azs : fuelAAZSStations) {
            income += azs.getIncome();
        }

        System.out.printf("Income : %2f", income);
    }

    private static void init() {
        for (int i = 0; i < 16; i++) {
            lightCarAZSClients.add(new LightCarAZSGenerator(6, 40, 10));
            heavyCarAZSClients.add(new HeavyCarAZSGenerator(13, 270, 30));
            fuelAZSStations.add(new AZS());
        }
        for (int i = 0; i < 14; i++) {
            lightCarAAZSClients.add(new LightCarAAZSGenerator(6, 40, 10));
            heavyCarAAZSClients.add(new HeavyCarAAZSGenerator(13, 270, 30));
            fuelAAZSStations.add(new AAZS());
        }
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
}