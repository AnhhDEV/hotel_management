package com.official.hotelmanagement.service;

import com.official.hotelmanagement.model.Floor;
import com.official.hotelmanagement.model.Hotel;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.repository.FloorRepository;
import com.official.hotelmanagement.repository.HotelRepository;
import com.official.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class HotelManagementService {

    public final HotelRepository hotelRepository;

    public final FloorRepository floorRepository;

    public final RoomRepository roomRepository;

    public HotelManagementService(HotelRepository hotelRepository, FloorRepository floorRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.floorRepository = floorRepository;
        this.roomRepository = roomRepository;
    }

    @Transactional
    public void createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Transactional
    public void addFloorToHotel(Integer hotelId, Floor floor) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        if (hotel.getFloors().isEmpty()) {
            hotel.setFloors(new HashSet<>());
        }
        hotel.getFloors().add(floor);
        hotelRepository.save(hotel);
    }

    @Transactional
    public void updateFloorToHotel(Integer hotelId, Floor floor) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        floorRepository.delete(floor);
        if (hotel.getFloors().isEmpty()) {
            hotel.setFloors(new HashSet<>());
        }
        hotel.getFloors().add(floor);
        floorRepository.save(floor);
        hotelRepository.save(hotel);
    }

    @Transactional
    public Floor addRoomToFloor(Integer hotelId, Integer floorNumber, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        Floor floor = hotel.getFloors().stream()
                .filter(f -> f.getFloorNumber().equals(floorNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Floor not found"));

        if (floor.getRooms() == null) {
            floor.setRooms(new HashSet<>());
        }
        floor.getRooms().add(room);
        return floorRepository.save(floor);
    }

}

