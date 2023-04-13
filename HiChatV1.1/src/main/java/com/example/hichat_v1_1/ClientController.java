package com.example.hichat_v1_1;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private Button sendButton;
    @FXML
    private TextField textField;
    @FXML
    private VBox vBox;
    @FXML
    private ScrollPane scrollPane;

    private Client client;
    private static Font font;
    private String name;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        font = Font.font("Times New Roman", FontWeight.BOLD, 10);
        try{
            client = new Client(new Socket("localhost",8000));
        }catch(IOException ex){
            System.out.println("Connection error!");
        }


        vBox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scrollPane.setVvalue((Double) t1);
            }
        });

        client.receiveMessage(vBox);

        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String message = textField.getText();
                if(!message.isEmpty()){
                    HBox hBox = new HBox();
                    hBox.setPadding(new Insets(5,5,5,10));
                    hBox.setAlignment(Pos.CENTER_RIGHT);

                    Text nameText = new Text("You");
                    nameText.setFill(Color.BLACK);
                    nameText.setFont(font);

                    HBox hBox1 = new HBox();
                    hBox1.setAlignment(Pos.CENTER_RIGHT);
                    hBox1.setPadding(new Insets(5,5,5,10));
                    hBox1.getChildren().add(nameText);

                    Text text = new Text(message);
                    TextFlow textFlow = new TextFlow(text);

                    textFlow.setStyle("-fx-color: rgb(239,242,255);"+
                            "-fx-background-color: rgb(15,125,242);"+
                            "-fx-background-radius: 20px;");

                    textFlow.setPadding(new Insets(5,10,5,10));
                    text.setFill(Color.color(0.934,0.945,0.996));

                    hBox.getChildren().add(textFlow);

                    vBox.getChildren().addAll(hBox1,hBox);

                    client.sendMessage(message);
                    textField.clear();
                }
            }
        });
    }

    public static void addLabel(String name, String message, VBox vBox){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));

        Text nameText = new Text(name);
        nameText.setFill(Color.BLACK);
        nameText.setFont(font);

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER_LEFT);
        hBox1.setPadding(new Insets(5,5,5,10));
        hBox1.getChildren().add(nameText);

        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);

        textFlow.setStyle("-fx-background-color: rgb(233,233,235);"+
                "-fx-background-radius: 20px;");
        textFlow.setPadding(new Insets(5,10,5,10));
        hBox.getChildren().add(textFlow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBox.getChildren().addAll(hBox1,hBox);
            }
        });
    }
    public void sendName(String name){
        client.sendName(name);
    }
}