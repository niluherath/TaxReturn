package com.nilu.gui.rmiclient;

import java.rmi.Naming;

import com.nilu.gui.dto.TaxReportDTO;
import com.nilu.rmiservice.TaxReportInterface;

public class TaxRMIClient {
	
	
	// this will communicate with RMIService
	public TaxReportDTO getTaxRport(TaxReportDTO dto) {
		
		TaxReportDTO resultDTO = null;
		try {
			
			TaxReportInterface  interfaceObj = (TaxReportInterface) Naming.lookup("TaxReportObject");
			resultDTO = interfaceObj.getTaxReport(dto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return resultDTO;
	}

}

