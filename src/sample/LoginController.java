package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private DbConnection dbconn;

    private Customer customer;

    @FXML
    void loginClicked(ActionEvent event) {

        Connection conn = dbconn.getConnection();

        try {
            ResultSet res = conn.createStatement().executeQuery("SELECT customer_id, password FROM mydb.customer WHERE username = '"
                    + loginField.getText() + "';");

            if(res.next())
            {
                //login correct
                if(res.getString(2).equals(passwordField.getText()))
                {
                    customer = new Customer(loginField.getText(), res.getString(1), true);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login successful", ButtonType.OK);
                    alert.showAndWait();
                }

                //wrong password
                else
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Wrong password", ButtonType.OK);
                    alert.showAndWait();
                }
            }

            //username not found
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "No such user found", ButtonType.OK);
                alert.showAndWait();
            }
        }
        catch(SQLException e) {
            System.err.println("Error" + e);
        }

        Stage stage = (Stage) loginButton.getScene().getWindow();

        if(customer.logged) {
            stage.fireEvent(
                    new WindowEvent(
                            stage,
                            WindowEvent.WINDOW_CLOSE_REQUEST
                    )
            );
        }

        //stage.close();
    }

    public void setDbConnection(DbConnection dbc) {
        this.dbconn = dbc;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public LoginController() {
        this.customer = new Customer();
    }

    @FXML
    void initialize() {
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'LoginWindow.fxml'.";
        assert loginField != null : "fx:id=\"loginField\" was not injected: check your FXML file 'LoginWindow.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'LoginWindow.fxml'.";
    }
}
