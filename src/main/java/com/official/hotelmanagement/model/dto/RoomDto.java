package com.official.hotelmanagement.model.dto;

import com.official.hotelmanagement.util.RoomType;
import com.official.hotelmanagement.util.Status;

import java.math.BigDecimal;

public record RoomDto(
        Integer roomNumber,
        RoomType roomType,
        String description,
        BigDecimal cost,
        Status status,
        Integer floor,
        Integer hotel
) {
}
