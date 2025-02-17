package org.example.gallows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GallowsApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GallowsApplication.class.getResource("/start_gallows.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250, 150);
        stage.setTitle("Виселица");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}