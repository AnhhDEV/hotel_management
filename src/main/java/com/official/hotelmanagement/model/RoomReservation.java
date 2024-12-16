package com.official.hotelmanagement.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("Room_Reservation")
public class RoomReservation {

    private Integer room;
    private Integer reservation;
    private BigDecimal totalCost;

    public RoomReservation() {}

    public RoomReservation(Integer room, Integer reservation, BigDecimal totalCost) {
        this.room = room;
        this.reservation = reservation;
        this.totalCost = totalCost;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getReservation() {
        return reservation;
    }

    public void setReservation(Integer reservation) {
        this.reservation = reservation;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "RoomReservation{" +
                "room=" + room +
                ", reservation=" + reservation +
                ", totalCost=" + totalCost +
                '}';
    }
}
