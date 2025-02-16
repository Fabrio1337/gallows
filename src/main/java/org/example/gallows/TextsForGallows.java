package org.example.gallows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TextsForGallows {

    //иерархия: themes -> words -> chars
    private Map<String, HashSet<ArrayList<Character>>> themes; //темы

    protected boolean addThemes()
    {
        themes = new HashMap<String, HashSet<ArrayList<Character>>>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("themes.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        try
        {
            String line = br.readLine();
            while(line != null)
            {
                themes.put(line, addWords(line));
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //метод в котором считываются слова и разделяются на буквы
    protected HashSet<ArrayList<Character>> addWords(String word)
    {
        HashSet<ArrayList<Character>> words = new HashSet<>(); //слова в темах
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(word + ".txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line = br.readLine();
            while(line != null)
            {
                ArrayList<Character> chars = new ArrayList<>(); //буквы в слове
                for(char c : line.toCharArray())
                {
                    chars.add(c);
                }
                words.add(chars);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return words;
    }

}