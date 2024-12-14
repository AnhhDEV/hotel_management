package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Hotel;
import com.official.hotelmanagement.repository.HotelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelRepository hotels;

    public HotelController(HotelRepository hotelRepository) {
        this.hotels = hotelRepository;
    }

    @GetMapping(path = "/hotels")
    public Iterable<Hotel> getHotels() {
        return hotels.findAll();
    }

}
