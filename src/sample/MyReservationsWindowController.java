package sample;

import javafx.application.Platform;
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
    private MenuItem settingsButton;

    @FXML
    private MenuItem loginButton;

    @FXML
    private DatePicker checkInDateContainer;

    @FXML
    private TableColumn<?, ?> departureDateColumn;

    @FXML
    private MenuItem newReservationButton;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> arivalDateColumn;

    @FXML
    private DatePicker checkOutDateContainer;

    @FXML
    private TableColumn<?, ?> reservationIdColumn;

    @FXML
    private TableColumn<?, ?> reservationStatusColumn;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem closeButton;

    @FXML
    private Button filterButton;


    @FXML
    private TableColumn<?, ?> guestsNoColumn;

    @FXML
    void settingsClicked(ActionEvent event) {
        new Controller().settingsClicked(event);
    }

    @FXML
    void closeClicked(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void newReservationClicked(ActionEvent event) {
        Stage stage = (Stage) filterButton.getScene().getWindow();
        stage.fireEvent(
                new WindowEvent(
                        stage,
                        WindowEvent.WINDOW_HIDING
                )
        );
        stage.close();
    }

    @FXML
    void filterClicked(ActionEvent event) {

        //TODO button clicked event do pokazania rezerwacji w przedziale czasu
        //TODO moim zdaniem bez dodatkowych filtrów

    }

    @FXML
    void initialize() {
        assert settingsButton != null : "fx:id=\"settingsButton\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert checkInDateContainer != null : "fx:id=\"checkInDateContainer\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert departureDateColumn != null : "fx:id=\"departureDateColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert newReservationButton != null : "fx:id=\"newReservationButton\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert arivalDateColumn != null : "fx:id=\"arivalDateColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert checkOutDateContainer != null : "fx:id=\"checkOutDateContainer\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert reservationIdColumn != null : "fx:id=\"reservationIdColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert reservationStatusColumn != null : "fx:id=\"reservationStatusColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert filterButton != null : "fx:id=\"filterButton\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";
        assert guestsNoColumn != null : "fx:id=\"guestsNoColumn\" was not injected: check your FXML file 'MyReservationsWindow.fxml'.";

    }
}
