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

public class Controller {

    @FXML
    private MenuItem settings_button;

    @FXML
    private MenuItem login_button;

    @FXML
    private TableView<RoomType> tableView;

    @FXML
    private MenuItem register_button;

    @FXML
    private DatePicker check_out_date_container;

    @FXML
    private MenuItem my_reservations_button;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button reserve_button;

    @FXML
    private DatePicker check_in_date_container;

    @FXML
    private MenuItem close_button;


    @FXML
    private Button filter_button;

    @FXML
    private Button search_button;

    @FXML
    private CheckBox price5CheckBox;

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
    private CheckBox guest5CheckBox;

    @FXML
    private TableColumn<RoomType, String> maxGuestsColumn;

    @FXML
    private TableColumn<RoomType, String> priceColumn;

    @FXML
    private TableColumn<RoomType, String> nameColumn;

    @FXML
    private TableColumn<RoomType, String> descriptionColumn;

    private ObservableList<RoomType> data;

    private DbConnection dbconn;

    @FXML
    void registerClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "RegisterWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            RegisterWindowController controller = fxmlLoader.<RegisterWindowController>getController();

            Stage stage = new Stage();
            stage.setTitle("Register Window");
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
    void loginClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "LoginWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            LoginController controller = fxmlLoader.<LoginController>getController();

            Stage stage = new Stage();
            stage.setTitle("Login Window");
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
    void myReservationsClicked(ActionEvent event) {
        Stage stage = (Stage) reserve_button.getScene().getWindow();
        stage.hide();
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "MyReservationsWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MyReservationsWindowController controller = fxmlLoader.<MyReservationsWindowController>getController();

            Stage myreservationsstage = new Stage();
            myreservationsstage.setTitle("Login Window");
            myreservationsstage.setScene(new Scene(root1));
            myreservationsstage.setResizable(false);
            myreservationsstage.show();


            myreservationsstage.setOnCloseRequest((WindowEvent event1) -> {
                stage.show();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void newReservationClicked(ActionEvent event) {

    }

    @FXML
    void settingsClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "SettingsWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            SettingsWindowController controller = fxmlLoader.<SettingsWindowController>getController();

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

        // To co tu jest pokazuje jak dostać się do wartości chceckboxów
        if (price5CheckBox.isSelected())
            price5CheckBox.setSelected(false);
        //TODO wyświetlić tylko te dane w tabeli które będą sfiltrowane przy pomocy checkboxów - nie widzę sensu,
        //TODO żeby strzelać jeszcze raz do bazy. Bardziej opłaca się chyba wyfiltrować observable arrayListe. Ale może
        //TODO to trudne
    }

    @FXML
    void reserveClicked(ActionEvent event) {
        //TODO wyświetlić okienko w którym będą dane rezerwacji z przyciskiem apply

        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "ConfirmReservationWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ConfirmReservationWindowController controller = fxmlLoader.<ConfirmReservationWindowController>getController();
            controller.setFields(
                    "King garten", //TODO poprawić tak, żeby brał z tabelki, anie na stałe
                    check_in_date_container.getValue().toString(),
                    check_out_date_container.getValue().toString(),
                    "12" //TODO tak samo jak room_name
            );
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
    void searchClicked(ActionEvent event) {

        //TODO REFORMAT TEGO KODU I ZAPYTAANIE WYCIAGAJĄCE DANE Z BAZY OGRANICZONYCH DO KONKRETNEGO PRZEDZIALU DAT
        //TODO WYCIAGNIETYFH Z ODPOWIEDNICH PÓl

        try {
            Connection conn = dbconn.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.room_type");
            while (rs.next()) {
                data.add(new RoomType(rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
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
    }

    @FXML
    void initialize() {
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'sample.fxml'.";
        assert reserve_button != null : "fx:id=\"reserve_button\" was not injected: check your FXML file 'sample.fxml'.";
        assert check_in_date_container != null : "fx:id=\"chceck_in_date_container\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert filter_button != null : "fx:id=\"filter_button\" was not injected: check your FXML file 'sample.fxml'.";
        assert search_button != null : "fx:id=\"search_button\" was not injected: check your FXML file 'sample.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'sample.fxml'.";
        assert check_out_date_container != null : "fx:id=\"check_out_date_container\" was not injected: check your FXML file 'sample.fxml'.";
        assert maxGuestsColumn != null : "fx:id=\"maxGuestsColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert priceColumn != null : "fx:id=\"priceColumn\" was not injected: check your FXML file 'sample.fxml'.";
        assert descriptionColumn != null : "fx:id=\"descriptionColumn\" was not injected: check your FXML file 'sample.fxml'.";
        dbconn = new DbConnection();
    }
}
