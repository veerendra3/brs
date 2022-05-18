package com.wipro.velocity.brs.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.brs.model.Booking;
import com.wipro.velocity.brs.model.BookingsGet;
import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.Routes;
import com.wipro.velocity.brs.repository.BookingRepository;
import com.wipro.velocity.brs.repository.RouteRepository;
import com.wipro.velocity.brs.repository.UserRepository;

@RestController
@RequestMapping(value="/api/bookings")
@CrossOrigin(origins="http://localhost:4200")
public class BookingRestController {
	
	@Autowired
	private BookingRepository brepo;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	RouteRepository rrepo;
	
	@PostMapping("/create/{email}")
	public Booking newBooking(@RequestBody Booking newbooking,@PathVariable String email) {
		
		
		Customer cust = urepo.findByEmail(email);
		List<Booking> bookings;
		
		Routes r = rrepo.findByRoute(newbooking.getStart()+" "+newbooking.getEnd());
		r.setUseCount(r.getUseCount()+1L);
		rrepo.save(r);
		
		if(cust.getBookings()!=null) {
					bookings= cust.getBookings();
			}
			else {
				bookings = new ArrayList<Booking>();
			}
			newbooking.setCustomer(cust);
			
			brepo.save(newbooking);
			bookings.add(newbooking);
			
			cust.setBookings(bookings);
			urepo.save(cust);
			return newbooking;
		
	}
	
	
	@GetMapping("/getUpcoming/{email}")
	public List<BookingsGet> getUBookings(@PathVariable String email){
		
		Customer cust = urepo.findByEmail(email);
		
		Date date=new Date();
		
		
		return brepo.getUpcomingBookings(cust , date);
		
	}
	
	@GetMapping("/getCancelled/{email}")
	public List<BookingsGet> getCBookings(@PathVariable String email){
		
		Customer cust = urepo.findByEmail(email);
		  
		return brepo.getCancelledBookings(cust);
		
	}
	
	@GetMapping("/get/{email}")
	public List<BookingsGet> getBookings(@PathVariable String email){
		
		Customer cust = urepo.findByEmail(email);
		Date date=new Date();
		return brepo.getBookings(cust,date);
		
	}
		
}
