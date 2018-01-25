package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.Player;

import java.util.List;

public interface PlayerService extends Service {
    void buyComputer();
    void destroyComputer();
    void mineMoney();
    List<Computer> listOwnedComputers();
    void setPlayer(Player player);
}
