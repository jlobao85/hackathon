package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class TerminalController implements Controller {

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

    }

    @FXML
    void sendText(ActionEvent event) {

    }

}

