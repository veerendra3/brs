package com.wipro.velocity.brs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.brs.model.Bus;
import com.wipro.velocity.brs.model.BusRequest;
import com.wipro.velocity.brs.repository.BusRepository;
import com.wipro.velocity.brs.model.Routes;
@RestController
@RequestMapping(value="/api/bus")
@CrossOrigin(origins="http://localhost:4200")
public class BusRestController {

	
	@Autowired
	private BusRepository busrepo;
	
	@PostMapping("create")
	public void createBus(@RequestBody Bus bus) {
		
		busrepo.save(bus);
	}
	
	@PostMapping("get")
	public List<Bus> getBus(@RequestBody BusRequest bus){
		System.out.println(bus.getSource()+" "+bus.getDestination());
		
	List<Bus> buses = busrepo.getBuses(bus.getSource(),bus.getDestination());
	System.out.println("buses info fetched");
	System.out.println(buses);
		return buses;
		
	}
}
