package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
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

    public void setFields(String room_name, String arrival_date, String departure_date,
                          Integer max_guest_no, Integer price) {
        this.roomNameLabel.setText(room_name);
        this.arrivalDateLabel.setText(arrival_date);
        this.departureDateLabel.setText(departure_date);
        this.maxGuestNoLabel.setText(max_guest_no.toString());
        this.priceLabel.setText(price.toString());
    }

    @FXML
    void confirmClicked(ActionEvent event) {

        //TODO ustawić rezerwację na bazie

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
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
