package org.academiadecodigo.bootcamp.model;

public abstract class Computer {
    private int moneyGenerated;

    public Computer(int value) {
        moneyGenerated = value;
    }

    public int getMoneyGenerated() {
        return moneyGenerated;
    }
}
