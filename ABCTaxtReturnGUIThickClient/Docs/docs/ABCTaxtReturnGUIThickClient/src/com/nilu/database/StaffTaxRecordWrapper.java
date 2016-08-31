package com.nilu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nilu.gui.dto.TaxReportDTO;
import com.nilu.rmiservice.TaxReportObject;

public class StaffTaxRecordWrapper {
	
	private Connection myConn = null;
	private Statement st = null;
	private ResultSet myRs = null;
	private String JDBC_DRIVER_MYSQL = null;
	

	public StaffTaxRecordWrapper() throws Exception {
		JDBC_DRIVER_MYSQL = "com.mysql.jdbc.Driver"; 
		Class.forName(JDBC_DRIVER_MYSQL);
		
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "student" , "password");
		st = myConn.createStatement();
	}
	
	public StaffTaxRecord[] getTaxRecordInfo(String personId) throws Exception {
		
		String query = "select * from taxrecord where id=" + personId;//sql query
				
		System.out.println(query);
						
		myRs = st.executeQuery(query);
		ArrayList<StaffTaxRecord> taxrecordsList = new ArrayList<StaffTaxRecord>();
		
		while(myRs.next()) {
			StaffTaxRecord tr = new StaffTaxRecord();
			
			tr.setId(Integer.toString(myRs.getInt("id")));
			
			tr.setYear(myRs.getString("year"));
			tr.setAnnualIncome(myRs.getString("annualincome"));
			tr.setTaxRate(myRs.getString("taxrate"));
			tr.setPaidAmount(myRs.getString("paidamount"));
			
			taxrecordsList.add(tr);
		}
			
		StaffTaxRecord[] trs = new StaffTaxRecord[taxrecordsList.size()];
		for (int i=0; i<taxrecordsList.size(); i++) {
			trs[i] = taxrecordsList.get(i);
		}
		
		myConn.close();
		return trs;
		
	}
	
	public static void main(String[] args) throws Exception {
		StaffTaxRecordWrapper wrapper = new StaffTaxRecordWrapper();
		String id = "1";
		StaffTaxRecord[] trs = wrapper.getTaxRecordInfo(id);
		
		for (int i=0; i<trs.length; i++) {
			System.out.println(trs[i].getId()+" "+trs[i].getPaidAmount()+" "+trs[i].getTaxRate()+" "+trs[i].getTaxRecordID()+" "+trs[i].getYear());
		}
	}
		
}
