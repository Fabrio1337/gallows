package org.example.gallows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
class TextsForGallowsTest {
    protected TextsForGallows textsForGallows;
    protected AnnotationConfigApplicationContext context;
    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(AllAnnotations.class);
        textsForGallows = context.getBean("getTextsForGallows", TextsForGallows.class);
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