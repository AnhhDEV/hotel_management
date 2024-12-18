package com.official.hotelmanagement;

import com.official.hotelmanagement.model.*;
import com.official.hotelmanagement.repository.RoomRepository;
import com.official.hotelmanagement.service.EmployeeManagementService;
import com.official.hotelmanagement.service.ReservationManagementService;
import com.official.hotelmanagement.util.Payment;
import com.official.hotelmanagement.util.Role;
import com.official.hotelmanagement.util.Source;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class HotelManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(
//			EmployeeManagementService employeeManagementService,
//			ReservationManagementService reserve,
//			RoomRepository roomRepository,
//			ReservationManagementService reservationManagementService
//	) {
//		return args -> {
//			Reservation reservation = new Reservation(LocalDateTime.now(), LocalDateTime.now(), Payment.deposit, 1);
//			Room room = (roomRepository.findById(510).get());
//			List<Room> rooms = new ArrayList<>();
//			rooms.add(room);
//			reservationManagementService.insertReservation(reservation, rooms);
//		};
//	}

}
