package com.nilu.rmiservice;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.nilu.businessrule.BusinessRule;
import com.nilu.database.StaffDetailsWrapper;
import com.nilu.gui.dto.TaxRecord;
import com.nilu.gui.dto.TaxReportDTO;

public class TaxReportObject extends UnicastRemoteObject implements TaxReportInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TaxRecord [] taxRecords;

	protected TaxReportObject() throws RemoteException {
		super();
	}

	@SuppressWarnings("null")
	@Override
	public TaxReportDTO getTaxReport(TaxReportDTO dto) throws Exception {
		
		//creates an instance of BusinessRule
		BusinessRule busRule = new BusinessRule();
		return busRule.getTaxReport(dto);
	}

	
	
}
