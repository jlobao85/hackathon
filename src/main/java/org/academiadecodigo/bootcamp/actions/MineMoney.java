package org.academiadecodigo.bootcamp.actions;

import org.academiadecodigo.bootcamp.BitsToEuro;
import org.academiadecodigo.bootcamp.Randomizer;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.Player;

public class MineMoney implements Runnable {
    private Player player;

    public MineMoney(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        while(true) {
            try {
                for(Computer c : player.getComputersOwned()) {
                    player.setBitsAmount(player.getBitsAmount());
                    player.setMoneyAmount(player.getMoneyAmount() + BitsToEuro.convertToEuro(c.getMoneyGenerated()));
                }
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
