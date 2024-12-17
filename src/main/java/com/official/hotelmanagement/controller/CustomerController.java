package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Customer;
import com.official.hotelmanagement.model.Employee;
import com.official.hotelmanagement.service.ReservationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/customers")
public class CustomerController {

    private final ReservationManagementService reservationService;

    @Autowired
    public CustomerController(ReservationManagementService reserveService) {
        this.reservationService = reserveService;
    }

    @GetMapping
    public String listCustomers(Model model) {
        Iterable<Customer> customers = reservationService.getCustomers();
        model.addAttribute("customers", customers);
        return "demo/customer"; // Trả về template customer.html
    }

    // 2. Thêm khách hàng mới
    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        reservationService.insertCustomer(customer);
        return "redirect:/admin/customers";
    }

    // 3. Chỉnh sửa khách hàng
    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") Integer id, @ModelAttribute("customer") Customer customer) {
        customer.setCustomerId(id);
        reservationService.updateCustomer(customer);
        return "redirect:/admin/customers";
    }

    // 4. Xóa khách hàng
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id) {
        Customer customer = reservationService.getCustomerById(id);
        if (customer != null) {
            reservationService.deleteCustomer(customer);
        }
        return "redirect:/admin/customers";
    }
}
