package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wipro.velocity.brs.model.Bus;

public interface BusRepository extends CrudRepository<Bus,Long> {
	
	@Query("SELECT new com.wipro.velocity.brs.model.Bus(b.busNo,b.source,b.destination,b.arrival,b.departure,b.price)"
			+ "FROM Bus b WHERE b.source= ?1 and b.destination= ?2")
	List<Bus> getBuses( String source, String destination);
	
	Bus findByBusNo(long busno);
}
