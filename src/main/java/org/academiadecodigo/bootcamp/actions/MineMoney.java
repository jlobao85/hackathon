package org.academiadecodigo.bootcamp.actions;

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
                    player.setMoneyAmount(player.getMoneyAmount() + c.getMoneyGenerated());
                }
                int random = Randomizer.randomNumber(1, 10);
                if (random == 10) {

                }
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
