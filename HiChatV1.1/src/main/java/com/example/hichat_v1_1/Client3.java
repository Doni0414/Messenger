package com.example.hichat_v1_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),448,356);
        stage.setScene(scene);
        stage.setTitle("Client");
        stage.show();
    }
}
