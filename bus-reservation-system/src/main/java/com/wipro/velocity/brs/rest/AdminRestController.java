package com.wipro.velocity.brs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.brs.model.Admin;
import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.Routes;
import com.wipro.velocity.brs.repository.AdminRepository;
import com.wipro.velocity.brs.repository.RouteRepository;

@RestController
@RequestMapping(value="/api/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminRestController {
		
	@Autowired
	AdminRepository arepo;
	
	@Autowired
	RouteRepository rrepo;
	
	@PostMapping("/login")
	public Boolean logInAdmin(Admin admin) {
		
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
	
	@PostMapping("/create")
	public void createAdmin(@RequestBody Admin admin) {
		arepo.save(admin);
		
	}
	
	@GetMapping("/top")
	public List<Routes> topRoutes(){
		
		List<Routes> routes= rrepo.findTop5ByOrderByUseCountDesc();
		return routes;
	}
}
