package com.wipro.velocity.brs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="addressid")
	private Long addressid;
	
	private String street;
	private String pincode;
	private String city;
	private String state;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	

}
