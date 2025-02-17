package org.example.gallows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

@Component
public class GallowsDiff {

    @FXML
    private Label diff;


    @FXML
    protected void initialize() {
        diffVisible();
    }

    protected void diffVisible() {
        diff.setText("Выберите сложность игры:");
    }
    @FXML
    protected void easyDiff()
    {

    }

    @FXML
    protected void midDiff()
    {

    }

    @FXML
    protected void hardDiff()
    {

    }
}
