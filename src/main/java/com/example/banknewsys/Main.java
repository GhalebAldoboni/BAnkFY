package com.example.banknewsys;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class Main extends Application {
    private static Stage stg;
    // Start the application with Login stage
    @Override
    public void start(Stage stage) throws IOException {

        stg = stage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Ghaleb Bank");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    //change the scene of the credentials are right
    public void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stg.close();
        stage.setResizable(false);
        stage.show();
    }
// main method
    public static void main(String[] args) {
        launch();
    }
}


