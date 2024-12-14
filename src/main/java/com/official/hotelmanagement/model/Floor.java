package com.official.hotelmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table(name = "floor")
public class Floor {

    @Id
    @Column("floor_number")
    private Integer floorNumber;
    private Integer hotel;
    private Set<Room> roomSet = new HashSet<Room>();

    public Floor(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addRoom(Room room) {
        roomSet.add(room);
        room.addReferenceToFloor(this.floorNumber);
        room.addReferenceToHotel(hotel);
    }

    public void addReferenceToHotel(Integer hotelId) {
        this.hotel = hotelId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getHotel() {
        return hotel;
    }

    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNumber=" + floorNumber +
                ", hotelId=" + hotel +
                '}';
    }
}
