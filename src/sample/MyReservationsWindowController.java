package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MyReservationsWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem settings_button;

    @FXML
    private MenuItem login_button;

    @FXML
    private DatePicker check_in_date_container;

    @FXML
    private TableColumn<?, ?> departureDateColumn;

    @FXML
    private MenuItem new_reservatuib_button;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> arivaldateColumn;

    @FXML
    private DatePicker check_out_date_container;

    @FXML
    private TableColumn<?, ?> reservationIdColumn;

    @FXML
    private TableColumn<?, ?> reservationStatusColumn;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem close_button;

    @FXML
    private Button filter_button;

    @FXML
    private MenuItem my_reservations_button;

    @FXML
    private TableColumn<?, ?> guestsNoColumn;

    @FXML
    void loginClicked(ActionEvent event) {

    }

    @FXML
    void settingsClicked(ActionEvent event) {

    }

    @FXML
    void closeClicked(ActionEvent event) {

    }

    @FXML
    void newReservationClicked(ActionEvent event) {
        Stage stage = (Stage) filter_button.getScene().getWindow();
        stage.fireEvent(
                new WindowEvent(
                        stage,
                        WindowEvent.WINDOW_CLOSE_REQUEST
                )
        );
    }

    @FXML
    void myReservationsClicked(ActionEvent event) {

    }

    @FXML
    void filterClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert settings_button != null : "fx:id=\"settings_button\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert login_button != null : "fx:id=\"login_button\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert check_in_date_container != null : "fx:id=\"check_in_date_container\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert departureDateColumn != null : "fx:id=\"departureDateColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert new_reservatuib_button != null : "fx:id=\"new_reservatuib_button\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert arivaldateColumn != null : "fx:id=\"arivaldateColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert check_out_date_container != null : "fx:id=\"check_out_date_container\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert reservationIdColumn != null : "fx:id=\"reservationIdColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert reservationStatusColumn != null : "fx:id=\"reservationStatusColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert close_button != null : "fx:id=\"close_button\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert filter_button != null : "fx:id=\"filter_button\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert my_reservations_button != null : "fx:id=\"my_reservations_button\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert guestsNoColumn != null : "fx:id=\"guestsNoColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";

    }
}
