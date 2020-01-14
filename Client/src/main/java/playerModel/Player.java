/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerModel;


import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;

/**
 *
 * @author halim
 */
public class Player {
    private int id; // autoGenerate in database
    private SimpleStringProperty name;
    private String uname;
    private String password; //it's a VARCHAR in database with size (32)
    private String email;
    private int status; // it's a ENUM in database which contain offline(0), online(1), busy(2)
    private int score;
    private String avatar; // optional
    public JFXButton btn = new JFXButton();
    // constructor used for GUI only
    public Player(String n, String p, String e){
        name = new SimpleStringProperty(n);
        uname = n;
        password = p;
        email = e;
        status = 0; // offline as initial
        score = 0; // as initial value
    }
    public String getName() {
        return name.get();
    }
    public void setName(String n){
        name.set(n);
    }

    public JFXButton getStatus(){
        if(status==0){
            btn.setStyle("-fx-background-color: #F8327E;");
            btn.setText("Offline");
            btn.setDisable(true);
            return btn;
        }
        else if (status==1){
            btn.setStyle("-fx-background-color: #54dfc4;");
            btn.setText("Online");
            return btn;
        }
        btn.setText("Busy");
        return btn;
    }
    public String getScore(){
        return Integer.toString(score);
    }


    // constructors used for retrieve in databaseManager only
    public Player(int i, String n, String p, String e, int s, String a, int sc){
        id = i;
        uname = n;
        name = new SimpleStringProperty(n);
        email = e;
        password = p;
        status = s;
        score = sc;
        avatar = a;
    }

    public Player(){
        event();
    }

    // setDATA for player
    public void setPlayerName(String n){
        name = new SimpleStringProperty(n);
        uname = n;
    }
    public void setPlayerPassword(String p){
        password = p;
    }
    public void setPlayerEmail(String e){
        email = e;
    }
    public void setPlayerStatus(int s){
        status = s;
    }
    public void setPlayerScore(int s){
        score = s;
    }
    public void setPlayerAvatar(String s){
        avatar = s;
    }

    // getDATA for player
    public int getID(){
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
    public String getPlayerName(){
        return uname;
    }
    public String getPlayerPassword(){
        return password;
    }
    public String getPlayerEmail(){
        return email;
    }
    public int getPlayerStatus(){
        return status;
    }
    public int getPlayerScore(){
        return score;
    }
    public String getPlayerAvatar(){
        return avatar;
    }
    public void event(){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(id+":"+name);
            }
        });
    }
}
