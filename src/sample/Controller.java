package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Controller {

    @FXML
    private MenuItem settingsButton;

    @FXML
    private MenuItem loginButton;

    @FXML
    private TableView<RoomType> tableView;

    @FXML
    private MenuItem registerButton;

    @FXML
    private DatePicker checkOutDateContainer;

    @FXML
    private MenuItem myReservationsButton;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button reserveButton;

    @FXML
    private DatePicker checkInDateContainer;

    @FXML
    private MenuItem closeButton;

    @FXML
    private Button filterButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button defaultFilters;

    @FXML
    private CheckBox price4CheckBox;

    @FXML
    private CheckBox price3CheckBox;

    @FXML
    private CheckBox price2CheckBox;

    @FXML
    private CheckBox price1CheckBox;

    @FXML
    private CheckBox guest1CheckBox;

    @FXML
    private CheckBox guest2CheckBox;

    @FXML
    private CheckBox guest3CheckBox;

    @FXML
    private CheckBox guest4CheckBox;

    @FXML
    private TableColumn<RoomType, String> maxGuestsColumn;

    @FXML
    private TableColumn<RoomType, String> priceColumn;

    @FXML
    private TableColumn<RoomType, String> nameColumn;

    @FXML
    private TableColumn<RoomType, String> descriptionColumn;

    private ObservableList<RoomType> data;

    private ObservableList<RoomType> firstFilteredData;

    private ObservableList<RoomType> filteredData;

    private RoomType filtrationIterator;

    private Integer IteratorRoomPrice;

    private Integer IteratorMaxGuests;

    private DbConnection dbconn;

    private Customer currentCustomer;

    @FXML
    void registerClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "RegisterWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            RegisterWindowController controller = fxmlLoader.getController();
            controller.setDbConnection(dbconn);

            Stage stage = new Stage();
            stage.setTitle("Register Window");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loginClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "LoginWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            LoginController controller = fxmlLoader.getController();
            controller.setDbConnection(dbconn);

            Stage stage = new Stage();
            stage.setTitle("Login Window");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();

            stage.setOnCloseRequest((WindowEvent event1) -> {
                currentCustomer = controller.getCustomer();

                if (currentCustomer.logged) {
                    settingsButton.setDisable(false);
                    reserveButton.setDisable(false);
                    myReservationsButton.setDisable(false);
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void myReservationsClicked(ActionEvent event) {

        Stage stage = (Stage) reserveButton.getScene().getWindow();
        stage.hide();
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "MyReservationsWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            MyReservationsWindowController controller = fxmlLoader.getController();
            controller.setDbConnection(dbconn);
            controller.setCustomer(currentCustomer);

            Stage myReservationsStage = new Stage();
            myReservationsStage.setTitle("My Reservations");
            myReservationsStage.setScene(new Scene(root1));
            myReservationsStage.setResizable(false);
            myReservationsStage.show();

            controller.displayData();

            myReservationsStage.setOnHiding((WindowEvent event1) -> stage.show());
            myReservationsStage.setOnCloseRequest((WindowEvent event2) -> {
                Platform.exit();
                System.exit(0);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void settingsClicked(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "SettingsWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            SettingsWindowController controller = fxmlLoader.getController();
            controller.setDbConnection(dbconn);
            controller.setCustomer(currentCustomer);
            controller.displayCustomerData();

            Stage stage = new Stage();
            stage.setTitle("Settings Window");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();


            stage.setOnCloseRequest((WindowEvent event1) -> {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void closeClicked(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void filterClicked(ActionEvent event) {
        firstFilteredData = FXCollections.observableArrayList();
        filteredData = FXCollections.observableArrayList();

        for (RoomType aData : data) {
            filtrationIterator = aData;
            IteratorMaxGuests = filtrationIterator.getMax_guests();
            if ((guest1CheckBox.isSelected() && IteratorMaxGuests == 1)
                    || (guest2CheckBox.isSelected() && IteratorMaxGuests == 2)
                    || (guest3CheckBox.isSelected() && IteratorMaxGuests == 3)
                    || (guest4CheckBox.isSelected() && IteratorMaxGuests == 4)
                    ) {
                firstFilteredData.add(filtrationIterator);
            }
        }

        for (RoomType aData : firstFilteredData) {
            filtrationIterator = aData;
            IteratorRoomPrice = filtrationIterator.getRoom_price();
            if ((price1CheckBox.isSelected() && filtrationIterator.getRoom_price() <= 100)
                    || (price2CheckBox.isSelected() && IteratorRoomPrice >= 100 && IteratorRoomPrice <= 200)
                    || (price3CheckBox.isSelected() && IteratorRoomPrice >= 200 && IteratorRoomPrice <= 500)
                    || (price4CheckBox.isSelected() && IteratorRoomPrice >= 500)
                    ) {
                filteredData.add(filtrationIterator);
            }
        }

        tableView.setItems(null);
        tableView.setItems(filteredData);

    }

    @FXML
    void defaultFiltersClicked(ActionEvent event) {
        price1CheckBox.setSelected(true);
        price2CheckBox.setSelected(true);
        price3CheckBox.setSelected(true);
        price4CheckBox.setSelected(true);
        guest1CheckBox.setSelected(true);
        guest2CheckBox.setSelected(true);
        guest3CheckBox.setSelected(true);
        guest4CheckBox.setSelected(true);
    }

    @FXML
    void reserveClicked(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "ConfirmReservationWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            ConfirmReservationWindowController controller =
                    fxmlLoader.getController();
            controller.setDbConnection(dbconn);
            controller.setCustomer(currentCustomer);

            ObservableList oList = tableView.getItems();
            RoomType temp = (RoomType) oList.get(tableView.getSelectionModel().getSelectedIndex());

            controller.setFields(
                    temp.getType_id(),
                    temp.getName(),
                    checkInDateContainer.getValue().toString(),
                    checkOutDateContainer.getValue().toString(),
                    temp.getMax_guests(),
                    temp.getRoom_price()
            );
            Stage stage = new Stage();
            stage.setTitle("Confirm");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();

            stage.setOnCloseRequest((WindowEvent event1) -> this.searchClicked(event));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void searchClicked(ActionEvent event) {
        LocalDate checkIn = checkInDateContainer.getValue();
        LocalDate checkOut = checkOutDateContainer.getValue();

        if (checkOut.isBefore(checkIn)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Check-out date before check-in date!");
            alert.showAndWait();
            data.clear();
            return;
        }

        try {
            Connection conn = dbconn.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.room_type " +
                    "WHERE mydb.get_number_of_free_rooms_this_type(mydb.room_type.type_id, '"
                    + checkIn.toString() + "', '"
                    + checkOut.toString() + "') > 0;");
            while (rs.next()) {
                data.add(new RoomType(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        maxGuestsColumn.setCellValueFactory(new PropertyValueFactory<>("max_guests"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("room_price"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        tableView.setItems(null);
        tableView.setItems(data);

        filterButton.setDisable(false);
    }

    @FXML
    void initialize() {
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'sample.fxml'.";
        assert reserveButton != null : "fx:id=\"reserveButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert checkInDateContainer != null : "fx:id=\"chceck_in_date_container\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert filterButton != null : "fx:id=\"filterButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'sample.fxml'.";
        assert checkOutDateContainer != null : "fx:id=\"checkOutDateContainer\" was not injected: check your FXML file 'sample.fxml'.";
        assert maxGuestsColumn != null : "fx:id=\"maxGuestsColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert priceColumn != null : "fx:id=\"priceColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert descriptionColumn != null : "fx:id=\"descriptionColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert defaultFilters != null : "fx:id=\"defaultFilters\" was not injected: check your FXML file 'sample.fxml'.";

        dbconn = new DbConnection();
        currentCustomer = new Customer();
        settingsButton.setDisable(true);
        filterButton.setDisable(true);
        reserveButton.setDisable(true);
        myReservationsButton.setDisable(true);
        searchButton.setDisable(true);

        checkInDateContainer.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (checkOutDateContainer.getValue() != null)
                searchButton.setDisable(false);
        });

        checkOutDateContainer.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (checkInDateContainer.getValue() != null)
                searchButton.setDisable(false);
        });
    }
}
