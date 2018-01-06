package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    private Button loginButton;

    @FXML
    void loginClicked(ActionEvent event) {

        //TODO napisać zapytanie które łączy się z bazą i sprawdza poprawność loginu i hasła

        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'LoginWindow.fxml'.";
        assert loginField != null : "fx:id=\"loginField\" was not injected: check your FXML file 'LoginWindow.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'LoginWindow.fxml'.";

    }
}
