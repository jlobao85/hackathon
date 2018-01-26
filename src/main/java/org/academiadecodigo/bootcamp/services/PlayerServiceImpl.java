package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.actions.MineMoney;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.Player;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerServiceImpl implements PlayerService {
    private Player player;

    @Override
    public String buyComputer(Computer computer, double price) {

        if(player.getComputersOwned().size() >= 5) {
            return "You don't have space at home!";
        }
        if (player.getMoneyAmount() < price){
            return "You don't have enough money!";
        }
        player.getComputersOwned().add(computer);
        player.setMoneyAmount(player.getMoneyAmount() - price);
        return "Congratulations. You bought a new computer.";
    }

    @Override
    public void destroyComputer(Computer computerToDelete) {
        Computer c = Collections.min(player.getComputersOwned());
        player.getComputersOwned().remove(c);
    }


    @Override
    public void mineMoney() {
        ExecutorService thread = Executors.newCachedThreadPool();
        thread.submit(new MineMoney(player));
    }

    @Override
    public List<Computer> listOwnedComputers() {
        return player.getComputersOwned();
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int getPlayerBits() {
        return player.getBitsAmount();
    }

    @Override
    public double getPlayerMoney() {
        return round(player.getMoneyAmount(), 2);
    }

    @Override
    public int getExperience() {
        return player.getExperience();
    }

    @Override
    public int getEnergy() {
        return player.getEnergy();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
