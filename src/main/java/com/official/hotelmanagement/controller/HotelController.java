package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.service.HotelManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/hotel")
public class HotelController {

    private HotelManagementService hotelService;

    public HotelController(HotelManagementService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String getHotel() {
        return "demo/hotel";
    }

    @GetMapping("/add")
    public String addRoom() {
        return "demo/add-room";
    }

}
