package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.Player;

import java.util.List;

public interface PlayerService extends Service {
    String buyComputer(Computer computer, double price);
    void destroyComputer(Computer computer);
    void mineMoney();
    List<Computer> listOwnedComputers();
    void setPlayer(Player player);
    int getPlayerBits();
    double getPlayerMoney();
    int getExperience();
    int getEnergy();
    void drinkCoffee();
    void fullEnergy();
    void hack(int bitsEarned, int energyToHack);
    void spendMoney(int moneySpent);

}
