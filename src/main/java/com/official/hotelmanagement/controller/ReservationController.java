package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Employee;
import com.official.hotelmanagement.model.Reservation;
import com.official.hotelmanagement.model.dto.ReservationDto;
import com.official.hotelmanagement.service.ReservationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin/reservations")
public class ReservationController {

    private ReservationManagementService reservationService;

    @Autowired
    public ReservationController(ReservationManagementService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String showReservation(Model model) {
        Iterable<ReservationDto> reservationDtos = reservationService.getReservationDtos();
        model.addAttribute("reservationsDtos", reservationDtos);
        return "demo/reservations";
    }

}
