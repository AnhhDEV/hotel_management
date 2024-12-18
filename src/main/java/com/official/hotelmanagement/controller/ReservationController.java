package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Reservation;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.model.dto.ReservationDto;
import com.official.hotelmanagement.service.ReservationManagementService;
import com.official.hotelmanagement.util.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/reservations")
public class ReservationController {

    private ReservationManagementService reservationService;

    @Autowired
    public ReservationController(ReservationManagementService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("/reserve")
    public String showReserveForm(Model model) {
        model.addAttribute("customers", reservationService.getCustomers());
        model.addAttribute("availableRooms", reservationService.getRoomsByAvailable());
        model.addAttribute("payments", Payment.values());
        return "demo/reserve-room";
    }

    // Xử lý lưu đặt phòng
    @PostMapping("/add")
    public String addReservation(@RequestParam("customerId") Integer customerId,
                                 @RequestParam("checkinDate") String checkinDate,
                                 @RequestParam("checkoutDate") String checkoutDate,
                                 @RequestParam("payment") Payment payment,
                                 @RequestParam("roomIds") List<Integer> roomIds,
                                 RedirectAttributes redirectAttributes) {
        // Tạo đối tượng Reservation
        Reservation reservation = new Reservation();
        reservation.setCustomer(customerId);
        reservation.setCheckinDate(LocalDateTime.parse(checkinDate + "T00:00:00"));
        reservation.setCheckoutDate(LocalDateTime.parse(checkoutDate + "T00:00:00"));
        reservation.setPayment(payment); // Gán trạng thái thanh toán

        // Tìm danh sách phòng từ roomIds
        List<Room> rooms = reservationService.getRoomsByIds(roomIds);

        // Lưu đặt phòng
        reservationService.insertReservation(reservation, rooms);
        redirectAttributes.addFlashAttribute("successMessage", "Đặt phòng thành công!");
        return "redirect:/admin/dashboard"; // Quay về danh sách đặt phòng
    }

    @GetMapping
    public String showReservation(Model model) {
        Iterable<ReservationDto> reservationDtos = reservationService.getReservationDtos();
        model.addAttribute("reservationsDtos", reservationDtos);
        model.addAttribute("payments", Payment.values());
        return "demo/reservations";
    }

    @PostMapping("/updatePayment")
    public String updatePayment(@RequestParam("reservationId") Integer reservationId,
                                @RequestParam("payment") Payment payment) {
        reservationService.updatePayment(reservationId, payment); // Cập nhật payment trong service
        return "redirect:/admin/dashboard";
    }

}
