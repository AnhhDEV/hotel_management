package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
