package com.wipro.velocity.brs.model;



import java.time.LocalDate;
import java.util.Date;

public class BookingsGet {
	
	private Long bookId;
	private String source;
	private String destination;
	private Date bookedDate;
	private Date journeyDate;
	private Long busNo;
	private Long price;
	private String status;
	private Long seat;
	
	
	public BookingsGet() {
		
	}
	
	public BookingsGet(Long bookId, String source, String destination, Date bookedDate, Date journeyDate, Long busNo, Long price,
			String status, Long seat) {
		this.bookId = bookId;
		this.source = source;
		this.destination = destination;
		this.bookedDate = bookedDate;
		this.journeyDate = journeyDate;
		this.busNo = busNo;
		this.price = price;
		this.status = status;
		this.seat = seat;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getSeat() {
		return seat;
	}

	public void setSeat(Long seat) {
		this.seat = seat;
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
	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
