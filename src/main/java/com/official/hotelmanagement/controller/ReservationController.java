package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Employee;
import com.official.hotelmanagement.model.Reservation;
import com.official.hotelmanagement.model.dto.ReservationDto;
import com.official.hotelmanagement.service.ReservationManagementService;
import com.official.hotelmanagement.util.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("payments", Payment.values());
        return "demo/reservations";
    }

    @PostMapping("/updatePayment")
    public String updatePayment(@RequestParam("reservationId") Integer reservationId,
                                @RequestParam("payment") Payment payment) {
        reservationService.updatePayment(reservationId, payment); // Cập nhật payment trong service
        return "redirect:/admin/dashboard";
    }

}
