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
	
	private String source;
	private String destination;
	private Long useCount;
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public String getRoute() {
//		return route;
//	}
//	public void setRoute(String route) {
//		this.route = route;
//	}
	public Long getUseCount() {
		return useCount;
	}
	public void setUseCount(Long useCount) {
		this.useCount = useCount;
	}
	
}
