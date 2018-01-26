package org.academiadecodigo.bootcamp.model;

public abstract class Computer implements Comparable<Computer>{
    private String name;
    private int moneyGenerated;
    private double price;
    private String convertedPrice;


    public Computer(String name, int value, double price) {
        this.name = name;
        moneyGenerated = value;
        this.price = price;
        this.convertedPrice = price + " €";
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

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getConvertedPrice() {
        return convertedPrice;
    }
}
