package com.official.hotelmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table(name = "hotel")
public class Hotel {
    @Id
    @Column("hotel_id")
    private Integer hotelId;
    private String name;
    private String address;
    private String contact;
    private String owner;
    private Set<Floor> floors = new HashSet<>();

    public Hotel(Integer hotelId, String name, String address, String contact, String owner) {
        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.owner = owner;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
        floor.addReferenceToHotel(this.hotelId);
    }

    public void removeFloor(Floor floor) {
        floors.remove(floor);
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

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", owner='" + owner + '\'' +
                ", floors=" + floors +
                '}';
    }
}
