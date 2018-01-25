package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.academiadecodigo.bootcamp.services.PlayerService;

public class MainController implements Controller {
    private PlayerService playerService;
    @FXML
    public Button ButtonProgramingClass;
    @FXML
    public Button ButtonPersonalComputer;
    @FXML
    public Button ButtonGetEnergy;
    @FXML
    public Button ButtonHWStore;


    public void ButtonProgramingClass(ActionEvent actionEvent) {

    }

    public void goToPC(ActionEvent actionEvent) {

    }

    public void EnergyView(ActionEvent actionEvent) {

    }

    public void HWStoreView(ActionEvent actionEvent) {

    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }
}
