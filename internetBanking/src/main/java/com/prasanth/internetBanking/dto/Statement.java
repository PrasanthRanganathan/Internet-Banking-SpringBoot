package com.prasanth.internetBanking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="statement")
public class Statement {

	@Id
	@Column
	private int id;
	@Column(name="remitteraccount")
	private String remitteraccount;
	@Column(name="beneficiaryaccount")
	private String beneficiaryaccount;
	@Column(name="name")
	private String name;
	@Column(name="amount")
	private String amount;
	@Column(name="paymentmode")
	private String paymentmode;
	@Column(name="remarks")
	private String remarks;
	
	public String getRemitteraccount() {
		return remitteraccount;
	}
	public void setRemitteraccount(String remitteraccount) {
		this.remitteraccount = remitteraccount;
	}
	public String getBeneficiaryaccount() {
		return beneficiaryaccount;
	}
	public void setBeneficiaryaccount(String beneficiaryaccount) {
		this.beneficiaryaccount = beneficiaryaccount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return " [remitteraccount=" + remitteraccount + ", beneficiaryaccount=" + beneficiaryaccount
				+ ", name=" + name + ", amount=" + amount + ", paymentmode=" + paymentmode + ", remarks=" + remarks
				+ "]";
	}
	
}
