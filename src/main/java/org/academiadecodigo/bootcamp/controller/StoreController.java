package org.academiadecodigo.bootcamp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.FatelaComputer;
import org.academiadecodigo.bootcamp.model.HighSpeedComputer;
import org.academiadecodigo.bootcamp.model.Server;
import org.academiadecodigo.bootcamp.navigation.Navigation;
import org.academiadecodigo.bootcamp.services.PlayerService;

import java.util.Date;

public class StoreController implements Controller{
    private Navigation navigation;
    private PlayerService playerService;

    public void initialize() {
        fillHwStore();
    }
    @FXML
    private Label notifyLabel;

    @FXML
    private TableView<Computer> tableview;

    @FXML
    private TableColumn<Computer, String> cmpName;

    @FXML
    private TableColumn<Computer, Integer> bitcoin;

    @FXML
    private TableColumn<Computer, String> price;

    @FXML
    private Button back;

    @FXML
    private Button buy;

    @FXML
    void buyHighSpeedComputer(ActionEvent event) {
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
