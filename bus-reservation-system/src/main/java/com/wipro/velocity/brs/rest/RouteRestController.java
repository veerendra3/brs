package com.wipro.velocity.brs.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.brs.model.Routes;
import com.wipro.velocity.brs.repository.RouteRepository;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins="http://localhost:4200")
public class RouteRestController {
	
	
	
	
	
	@Autowired
	RouteRepository rrepo;
	
//	@GetMapping("/get")
//	public Boolean createRoutes() {
//		for(int i=0;i<routes.length;i++) {
//			Routes r=new Routes();
//			r.setRoute(routes[i]);
//			r.setFare(fares[i]);
//			r.setUseCount(0L);
//			rrepo.save(r);
//		}
//		return true;
//	}
	
	@GetMapping("/getsources")
	public List<String> getSources(){
		List<String> routes=rrepo.findSources();
		return routes;
	}
	
	@GetMapping("/getdestinations")
	public List<String> getDestinations(){
		List<String> routes=rrepo.findDestinations();
		return routes;
	}
	
	@GetMapping("/addroute/{source}/{destination}")
	public void addRoute(@PathVariable String source, @PathVariable String destination){
		Routes route=new Routes();
		route.setSource(source);
		route.setDestination(destination);
		route.setUseCount(0L);
		rrepo.save(route);
	}
	
	@GetMapping("/deleteroute/{source}/{destination}")
	public void deleteRoute(@PathVariable String source, @PathVariable String destination) {
		Routes route=rrepo.findRoute(source, destination);
		rrepo.deleteById(route.getId());
	}
}
