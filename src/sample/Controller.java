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
            }); //TODO jeżeli nie chcemy żeby coś się działo przy zamknięciu to wywalić tą lambdę

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void loginClicked(ActionEvent event) {

        //TODO prawdoopodnie trzeba stworzyć obiekt customera, który miałby dane wyciągnięte z bazy podczas logowania
        //TODO nie wiem czy nie przy inicjalizacji projektu i przekazywać go sobie między kontrolerami okienek.
        //TODO bo bez tego okienko settings i my reservation cale bedzie biedą.
        //TODO Zainicjalizować go nullami i w logowaniu setować realnymi wartoścami. Wiem że obvious ale lepiej
        //TODO napisać.

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
            }); //TODO jeżeli nie chcemy żeby coś się działo przy zamknięciu to wywalić tą lambdę

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void myReservationsClicked(ActionEvent event) {

        //TODO przekazanie obiektu customera tak jak pisałem wcześniej??

        Stage stage = (Stage) reserveButton.getScene().getWindow();
        stage.hide();
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "MyReservationsWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MyReservationsWindowController controller = fxmlLoader.<MyReservationsWindowController>getController();

            Stage myReservationsStage = new Stage();
            myReservationsStage.setTitle("My Reservations");
            myReservationsStage.setScene(new Scene(root1));
            myReservationsStage.setResizable(false);
            myReservationsStage.show();

            myReservationsStage.setOnHiding((WindowEvent event1) -> {
                stage.show();
            });
            myReservationsStage.setOnCloseRequest((WindowEvent event2) -> {
                Platform.exit();
                System.exit(0);
            }); // Przypadki gdy zamykamy albo chowamy okienko obsłużone WindowEventami i Lambdami

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void settingsClicked(ActionEvent event) {

        //TODO przeniesienie obiektu customera ??

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
            }); //TODO jeżeli nie chcemy żeby coś się działo przy zamknięciu to wywalić tą lambdę

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
        //TODO żeby strzelać jeszcze raz do bazy. Bardziej opłaca się chyba wyfiltrować observable arrayListe.
        //TODO Ale może to trudne.
    }

    @FXML
    void reserveClicked(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource(
                            "ConfirmReservationWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ConfirmReservationWindowController controller =
                    fxmlLoader.<ConfirmReservationWindowController>getController();

            ObservableList oList = tableView.getItems();
            RoomType temp = (RoomType) oList.get(tableView.getSelectionModel().getSelectedIndex());

            controller.setFields(
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

            stage.setOnCloseRequest((WindowEvent event1) -> {
            }); //TODO jeżeli nie chcemy żeby coś się działo przy zamknięciu to wywalić tą lambdę

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void searchClicked(ActionEvent event) {

        //TODO REFORMAT TEGO KODU I ZAPYTAANIE WYCIAGAJĄCE DANE Z BAZY OGRANICZONYCH DO KONKRETNEGO PRZEDZIALU DAT
        //TODO WYCIAGNIETYCH Z ODPOWIEDNICH PÓl
        //TODO zastanowic się czy sensowne jest zachowanie, gdzie najpierw filtrujemy i potem klikamy search.
        //TODO co wyciągnęło by dane już zfiltrowane, ale nie wiem czy nie skomplikuje nam to zapytania
        //TODO ewentualnie jak jest picknięte w filtrach to pofiltrowac dane po pobraniu i dopiero dac do tabeli
        //TODO dodać sprawdzanie czy coś jest w date_pickerach bo jeśli nie to nie robić nic moim zdaniem

        try {
            Connection conn = dbconn.getConnection();
            data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.room_type");
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
        dbconn = new DbConnection();
    }
}
