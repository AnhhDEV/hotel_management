package com.official.hotelmanagement.model;

import com.official.hotelmanagement.util.RoomType;
import com.official.hotelmanagement.util.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Set;

@Table("Room")
public class Room {

    @Id
    private Integer roomNumber;
    private RoomType roomType;
    private String description;
    private BigDecimal cost;
    private Status status;
    @MappedCollection(idColumn = "room")
    private Set<RoomReservation> roomReservations;

    public Room() {}

    public Room(Integer roomNumber, RoomType roomType, String description, BigDecimal cost, Status status) {
        this.roomNumber = roomNumber;

        this.roomType = roomType;
        this.description = description;
        this.cost = cost;
        this.status = status;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(Set<RoomReservation> roomReservations) {
        this.roomReservations = roomReservations;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", status=" + status +
                '}';
    }
}
