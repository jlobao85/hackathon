package org.academiadecodigo.bootcamp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import org.academiadecodigo.bootcamp.Randomizer;
import org.academiadecodigo.bootcamp.SoundEffects;
import org.academiadecodigo.bootcamp.navigation.Navigation;
import org.academiadecodigo.bootcamp.services.PlayerService;

import java.util.Timer;
import java.util.TimerTask;


public class TerminalController implements Controller {
    private int energyToHack;
    private final int EARNERPERHACK = 5;
    private final int BONUSHACK = 20;
    private Navigation navigation;
    private int counter = 0;
    private final String[] stringArray = new String[] {"null pointer exception virus" ,"inject stuxnet malware", "john the ripper cracking", "make ping of death",
            "check servers security", "weaken security", "ddos attack", "take control of system", "try to break in" ,"try to connect to server", "get server ip", "get data"};
    private int hacksRight = 0;
    private int time = 0;
    private Timer timer;
    private int moneyEarned;
    private PlayerService playerService;
    
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
            sendText();
        }
    }

    @FXML
    void sendText(ActionEvent event) {
        sendText();
    }

    public void changeLbl() {
        codeLbl.setText(stringArray[Randomizer.randomNumber(0,11)]);

    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    public void startTimer() {
        changeLbl();
        if(playerService.getEnergy() < 25) {
            codeLbl.setText("I'm dying, i need more energy.");
            return;
        }
        System.out.println(playerService.getEnergy());
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        if(time == 4 && hacksRight < time) {
                            codeLbl.setText("You won " + hacksRight * EARNERPERHACK + " bitcoins;");
                            moneyEarned = hacksRight * EARNERPERHACK;
                            return;
                        }
                        if(time == 5) {
                            int value = hacksRight * EARNERPERHACK + BONUSHACK;
                            codeLbl.setText("You won " + value + " bitcoins;");
                            moneyEarned = value;
                            return;
                        }
                        if(time == 4 && hacksRight == 4) {
                            codeLbl.setText("hack it like a boss");
                            SoundEffects.espetaculo();
                            time++;
                        } else {
                            changeLbl();
                            time++;
                        }
                        System.out.println("timer");
                    }
                });

            }
        }, 0, 7000);

    }

    public void sendText() {
        String text = writableField.getText();
        if(text.equals("exit")) {
            navigation.back();
            energyToHack = Randomizer.randomNumber(15, 30);
            playerService.hack(moneyEarned, energyToHack);
            if(hacksRight >= 4) {
                SoundEffects.espetaculo();
            }
            resetValues();
            timer.cancel();
        }
        if(text.equals("")) {
            return;
        }
        if(counter == 8) {
            String lastString = screenLbl.getText().split("\n")[screenLbl.getText().split("\n").length - 2];
            screenLbl.setText(lastString + "\n>/");
            counter = 1;
        }

        //SET LATER TO CHANGE MISSION COMPLETION
        if(writableField.getText().equals(codeLbl.getText())) {
            writableField.setText("");
            hacksRight++;
            System.out.println(hacksRight);
        }
        SoundEffects.keyboard();
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

    public void resetValues() {
        counter = 0;
        hacksRight = 0;
        time = 0;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

}

