package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wipro.velocity.brs.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	
	public List<Booking> findAll();
	
}
