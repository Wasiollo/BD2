package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField credit_card_no_textfield;

    @FXML
    private Button update_button;

    @FXML
    private TextField first_name_textfiled;

    @FXML
    private TextField email_textfield;

    @FXML
    private TextField contact_no_textfield;

    @FXML
    private TextField last_name_textfield;

    @FXML
    private TextField zip_code_textfield;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField street_textfield;

    @FXML
    private PasswordField confirm_password_field;

    @FXML
    private TextField country_textfield;

    @FXML
    private TextField city_textfield;

    @FXML
    private TextField home_no_textfield;

    @FXML
    void updateClicked(ActionEvent event) {

        //TODO napisać zapytanie które wykonuje update jesli password jest poprawny

        Stage stage = (Stage) update_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert credit_card_no_textfield != null : "fx:id=\"credit_card_no_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert update_button != null : "fx:id=\"update_button\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert first_name_textfiled != null : "fx:id=\"first_name_textfiled\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert email_textfield != null : "fx:id=\"email_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert contact_no_textfield != null : "fx:id=\"contact_no_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert last_name_textfield != null : "fx:id=\"last_name_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert zip_code_textfield != null : "fx:id=\"zip_code_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert password_field != null : "fx:id=\"password_field\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert street_textfield != null : "fx:id=\"street_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert confirm_password_field != null : "fx:id=\"confirm_password_field\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert country_textfield != null : "fx:id=\"country_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert city_textfield != null : "fx:id=\"city_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert home_no_textfield != null : "fx:id=\"home_no_textfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";

    }
}
