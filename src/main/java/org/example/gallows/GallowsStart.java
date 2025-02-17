package org.example.gallows;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class GallowsStart {
    @FXML
    private Label welcomeText;

    @FXML
    protected void initialize()
    {
        welcomeText.setText("Добро пожаловать в игру 'Виселица'");
    }

    @FXML
    protected void onHelloButtonClick() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spr.xml");
        GallowsDiffFXML gallowsDiffFXML = context.getBean("gallowsDiffFXML", GallowsDiffFXML.class);
        gallowsDiffFXML.setDisplay();
    }
}