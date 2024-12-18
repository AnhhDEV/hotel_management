package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Integer> {
    boolean existsByUsernameAndPassword(String username, String password);
}
