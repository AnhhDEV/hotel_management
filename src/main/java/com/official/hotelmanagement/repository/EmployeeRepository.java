package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
