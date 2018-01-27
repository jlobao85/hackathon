package org.academiadecodigo.bootcamp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import org.academiadecodigo.bootcamp.navigation.Navigation;
import org.academiadecodigo.bootcamp.services.PlayerService;

import java.util.Timer;
import java.util.TimerTask;

public class ProgrammingController implements Controller{
    private Navigation navigation;
    private PlayerService playerService;

    @FXML
    private Button btnDeveloperClass;

    @FXML
    private Button btnNewbieClass;

    @FXML
    private Button btnMasterClass;

    @FXML
    private Button btnJediClass;

    @FXML
    private ProgressBar energyLevel;

    @FXML
    private Label lblHackingSkill;

    @FXML
    private Label lblMoneyValue;

    @FXML
    private Label lblCryptoValue;

    @FXML
    void getClass(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {
        navigation.back();
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void initialize(){
        startTimer();
    }

    public void startTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        lblMoneyValue.setText(playerService.getPlayerMoney() + " €");
                        lblCryptoValue.setText(playerService.getPlayerBits() + " BTC");
                        lblHackingSkill.setText(playerService.getExperience() + " XP");
                        energyLevel.progressProperty().setValue((double)playerService.getEnergy() / 100);
                    }
                });

            }
        }, 0, 2000);

    }
}

