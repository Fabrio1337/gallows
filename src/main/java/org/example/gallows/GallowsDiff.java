package org.example.gallows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class GallowsDiff {

    protected GallowsThemesFXML gallowsThemesFXML;
    protected AnnotationConfigApplicationContext context = GetBeans.getContext();

    @FXML
    private Label diff;

    protected void gallowsVisible() throws IOException
    {
        gallowsThemesFXML.setDisplay();
        isVisible();
    }

    protected void isVisible()
    {
        GallowsDiffFXML gallowsDiffFXML = context.getBean("getGallowsDiffFXML", GallowsDiffFXML.class);
        gallowsDiffFXML.isVisible(false);
    }


    @FXML
    protected void initialize() {
        gallowsThemesFXML = context.getBean("getGallowsThemesFXML", GallowsThemesFXML.class);
        diffVisible();
    }

    protected void diffVisible() {
        diff.setText("Выберите сложность игры:");
    }
    @FXML
    protected void easyDiff() throws IOException
    {
        gallowsVisible();
    }

    @FXML
    protected void midDiff() throws IOException
    {
        gallowsVisible();
    }

    @FXML
    protected void hardDiff() throws IOException
    {
        gallowsVisible();
    }
}
