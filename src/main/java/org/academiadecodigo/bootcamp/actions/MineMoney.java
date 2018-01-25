package org.academiadecodigo.bootcamp.actions;

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
                Thread.sleep(7000);
                for(Computer c : player.getComputersOwned()) {
                    player.setMoneyAmount(2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
