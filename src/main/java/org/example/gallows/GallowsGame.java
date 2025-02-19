package org.example.gallows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.w3c.dom.Text;

import javax.swing.*;
import java.io.IOException;
import java.util.*;


public class GallowsGame {
    private Map<String, ArrayList<String>> themes = new HashMap<>();
    private ArrayList<String> words;
    private int counter = 1;
    private StringBuilder wordBuilder;
    private int countSymbol = 0;


    protected AnnotationConfigApplicationContext context = GetBeans.getContext();

    private static final String[][] LAYOUT = {
            {"й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ъ"},
            {"ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э"},
            {"я", "ч", "с", "м", "и", "т", "ь", "б", "ю", "ё"}
    };

    @FXML
    protected ImageView imageView;

    //@FXML
   // protected Label theme2;

    @FXML
    protected GridPane keyboard;

    @FXML
    protected Label writeWord;

    protected static String theme;
    protected static String diff;

    private String word;

    public void changeImage() throws IOException {
        if(counter > 8)
        {
            resultGame("Вы Проиграли!");
            counter = 1;
        }
        // Меняем изображение при вызове метода
        imageView.setImage(new Image(getClass().getResource("/diedPersonImages/" + String.valueOf(counter)  + ".png").toExternalForm()));
        counter++;
    }

    @FXML
    public void initialize() throws IOException {
        System.out.println(theme);

        getKeyboard();
        getThemes();
        wordAssignment();
        printWord();

        System.out.println(diff);
    }

    private void getKeyboard() throws IOException
    {
        // Создаем кнопки для каждой буквы
        for (int row = 0; row < LAYOUT.length; row++) {
            for (int col = 0; col < LAYOUT[row].length; col++) {
                Button button = createButton(LAYOUT[row][col]);
                // Добавляем отступ для второго ряда
                if (row == 1) {
                    keyboard.add(button, col + 1, row);
                }
                // Добавляем отступ для третьего ряда
                else if (row == 2) {
                    keyboard.add(button, col + 2, row);
                }
                else {
                    keyboard.add(button, col, row);
                }
            }
        }
    }

    private Button createButton(String text)  {
        Button button = new Button(text);
        button.setMinSize(40, 40);
        button.setStyle("-fx-font-size: 14px;");

        button.setId(text); // Устанавливаем ID

        // Добавляем обработчик события при нажатии
        button.setOnAction(e -> {
            System.out.println("Нажата клавиша: " + text);
            try {
                realizeButton(text, button);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });

        return button;
    }

    private void printWord() {
        wordBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++)
        {
            wordBuilder.append("_");
        }

        writeWord.setText(wordBuilder.toString());
    }

    private void resultGame( String result)  throws IOException
    {
        GallowsWinOrLoseFXML gallowsWinOrLoseFXML = context.getBean("getGallowsWinOrLoseFXML", GallowsWinOrLoseFXML.class);
        GallowsWinOrLose.result = result;
        gallowsWinOrLoseFXML.setDisplay();
        GallowsGameFXML gallowsGameFXML = context.getBean("getGallowsGameFXML", GallowsGameFXML.class);
        gallowsGameFXML.isVisible(false);
    }

    private void realizeButton(String text, Button button2) throws IOException
    {
        Button button = button2;
        char[] symbols = word.toCharArray();
        boolean flag = false;
        for(int i = 0; i < symbols.length; i++)
        {
            if(symbols[i] == text.charAt(0))
            {
                wordBuilder.setCharAt(i, text.charAt(0));
                writeWord.setText(wordBuilder.toString());
                flag = true;
                countSymbol++;
            }
        }
        if(countSymbol == word.length())
        {
            System.out.println("ПОБЕДА!!!!!!!!!!!!!!!!!!!");
            resultGame("Вы победили!");

        }
        if(!flag) changeImage();
        button.setDisable(true);
    }

    private  void getThemes()
    {
        TextsForGallows textsForGallows = context.getBean("getTextsForGallows", TextsForGallows.class);
        themes = textsForGallows.getThemes();
    }

    private void wordAssignment()
    {
        words = themes.get(theme);
        Random random = new Random();
        int index = random.nextInt(words.size());
        word = words.get(index);
        if(diff.equals("easy"))
        {
            while(word.length() > 6)
            {
                index = random.nextInt(words.size());
                word = words.get(index);
            }
        }
        if(diff.equals("mid"))
        {
            while(word.length() < 6 || word.length() > 8)
            {
                index = random.nextInt(words.size());
                word = words.get(index);
            }
        }
        if(diff.equals("hard"))
        {
            while(word.length() <= 8)
            {
                index = random.nextInt(words.size());
                word = words.get(index);
            }
        }
        System.out.println(word);
    }



}
