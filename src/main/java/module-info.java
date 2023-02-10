module com.example.banknewsys {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.banknewsys to javafx.fxml;
    exports com.example.banknewsys;
}