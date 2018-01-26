package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.BitsToEuro;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private double moneyAmount;
    private int bitsAmount;
    private int experience;
    private List<Computer> computersOwned;

    public Player(String name) {
        this.name = name;
        this.bitsAmount = 25;
        this.moneyAmount = BitsToEuro.convertToEuro(bitsAmount);
        this.computersOwned = new ArrayList<>();
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
}
