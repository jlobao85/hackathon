package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.model.Computer;

import java.util.List;


public class StoreServiceImpl implements StoreService {

    private List<Computer> computers;


    @Override
    public List<Computer> listComputers() {
        return computers;
    }

    @Override
    public void sellComputer() {

    }

}
