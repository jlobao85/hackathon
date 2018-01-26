package org.academiadecodigo.bootcamp.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.FatelaComputer;
import org.academiadecodigo.bootcamp.model.HighSpeedComputer;
import org.academiadecodigo.bootcamp.model.Server;
import org.academiadecodigo.bootcamp.navigation.Navigation;
import org.academiadecodigo.bootcamp.services.PlayerService;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class StoreController implements Controller{

    private Navigation navigation;
    private PlayerService playerService;

    public void initialize() {
        fillHwStore();
        startTimer();
    }
    @FXML
    public Label lblCryptoValue;
    @FXML
    public TableView<Computer> tableview;
    @FXML
    public Label notifyLabel;
    @FXML
    private TableColumn<Computer, String> cmpName;

    @FXML
    private TableColumn<Computer, Integer> bitcoin;

    @FXML
    private TableColumn<Computer, String> price;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonBuyHighSpeed;

    @FXML
    private ProgressBar energyLevel;

    @FXML
    private Label lblHackingSkill;

    @FXML
    private Label lblMoneyValue;


    @FXML
    void sellComputer(ActionEvent event) {
        Computer row = tableview.getSelectionModel().getSelectedItem();
        if(row == null) {
            return;
        } else {
           if(playerService.buyComputer(row, row.getPrice())) {
               notifyLabel.setText(row.getName() + " bought!");
           } else {
               notifyLabel.setText("I don't have space at home!");
           }
        }
        tableview.getSelectionModel().clearSelection();
    }

    public void back(ActionEvent actionEvent) {
        navigation.back();
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

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    public void fillHwStore() {
        ObservableList<Computer> observableList = FXCollections.observableArrayList();
        observableList.add(new FatelaComputer());
        observableList.add(new HighSpeedComputer());
        observableList.add(new Server());
        tableview.setEditable(false);
        cmpName.setCellValueFactory(new PropertyValueFactory<>("name"));
        bitcoin.setCellValueFactory(new PropertyValueFactory<>("moneyGenerated"));
        price.setCellValueFactory(new PropertyValueFactory<>("convertedPrice"));
        tableview.setItems(observableList);
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }
}
