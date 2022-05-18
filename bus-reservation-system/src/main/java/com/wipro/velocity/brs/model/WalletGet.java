package com.wipro.velocity.brs.model;

public class WalletGet {
	
	private String cardType;
	private String cardNo;
	private String pin;
	private String validity;
	
	public WalletGet(String cardType, String cardNo, String pin, String validity) {
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.pin = pin;
		this.validity = validity;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}
	
	
	
}
