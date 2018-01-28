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

public class ConfirmReservationWindowController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField guestNoTextField;
    @FXML
    private Label roomNameLabel;
    @FXML
    private Label maxGuestNoLabel;
    @FXML
    private Label departureDateLabel;
    @FXML
    private Label arrivalDateLabel;
    @FXML
    private Label priceLabel;

    private Integer roomTypeId;

    private int maxguests;

    private DbConnection dbconn;

    private Customer customer;

    public void setFields(Integer id, String room_name, String arrival_date, String departure_date,
                          Integer max_guest_no, Integer price) {
        this.roomTypeId = id;
        this.roomNameLabel.setText(room_name);
        this.arrivalDateLabel.setText(arrival_date);
        this.departureDateLabel.setText(departure_date);
        this.maxGuestNoLabel.setText(max_guest_no.toString());
        this.priceLabel.setText(price.toString());
        this.maxguests = max_guest_no;
    }

    @FXML
    void confirmClicked(ActionEvent event) {

        try {
            int parsed = Integer.parseInt(guestNoTextField.getText());

            if(parsed < 1 || parsed > maxguests) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please specify a valid number of guests", ButtonType.OK);
                alert.showAndWait();
                return;
            }
        }
        catch(NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect value", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        Connection conn = dbconn.getConnection();

        try {
            String arrival = arrivalDateLabel.getText();
            String departure = departureDateLabel.getText();

            ResultSet res = conn.createStatement().executeQuery("SELECT room_no FROM mydb.room " +
                    "WHERE mydb.room.type_id = " + roomTypeId.toString()
                    + " AND room_no NOT IN (SELECT room_no FROM mydb.reservation " +
                    "WHERE (arrival_date <= '" + arrival + "' AND " +
                    "departure_date >= '" + arrival + "') OR " +
                    "(arrival_date <= '" + departure + "' AND " +
                    "departure_date >= '" + departure + "'));");

            String reserved_room = "";

            if(res.next())
            {
                reserved_room = res.getString(1);
            }

            conn.createStatement().executeUpdate("INSERT INTO mydb.reservation " + " VALUES (DEFAULT, "
                    + "'CONFIRMED', "
                    + reserved_room + ", "
                    + "1, "
                    + "'" + customer.cust_id + "', "
                    + guestNoTextField.getText() + ", "
                    + "'" + arrivalDateLabel.getText() + "', "
                    + "'" + departureDateLabel.getText() + "');");
        }
        catch(SQLException e) {
            System.err.println("Error" + e);
        }

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.fireEvent(
                new WindowEvent(
                        stage,
                        WindowEvent.WINDOW_CLOSE_REQUEST
                )
        );
        stage.close();
    }

    public void setDbConnection(DbConnection dbc) {
        this.dbconn = dbc;
    }

    public void setCustomer(Customer cus) {
        this.customer = cus;
    }

    @FXML
    void initialize() {
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert guestNoTextField != null : "fx:id=\"guestNoTextField\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert roomNameLabel != null : "fx:id=\"roomNameLabel\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert maxGuestNoLabel != null : "fx:id=\"maxGuestNoLabel\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert departureDateLabel != null : "fx:id=\"departureDateLabel\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert arrivalDateLabel != null : "fx:id=\"arrivalDateLabel\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert priceLabel != null : "fx:id=\"priceLabel\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
    }
}
