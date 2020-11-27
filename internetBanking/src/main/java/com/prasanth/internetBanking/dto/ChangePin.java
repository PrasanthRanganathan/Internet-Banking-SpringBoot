package com.prasanth.internetBanking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class ChangePin {

	@Id
	@Column
	private int id;
	
	@Column(name="creditcardpin")
	private String creditCardPin;
	
	@Column(name="debitcardpin")
	private String debitCardPin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreditCardPin() {
		return creditCardPin;
	}

	public void setCreditCardPin(String creditCardPin) {
		this.creditCardPin = creditCardPin;
	}

	public String getDebitCardPin() {
		return debitCardPin;
	}

	public void setDebitCardPin(String debitCardPin) {
		this.debitCardPin = debitCardPin;
	}
}
