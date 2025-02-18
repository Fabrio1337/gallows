package org.example.gallows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GallowsAppFXML {
    protected Stage stage = new Stage();
    public void setDisplay () throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(GallowsApplication.class.getResource("/start_gallows.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250, 150);
        stage.setTitle("Виселица");
        stage.setScene(scene);
        stage.show();
    }

    public void isVisible(boolean isOpen)
    {
        if(!isOpen) stage.close(); else stage.show();
    }
}
