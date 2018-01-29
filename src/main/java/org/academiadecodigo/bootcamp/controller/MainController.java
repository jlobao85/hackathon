package org.academiadecodigo.bootcamp.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.navigation.Navigation;
import org.academiadecodigo.bootcamp.services.PlayerService;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainController implements Controller {
    private PlayerService playerService;
    private Navigation navigation;


    public void initialize() {

        playerService.mineMoney();

        updateTopInfo();
        updatePcVisibility();

        startTimer();

    }


    public void updatePcVisibility(){

        List<Computer> computerList = playerService.listOwnedComputers();

        int numbPC = computerList.size();
        // 5 PCs
        if (numbPC > 4 ){ lblPC5.setText(computerList.get(4).getName()); }
        setPcVisibility(table3, pc5, lblPC5, numbPC > 4);
        // 4 PCs
        if (numbPC > 3 ){ lblPC4.setText(computerList.get(3).getName()); }
        setPcVisibility(table2, pc4, lblPC4, numbPC > 3);
        // 3 PCs
        if (numbPC > 2 ){ lblPC3.setText(computerList.get(2).getName()); }
        setPcVisibility(table2, pc3, lblPC3, numbPC > 2);
        // 2 PCs
        if (numbPC > 1 ){ lblPC2.setText(computerList.get(1).getName()); }
        setPcVisibility(table1, pc2, lblPC2, numbPC > 1);
        // 1 PC
        if (numbPC > 0 ){ lblPC1.setText(computerList.get(0).getName()); }
        setPcVisibility(table1, pc1, lblPC1, numbPC > 0);

    }


    private void setPcVisibility(ImageView table, ImageView img, Label lbl, boolean isVisible){

        table.setVisible(isVisible);
        img.setVisible(isVisible);
        lbl.setVisible(isVisible);

    }


    private void updateTopInfo(){

        lblMoneyValue.setText(playerService.getPlayerMoney() + " €");
        lblCryptoValue.setText(playerService.getPlayerBits() + " BTC");
        lblHackingSkill.setText(playerService.getExperience() + " XP");
        energyLevel.progressProperty().setValue((double)playerService.getEnergy() / 100);

    }


    public void startTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        updateTopInfo();
                    }
                });

            }
        }, 0, 2000);

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
        navigation.loadScreen("programmingClassView");
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


    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

}
