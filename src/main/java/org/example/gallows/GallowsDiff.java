package org.example.gallows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GallowsDiff {

    private TextsForGallows textsForGallows;

    @FXML
    private Label diff;

    @Autowired
    public GallowsDiff(TextsForGallows textsForGallows) {
        this.textsForGallows = textsForGallows;
    }

    protected void gallowsVisible()
    {

    }


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
