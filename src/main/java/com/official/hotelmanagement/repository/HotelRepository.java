package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Hotel;
import com.official.hotelmanagement.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {


}
