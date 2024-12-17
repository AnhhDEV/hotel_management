package com.official.hotelmanagement.service;

import com.official.hotelmanagement.model.Customer;
import com.official.hotelmanagement.model.Reservation;
import com.official.hotelmanagement.model.RoomReservation;
import com.official.hotelmanagement.repository.CustomerRepository;
import com.official.hotelmanagement.repository.ReservationRepository;
import com.official.hotelmanagement.repository.RoomRepository;
import com.official.hotelmanagement.repository.RoomReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Service
public class ReservationManagementService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;
    private final RoomReservationRepository roomReservationRepository;

    @Autowired
    public ReservationManagementService(ReservationRepository reservationRepository, CustomerRepository customerRepository, RoomRepository roomRepository, RoomReservationRepository roomReservationRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
        this.roomReservationRepository = roomReservationRepository;
    }

    public Iterable<RoomReservation> getRoomReservations() {
        return roomReservationRepository.findAll();
    }

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
