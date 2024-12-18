package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Floor;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.model.RoomReservation;
import com.official.hotelmanagement.model.dto.RoomDto;
import com.official.hotelmanagement.service.HotelManagementService;
import com.official.hotelmanagement.service.ReservationManagementService;
import com.official.hotelmanagement.util.RoomType;
import com.official.hotelmanagement.util.Status;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin/hotel")
public class HotelController {

    private final HotelManagementService hotelService;
    private final ReservationManagementService reservationService;

    public HotelController(HotelManagementService hotelService, ReservationManagementService reservationService) {
        this.hotelService = hotelService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getHotel(Model model) {
        List<Floor> floors = hotelService.getFloors();
        for(Floor floor : floors) {
            Set<Room> rooms = floor.getRooms();
            if(!rooms.isEmpty()) {
                for(Room room : rooms) {
                    Boolean check = reservationService.roomIsAvailable(room);
                    if(check) {
                        hotelService.updateRoomStatus(room, Status.Available);
                    } else {
                        hotelService.updateRoomStatus(room, Status.Occupied);
                    }
                }
            }
        }
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
        model.addAttribute("roomDto", new RoomDto(null, null, "", null, null, null, 1));
        model.addAttribute("roomTypes", RoomType.values());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("floors", hotelService.getFloorNumbers());
        return "demo/add-room";
    }

    @PostMapping("/add-room")
    public String addRoom(@ModelAttribute RoomDto roomDto, RedirectAttributes redirectAttributes) {
        try {
            hotelService.insertRoom(roomDto);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm phòng thành công!");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi: Số phòng đã tồn tại hoặc dữ liệu không hợp lệ!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi: Không thể thêm phòng. Vui lòng thử lại.");
        }
        return "redirect:/admin/dashboard";
    }

}
