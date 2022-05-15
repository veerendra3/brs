package com.wipro.velocity.brs.model;

import java.util.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookid")
	private Long bookId;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	private String start;
	private String end;
	private Date bookedDate;
	private Date journeyDate;
	private Time journeyTime;
	private Long busNo;
	private Long price;
	private String status;
	
	
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	public Long getBookId() {
		return bookId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Date getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Time getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(Time journeyTime) {
		this.journeyTime = journeyTime;
	}
	public Long getBusNo() {
		return busNo;
	}
	public void setBusNo(Long busNo) {
		this.busNo = busNo;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
}
