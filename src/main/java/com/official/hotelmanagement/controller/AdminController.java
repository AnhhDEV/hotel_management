package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Hotel;
import com.official.hotelmanagement.model.Reservation;
import com.official.hotelmanagement.service.HotelManagementService;
import com.official.hotelmanagement.service.ReservationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private HotelManagementService hotelManagementService;

    @Autowired
    private ReservationManagementService reservationService;

    @GetMapping({"/dashboard", "/"})
    public String test(Model model) {
        Hotel hotel = hotelManagementService.getHotel();
        Integer floorTotal = hotelManagementService.getFloors().size();
        Integer roomTotal = hotelManagementService.getRoomTotal();
        Integer visitorCount = reservationService.customerTraffic();
        BigDecimal profit = reservationService.getProfit();
        model.addAttribute("hotel", hotel);
        model.addAttribute("floor", floorTotal);
        model.addAttribute("room", roomTotal);
        model.addAttribute("visitorCount", visitorCount);
        model.addAttribute("profit", profit);
        return "demo/test";
    }

}
