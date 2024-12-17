package com.official.hotelmanagement.controller;

import com.official.hotelmanagement.model.Employee;
import com.official.hotelmanagement.service.EmployeeManagementService;
import com.official.hotelmanagement.service.ReservationManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/employees")
public class EmployeeController {

    private EmployeeManagementService employeeService;
    public EmployeeController(EmployeeManagementService employeeManagementService) {
        this.employeeService = employeeManagementService;
    }

    @GetMapping
    public String showEmployeePage(Model model) {
        Iterable<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "demo/employee";
    }

    // 2. Thêm nhân viên mới
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.insertEmployee(employee);
        return "redirect:/admin/dashboard";
    }

    // 3. Chỉnh sửa nhân viên
    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") Integer id, @ModelAttribute("employee") Employee employee) {
        employee.setEmployeeId(id); // Đảm bảo ID không bị thay đổi
        employeeService.updateEmployee(employee);
        return "redirect:/admin/dashboard"; // Quay lại danh sách sau khi cập nhật thành công
    }

    // 4. Xóa nhân viên
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            employeeService.deleteEmployee(employee);
        }
        return "redirect:/admin/dashboard"; // Quay lại danh sách sau khi xóa
    }


}
