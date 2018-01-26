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

public class BarController implements Controller {
    private Navigation navigation;
    private PlayerService playerService;
    private final int COFFEE_PRICE = 10;
    private final int CHILL_BAR = 100;
    @FXML
    private Button buttonBar;

    @FXML
    private Button buttonDringCoffee;

    @FXML
    private Button buttonBack;

    @FXML
    private ProgressBar energyLevel;

    @FXML
    private Label lblHackingSkill;

    @FXML
    private Label lblMoneyValue;

    @FXML
    private Label lblCryptoValue;

    @FXML
    private Label notifyLbl;

    @FXML
    void drinkCoffee(ActionEvent event) {
        if(playerService.getPlayerMoney() >= COFFEE_PRICE) {
            playerService.drinkCoffee();
            playerService.spendMoney(COFFEE_PRICE);
            notifyLbl.setText("");
        } else {
            notifyLbl.setText("Not enough €.");
        }
    }

    @FXML
    void goBack(ActionEvent event) {
        navigation.back();
    }

    @FXML
    void goToBar(ActionEvent event) {
        if(playerService.getPlayerMoney() >= CHILL_BAR) {
            playerService.fullEnergy();
            playerService.spendMoney(CHILL_BAR);
            notifyLbl.setText("");
        } else {
            notifyLbl.setText("Not enought €.");
        }
    }

    public void initialize() {
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

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }
}
