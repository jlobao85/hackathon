package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.actions.MineMoney;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.Player;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerServiceImpl implements PlayerService {
    private Player player;

    @Override
    public void buyComputer(Computer computer, int price) {
        if(player.getComputersOwned().size() >= 5) {
            return;
        }
        player.getComputersOwned().add(computer);
        player.setMoneyAmount(player.getMoneyAmount() - price);
    }

    @Override
    public void destroyComputer(Computer computerToDelete) {
        player.getComputersOwned().remove(computerToDelete);
        /*
        Computer computerToDelete = null;
        for(int i = 0; i < player.getComputersOwned().size(); i++) {
            for (int y = 0; y < player.getComputersOwned().size(); y++) {
                if(player.getComputersOwned().get(i) == player.getComputersOwned().get(y)) {
                    continue;
                }

                if(player.getComputersOwned().get(i).getMoneyGenerated() < player.getComputersOwned().get(y).getMoneyGenerated()) {
                    computerToDelete = player.getComputersOwned().get(i);
                }
            }
        }
        player.getComputersOwned().remove(computerToDelete);*/
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
