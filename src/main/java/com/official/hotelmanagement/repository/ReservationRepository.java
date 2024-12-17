package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Reservation;
import com.official.hotelmanagement.model.dto.ReservationDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    @Query("SELECT r.reservation_id, r.checkin_date, r.checkout_date, r.payment, " +
            "c.customer_id, c.firstname, c.lastname, c.contact, c.email, c.address, c.source, c.id_proof " +
            "FROM Reservation r " +
            "JOIN Customer c ON r.customer = c.customer_id " +
            "WHERE r.reservation_id = :reservationId")
    Optional<ReservationDto> findReservationWithCustomerById(Integer reservationId);

    @Query("SELECT r.reservation_id, r.checkin_date, r.checkout_date, r.payment, " +
            "c.customer_id, c.firstname, c.lastname, c.contact, c.email, c.address, c.source, c.id_proof " +
            "FROM Reservation r " +
            "JOIN Customer c ON r.customer = c.customer_id ")
    Iterable<ReservationDto> findReservationsDto();

}
