package com.wipro.velocity.brs.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.brs.model.Address;
import com.wipro.velocity.brs.model.Booking;
import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.CustomerAddress;
import com.wipro.velocity.brs.repository.BookingRepository;
import com.wipro.velocity.brs.repository.CustomerRepository;
import com.wipro.velocity.brs.repository.UserRepository;


@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerRestController {
	
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	@Autowired
	private BookingRepository brepo;
	
	@PostMapping("/customer")
    public Boolean loginCustomer(@Validated @RequestBody Customer customer) 
    {
        Boolean a=false;
        String email=customer.getEmail();
        String password=customer.getPassword();
        System.out.println(email+" "+password);
        Customer c = urepo.findByEmail(email);//.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: "));
    //    System.out.println(d.getEmail() +d.getPassword() );
       if(c!=null)
        if(email.equals(c.getEmail()) && password.equals(c.getPassword()))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
            a=true;
           
                }
        return a;
    }
	
	
	@GetMapping("/getcustomer/{email}")
	public CustomerAddress getCustomer(@PathVariable String email) {
		System.out.println("customer details requested");
		return urepo.getCustomer(email);
	}
	
	
	@PostMapping("/customers")
    public CustomerAddress createCustomer(@Validated @RequestBody CustomerAddress customer) {
		
        Customer c=new Customer();
        c.setEmail(customer.getEmail());
        c.setFname(customer.getFname());
        c.setLname(customer.getLname());
        c.setPassword(customer.getPassword());
        c.setMobile(customer.getMobile());
        
        Address a=new Address();
        a.setStreet(customer.getStreet());
        a.setCity(customer.getCity());
        a.setPincode(customer.getPincode());
        a.setState(customer.getState());
        	
        c.setAddress(a);
        a.setCustomer(c);
        urepo.save(c);
        return customer;
    }
	
	@PostMapping("/changepass/{email}/{pass}")
	public Customer changePassword(@PathVariable String pass,@PathVariable String email) {
		System.out.println(email);
		System.out.println(pass);
		Customer cust = urepo.findByEmail(email);
		cust.setPassword(pass);
		urepo.save(cust);
		return cust;
	}
	
	@PutMapping("/update/{email}")
	public void updateProfile(@PathVariable String email, @Validated @RequestBody CustomerAddress customer ) {
		Customer cust = urepo.findByEmail(email);
		
		Address address = cust.getAddress();
		cust.setFname(customer.getFname());
		cust.setLname(customer.getLname());
		cust.setMobile(customer.getMobile());
		address.setCity(customer.getCity());
		address.setState(customer.getState());
		address.setStreet(customer.getStreet());
		address.setPincode(customer.getPincode());
		
		urepo.save(cust);
		
	}
	
}
