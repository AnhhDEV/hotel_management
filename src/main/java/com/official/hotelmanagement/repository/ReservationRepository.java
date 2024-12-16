package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
