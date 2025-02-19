package org.example.gallows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GallowsWinOrLose {
    protected AnnotationConfigApplicationContext context = GetBeans.getContext();
    @FXML
    public Label resultGame;

    public static String result;

    @FXML
    public void initialize() {
        resultGame.setText(result);
    }

    @FXML
    protected void restart() {
        GallowsDiffFXML gallowsDiffFXML = context.getBean("getGallowsDiffFXML", GallowsDiffFXML.class);
        gallowsDiffFXML.isVisible(true);
        GallowsWinOrLoseFXML gallowsWinOrLoseFXML = context.getBean("getGallowsWinOrLoseFXML", GallowsWinOrLoseFXML.class);
        gallowsWinOrLoseFXML.isVisible(false);
    }

}
