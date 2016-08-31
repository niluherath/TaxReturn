package com.nilu.database;

public class StaffTaxRecord {

	private String id;
	private String year;
	private String annualIncome;
	private String taxRate;
	private String paidAmount;
	private String taxRecordID;
	
	public String getTaxRecordID() {
		return taxRecordID;
	}
	public void setTaxRecordID(String taxRecordID) {
		this.taxRecordID = taxRecordID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
}
