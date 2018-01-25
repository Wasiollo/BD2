package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Reservation {
    public final StringProperty reservation_id;
    public final StringProperty guests_no;
    public final StringProperty arrival;

    public String getReservation_id() {
        return reservation_id.get();
    }

    public StringProperty reservation_idProperty() {
        return reservation_id;
    }

    public void setReservation_id(String reservation_id) {
        this.reservation_id.set(reservation_id);
    }

    public String getGuests_no() {
        return guests_no.get();
    }

    public StringProperty guests_noProperty() {
        return guests_no;
    }

    public void setGuests_no(String guests_no) {
        this.guests_no.set(guests_no);
    }

    public String getArrival() {
        return arrival.get();
    }

    public StringProperty arrivalProperty() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival.set(arrival);
    }

    public String getDeparture() {
        return departure.get();
    }

    public StringProperty departureProperty() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure.set(departure);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public final StringProperty departure;
    public final StringProperty status;

    public Reservation(String reservation_id, String guests_no, String arrival, String departure, String status) {
        this.reservation_id = new SimpleStringProperty(reservation_id);
        this.guests_no = new SimpleStringProperty(guests_no);
        this.arrival = new SimpleStringProperty(arrival);
        this.departure = new SimpleStringProperty(departure);
        this.status = new SimpleStringProperty(status);
    }
}
