package com.wipro.velocity.brs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Routes {
	 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String route;
	private Long useCount;
	private Long fare;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public Long getUseCount() {
		return useCount;
	}
	public void setUseCount(Long useCount) {
		this.useCount = useCount;
	}
	public Long getFare() {
		return fare;
		}
	public void setFare(Long fare) {
		this.fare = fare;
	}
	
	
	
	
	
	
}
