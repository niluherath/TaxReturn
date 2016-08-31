package com.nilu.rmiservice;

import java.rmi.Remote;

import com.nilu.gui.dto.TaxReportDTO;

public interface TaxReportInterface extends Remote {
	public TaxReportDTO getTaxReport(TaxReportDTO dto) throws Exception;
}
