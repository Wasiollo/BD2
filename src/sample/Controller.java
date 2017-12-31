package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Button reserve_button;

    @FXML
    private DatePicker chceck_in_date_container;

    @FXML
    private TableColumn<RoomType, String> nameColumn;

    @FXML
    private Button filter_button;

    @FXML
    private Button search_button;

    @FXML
    private TableView<RoomType> tableView;

    @FXML
    private DatePicker check_out_date_container;

    @FXML
    private TableColumn<RoomType, String> maxGuestsColumn;

    @FXML
    private TableColumn<RoomType, String> priceColumn;

    @FXML
    private TableColumn<RoomType, String> descriptionColumn;

    private ObservableList<RoomType> data;

    private DbConnection dbconn;

    @FXML
    void filterClicked(ActionEvent event) {

    }

    @FXML
    void reserveClicked(ActionEvent event) {

    }

    @FXML
    void searchClicked(ActionEvent event) {
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
        assert chceck_in_date_container != null : "fx:id=\"chceck_in_date_container\" was not injected: check your FXML file 'sample.fxml'.";
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
