package  com.example.banknewsys;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AdminUiCtrl implements Initializable {
Main m=new Main();
    @FXML
    private ListView<String> usersList;
    @FXML
    private ListView<String> balance;

    @FXML
    private Label slctdUser;

    String[] users = {"Ghaleb","Ahmed","Ali"};
    String [] userBalance = {"159000","321400","789456"};

    String currentUser;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        usersList.getItems().addAll(users);

        usersList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentUser = usersList.getSelectionModel().getSelectedItem();

                slctdUser.setText(currentUser);

            }
        });
    } public  void logout () throws IOException{
        m.changeScene("login.fxml");
    }
}