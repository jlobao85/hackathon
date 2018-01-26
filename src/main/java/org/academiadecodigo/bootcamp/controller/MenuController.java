package org.academiadecodigo.bootcamp.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.navigation.Navigation;

public class MenuController implements Controller {
    private Navigation navigation;

    @FXML
    private ImageView btnLoadGame;

    @FXML
    private ImageView btnStartGame;

    @FXML
    private ImageView startgame;

    @FXML
    private ImageView btnExit;

    @FXML
    private ImageView bitImg3;

    @FXML
    private ImageView bitImg4;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void loadGame(MouseEvent event) {

    }

    @FXML
    void startGame(MouseEvent event) {
        navigation.loadScreen("roomView");
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }
}
