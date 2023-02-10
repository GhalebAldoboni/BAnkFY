package com.example.banknewsys;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
public class UserUiCtrl implements Initializable {

    private static Stage stage;
    private Scene scene;
    private Parent root;
    UserOps ops = new UserOps();
    // defifing the labels,textfields and buttons
    String carnumber = ops.cardNumber;
    Double vbalance = ops.getBalance();
    Main m = new Main();
    Label timerLabel = new Label();
    Timer timer = new Timer();
    @FXML
    public Label UserID;
    public static Label D_S;
    @FXML
    private Label cardNumber=new Label(carnumber);
    @FXML
    public  Label balance = new Label();
    @FXML
    public  Label income = new Label();
    @FXML
    public  Label expense = new Label();
    @FXML
    private TextField mailTrans1 = new TextField();
    @FXML
    private TextField  mailTrans=new TextField();
    @FXML
    private PasswordField mailTrans11= new PasswordField();
    @FXML
    private Label CardName = new Label(ops.Username);
    @FXML
    private Label ValidDate = new Label(ops.cardValid);
    @FXML
    private Label incomePer = new Label(UserOps.incomePercentage.toString());
    @FXML
    private Label expensePer = new Label(UserOps.expensePercentage.toString());
    @FXML
    private Button topUp;
    private Button refresh;
    @FXML
    private Button incomebut;
    @FXML
    private Button account;
    @FXML
    private  Label sucNot=new Label("Your transfer's complete");
    @FXML
    private Label failNot=new Label("Not enough balance!");
    @FXML
    private Button withdraw;
    // method to open new stage without closing Dashboard

    public void openScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setResizable(true);
        stage.show();
    }
@FXML
private Button logout=new Button();
    // button to close the dashboard and open Login Stage
    public void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        m.changeScene("login.fxml");
        stage.close();
    }
    //open topUp stage
    public void topup(ActionEvent event) throws IOException {
      openScene("topup.fxml");
        Refresh();

    }
    //open interest calculator stage
    public void income(ActionEvent event) throws IOException {
      openScene("intrest.fxml");
      Refresh();
    }
    // refresh all labels value
    public void refresh(ActionEvent event) throws IOException {
       Refresh();
    }
    //   // refresh all labels value
    public  void Refresh(){
        balance.setText(UserOps.getBalance().toString());
        cardNumber.setText(ops.cardNumber);
        CardName.setText(ops.Username.toUpperCase());
        ValidDate.setText(ops.cardValid);
        income.setText(UserOps.income.toString());
        expense.setText(UserOps.expense.toString());
        expensePer.setText(UserOps.expensePercentage.toString());
        incomePer.setText(UserOps.incomePercentage.toString());
        sucNot.setText("");
        failNot.setText("");
    }
// open Withdraw stage
    public void withdraw(ActionEvent event) throws IOException {
        openScene("withdraw.fxml");
        Refresh();
    }
    public void transfer(ActionEvent event) {
        Double amount = Double.parseDouble(mailTrans1.getText());
        PauseTransition visiblePause = null;
        if (amount <= UserOps.getBalance() && UserOps.validCredentials("Ghaleb",mailTrans11.getText())) {
            UserOps.withdraw(amount);
            Refresh();
            mailTrans1.clear();
            mailTrans.clear();
            mailTrans11.clear();
            // timer to hide the notification label
            sucNot.setText("Your transfer's complete");
            visiblePause = new PauseTransition(
                    Duration.seconds(2)
            );
            visiblePause.setOnFinished(
                    g -> sucNot.setText("")
            );
            visiblePause.play();
        }
        else {
            failNot.setText("insufficient funds or wrong password");
            mailTrans1.clear();
            mailTrans.clear();
            mailTrans11.clear();
            visiblePause = new PauseTransition(
                    Duration.seconds(2)
            );
            visiblePause.setOnFinished(
                    g -> failNot.setText("")
            );
            visiblePause.play();

    }balance.setText(UserOps.getBalance().toString());}
    public void digitsTxtFld() {
        this.mailTrans1.setTextFormatter(new TextFormatter<Integer>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));
    }
    public void digitsTxtFldpin() {
        this.mailTrans11.setTextFormatter(new TextFormatter<Integer>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") ) {
                return change;
            }
            return null;
        }));
    }
    public  void account (ActionEvent event) throws IOException {
        openScene("accont.fxml");
    }
    @Override
    //intialize all values
    public void initialize(URL url, ResourceBundle resourceBundle) {
  Refresh();
    }
}






