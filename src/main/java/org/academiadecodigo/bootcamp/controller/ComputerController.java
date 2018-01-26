package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.academiadecodigo.bootcamp.navigation.Navigation;

public class ComputerController implements Controller{
    private Navigation navigation;



    @FXML
    private Button emailButton;

    @FXML
    private Button hackButton;

    @FXML
    void checkEmail(ActionEvent event) {

    }

    @FXML
    void hack(ActionEvent event) {
        navigation.loadScreen("terminalController");
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

}