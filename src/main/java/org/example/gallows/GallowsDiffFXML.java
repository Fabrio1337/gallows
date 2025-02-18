package org.example.gallows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class GallowsDiffFXML {
    protected Stage stage = new Stage();
    public void setDisplay () throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gallows_diff.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Виселица");
        stage.show();
    }

    public void isVisible(boolean isOpen)
    {
        if(!isOpen) stage.close(); else stage.show();
    }
}
