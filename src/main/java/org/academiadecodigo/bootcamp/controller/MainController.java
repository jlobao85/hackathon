package org.academiadecodigo.bootcamp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.BitsToEuro;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.navigation.Navigation;
import org.academiadecodigo.bootcamp.services.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainController implements Controller {
    private PlayerService playerService;
    private Navigation navigation;
    private ArrayList<ImageView> pcImagesList;
    private ArrayList<Label> pcLabels;


    public void initialize() {
        playerService.mineMoney();
        lblMoneyValue.setText(playerService.getPlayerMoney() + " €");
        lblCryptoValue.setText(playerService.getPlayerBits() + " BTC");
        lblHackingSkill.setText(playerService.getExperience() + " XP");
        energyLevel.progressProperty().setValue((double)playerService.getEnergy() / 100);
        startTimer();
        lblPC1.setText(playerService.listOwnedComputers().get(0).getName());

        List<Computer> computerList = playerService.listOwnedComputers();

        pc1.setVisible(true);
        pc2.setVisible(false);
        pc3.setVisible(false);
        pc4.setVisible(false);
        pc5.setVisible(false);
        lblPC1.setVisible(true);
        lblPC2.setVisible(false);
        lblPC3.setVisible(false);
        lblPC4.setVisible(false);
        lblPC5.setVisible(false);

    }

    @FXML
    private ImageView lblEnergyLevel;

    @FXML
    private ImageView table1;

    @FXML
    private ImageView table2;

    @FXML
    private ImageView table3;

    @FXML
    private ImageView pc1;

    @FXML
    private ImageView pc2;

    @FXML
    private ImageView pc3;

    @FXML
    private ImageView pc4;

    @FXML
    private ImageView pc5;

    @FXML
    private ImageView btnShop;

    @FXML
    private ImageView btnBar;

    @FXML
    private ImageView btnClasses;

    @FXML
    private ImageView btnPC;

    @FXML
    private Label lblPC1;

    @FXML
    private Label lblPC2;

    @FXML
    private Label lblPC3;

    @FXML
    private Label lblPC4;

    @FXML
    private Label lblPC5;

    @FXML
    private ProgressBar energyLevel;

    @FXML
    private Label lblHackingSkill;

    @FXML
    private Label lblMoneyValue;

    @FXML
    private Label lblCryptoValue;

    @FXML
    void goToBar(MouseEvent event) {
        navigation.loadScreen("energyView");
    }

    @FXML
    void goToClasses(MouseEvent event) {

    }

    @FXML
    void goToMyPC(MouseEvent event) {
        navigation.loadScreen("terminalController");
        ((TerminalController) navigation.getControllers("TerminalController")).startTimer();
    }

    @FXML
    void goToShop(MouseEvent event) {
        navigation.loadScreen("HWstoreView");
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
