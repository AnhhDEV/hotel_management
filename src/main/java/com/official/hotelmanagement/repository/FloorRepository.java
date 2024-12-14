package com.official.hotelmanagement.repository;

import com.official.hotelmanagement.model.Floor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FloorRepository extends CrudRepository<Floor, Integer> {

}
