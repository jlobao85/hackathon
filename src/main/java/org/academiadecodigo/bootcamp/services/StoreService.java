package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.model.Computer;

import java.util.List;

public interface StoreService extends Service{
    List<Computer> listComputers();
    void sellComputer();
}
