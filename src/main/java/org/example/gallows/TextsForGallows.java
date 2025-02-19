package org.example.gallows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;



public class TextsForGallows {
    private Map<String, ArrayList<String>> themes = new HashMap<>();


    public TextsForGallows() {
        loadThemes();
    }

    private void loadThemes() {
        try {
            // Загружаем все .txt файлы из папки themes/
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:themes/*.txt");

            for (Resource resource : resources) {
                String themeName = resource.getFilename().replace(".txt", ""); // Название темы = имя файла
                ArrayList<String> words = new ArrayList<>();

                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        words.add(line.trim());
                    }
                }
                themes.put(themeName, words);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Map<String, ArrayList<String>> getThemes() {
        return themes;
    }


    //тестовый метод для проверки
    public void printThemes()
    {
        for(Map.Entry<String, ArrayList<String>> entry : themes.entrySet())
        {
            System.out.println(entry);
        }
    }

}