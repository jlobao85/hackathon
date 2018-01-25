package org.academiadecodigo.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int moneyAmount;
    private List<Computer> computersOwned;

    public Player(String name) {
        this.name = name;
        this.moneyAmount = 25;
        this.computersOwned = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public List<Computer> getComputersOwned() {
        return computersOwned;
    }

    public void setComputersOwned(List<Computer> computersOwned) {
        this.computersOwned = computersOwned;
    }
}
