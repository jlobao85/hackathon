package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.academiadecodigo.bootcamp.Randomizer;
import org.academiadecodigo.bootcamp.navigation.Navigation;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class TerminalController implements Controller {
    private Navigation navigation;
    private int counter = 0;
    private String[] stringArray = new String[] {"make ping of death", "check servers security", "weaken seurity", "ddos attack", "take control of system", "try to break in"};

    public void initialize() {

    }

    @FXML
    private TextField writableField;

    @FXML
    private Button sendButton;

    @FXML
    private Label codeLbl;

    @FXML
    private Label screenLbl;

    @FXML
    void sendFieldText(KeyEvent event) {



        if(event.getCode() == KeyCode.ENTER) {
            String text = writableField.getText();
            if(text.equals("exit")) {
                navigation.back();
                counter = 0;
            }
            if(counter == 8) {
                String lastString = screenLbl.getText().split("\n")[screenLbl.getText().split("\n").length - 2];
                screenLbl.setText(lastString + "\n>/");
                counter = 1;
            }

            //SET LATER TO CHANGE MISSION COMPLETION
            /*if(!writableField.getText().equals(codeLbl.getText())) {
                writableField.setText("");
                return;
            }*/
            if(screenLbl.getText().equals(">/")) {
                screenLbl.setText(">/" + text + "\n>/");
                counter++;
            } else {
                screenLbl.setText(screenLbl.getText() + text + "\n>/");
                System.out.println("else");
                counter++;
            }
            if(text.equals("clear")) {
                screenLbl.setText(">/");
                counter = 0;
            }
            writableField.setText("");
        }
    }

    @FXML
    void sendText(ActionEvent event) {

    }

    public void changeLbl() {
        codeLbl.setText(stringArray[Randomizer.randomNumber(0,5)]);

    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }
}

