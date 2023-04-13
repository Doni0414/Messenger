package com.example.hichat_v1_1;

import javafx.scene.layout.VBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;
    private String name;
    private DataOutputStream toServer;
    private DataInputStream fromServer;

    public Client(Socket socket){
        this.socket = socket;
        try{
            toServer = new DataOutputStream(socket.getOutputStream());
            fromServer = new DataInputStream(socket.getInputStream());

        }catch(IOException ex){

        }
    }
    public void sendMessage(String message){
        try {
            toServer.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendName(String name){
        try{
            toServer.writeUTF(name);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void receiveMessage(VBox vBox){
        new Thread(() -> {
            try{
                while(socket.isConnected()){
                    String name = fromServer.readUTF();
                    String message = fromServer.readUTF();
                    ClientController.addLabel(name,message,vBox);
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }).start();
    }

}
