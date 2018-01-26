package org.academiadecodigo.bootcamp.main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.BitsToEuro;
import org.academiadecodigo.bootcamp.model.Computer;
import org.academiadecodigo.bootcamp.model.FatelaComputer;
import org.academiadecodigo.bootcamp.model.Player;
import org.academiadecodigo.bootcamp.navigation.Navigation;
import org.academiadecodigo.bootcamp.services.PlayerService;
import org.academiadecodigo.bootcamp.services.PlayerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring-config.xml");
        Navigation navigation = applicationContext.getBean("navigation", Navigation.class);
        navigation.setStage(primaryStage);
        primaryStage.centerOnScreen();
        navigation.loadScreen("menuView");
    }

    public static void main(String[] args) { launch(args);
    }
}
