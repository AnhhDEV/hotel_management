package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Customer;
import com.official.hotelmanagement.model.Employee;
import com.official.hotelmanagement.service.EmployeeManagementService;
import com.official.hotelmanagement.service.ReservationManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    private EmployeeManagementService employeeManagementService;
    private ReservationManagementService reservationManagementService;

    public AdminPageController(EmployeeManagementService employeeManagementService, ReservationManagementService reservationManagementService) {
        this.employeeManagementService = employeeManagementService;
        this.reservationManagementService = reservationManagementService;
    }

    @RequestMapping({"/dashboard", "/"})
    public String test() {
        return "demo/test";
    }

    @GetMapping("/customers")
    public String getCustomerPage(Model model) {
        Iterable<Customer> customers = reservationManagementService.getCustomers();
        model.addAttribute("customers", customers);
        return "demo/customer";
    }

    @GetMapping("/employees")
    public String showEmployeePage(Model model) {
        Iterable<Employee> employees = employeeManagementService.getEmployees();
        model.addAttribute("employees", employees);
        return "demo/employee";
    }


}
