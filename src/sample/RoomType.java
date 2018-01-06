package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RoomType {

    private Integer type_id;
    private final StringProperty name;
    private Integer max_guests;
    private Integer total_rooms;
    private Integer room_price;
    private final StringProperty description;

    public RoomType(Integer type_id, String name, Integer max_guests, Integer total_rooms, Integer room_price,
                    String description) {
        this.type_id = type_id;
        this.name = new SimpleStringProperty(name);
        this.max_guests = max_guests;
        this.total_rooms = total_rooms;
        this.room_price = room_price;
        this.description = new SimpleStringProperty(description);

    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
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

    public Integer getMax_guests() {
        return max_guests;
    }

    public void setMax_guests(Integer max_guests) {
        this.max_guests = max_guests;
    }

    public Integer getTotal_rooms() {
        return total_rooms;
    }

    public void setTotal_rooms(Integer total_rooms) {
        this.total_rooms = total_rooms;
    }

    public Integer getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Integer room_price) {
        this.room_price = room_price;
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
