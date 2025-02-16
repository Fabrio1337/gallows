package org.example.gallows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GallowsStart {
    @FXML
    private Label welcomeText;

    @FXML
    protected void initialize()
    {
        welcomeText.setText("Добро пожаловать в игру 'Виселица'");
    }

    @FXML
    protected void onHelloButtonClick() {

    }
}