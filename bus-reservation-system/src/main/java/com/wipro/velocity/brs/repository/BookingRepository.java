package com.wipro.velocity.brs.repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.velocity.brs.model.Booking;
import com.wipro.velocity.brs.model.BookingsGet;
import com.wipro.velocity.brs.model.Customer;

public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	
	public List<Booking> findAll();
	
	@Query("SELECT new com.wipro.velocity.brs.model.BookingsGet(b.bookId,b.start, b.end, b.bookedDate, b.journeyDate, b.busNo,b.price, b.status, b.seat)"
			+ " FROM Booking b where b.customer = ?1 and b.journeyDate > ?2")
	List<BookingsGet> getUpcomingBookings(Customer cust,Date date);
	
	@Query("SELECT new com.wipro.velocity.brs.model.BookingsGet(b.bookId,b.start, b.end, b.bookedDate, b.journeyDate, b.busNo,b.price, b.status, b.seat)"
			+ " FROM Booking b where b.customer = ?1 and b.status='cancelled'")
	List<BookingsGet> getCancelledBookings(Customer cust);
	
	@Query("SELECT new com.wipro.velocity.brs.model.BookingsGet(b.bookId,b.start, b.end, b.bookedDate, b.journeyDate, b.busNo,b.price, b.status, b.seat)"
			+ " FROM Booking b where b.customer = ?1 and b.status='booked' and b.journeyDate < ?2")
	List<BookingsGet> getBookings(Customer cust, Date date);
	
	@Query("SELECT b.seat FROM Booking b where b.busNo=?1")
	List<Long> getBookedSeats(Long busId);
	
}
