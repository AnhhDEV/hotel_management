package com.official.hotelmanagement.model;

import com.official.hotelmanagement.util.RoomType;
import com.official.hotelmanagement.util.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "room")
public class Room {

    @Id
    @Column("room_number")
    private Integer roomNumber;
    @Column("room_type")
    private RoomType roomType;
    private String description;
    private Long cost;
    private Status status;
    private Integer floor;
    private Integer hotel;

    public Room(Integer roomNumber, RoomType roomType, String description, Long cost, Status status) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.description = description;
        this.cost = cost;
        this.status = status;
    }

    public void addReferenceToFloor(Integer floorNumber) {
        this.floor = floorNumber;
    }

    public void addReferenceToHotel(Integer hotelId) {
        this.hotel = hotelId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getHotel() {
        return hotel;
    }

    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", status=" + status +
                ", floorNumber=" + floor +
                ", hotelId=" + hotel +
                '}';
    }
}
