package org.example;

import org.example.config.SpringConfig;
import org.example.models.MusicPlayer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class, "musicPlayer");
        musicPlayer.playMusic();
    }
}
