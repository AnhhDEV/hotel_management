package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Floor;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.model.dto.FloorDto;
import com.official.hotelmanagement.repository.RoomRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class RoomController {

    private RoomRepository rooms;

    public RoomController(RoomRepository rooms) {
        this.rooms = rooms;
    }

    @GetMapping(path = "/rooms")
    public Iterable<Room> getRooms() {
        return rooms.findAll();
    }

}
