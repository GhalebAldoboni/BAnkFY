package com.example.banknewsys;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends UserUiCtrl implements Initializable {

private  Stage stage;
private Scene scene;
private Parent root;
    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn=new Label("");
    @FXML
    public TextField username;
    @FXML
    private PasswordField password;



    public void switchToScene2(ActionEvent event) throws IOException {


        Main m = new Main();
        //pass entered credentials from text and password field to validCredentials in UserOps class or show error message
        if(UserOps.validCredentials(username.getText(),password.getText())) {
            wrongLogIn.setText("Success!");
            m.changeScene("UserUi.fxml");

        }

        else if(! UserOps.validCredentials(username.getText(),password.getText())) {
            wrongLogIn.setText("Please enter your data correctly ");
        }
        else if(username.getText().toString().equals("Admin") && password.getText().toString().equals("123")) {
            wrongLogIn.setText("Success!");

            m.changeScene("Admin.fxml");
        }

        else {
            wrongLogIn.setText("Wrong username or password!");
        }


    }



    }
