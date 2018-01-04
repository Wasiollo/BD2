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
    private Button confirm_button;
    @FXML
    private TextField guest_notextfield;
    @FXML
    private Label room_name_label;
    @FXML
    private Label max_guest_no_label;
    @FXML
    private Label departure_date_label;
    @FXML
    private Label arrival_date_label;

    public void setFields(String room_name, String arrival_date, String departure_date, String max_guest_no) {
        this.room_name_label.setText(room_name);
        this.arrival_date_label.setText(arrival_date);
        this.departure_date_label.setText(departure_date);
        this.max_guest_no_label.setText(max_guest_no);
    }

    @FXML
    void confirmClicked(ActionEvent event) {

        //TODO set reservation to database

        Stage stage = (Stage) confirm_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert confirm_button != null : "fx:id=\"confirm_button\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert guest_notextfield != null : "fx:id=\"guest_notextfield\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert room_name_label != null : "fx:id=\"room_name_label\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert max_guest_no_label != null : "fx:id=\"max_guest_no_label\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert departure_date_label != null : "fx:id=\"departure_date_label\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";
        assert arrival_date_label != null : "fx:id=\"arrival_date_label\" was not injected: check your FXML file 'ConfirmReservationWindow.fxml'.";

    }
}
