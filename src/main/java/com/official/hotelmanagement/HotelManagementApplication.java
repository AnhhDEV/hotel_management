package com.official.hotelmanagement;

import com.official.hotelmanagement.model.Customer;
import com.official.hotelmanagement.model.Employee;
import com.official.hotelmanagement.service.EmployeeManagementService;
import com.official.hotelmanagement.service.ReservationManagementService;
import com.official.hotelmanagement.util.Role;
import com.official.hotelmanagement.util.Source;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

@SpringBootApplication
public class HotelManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			EmployeeManagementService employeeManagementService,
			ReservationManagementService reserve
	) {
		return args -> {
//			Employee employee = new Employee("Mike heng", Role.receptionist, new BigDecimal(1231231));
//			employeeManagementService.insertEmployee(employee);

//			Customer customer = new Customer("nah", "adwd", "213@", "a23", "", Source.corporate, "1231231231");
//			reserve.insertCustomer(customer);
//
//			Customer newCustomer = reserve.getCustomerById(5);
//			newCustomer.setFirstname("aaaaaaaaaaa");
//			reserve.updateCustomer(newCustomer);
//
//			reserve.deleteCustomer(customer);
		};
	}

}
