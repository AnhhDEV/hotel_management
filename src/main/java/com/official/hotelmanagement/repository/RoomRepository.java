package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Floor;
import com.official.hotelmanagement.model.Room;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    @Query("SELECT f.* FROM Floor f JOIN Room r ON r.floor = f.floor_number WHERE r.room_number = :roomNumber")
    Optional<Floor> findFloorByRoomNumber(@Param("roomNumber") Integer roomNumber);

}
