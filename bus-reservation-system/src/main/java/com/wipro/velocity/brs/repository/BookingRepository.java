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
	
	@Query("SELECT new com.wipro.velocity.brs.model.BookingsGet(b.bookId,b.source, b.destination, b.bookedDate, b.journeyDate, b.busNo,b.price, b.status, b.seat)"
			+ " FROM Booking b where b.customer = ?1 and b.journeyDate > ?2 and b.status='booked'")
	List<BookingsGet> getUpcomingBookings(Customer cust,Date date);
	
	@Query("SELECT new com.wipro.velocity.brs.model.BookingsGet(b.bookId,b.source, b.destination, b.bookedDate, b.journeyDate, b.busNo,b.price, b.status, b.seat)"
			+ " FROM Booking b where b.customer = ?1 and b.status='cancelled'")
	List<BookingsGet> getCancelledBookings(Customer cust);
	
	@Query("SELECT new com.wipro.velocity.brs.model.BookingsGet(b.bookId,b.source, b.destination, b.bookedDate, b.journeyDate, b.busNo,b.price, b.status, b.seat)"
			+ " FROM Booking b where b.customer = ?1 and b.status='booked' and b.journeyDate < ?2")
	List<BookingsGet> getBookings(Customer cust, Date date);
	
	@Query(value="SELECT * FROM bookings b where b.bus_no=?1 and b.status='booked'",
			nativeQuery=true)
	List<Booking> getBookedSeats(Long busId);
	
	@Query("SELECT SUM(b.price)"+ "FROM Booking b WHERE b.bookedDate>?1 and b.status='booked'")
	Long getProfits(Date date);

	@Query("SELECT COUNT(b.price)"+ "FROM Booking b WHERE b.bookedDate>?1 and b.status='booked'")
	Long getLMB(Date date);
	
	@Query("SELECT SUM(b.price)"+ "FROM Booking b WHERE b.bookedDate>?1 and b.status='booked'")
	Long getLWProfits(Date date);

	@Query("SELECT COUNT(b.price)"+ "FROM Booking b WHERE b.bookedDate>?1 and b.status='booked'")
	Long getLWB(Date date);
	
	@Query(value="Select source FROM bookings WHERE bookid=?1",nativeQuery=true)
	String getSource(Long id);
	
	@Query(value="Select destination FROM bookings WHERE bookid=?1",nativeQuery=true)
	String getDestination(Long id);
	
	@Query(value="select * from bookings where bookid=?1",
			nativeQuery=true)
	Booking getBookById(Long id);
	
	@Query("SELECT  new com.wipro.velocity.brs.model.BookingsGet(b.bookId,b.source, b.destination, b.bookedDate, b.journeyDate, b.busNo,b.price, b.status, b.seat)"
			+ " FROM Booking b order by b.bookedDate desc")
	public List<BookingsGet> getLatest();
}
