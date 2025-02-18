package org.example.gallows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class GallowsApplication extends Application {
    protected GallowsAppFXML gallowsAppFXML;

    @Override
    public void start(Stage stage) throws IOException {
        AnnotationConfigApplicationContext context = GetBeans.getContext();
        gallowsAppFXML = context.getBean("getGallowsAppFXML", GallowsAppFXML.class);
        gallowsAppFXML.setDisplay();
    }

    public static void main(String[] args) {
        launch();
    }

}