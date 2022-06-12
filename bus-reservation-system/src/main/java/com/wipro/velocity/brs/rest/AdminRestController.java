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

import com.wipro.velocity.brs.model.Admin;
import com.wipro.velocity.brs.model.Booking;
import com.wipro.velocity.brs.model.BookingsGet;
import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.CustomerAddress;
import com.wipro.velocity.brs.model.Routes;
import com.wipro.velocity.brs.repository.AdminRepository;
import com.wipro.velocity.brs.repository.BookingRepository;
import com.wipro.velocity.brs.repository.BusRepository;
import com.wipro.velocity.brs.repository.RouteRepository;
import com.wipro.velocity.brs.repository.UserRepository;

@RestController
@RequestMapping(value="/api/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminRestController {
		
	@Autowired
	AdminRepository arepo;
	
	@Autowired
	BookingRepository brepo;
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	RouteRepository rrepo;
	
	@Autowired
	BusRepository busrepo;
	
	@PostMapping("/login")
	public Boolean logInAdmin(@RequestBody Admin admin) {
		
		Boolean r =false;
		String email=admin.getEmail();
        String password=admin.getPassword();
        System.out.println(email+" "+password);
        Admin a = arepo.findByEmail(email);
       if(a!=null)
        if(email.equals(a.getEmail()) && password.equals(a.getPassword()))
                {
            r=true;
           
                }
        return r;
		
	}
	
	@PostMapping("/signup")
	public void createAdmin(@RequestBody Admin admin) {
		arepo.save(admin);
	}
	
	@GetMapping("/top")
	public List<Routes> topRoutes(){
		
		List<Routes> routes= rrepo.findTop5ByOrderByUseCountDesc();
		return routes;
	}

	@GetMapping("/inactive")
	public List<CustomerAddress> inactive(){
		List<CustomerAddress> customers = urepo.getCustomers();
		List<CustomerAddress> inactive = new ArrayList();
		for(CustomerAddress cust:customers) {
			Long count = urepo.getBookingsCount(cust.getId());
			
			if(count==0L)
				inactive.add(cust);
		}
		return inactive;
	}
	
	@GetMapping("/LMprofits")
	public Long getProfits() {
		Date newDate=new Date();
		Long profits;
		newDate.setMonth(newDate.getMonth()-1);
		profits= brepo.getProfits(newDate);

		return profits;
	}
	
	@GetMapping("LMB")
	public Long lastMonthBookings() {
		Date newDate=new Date();
		Long bookings;
		newDate.setMonth(newDate.getMonth()-1);
		return brepo.getLMB(newDate);
	}
	
	@GetMapping("/LWprofits")
	public Long LWProfits() {
		Date newDate=new Date();
		Long profits;
		newDate.setDate(newDate.getDate()-7);
		profits= brepo.getProfits(newDate);
		
		return profits;
	}
	
	@GetMapping("LWB")
	public Long LWBookings() {
		Date newDate=new Date();
		Long bookings;
		newDate.setDate(newDate.getDate()-7);
		return brepo.getLWB(newDate);
	}
	
	
	@GetMapping("delete/{id}")
	public void deleteBus(@PathVariable Long id) {
		busrepo.deleteById(id);
	}
	
}
	
