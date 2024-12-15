package com.official.hotelmanagement.service;

import com.official.hotelmanagement.model.Employee;
import com.official.hotelmanagement.model.Room;
import com.official.hotelmanagement.repository.EmployeeRepository;
import com.official.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
public class EmployeeManagementService {

    private final EmployeeRepository employeeRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public EmployeeManagementService(EmployeeRepository employeeRepository, RoomRepository roomRepository) {
        this.employeeRepository = employeeRepository;
        this.roomRepository = roomRepository;
    }

    //Only add new room.
    @Transactional
    public void addRoomToEmployee(Integer employeeId, Room room) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Not found employee"));
        if(employee.getRooms().isEmpty()) {
            employee.setRooms(new HashSet<>());
        }
        employee.getRooms().add(room);
        employeeRepository.save(employee);
    }

    //Basic CRUD
    public void insertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

}

