package com.wipro.velocity.brs.model;

public class CustomerAddress {
	
	private Long id;
	private String email;
	private String fname;
	private String lname;
	private String mobile;
	private String password;
	private String street;
	private String pincode;
	private String city;
	private String state;
	private String gender;
	
	
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CustomerAddress(Long id, String email, String fname, String lname, String mobile, String password,
			 String gender,String street, String pincode, String city, String state) {
		this.id = id;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.password = password;
		this.street = street;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.gender = gender;
	}
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
		this.password = password;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
