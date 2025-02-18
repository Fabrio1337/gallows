package org.example.gallows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class GallowsThemes {

    @FXML
    protected Label theme;

    protected AnnotationConfigApplicationContext context = GetBeans.getContext();


    protected void gameIsStarted(String theme) throws IOException
    {
        GallowsGame.theme = theme;
        GallowsGameFXML game = context.getBean("getGallowsGameFXML", GallowsGameFXML.class);
        game.setDisplay();
        isVisible();

    }

    protected void isVisible()
    {
        GallowsThemesFXML gallowsThemesFXML = context.getBean("getGallowsThemesFXML", GallowsThemesFXML.class);
        gallowsThemesFXML.isVisible(false);
    }

    @FXML
    protected void initialize() {
        theme.setText("Выберите тему:");
    }

    @FXML
    protected void countrys() throws IOException
    {
        gameIsStarted("countrys");
    }

    @FXML
    protected void citys() throws IOException
    {
        gameIsStarted("citys");
    }

    @FXML
    protected void foods() throws IOException
    {
        gameIsStarted("foods");
    }

    @FXML
    protected void animals() throws IOException
    {
        gameIsStarted("animals");
    }

    @FXML
    protected void hobbies() throws IOException
    {
        gameIsStarted("hobbies");
    }

    @FXML
    protected void random() throws IOException
    {
        gameIsStarted("random");
    }

}
