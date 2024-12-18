package com.official.hotelmanagement.service;

import com.official.hotelmanagement.model.Customer;
import com.official.hotelmanagement.model.Reservation;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.model.RoomReservation;
import com.official.hotelmanagement.model.dto.ReservationDto;
import com.official.hotelmanagement.repository.CustomerRepository;
import com.official.hotelmanagement.repository.ReservationRepository;
import com.official.hotelmanagement.repository.RoomRepository;
import com.official.hotelmanagement.repository.RoomReservationRepository;
import com.official.hotelmanagement.util.Payment;
import com.official.hotelmanagement.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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

    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Iterable<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public ReservationDto getReservationById(Integer id) {
        return reservationRepository.findReservationWithCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public List<ReservationDto> getReservationDtos() {
        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();

        return reservations.stream().map(reservation -> {
            ReservationDto dto = new ReservationDto();
            dto.setReservationId(reservation.getReservationId());
            dto.setFirstname(customerRepository.findById(reservation.getCustomer()).orElseThrow().getFirstname());
            dto.setLastname(customerRepository.findById(reservation.getCustomer()).orElseThrow().getLastname());
            dto.setContact(customerRepository.findById(reservation.getCustomer()).orElseThrow().getContact());
            dto.setCheckinDate(reservation.getCheckinDate());
            dto.setCheckoutDate(reservation.getCheckoutDate());
            dto.setPayment(reservation.getPayment().name());

            // Lấy danh sách các phòng đã đặt
            List<String> roomNumbers = reservation.getRoomReservations().stream()
                    .map(rr -> rr.getRoom().toString())
                    .collect(Collectors.toList());
            dto.setRoomNumbers(roomNumbers);

            return dto;
        }).collect(Collectors.toList());
    }

    public void updatePayment(Integer reservationId, Payment payment) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setPayment(payment);
        reservationRepository.save(reservation);
    }

    public void insertReservation(Reservation reservation, List<Room> rooms) {
        reservation.setRoomReservations(new HashSet<>());
        rooms.forEach(r -> {
            reservation.getRoomReservations().add(
                    new RoomReservation(r.getRoomNumber(), reservation.getReservationId(), r.getCost())
            );
        });
        reservationRepository.save(reservation);
    }

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public List<Room> getRoomsByAvailable() {
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms.stream()
                .filter(room -> room.getStatus().equals(Status.Available))
                .collect(Collectors.toList());
    }

    public List<Room> getRoomsByIds(List<Integer> roomIds) {
        List<Room> rooms = new ArrayList<>();
       roomRepository.findAllById(roomIds).forEach(rooms::add);
       return rooms;
    }

    public Boolean roomIsAvailable(Room room) {
        Set<RoomReservation> roomReservations = room.getRoomReservations();
        if(!roomReservations.isEmpty()) {
            for(RoomReservation r : roomReservations) {
                Integer reservationId = r.getReservation();
                Reservation reservation = reservationRepository.findById(reservationId)
                        .orElseThrow(() -> new RuntimeException("Not found reservation"));
                LocalDateTime checkedOut = reservation.getCheckoutDate();
                LocalDateTime now = LocalDateTime.now();
                if(now.isAfter(checkedOut)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public BigDecimal getProfit() {
        BigDecimal total = new BigDecimal(0);
        for (RoomReservation roomReservation : roomReservationRepository.findAll()) {
            total = total.add(roomReservation.getTotalCost());
        }
        return total;
    }

    public Integer customerTraffic() {
        return reservationRepository.countReservation();
    }

}
