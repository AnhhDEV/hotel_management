package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Floor;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.util.RoomType;
import com.official.hotelmanagement.util.Status;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    @Query("SELECT f.* FROM Floor f JOIN Room r ON r.floor = f.floor_number WHERE r.room_number = :roomNumber")
    Optional<Floor> findFloorByRoomNumber(@Param("roomNumber") Integer roomNumber);

    @Modifying
    @Query("INSERT INTO Room (room_number, room_type, description, cost, status, floor, hotel) " +
            "VALUES (:roomNumber, :roomType, :description, :cost, :status,:floor, :hotel)")
    void insertRoom(
            Integer roomNumber,
            String roomType,
            String description,
            BigDecimal cost,
            String status,
            Integer floor,
            Integer hotel
    );

}
