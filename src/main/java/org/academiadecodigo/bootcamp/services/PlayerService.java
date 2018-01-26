package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.Player;

import java.util.List;

public interface PlayerService extends Service {
    boolean buyComputer(Computer computer, double price);
    void destroyComputer(Computer computer);
    void mineMoney();
    List<Computer> listOwnedComputers();
    void setPlayer(Player player);
    void hack();
    //Computer findById(int id);
}
