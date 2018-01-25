package org.academiadecodigo.bootcamp.model;

public abstract class Computer implements Comparable<Computer>{
    private int moneyGenerated;

    public Computer(int value) {
        moneyGenerated = value;
    }

    @Override
    public int compareTo(Computer o) {
        if(this.getMoneyGenerated() > o.getMoneyGenerated()) {
            return 1;
        } else if(this.getMoneyGenerated() < o.getMoneyGenerated()){
            return -1;
        }
        return 0;
    }

    public int getMoneyGenerated() {
        return moneyGenerated;
    }
}
