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
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private DbConnection dbconn;

    private Customer customer;

    @FXML
    void updateClicked(ActionEvent event) {

        Connection conn = dbconn.getConnection();

        try {
            conn.createStatement().executeUpdate("UPDATE mydb.customer SET "
                    + "first_name = '" + firstNameTextfiled.getText() + "', "
                    + "last_name = '" + lastNameTextfield.getText() + "', "
                    + "country = '" + countryTextfield.getText() + "', "
                    + "city = '" + cityTextfield.getText() + "', "
                    + "street = '" + streetTextfield.getText() + "', "
                    + "home_no = '" + homeNoTextfield.getText() + "', "
                    + "zip_code = '" + zipCodeTextfield.getText() + "', "
                    + "contact_no = '" + contactNoTextfield.getText() + "', "
                    + "email = '" + emailTextfield.getText() + "', "
                    + "credit_card_no = '" + creditCardNoTextfield.getText() + "', "
                    + "password = '" + passwordField.getText() + "' "
                    + "WHERE username = '" + customer.login + "';");
        }
        catch(SQLException e) {
            System.err.println("Error" + e);
        }

        Stage stage = (Stage) updateButton.getScene().getWindow();
        stage.close();
    }

    public void setDbConnection(DbConnection dbc) {
        this.dbconn = dbc;
    }

    public void setCustomer(Customer cus) {
        this.customer = cus;
    }

    public void displayCustomerData() {
        final String columns = "first_name, last_name," +
                "country, city, street, home_no, zip_code, contact_no, email, credit_card_no, password";

        Connection conn = dbconn.getConnection();

        try {
            ResultSet res = conn.createStatement().executeQuery("SELECT " + columns + " FROM mydb.customer WHERE username = '"
                    + customer.login + "';");

            if(res.next())
            {
                firstNameTextfiled.setText(res.getString(1));
                lastNameTextfield.setText(res.getString(2));
                countryTextfield.setText(res.getString(3));
                cityTextfield.setText(res.getString(4));
                streetTextfield.setText(res.getString(5));
                homeNoTextfield.setText(res.getString(6));
                zipCodeTextfield.setText(res.getString(7));
                contactNoTextfield.setText(res.getString(8));
                emailTextfield.setText(res.getString(9));
                creditCardNoTextfield.setText(res.getString(10));
                passwordField.setText(res.getString(11));
                confirmPasswordField.setText(res.getString(11));
            }
        }
        catch(SQLException e) {
            System.err.println("Error" + e);
        }
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
