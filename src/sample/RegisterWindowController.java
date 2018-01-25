package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.ConnectException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField creditCardNoTextfield;

    @FXML
    private TextField firstNameTextfiled;

    @FXML
    private Button registerButton;

    @FXML
    private TextField loginTextfield;

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

    private DbConnection dbconn;

    @FXML
    void registerClicked(ActionEvent event) {
        //TODO rrejestracja customera w bazie

        Connection conn = dbconn.getConnection();

        final String columns = "(customer_id, first_name, last_name," +
                "country, city, street, home_no, zip_code, contact_no, email, credit_card_no, username, password)";

        try {
            conn.createStatement().executeUpdate("INSERT INTO mydb.customer " /*+ columns +*/ + " VALUES (DEFAULT, "
                    + "'" + firstNameTextfiled.getText() + "', "
                    + "'" + lastNameTextfield.getText() + "', "
                    + "'" + countryTextfield.getText() + "', "
                    + "'" + cityTextfield.getText() + "', "
                    + "'" + streetTextfield.getText() + "', "
                    + "'" + homeNoTextfield.getText() + "', "
                    + "'" + zipCodeTextfield.getText() + "', "
                    + "'" + contactNoTextfield.getText() + "', "
                    + "'" + emailTextfield.getText() + "', "
                    + "'" + creditCardNoTextfield.getText() + "', "
                    + "'" + loginTextfield.getText() + "', "
                    + "'" + passwordField.getText() + "');");
        }
        catch(SQLException e) {
            System.err.println("Error" + e);
        }

        Stage stage = (Stage) registerButton.getScene().getWindow();
        stage.close();
    }

    public void setDbConnection(DbConnection dbc) {
        this.dbconn = dbc;
    }

    @FXML
    void initialize() {
        assert creditCardNoTextfield != null : "fx:id=\"creditCardNoTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert firstNameTextfiled != null : "fx:id=\"firstNameTextfiled\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert loginTextfield != null : "fx:id=\"loginTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert emailTextfield != null : "fx:id=\"emailTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert contactNoTextfield != null : "fx:id=\"contactNoTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert lastNameTextfield != null : "fx:id=\"lastNameTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert zipCodeTextfield != null : "fx:id=\"zipCodeTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert streetTextfield != null : "fx:id=\"streetTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert confirmPasswordField != null : "fx:id=\"confirmPasswordField\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert countryTextfield != null : "fx:id=\"countryTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert cityTextfield != null : "fx:id=\"cityTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";
        assert homeNoTextfield != null : "fx:id=\"homeNoTextfield\" was not injected: check your FXML file 'RegisterWindow.fxml'.";

    }
}
