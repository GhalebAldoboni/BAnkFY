package com.example.banknewsys;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Intrest implements Initializable {
// defifing the labels,textfields and buttons

    @FXML
    private TextField Balance=new TextField("");

    @FXML
    private TextField EXProfit=new TextField("");

    @FXML
    private TextField Months=new TextField("");

    @FXML
    private Button calculate=new Button();
    @FXML
    private Label balance =new Label("");
    @FXML
    private TextField profRate=new TextField("");
// method to calculate the interest with info in text-field
    @FXML
    public void calc(ActionEvent event) throws IOException {
            double a = getDoubleFromTextField(Balance);
            double b = getDoubleFromTextField(profRate) /1200;
            double c = getDoubleFromTextField(Months);
            Double intrest= Double.valueOf(Math.round( a * Math.pow(1 + b, c)));
            balance.setText(intrest.toString());
        }
        // method to get the double value from the text-field
    private  double getDoubleFromTextField(TextField t) {
        return Double.parseDouble(t.getText());
    }
    @Override
    // initialize balance text field
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Balance.setText(UserOps.getBalance().toString());
    }
}