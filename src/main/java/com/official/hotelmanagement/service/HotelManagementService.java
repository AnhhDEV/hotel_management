package com.official.hotelmanagement.service;

import com.official.hotelmanagement.model.Floor;
import com.official.hotelmanagement.model.Hotel;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.model.dto.FloorDto;
import com.official.hotelmanagement.model.dto.RoomDto;
import com.official.hotelmanagement.repository.FloorRepository;
import com.official.hotelmanagement.repository.HotelRepository;
import com.official.hotelmanagement.repository.RoomRepository;
import com.official.hotelmanagement.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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


    @Transactional
    public void updateRoomToFloor(Integer newFloorNumber, Room updatedRoom) {
        Floor currentFloor = roomRepository.findFloorByRoomNumber(updatedRoom.getRoomNumber())
                .orElseThrow(() -> new RuntimeException("Room not found: " + updatedRoom.getRoomNumber()));
        Floor newFloor = floorRepository.findById(newFloorNumber)
                .orElseThrow(() -> new RuntimeException("New floor not found: " + newFloorNumber));
        currentFloor.getRooms().removeIf(room -> room.getRoomNumber().equals(updatedRoom.getRoomNumber()));
        if (newFloor.getRooms() == null) {
            newFloor.setRooms(new HashSet<>());
        }
        newFloor.getRooms().add(updatedRoom);
        floorRepository.save(currentFloor);
        floorRepository.save(newFloor);
    }

    public List<Floor> getFloors() {
        List<Floor> newFloors = new ArrayList<>();
        floorRepository.findAll().forEach(newFloors::add);
        return newFloors;
    }

    public Iterable<Room> getRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<FloorDto> getFloorNumbers() {
        List<FloorDto> list = new ArrayList<>();
        floorRepository.findAll().forEach(floorNumber -> {
            FloorDto floorDto = new FloorDto(floorNumber.getFloorNumber());
            list.add(floorDto);
        });
        return list;
    }

    public Room getFloorById(Integer id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found room"));
    }

    public void insertRoom(RoomDto roomDto) {
        roomRepository.insertRoom(
                roomDto.roomNumber(),
                roomDto.roomType().name(),
                roomDto.description(),
                roomDto.cost(),
                roomDto.status().name(),
                roomDto.floor(),
                roomDto.hotel()
        );
    }

    public void updateRoomStatus(Room room, Status status) {
        room.setStatus(status);
        roomRepository.save(room);
    }

}

