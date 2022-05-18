package com.wipro.velocity.brs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.brs.model.Routes;
import com.wipro.velocity.brs.repository.RouteRepository;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins="http://localhost:4200")
public class RouteRestController {

	static String[] routes= {"bangalore chennai","bangalore hyderabad","bangalore mumbai","bengalore trivandrum",
			"chennai bangalore","chennai hyderabad","chennai mumbai","chennai trivandrum",
			"hyderabad bangalore","hyderabad chennai","hyderabad mumbai","hyderabad trivandrum",
			"mumbai bangalore","mumbai chennai","mumbai hyderabad","mumbai trivandrum",
			"trivandrum chennai","trivandrum bangalore","trivandrum hyderabad","trivandrum mumbai"};
	static Long[] fares= {950L,750L,1000L,1500L,
			950L,1100L,2000L,1050L,
			750L,1100L,1200L,2050L,
			1000L,2000L,1200L,2500L,
			1050L,1500L,2050L,2500L};
	@Autowired
	RouteRepository rrepo;
	
	@GetMapping("/get")
	public Boolean createRoutes() {
		for(int i=0;i<routes.length;i++) {
			Routes r=new Routes();
			r.setRoute(routes[i]);
			r.setFare(fares[i]);
			r.setUseCount(0L);
			rrepo.save(r);
		}
		return true;
	}
}
