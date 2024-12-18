package com.official.hotelmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("Hotel")
public class Hotel {
    @Id
    private Integer hotelId;
    private String name;
    private String address;
    private String contact;
    private String owner;
    @Transient
    @MappedCollection(idColumn = "hotel")
    private Set<Floor> floors;

    public Hotel() {};

    public Hotel(String name, String address, String contact, String owner) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.owner = owner;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }
}
