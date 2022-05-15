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
	
	
	@Column(name="start_point")
	private String startPoint;
	
	
	@Column(name="end_point")
	private String endPoint;
	
}
