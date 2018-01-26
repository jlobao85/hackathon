package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.actions.MineMoney;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerServiceImpl implements PlayerService {
    private Player player;

    @Override
    public boolean buyComputer(Computer computer, double price) {
        if(player.getComputersOwned().size() >= 5) {
            return false;
        }
        player.getComputersOwned().add(computer);
        player.setMoneyAmount(player.getMoneyAmount() - price);
        return true;
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
    public void hack() {

    }
}
