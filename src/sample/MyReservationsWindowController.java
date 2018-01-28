package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyReservationsWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker checkInDateContainer;

    @FXML
    private TableColumn<Reservation, String> departureDateColumn;

    @FXML
    private MenuItem newReservationButton;

    @FXML
    private TableView<Reservation> tableView;

    @FXML
    private TableColumn<Reservation, String> arivalDateColumn;

    @FXML
    private DatePicker checkOutDateContainer;

    @FXML
    private TableColumn<Reservation, String> reservationIdColumn;

    @FXML
    private TableColumn<Reservation, String> reservationStatusColumn;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem closeButton;

    @FXML
    private Button filterButton;

    @FXML
    private TableColumn<Reservation, String> guestsNoColumn;

    private ObservableList<Reservation> data;

    private DbConnection dbconn;

    private Customer customer;

    private ObservableList<Reservation> filteredData;

    private Reservation tempReservation;

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
    public void filterClicked(ActionEvent event) {
        filteredData = FXCollections.observableArrayList();

        for (Reservation aData : data) {
            tempReservation = aData;
            if (tempReservation.getArrival().compareTo(checkInDateContainer.getValue().toString()) >= 0
                    && tempReservation.getDeparture().compareTo(checkOutDateContainer.getValue().toString()) <= 0) {
                filteredData.add(tempReservation);
            }
        }

        tableView.setItems(null);
        tableView.setItems(filteredData);
    }

    public void displayData() {
        Connection conn = dbconn.getConnection();

        try {
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT reservation_id, guests_no, arrival_date, departure_date, reservation_status" +
                    " FROM mydb.reservation WHERE customer_id = '" + customer.cust_id + "';");
            while (rs.next()) {
                data.add(new Reservation(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)));
            }

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservation_id"));
        guestsNoColumn.setCellValueFactory(new PropertyValueFactory<>("guests_no"));
        arivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrival"));
        departureDateColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
        reservationStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableView.setItems(null);
        tableView.setItems(data);
    }

    public void setDbConnection(DbConnection dbc) {
        this.dbconn = dbc;
    }

    public void setCustomer(Customer cus) {
        this.customer = cus;
    }

    @FXML
    void initialize() {
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
