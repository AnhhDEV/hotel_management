package com.official.hotelmanagement.model.dto;

import com.official.hotelmanagement.model.Customer;
import com.official.hotelmanagement.model.Reservation;

import java.time.LocalDateTime;

public class ReservationDto {

    private Integer reservationId;
    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;
    private String payment;

    private Integer customerId;
    private String firstname;
    private String lastname;
    private String contact;
    private String email;
    private String address;


    public ReservationDto(Integer reservationId, LocalDateTime checkinDate, LocalDateTime checkoutDate, String payment, Integer customerId, String firstname, String lastname, String contact, String email, String address) {
        this.reservationId = reservationId;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.payment = payment;
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
        this.email = email;
        this.address = address;
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

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
