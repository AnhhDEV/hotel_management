package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Customer;
import com.official.hotelmanagement.service.ReservationManagementService;
import com.official.hotelmanagement.util.Source;
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
        model.addAttribute("sources", Source.values()); // Enum Source
        return "demo/customer";
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam String firstname,
                              @RequestParam String lastname,
                              @RequestParam String contact,
                              @RequestParam String email,
                              @RequestParam String address,
                              @RequestParam Source source,
                              @RequestParam String idProof) {
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setContact(contact);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setSource(source);
        customer.setIdProof(idProof);

        reservationService.insertCustomer(customer);
        return "redirect:/admin/customers";
    }

    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") Integer id,
                                 @RequestParam String firstname,
                                 @RequestParam String lastname,
                                 @RequestParam String contact,
                                 @RequestParam String email,
                                 @RequestParam String address,
                                 @RequestParam Source source,
                                 @RequestParam String idProof) {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setContact(contact);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setSource(source);
        customer.setIdProof(idProof);

        reservationService.updateCustomer(customer);
        return "redirect:/admin/customers";
    }

}
