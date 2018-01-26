package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.BitsToEuro;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private double moneyAmount;
    private int bitsAmount;
    private int experience;
    private int energy;
    private List<Computer> computersOwned;

    public Player(String name, Computer computer) {
        this.name = name;
        this.bitsAmount = 250;
        this.energy = 100;
        this.moneyAmount = BitsToEuro.convertToEuro(bitsAmount);
        this.computersOwned = new ArrayList<>();
        this.computersOwned.add(computer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public List<Computer> getComputersOwned() {
        return computersOwned;
    }

    public void setComputersOwned(List<Computer> computersOwned) {
        this.computersOwned = computersOwned;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public int getBitsAmount() {
        return bitsAmount;
    }

    public void setBitsAmount(int bitsAmount) {
        this.bitsAmount = bitsAmount;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
