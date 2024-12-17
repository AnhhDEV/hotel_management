package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.*;
import com.official.hotelmanagement.model.dto.FloorDto;
import com.official.hotelmanagement.model.dto.ReservationDto;
import com.official.hotelmanagement.repository.*;
import com.official.hotelmanagement.service.EmployeeManagementService;
import com.official.hotelmanagement.service.HotelManagementService;
import com.official.hotelmanagement.service.ReservationManagementService;
import com.official.hotelmanagement.util.RoomType;
import com.official.hotelmanagement.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoController {

    private final EmployeeManagementService employeeManagementService;
    private final HotelManagementService hotelManagementService;
    private final HotelRepository hotelRepository;
    private final FloorRepository floorRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationManagementService reservationManagementService;

    @Autowired
    public DemoController(EmployeeManagementService employeeManagementService, HotelManagementService hotelManagementService, HotelRepository hotelRepository, FloorRepository floorRepository, RoomRepository roomRepository, CustomerRepository customerRepository, ReservationRepository reservationRepository, ReservationManagementService reservationManagementService) {
        this.employeeManagementService = employeeManagementService;
        this.hotelManagementService = hotelManagementService;
        this.hotelRepository = hotelRepository;
        this.floorRepository = floorRepository;
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
        this.reservationRepository = reservationRepository;
        this.reservationManagementService = reservationManagementService;
    }

    @GetMapping(path = "/hotels")
    public Iterable<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping(path = "/floors")
    public Iterable<Floor> getFloors() {
        return floorRepository.findAll();
    }

    @GetMapping(path = "/rooms")
    public Iterable<Room> getRooms() {
        return hotelManagementService.getRooms();
    }

    @GetMapping(path = "/employees")
    public Iterable<Employee> getEmployees() {
        return employeeManagementService.getEmployees();
    }

    @GetMapping(path = "/customers")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/reservations")
    public Iterable<Reservation> getReservations() {
        return reservationManagementService.getReservations();
    }

    @GetMapping(path = "/reservationDtos")
    public Iterable<ReservationDto> getReservationDtos() {
        return reservationManagementService.getReservationDtos();
    }

    @GetMapping(path = "/reservation/{id}")
    public ReservationDto getReservation(@PathVariable("id") Integer id) {
        return reservationManagementService.getReservationById(id);
    }

    @GetMapping(path = "/floor_number")
    public List<FloorDto> getFloorNumbers() {
        return hotelManagementService.getFloorNumbers();
    }

    @GetMapping(path = "/room_ref")
    public Iterable<RoomReservation> getRoomRefs() {
        return reservationManagementService.getRoomReservations();
    }

    @GetMapping(path = "/new_hotel")
    public Iterable<Hotel> addFloorToHotel() {
        Floor floor = floorRepository.findById(10).get();
        hotelManagementService.updateFloorToHotel(1, floor);
        return hotelRepository.findAll();
    }

    @GetMapping(path = "/add_room_to_floor")
    public Floor addRoomToFloor() {
//        Room room = new Room(301, RoomType.vip, "", new BigDecimal(1300000), Status.occupied);
        Room room = roomRepository.findById(501).get();
        hotelManagementService.updateRoomToFloor(3, room);
        return floorRepository.findById(3).get();
    }

    @GetMapping(path = "/add_room_to_employee")
    public Employee addRoomToEmployee() {
        Room room = new Room(501, RoomType.normal, "", new BigDecimal(0), Status.out_of_service);
        employeeManagementService.addRoomToEmployee(8, room);
        return employeeManagementService.getEmployeeById(8);
    }

}
