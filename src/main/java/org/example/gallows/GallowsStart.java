package org.example.gallows;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class GallowsStart {
    @FXML
    private Label welcomeText;
    protected AnnotationConfigApplicationContext context = GetBeans.getContext();

    @FXML
    protected void initialize()
    {
        welcomeText.setText("Добро пожаловать в игру 'Виселица'");
    }

    @FXML
    protected void onHelloButtonClick() throws IOException {
        GallowsDiffFXML gallowsDiffFXML = context.getBean("getGallowsDiffFXML", GallowsDiffFXML.class);
        gallowsDiffFXML.setDisplay();
        isVisible();

    }

    protected void isVisible()
    {
        GallowsAppFXML gallowsAppFXML = context.getBean("getGallowsAppFXML", GallowsAppFXML.class);
        gallowsAppFXML.isVisible(false);
    }
}