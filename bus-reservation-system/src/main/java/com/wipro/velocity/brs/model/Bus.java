package com.wipro.velocity.brs.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bus")
public class Bus {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bus_no")
	private Long busNo;
	
	private String source;
	private String destination;
	
	@Column(name="arrival_time")
	private String arrival;
	
	@Column(name="departure_time")
	private String departure;
	
	private Long price;

	
	public Bus() {
		// TODO Auto-generated constructor stub
	}


	public Bus(Long busNo, String source, String destination, String arrival, String departure, Long price) {
		this.busNo = busNo;
		this.source = source;
		this.destination = destination;
		this.arrival = arrival;
		this.departure = departure;
		this.price = price;
	}

	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getBusNo() {
		return busNo;
	}

	public void setBusNo(Long busNo) {
		this.busNo = busNo;
	}

	

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


	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
}
