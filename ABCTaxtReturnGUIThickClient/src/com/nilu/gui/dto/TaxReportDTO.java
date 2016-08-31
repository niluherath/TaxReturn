package com.nilu.gui.dto;

import java.io.Serializable;

public class TaxReportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	// request data
	private String clientID;
	
	// response data
	private String clientName;
	private String clientAddress;
	private String clientTeleNo;
	
	private TaxRecord[] taxRecords;
	
	
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientTeleNo() {
		return clientTeleNo;
	}
	public void setClientTeleNo(String clientTeleNo) {
		this.clientTeleNo = clientTeleNo;
	}
	
	public TaxRecord[] getTaxRecords() {
		return taxRecords;
	}
	public void setTaxRecords(TaxRecord[] taxRecords) {
		this.taxRecords = taxRecords;
	}

	
}
