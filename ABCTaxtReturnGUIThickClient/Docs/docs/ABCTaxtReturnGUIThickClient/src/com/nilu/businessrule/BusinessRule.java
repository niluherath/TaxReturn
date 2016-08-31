package com.nilu.businessrule;

import com.nilu.database.StaffDetailsWrapper;
import com.nilu.database.StaffTaxRecord;
import com.nilu.database.StaffTaxRecordWrapper;

import java.util.ArrayList;

import com.nilu.database.StaffDetails;
import com.nilu.gui.dto.TaxRecord;
import com.nilu.gui.dto.TaxReportDTO;

public class BusinessRule {

	public BusinessRule(){
	}
	
	public TaxReportDTO getTaxReport(TaxReportDTO dto) throws Exception {
		
		String id  = dto.getClientID();
		//will create a wrapper and give information and tax report
		StaffDetailsWrapper sqWr = new StaffDetailsWrapper();
		StaffDetails sd = sqWr.getPersonInfo(id);
		
		dto.setClientName(sd.getName());
		dto.setClientAddress(sd.getAddress());
		dto.setClientTeleNo(sd.getTelephoneNumber());
		
		StaffTaxRecordWrapper stWr = new StaffTaxRecordWrapper();
		StaffTaxRecord[] staffTaxRecordArray = stWr.getTaxRecordInfo(id);
		
		ArrayList<TaxRecord> taxRecordList = new ArrayList<TaxRecord>();
		
		for(int i = 0; i<staffTaxRecordArray.length;i++) {
			
			TaxRecord tr = new TaxRecord();
			
			tr.setAnnualIncome(staffTaxRecordArray[i].getAnnualIncome());
			tr.setPaidAmount(staffTaxRecordArray[i].getPaidAmount());
			tr.setTaxRate(staffTaxRecordArray[i].getTaxRate());
			tr.setYear(staffTaxRecordArray[i].getYear());
			
			Double annualIncome = Double.parseDouble(tr.getAnnualIncome());
			Double taxRate = Double.parseDouble(tr.getTaxRate());
			Double taxAmount = (annualIncome * taxRate) /100;
			
			tr.setTaxAMount( Double.toString(taxAmount) );
			
			taxRecordList.add(tr);
		}
		
		TaxRecord[] taxrecords = new TaxRecord[taxRecordList.size()];
		
		for (int i=0; i<taxRecordList.size(); i++) {
			taxrecords[i] = taxRecordList.get(i);
		}
		
		dto.setTaxRecords(taxrecords);
		
		return dto;
		
	}
	
	public static void main(String[] args) throws Exception {
		BusinessRule br = new BusinessRule();
		TaxReportDTO dto = new TaxReportDTO();
		dto.setClientID("1");
		TaxReportDTO newDTO = br.getTaxReport(dto);
		
		System.out.println("Number of tax records for client id 1 is: "+newDTO.getTaxRecords().length);
	}
	
}
