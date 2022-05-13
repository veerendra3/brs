package com.wipro.velocity.brs.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String email;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="mobile_no")
	private String mobile;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private Booking bookings;
	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
	private Address address;
	
	
	
	
	
}
