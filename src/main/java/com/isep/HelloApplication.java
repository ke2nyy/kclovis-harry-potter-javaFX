package com.isep;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenes.Scene1;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Harry Potter At Home Game");
        Scene scene = new Scene1(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}