package com.wipro.velocity.brs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.brs.model.Address;
import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.CustomerAddress;
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
	@PostMapping("/customer")
    public Boolean loginDealer(@Validated @RequestBody Customer customer) 
    {
        Boolean a=false;;
        String email=customer.getEmail();
        String password=customer.getPassword();
        //System.out.println(email+password);
        Customer d = urepo.findByEmail(email);//.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: "));
    //    System.out.println(d.getEmail() +d.getPassword() );
       
        if(email.equals(d.getEmail()) && password.equals(d.getPassword()))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
            a=true;
           
                }
        return a;
    }
	
	@PostMapping("/customers")
    public CustomerAddress createDealer(@Validated @RequestBody CustomerAddress customer) {

 

        /*if(urepo.findByEmail(dealer.getEmail())!=null)
        {            
            new ResourceNotFoundException("User Already Exists");
        }*/
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
	
	 @GetMapping("/customers")
	    public List<CustomerAddress> getAllCustomers() {
	         return  urepo.fetchDealerInnerJoin();
	    }


}
