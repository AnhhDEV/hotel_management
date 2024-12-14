package com.official.hotelmanagement.model.dto;

import com.official.hotelmanagement.model.Room;

public record FloorDto(
        Integer floorNumber,
        java.util.Set<Room> rooms
) {
}
