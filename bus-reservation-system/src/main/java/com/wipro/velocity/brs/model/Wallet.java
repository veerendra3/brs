package com.wipro.velocity.brs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long walletNo;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	private String pin;
	private String cardType;
	private String cardno;
	private String validity;
	
	public Long getWalletNo() {
		return walletNo;
	}
	public void setWalletNo(Long walletNo) {
		this.walletNo = walletNo;
	}
	public Customer getCustomerId() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	
	
	
	
	

}
