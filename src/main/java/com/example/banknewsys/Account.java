package com.example.banknewsys;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Account  implements Initializable  {

    @FXML
    private PasswordField ConfirmPassword;

    @FXML
    private PasswordField NewPassword;

    @FXML
    private Label accountType;
    @FXML
    private Label notification;


    @FXML
    private Label name;
    @FXML
    private Button Save;
    @FXML
    private PasswordField password;


    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) Save.getScene().getWindow();
        if ( UserOps.validPass(password.getText()) && NewPassword.getText().equals(ConfirmPassword.getText()) && NewPassword.getLength()>0) {
            UserOps.updatePass(NewPassword.getText());
            stage.close();
        }
        else if (! UserOps.validPass(password.getText())){
            notification.setText("Wrong Credentials");
        }
        else if ( NewPassword.getLength()==0){
            notification.setText("Password is not long enough");
        }
        else {
            notification.setText("new password doesn't match");
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(UserOps.Username);
        accountType.setText(UserOps.AccountType);

    }


}
