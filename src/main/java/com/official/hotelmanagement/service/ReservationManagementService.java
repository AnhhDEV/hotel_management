package com.official.hotelmanagement.service;

import com.official.hotelmanagement.model.Reservation;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.repository.CustomerRepository;
import com.official.hotelmanagement.repository.ReservationRepository;
import com.official.hotelmanagement.repository.RoomRepository;
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
    @Autowired
    public ReservationManagementService(ReservationRepository reservationRepository, CustomerRepository customerRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
    }

//    public void createReservationWithRooms(LocalDateTime checkinDate, LocalDateTime checkoutDate, Set<Integer> roomNumbers, BigDecimal cost) {
//        // Tạo một Reservation mới
//        Reservation reservation = new Reservation(checkinDate, checkoutDate, null);
//        reservationRepository.save(reservation);
//
//        // Duyệt qua các roomNumber và tạo RoomReservation
//        for (Integer roomNumber : roomNumbers) {
//            Room room = roomRepository.findById(roomNumber)
//                    .orElseThrow(() -> new IllegalArgumentException("Room không tồn tại: " + roomNumber));
//
//            RoomReservation roomReservation = new RoomReservation(
//                    room.getRoomNumber(),
//                    reservation.getReservationId(),
//                    cost
//            );
//            roomReservationRepository.save(roomReservation);
//        }
//
//        System.out.println("Đặt phòng thành công!");
//    }

}
