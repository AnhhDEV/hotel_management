package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.model.dto.RoomDto;
import com.official.hotelmanagement.service.HotelManagementService;
import com.official.hotelmanagement.util.RoomType;
import com.official.hotelmanagement.util.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/hotel")
public class HotelController {

    private final HotelManagementService hotelService;

    public HotelController(HotelManagementService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String getHotel() {
        return "demo/hotel";
    }

    @GetMapping("/add-room")
    public String showAddRoomForm(Model model) {
        model.addAttribute("roomDto", new RoomDto(null, null, "", null, null, null, null));
        model.addAttribute("roomTypes", RoomType.values());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("floors", hotelService.getFloorNumbers());
        return "demo/add-room";
    }

    @PostMapping("/add-room")
    public String addRoom(@ModelAttribute RoomDto roomDto) {
        hotelService.insertRoom(roomDto);
        return "redirect:/admin/dashboard";
    }

}
