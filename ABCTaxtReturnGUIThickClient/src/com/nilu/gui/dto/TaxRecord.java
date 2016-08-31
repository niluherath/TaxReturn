package com.nilu.gui.dto;

import java.io.Serializable;

public class TaxRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String year;
	private String annualIncome;
	private String taxRate;
	private String taxAMount;
	private String paidAmount;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public String getTaxAMount() {
		return taxAMount;
	}
	public void setTaxAMount(String taxAMount) {
		this.taxAMount = taxAMount;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	
}
