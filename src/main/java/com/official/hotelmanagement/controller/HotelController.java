package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Floor;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.model.dto.RoomDto;
import com.official.hotelmanagement.service.HotelManagementService;
import com.official.hotelmanagement.util.RoomType;
import com.official.hotelmanagement.util.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/hotel")
public class HotelController {

    private final HotelManagementService hotelService;

    public HotelController(HotelManagementService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String getHotel(Model model) {
        List<Floor> floors = hotelService.getFloors();
        model.addAttribute("floors", floors);
        return "demo/hotel";
    }

    @GetMapping("/{id}")
    public String getHotelById(@PathVariable("id") Integer id, Model model) {
        Room room = hotelService.getRoomById(id);
        model.addAttribute("room", room);
        return "demo/room-detail";
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
