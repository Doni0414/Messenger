package com.example.hichat_v1_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain{
    static ArrayList<DataOutputStream> outputStreams = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(() ->{
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                while(true) {
                    Socket socket = serverSocket.accept();
                    new HandleSession(socket).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    static class HandleSession extends Thread{
        Socket socket;
        String name;

        HandleSession(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream fromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
                outputStreams.add(toClient);

                name = fromClient.readUTF();

                while(true){
                    String message = fromClient.readUTF();
                    for(int i = 0; i < outputStreams.size(); i++){
                        if(outputStreams.get(i) != toClient){
                            outputStreams.get(i).writeUTF(name);
                            outputStreams.get(i).writeUTF(message);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}