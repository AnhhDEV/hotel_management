package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Customer;
import com.official.hotelmanagement.service.ReservationManagementService;
import com.official.hotelmanagement.util.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("sources", Source.values());
        return "demo/customer";
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam String firstname,
                              @RequestParam String lastname,
                              @RequestParam String contact,
                              @RequestParam String email,
                              @RequestParam String address,
                              @RequestParam Source source,
                              @RequestParam String idProof,
                              RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setContact(contact);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setSource(source);
        customer.setIdProof(idProof);
        try {
            reservationService.insertCustomer(customer);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm khách hàng thành công");
            return "redirect:/admin/customers";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Thêm khách hàng thất bại");
            return "redirect:/admin/customers";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") Integer id,
                                 @RequestParam String firstname,
                                 @RequestParam String lastname,
                                 @RequestParam String contact,
                                 @RequestParam String email,
                                 @RequestParam String address,
                                 @RequestParam Source source,
                                 @RequestParam String idProof,
                                 RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setContact(contact);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setSource(source);
        customer.setIdProof(idProof);
        try {
            reservationService.updateCustomer(customer);
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhập thông tin khách hàng thành công");
            return "redirect:/admin/customers";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Thêm khách hàng thất bại");
            return "redirect:/admin/customers";
        }
    }

}
