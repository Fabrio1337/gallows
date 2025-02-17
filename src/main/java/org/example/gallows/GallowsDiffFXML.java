package org.example.gallows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("gallowsDiffFXML")
public class GallowsDiffFXML {

    public void setDisplay () throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gallows_diff.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Виселица");
        stage.show();
    }
}
