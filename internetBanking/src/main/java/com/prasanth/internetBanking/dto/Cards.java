package com.prasanth.internetBanking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Cards {

	@Id
	@Column
	private int id;
	
	@Column
	private String creditcard;
	
	@Column
	private String debitcard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getDebitcard() {
		return debitcard;
	}

	public void setDebitcard(String debitcard) {
		this.debitcard = debitcard;
	}
}
