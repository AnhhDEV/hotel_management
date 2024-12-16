package com.official.hotelmanagement.model;

import com.official.hotelmanagement.util.Payment;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("Reservation")
public class Reservation {

    @Id
    private Integer reservationId;
    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;
    private Payment payment;

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
