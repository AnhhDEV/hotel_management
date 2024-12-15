package com.official.hotelmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("Floor")
public class Floor {

    @Id
    private Integer floorNumber;
    @MappedCollection(idColumn = "floor")
    private Set<Room> rooms;

    public Floor() {}

    public Floor(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
