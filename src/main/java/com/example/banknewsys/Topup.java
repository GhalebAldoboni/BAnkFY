package com.example.banknewsys;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import java.io.IOException;
public class Topup extends  UserUiCtrl{
private UserOps ops =new UserOps();
// defifing the labels,textfields and buttons
    @FXML
    private TextField amount = new TextField("");
    public void topup(ActionEvent event){

        amount.getProperties().put("vkType", "numeric");
    }
    // link the text-field with a method restricts keyboard input to numbers only
    public void digitsTxtFld() {

        this.amount.setTextFormatter(new TextFormatter<Integer>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));
    }
    @FXML
    public Button closeButton;
    // pass the amount in amount textfiled to topuup method the UserOps class when press TopUP method and close TopUp stage
    @FXML
    public void handleCloseButtonAction(ActionEvent event) throws IOException {
        // get the double value from amount text-field
        Double i = Double.parseDouble(amount.getText().toString());
        UserOps.topup(i);
        Refresh();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }




    }

