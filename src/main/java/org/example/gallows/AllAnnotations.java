package org.example.gallows;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("org.example.gallows")
public class AllAnnotations {

    @Bean
    public GallowsDiffFXML getGallowsDiffFXML() {
        return new GallowsDiffFXML();
    }

    @Bean
    public GallowsGameFXML getGallowsGameFXML() {
        return new GallowsGameFXML();
    }

    @Bean
    public TextsForGallows getTextsForGallows() {
        return new TextsForGallows();
    }

    @Bean
    public GallowsAppFXML getGallowsAppFXML() {
        return new GallowsAppFXML();
    }

    @Bean
    public GallowsThemesFXML getGallowsThemesFXML() {
        return new GallowsThemesFXML();
    }

    @Bean
    public  GallowsWinOrLoseFXML getGallowsWinOrLoseFXML() { return new GallowsWinOrLoseFXML(); }
}
