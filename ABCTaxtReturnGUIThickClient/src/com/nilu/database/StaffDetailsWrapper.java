package com.nilu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nilu.gui.dto.TaxReportDTO;
import com.nilu.rmiservice.TaxReportObject;

public class StaffDetailsWrapper {
	
	private Connection myConn = null;
	private Statement st = null;
	private ResultSet myRs = null;
	private String JDBC_DRIVER_MYSQL = null;
	

	public StaffDetailsWrapper() throws Exception {
		JDBC_DRIVER_MYSQL = "com.mysql.jdbc.Driver"; 
		Class.forName(JDBC_DRIVER_MYSQL);
		
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "student" , "password");
		st = myConn.createStatement();
	}
	
	public StaffDetails getPersonInfo(String personId) throws Exception {
		
		StaffDetails sDetails = new StaffDetails();
		sDetails.setId(personId);
		
		String query = "select * from staffdetails where id=" + sDetails.getId();
				
		System.out.println(query);
						
		myRs = st.executeQuery(query);
			
		while(myRs.next()) {
			sDetails.setName(myRs.getString("name"));
			System.out.println(sDetails.getName());
			sDetails.setAddress(myRs.getString("address"));
			System.out.println(sDetails.getAddress());				
			sDetails.setTelephoneNumber(myRs.getString("telephoneNumber"));
			System.out.println(sDetails.getTelephoneNumber());
				
		}
		myConn.close();
		
		return sDetails;
	}
	
	public static void main(String[] args) throws Exception {
		StaffDetailsWrapper wrapper = new StaffDetailsWrapper();
		String id = "1";
		StaffDetails staffDetails = wrapper.getPersonInfo(id);
	}
		
}
