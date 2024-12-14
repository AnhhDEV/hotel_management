package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Hotel;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}
