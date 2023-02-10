package com.example.banknewsys;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

public class Withdraw {
    private UserOps ops=new UserOps();
    @FXML
    private TextField amount = new TextField();
    @FXML
    private TextField User = new TextField();

    @FXML
    private TextField Pass = new TextField();
@FXML
private  TextField notifcation = new TextField();

    public void withdraw(ActionEvent event){

        amount.getProperties().put("vkType", "numeric");
    }
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
    public Button closeButton=new Button();
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
            Double i = Double.parseDouble(amount.getText().toString());
            if (i<= UserOps.getBalance() & ops.validCredentials(User.getText().toString(), Pass.getText().toString())) {
                UserOps.withdraw(i);
                stage.close();
            }
            else if (!ops.validCredentials(User.getText(), Pass.getText())){
                notifcation.setText("Wrong Credentials");
            }
            else {
                notifcation.setText("Insufficient Funds");
            }


        }
    }




