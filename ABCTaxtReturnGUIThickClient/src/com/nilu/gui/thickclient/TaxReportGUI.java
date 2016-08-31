package com.nilu.gui.thickclient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.nilu.gui.dto.TaxRecord;
import com.nilu.gui.dto.TaxReportDTO;
import com.nilu.gui.rmiclient.TaxRMIClient;
import com.nilu.rmiservice.TaxReportServer;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;

public class TaxReportGUI {

	private JFrame frame;
	private JTextField staffID;
	private JTextField staffName;
	private JTextField staffAddress;
	private JTextField staffTelepohone;
	private JTextField txtYear;
	private JTextField txtAnnualIncome;
	private JTextField txtTaxRate;
	private JTextField txtTaxAmount;
	private JTextField txtPaidAmount;
	private JTable table;
	private TaxRecord[] taxRecords;

	private String[] columnNames;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxReportGUI window = new TaxReportGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TaxReportGUI() {
		initialize();
		this.taxRecords = new TaxRecord[100];

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 434, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAbcComapny = new JLabel("ABC Comapny");
		lblAbcComapny.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAbcComapny.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbcComapny.setBounds(94, 11, 203, 14);
		frame.getContentPane().add(lblAbcComapny);
		
		JLabel lblAnnualTaxtReport = new JLabel("Annual Taxt Report");
		lblAnnualTaxtReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnualTaxtReport.setBounds(104, 36, 203, 14);
		frame.getContentPane().add(lblAnnualTaxtReport);
		
		JLabel lblNewLabel = new JLabel("Client ID:");
		lblNewLabel.setBounds(31, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		staffID = new JTextField();
		staffID.setBounds(131, 61, 86, 20);
		frame.getContentPane().add(staffID);
		staffID.setColumns(10);
		
		
		JLabel lblStaffName = new JLabel("Client Name:");
		lblStaffName.setBounds(31, 89, 60, 14);
		frame.getContentPane().add(lblStaffName);
		
		staffName = new JTextField();
		staffName.setEditable(false);
		staffName.setBounds(131, 86, 86, 20);
		frame.getContentPane().add(staffName);
		staffName.setColumns(10);
		
		JLabel lblStaffAdress = new JLabel("Client Address:");
		lblStaffAdress.setBounds(31, 114, 102, 14);
		frame.getContentPane().add(lblStaffAdress);
		
		staffAddress = new JTextField();
		staffAddress.setEditable(false);
		staffAddress.setBounds(131, 111, 203, 20);
		frame.getContentPane().add(staffAddress);
		staffAddress.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(61, 202, 46, -13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblStaffTelephone = new JLabel("Client Telephone:");
		lblStaffTelephone.setBounds(31, 136, 86, 14);
		frame.getContentPane().add(lblStaffTelephone);
		
		staffTelepohone = new JTextField();
		staffTelepohone.setEditable(false);
		staffTelepohone.setBounds(131, 139, 129, 20);
		frame.getContentPane().add(staffTelepohone);
		staffTelepohone.setColumns(10);
		
		JButton btnSubmit = new JButton("Get Tax Report");
		btnSubmit.setBounds(284, 60, 120, 23);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			TaxRecord[] gUItaxRecords;

			public void actionPerformed(ActionEvent arg0) {
				
				TaxReportDTO dto = new TaxReportDTO();
				dto.setClientID(staffID.getText());
				
				TaxRMIClient client = new TaxRMIClient();
				
				TaxReportDTO reportDTO = client.getTaxRport(dto);
				
				// set repost data back to GUI
				staffName.setText(reportDTO.getClientName());
				staffAddress.setText(reportDTO.getClientAddress());
				staffTelepohone.setText(reportDTO.getClientTeleNo());
				gUItaxRecords = reportDTO.getTaxRecords();

				String[] columnNames = {"Year", "Annual Income", "Tax Rate", "Tax Amnount", "Tax AMount Paid"};
				Object[][] data = new Object[gUItaxRecords.length][5];
				
				for (int i=0; i<gUItaxRecords.length; i++) {
					data[i][0] = gUItaxRecords[i].getYear();
					data[i][1] = gUItaxRecords[i].getAnnualIncome();
					data[i][2] = gUItaxRecords[i].getTaxRate();
					data[i][3] = gUItaxRecords[i].getTaxAMount();
					data[i][4] = gUItaxRecords[i].getPaidAmount();
				}

				table = new JTable(data, columnNames);
				table.setBounds(15, 233, 393, 125);
				table.setFillsViewportHeight(true);
				frame.getContentPane().add(table);
				
				table.updateUI();
				table.repaint();
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Tax Report");
		lblNewLabel_2.setBounds(61, 176, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtYear = new JTextField();
		txtYear.setEditable(false);
		txtYear.setText("Year");
		txtYear.setBounds(15, 213, 76, 20);
		frame.getContentPane().add(txtYear);
		txtYear.setColumns(10);
		
		txtAnnualIncome = new JTextField();
		txtAnnualIncome.setEditable(false);
		txtAnnualIncome.setText("Annual Income");
		txtAnnualIncome.setBounds(94, 213, 76, 20);
		frame.getContentPane().add(txtAnnualIncome);
		txtAnnualIncome.setColumns(10);
		
		txtTaxRate = new JTextField();
		txtTaxRate.setEditable(false);
		txtTaxRate.setText("Tax Rate");
		txtTaxRate.setBounds(174, 213, 76, 20);
		frame.getContentPane().add(txtTaxRate);
		txtTaxRate.setColumns(10);
		
		txtTaxAmount = new JTextField();
		txtTaxAmount.setEditable(false);
		txtTaxAmount.setText("Tax amount");
		txtTaxAmount.setBounds(248, 213, 86, 20);
		frame.getContentPane().add(txtTaxAmount);
		txtTaxAmount.setColumns(10);
		
		txtPaidAmount = new JTextField();
		txtPaidAmount.setEditable(false);
		txtPaidAmount.setText("Paid Amount");
		txtPaidAmount.setBounds(332, 213, 76, 20);
		frame.getContentPane().add(txtPaidAmount);
		txtPaidAmount.setColumns(10);
		
		
	}
}
