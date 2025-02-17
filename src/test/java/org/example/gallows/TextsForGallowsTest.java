package org.example.gallows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
class TextsForGallowsTest {
    private TextsForGallows textsForGallows;
    private ClassPathXmlApplicationContext context;
    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("spr.xml");
        textsForGallows = context.getBean("textsForGallows", TextsForGallows.class);
    }
    @AfterEach
    void tearDown() {
        context.close();
    }

    @Test
    void readingFromFiles() {
        textsForGallows.getThemes();
        assertNotNull(textsForGallows.getThemes());
    }
    @Test
    void readingFromFilesIncreaseGetMapResult6()
    {
        assertEquals(6, textsForGallows.getThemes().size());
    }

    @Test
    void printlAllThemes()
    {
        textsForGallows.printThemes();
        assertEquals(6, textsForGallows.getThemes().size());
    }
  
}