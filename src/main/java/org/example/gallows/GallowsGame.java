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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class GallowsGame {
    private Map<String, Set<String>> themes = new HashMap<>();

    private static final String[][] LAYOUT = {
            {"й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ъ"},
            {"ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э"},
            {"я", "ч", "с", "м", "и", "т", "ь", "б", "ю", "ё"}
    };

    @FXML
    protected ImageView imageView;

    @FXML
    protected Label theme2;

    @FXML
    protected GridPane keyboard;

    @FXML
    protected Label writeWord;

    protected static String theme;

    public void changeImage(int counter) {
        // Меняем изображение при вызове метода
        imageView.setImage(new Image(getClass().getResource("/diedPersonImages/" + counter + ".png").toExternalForm()));
    }

    @FXML
    public void initialize() {
        System.out.println(theme);
        if (theme != null) {
            theme2.setText(theme);
        }
        // Начальное изображение
        imageView.setImage(new Image(getClass().getResource("/diedPersonImages/1.png").toExternalForm()));
        writeWord.setText("Введите букву: ");
        getKeyboard();
    }

    private void getKeyboard()
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

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMinSize(40, 40);
        button.setStyle("-fx-font-size: 14px;");

        // Добавляем обработчик события при нажатии
        button.setOnAction(e -> {
            System.out.println("Нажата клавиша: " + text);
            // Здесь можно добавить свою логику обработки нажатия клавиши
        });

        return button;
    }

}
