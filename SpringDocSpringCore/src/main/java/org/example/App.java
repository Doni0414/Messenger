package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer musicPlayer2 = context.getBean("musicRlayer", MusicPlayer.class);
        MusicPlayer musicPlayer3 = context.getBean("musicRlayer", MusicPlayer.class);
        System.out.println(musicPlayer2 == musicPlayer3);
        RockMusic rockMusic = context.getBean("rockMusic", RockMusic.class);
        System.out.println(rockMusic.getName());
        context.close();
    }
}
