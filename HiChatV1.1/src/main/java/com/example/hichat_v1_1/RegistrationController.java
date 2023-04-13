package com.example.hichat_v1_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private Button enterButton;
    @FXML
    private TextField nameField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void sendName(ActionEvent event){
        try{
            String username = nameField.getText();
            if(username.equals("Nurda")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.showAndWait();
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client.fxml"));
            root = fxmlLoader.load();

            ClientController clientController = fxmlLoader.getController();
            clientController.sendName(username);

            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }catch (IOException ex){

        }
    }
}
