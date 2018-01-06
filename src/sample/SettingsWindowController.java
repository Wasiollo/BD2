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
    private TextField creditCardNoTextfield;

    @FXML
    private Button updateButton;

    @FXML
    private TextField firstNameTextfiled;

    @FXML
    private TextField emailTextfield;

    @FXML
    private TextField contactNoTextfield;

    @FXML
    private TextField lastNameTextfield;

    @FXML
    private TextField zipCodeTextfield;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField streetTextfield;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField countryTextfield;

    @FXML
    private TextField cityTextfield;

    @FXML
    private TextField homeNoTextfield;

    @FXML
    void updateClicked(ActionEvent event) {

        //TODO napisać zapytanie które wykonuje update jesli password jest poprawny

        Stage stage = (Stage) updateButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert creditCardNoTextfield != null : "fx:id=\"creditCardNoTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert updateButton != null : "fx:id=\"updateButton\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert firstNameTextfiled != null : "fx:id=\"firstNameTextfiled\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert emailTextfield != null : "fx:id=\"emailTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert contactNoTextfield != null : "fx:id=\"contactNoTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert lastNameTextfield != null : "fx:id=\"lastNameTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert zipCodeTextfield != null : "fx:id=\"zipCodeTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert streetTextfield != null : "fx:id=\"streetTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert confirmPasswordField != null : "fx:id=\"confirmPasswordField\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert countryTextfield != null : "fx:id=\"countryTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert cityTextfield != null : "fx:id=\"cityTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";
        assert homeNoTextfield != null : "fx:id=\"homeNoTextfield\" was not injected: check your FXML file 'SettingsWindow.fxml'.";

    }
}
