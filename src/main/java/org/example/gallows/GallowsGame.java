package org.example.gallows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//@Component
public class GallowsGame {
    private Map<String, Set<String>> themes = new HashMap<>();

    @Autowired
    GallowsGame(TextsForGallows texts) {
        themes = texts.getThemes();
    }

    @FXML
    protected void initialize() {

    }

}
