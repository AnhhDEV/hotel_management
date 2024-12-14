package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Floor;
import com.official.hotelmanagement.model.dto.FloorDto;
import com.official.hotelmanagement.repository.FloorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class FloorController {

    private FloorRepository floors;

    public FloorController(FloorRepository floors) {
        this.floors = floors;
    }

    @GetMapping(path = "/floors")
    public Iterable<Floor> getFloors() {
        return floors.findAll();
    }

    @GetMapping(path = "/floorss")
    public List<FloorDto> getFloorss() {
        List<FloorDto> list = new ArrayList<>();
        floors.findAll().forEach(floor -> {
            list.add(toFloorDto(floor));
        } );
        return list;
    }

    public FloorDto toFloorDto(Floor floor) {
        return new FloorDto(
                floor.getFloorNumber(),
                floor.getRoomSet()
        );
    }

}
