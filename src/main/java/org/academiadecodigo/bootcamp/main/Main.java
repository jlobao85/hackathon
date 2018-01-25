package org.academiadecodigo.bootcamp.main;

import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.FatelaComputer;
import org.academiadecodigo.bootcamp.model.Player;
import org.academiadecodigo.bootcamp.services.PlayerService;
import org.academiadecodigo.bootcamp.services.PlayerServiceImpl;

public class Main {
    public static void main(String[] args) {
        PlayerService playerService = new PlayerServiceImpl();
        Player player = new Player("migas");
        Computer computer = new FatelaComputer();
        player.getComputersOwned().add(computer);
        playerService.setPlayer(player);
        playerService.mineMoney();
    }
}
