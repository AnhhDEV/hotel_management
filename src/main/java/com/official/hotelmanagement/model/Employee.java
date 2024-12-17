package com.official.hotelmanagement.model;

import com.official.hotelmanagement.util.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Set;

@Table("Employee")
public class Employee {

    @Id
    private Integer employeeId;
    @Column("full_name")
    private String fullname;
    private Role role;
    private BigDecimal salary;
    @MappedCollection(idColumn = "employee")
    private Set<Room> rooms;

    public Employee() {};

    public Employee(String fullname, Role role, BigDecimal salary) {
        this.fullname = fullname;
        this.role = role;
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", fullname='" + fullname + '\'' +
                ", role=" + role +
                ", rooms=" + rooms +
                '}';
    }
}
