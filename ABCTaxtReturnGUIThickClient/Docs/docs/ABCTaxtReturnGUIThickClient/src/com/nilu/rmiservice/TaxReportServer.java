package com.nilu.rmiservice;

import java.rmi.Naming;
import java.rmi.registry.Registry;

public class TaxReportServer {
	
	public static void main(String[] args) {
		
		try {
			Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
			TaxReportObject object = new TaxReportObject();
			Naming.rebind("TaxReportObject", object);
			System.out.println("Server started");
		} catch(Exception e) {
			e.printStackTrace();
		}
		 
		
	}
}

