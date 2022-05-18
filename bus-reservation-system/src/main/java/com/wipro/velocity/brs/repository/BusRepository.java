package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wipro.velocity.brs.model.Bus;

public interface BusRepository extends CrudRepository<Bus,Long> {
	
	@Query("SELECT new com.wipro.velocity.brs.model.Bus(b.busNo,b.start,b.end,b.arrival,b.departure,b.price)"
			+ "FROM Bus b WHERE b.start= ?1 and b.end= ?2")
	List<Bus> getBuses( String start, String end);
}
