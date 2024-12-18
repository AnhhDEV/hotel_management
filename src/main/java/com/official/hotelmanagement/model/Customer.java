package com.official.hotelmanagement.model;

import com.official.hotelmanagement.util.Source;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("Customer")
public class Customer {

    @Id
    private Integer customerId;
    private String firstname;
    private String lastname;
    private String contact;
    private String email;
    private String address;
    private Source source;
    private String idProof;
    @Transient
    @MappedCollection(idColumn = "customer")
    private Set<Reservation> reservations;

    public Customer() {}

    public Customer(String firstname, String lastname, String contact, String email, String address, Source source, String idProof) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.source = source;
        this.idProof = idProof;
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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", source=" + source +
                ", idProof='" + idProof + '\'' +
                '}';
    }
}
