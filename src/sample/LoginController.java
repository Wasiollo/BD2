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
    private PasswordField password_field;

    @FXML
    private TextField login_field;

    @FXML
    private Button login_button;

    @FXML
    void loginClicked(ActionEvent event) {

        //TODO napisać zapytanie które łączy się z bazą i sprawdza poprawność loginu i hasła

        Stage stage = (Stage) login_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert password_field != null : "fx:id=\"password_field\" was not injected: check your FXML file 'LoginWindow.fxml'.";
        assert login_field != null : "fx:id=\"login_field\" was not injected: check your FXML file 'LoginWindow.fxml'.";
        assert login_button != null : "fx:id=\"login_button\" was not injected: check your FXML file 'LoginWindow.fxml'.";

    }
}
