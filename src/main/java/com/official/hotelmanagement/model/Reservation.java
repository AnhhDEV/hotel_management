package com.official.hotelmanagement.model;

import com.official.hotelmanagement.util.Payment;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Table("Reservation")
public class Reservation {

    @Id
    private Integer reservationId;
    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;
    private Payment payment;
    @MappedCollection(idColumn = "reservation")
    private Set<RoomReservation> roomReservations;

    public Reservation() {}

    public Reservation(LocalDateTime checkinDate, LocalDateTime checkoutDate, Payment payment) {
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.payment = payment;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDateTime checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(Set<RoomReservation> roomReservations) {
        this.roomReservations = roomReservations;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", payment=" + payment +
                '}';
    }
}
