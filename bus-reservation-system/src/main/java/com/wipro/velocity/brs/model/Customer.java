package com.wipro.velocity.brs.model;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		Base64.Encoder encoder = Base64.getEncoder();  // encrypt password in database field
        String normalString = password;
        String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8) );
        this.password = encodedString;
        }

	public Booking getBookings() {
		return bookings;
	}

	public void setBookings(Booking bookings) {
		this.bookings = bookings;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
	
	
	
}
