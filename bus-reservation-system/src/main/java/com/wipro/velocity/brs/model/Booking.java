package com.wipro.velocity.brs.model;

import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;

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
	
	private String source;
	private String destination;
	public Date bookedDate;
	private Date journeyDate;
	private Long seat;
	private Long busNo;
	private Long price;
	private String status;
	
	
	public Long getSeat() {
		return seat;
	}
	public void setSeat(Long seat) {
		this.seat = seat;
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
	public Date getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate() {
		Date date= new Date();
		this.bookedDate = date;
	}
	
	
	
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
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
