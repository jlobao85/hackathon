package org.academiadecodigo.bootcamp.main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.SoundEffects;
import org.academiadecodigo.bootcamp.navigation.Navigation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main extends Application{

    private final String SPRING_CONFIG_PATH = "/spring/";

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Load spring config
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(SPRING_CONFIG_PATH + "spring-config.xml");

        //Load navigation bean
        Navigation navigation = applicationContext.getBean("navigation", Navigation.class);

        //Set navigation primary stage
        navigation.setStage(primaryStage);

        //Center the stage window
        primaryStage.centerOnScreen();

        //Load menu view
        navigation.loadScreen("menuView");

        //Start game theme music
        SoundEffects.gameTheme();

    }

    public static void main(String[] args) { launch(args); }
}
