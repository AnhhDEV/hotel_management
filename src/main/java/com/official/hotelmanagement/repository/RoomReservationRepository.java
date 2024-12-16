package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.RoomReservation;
import org.springframework.data.repository.CrudRepository;

public interface RoomReservationRepository extends CrudRepository<RoomReservation, Integer> {
}
