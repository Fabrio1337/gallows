package org.example.gallows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
@Scope("Prototype")
public class Theme {

    public String theme;
    public Map<String, List<Character>> words;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Map<String, List<Character>> getWords() {
        return words;
    }

    public void setWords(Map<String, List<Character>> words) {
        this.words = words;
    }
}
