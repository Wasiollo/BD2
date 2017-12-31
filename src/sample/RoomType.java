package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RoomType {

    private final StringProperty name;
    private final StringProperty max_guests;
    private final StringProperty total_rooms;
    private final StringProperty room_price;
    private final StringProperty description;

    public RoomType(String name, String max_guests, String total_rooms, String room_price, String description) {
        this.name = new SimpleStringProperty(name);
        this.max_guests = new SimpleStringProperty(max_guests);
        this.total_rooms = new SimpleStringProperty(total_rooms);
        this.room_price = new SimpleStringProperty(room_price);
        this.description = new SimpleStringProperty(description);

    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getMax_guests() {
        return max_guests.get();
    }

    public StringProperty max_guestsProperty() {
        return max_guests;
    }

    public void setMax_guests(String max_guests) {
        this.max_guests.set(max_guests);
    }

    public String getTotal_rooms() {
        return total_rooms.get();
    }

    public StringProperty total_roomsProperty() {
        return total_rooms;
    }

    public void setTotal_rooms(String total_rooms) {
        this.total_rooms.set(total_rooms);
    }

    public String getRoom_price() {
        return room_price.get();
    }

    public StringProperty room_priceProperty() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price.set(room_price);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
