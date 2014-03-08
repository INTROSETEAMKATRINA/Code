/*******************************************************
	 *  Class name: ViewSummaryReportView
 	 *  Inheritance: JFrame
	 *  Attributes: model
	 *  Methods:	ViewSummaryReportView, getClient, setPickerListener
	 *  Functionality: View
	 *  Visibility: public
	 *******************************************************/
	 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.event.*;

public class ViewSummaryReportView extends JFrame {

	private PayrollSystemModel model;
	
	private JLabel titleLbl;
	
	private JButton viewBtn;
	private JButton backBtn;
	
	private JLabel selectSummLbl;
	private JLabel selectClientLbl;
	private JLabel statusLbl;
	private JLabel selectDateLbl;
	private JComboBox<String> viewCBox;
	private JComboBox<String> clientCBox;
	private JComboBox<String> dateCBox;
	private JTable summaryTable;
	private JScrollPane summaryPane;
	private DefaultTableModel tableModel;
	
	
	public ViewSummaryReportView(PayrollSystemModel model){
		this.model = model;
		
		titleLbl = new JLabel("View Summary Reports");
		statusLbl = new JLabel("Status: ");
		
		viewBtn = new JButton("View Report");
		backBtn = new JButton("Back");
		
		selectSummLbl = new JLabel("Select Summary Report: ");
		selectClientLbl = new JLabel("Select Client: ");
		selectDateLbl = new JLabel("Select Period: ");

		clientCBox = new JComboBox<String>();
		viewCBox = new JComboBox<String>();
		dateCBox = new JComboBox<String>();
		
		/*Testing*/
		tableModel = new DefaultTableModel() {
		    public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return false;
	        }
		};
		
		summaryTable = new JTable(tableModel);
		summaryPane = new JScrollPane(summaryTable);
		summaryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    	this.add(summaryPane, BorderLayout.CENTER);
		
		
		modifyUI();
	}
	
	private void modifyUI(){
		setSize(1064, 720);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());	
		
		titleLbl.setFont(new Font("Helvetica", Font.PLAIN, 32));
		
		summaryTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
		summaryTable.setFillsViewportHeight(true);
		summaryPane.setPreferredSize(new Dimension(500,280));
		
		viewBtn.setPreferredSize(new Dimension(140,30));
		backBtn.setPreferredSize(new Dimension(140,30));
		
		viewCBox.setPreferredSize(new Dimension(500,30));
		viewCBox.setBorder(new LineBorder(Color.GRAY));
		clientCBox.setPreferredSize(new Dimension(500,30));
		clientCBox.setBorder(new LineBorder(Color.GRAY));
		dateCBox.setPreferredSize(new Dimension(500,30));
		dateCBox.setBorder(new LineBorder(Color.GRAY));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0,0,30,0);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(titleLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(selectClientLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(selectDateLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(30,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(selectSummLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(clientCBox,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(dateCBox,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(viewCBox,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,0,5,0);
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(summaryPane,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 6;
		add(statusLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(viewBtn,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 7;
		add(backBtn,gbc);
	}
	
	public void updateTableColumn(){
		ArrayList<String> column = model.getColumnName(getReport());
		tableModel.setColumnCount(column.size());
		for(int i = 0; i < column.size();i++){
			summaryTable.getColumnModel().getColumn(i).setHeaderValue(column.get(i));
		}
	}
	
	public String getClient(){ 
		return (String)clientCBox.getSelectedItem();
	}
	
	public String getPeriodStartDate(){ 
		return (String)dateCBox.getSelectedItem(); 
	}
	
	public String getReport(){ 
		return (String)viewCBox.getSelectedItem(); 
	}
	
	public void setPeriodStartDateListener(ActionListener list){
		clientCBox.addActionListener(list);
	}
	
	public void setViewListener(ActionListener list){
		viewBtn.addActionListener(list);
	}
	
	public void backListener(ActionListener list){
		backBtn.addActionListener(list);
	}
	
	public void updateTable(){
		tableModel.setRowCount(0);
		statusLbl.setText("Status: You are now viewing " + getReport().toLowerCase() + ".");
		ArrayList<Object[]> row = model.getTableRow(getClient(),getPeriodStartDate(),getReport());
		
		for(Object[] t : row){
			tableModel.addRow(t);
		}
	}
	
	public void updateClientList(){
		clientCBox.removeAllItems();
		ArrayList<String> clients = model.getClientList();
		
		for(String t : clients){
			clientCBox.addItem(t);
		}
	}
	
	public void updateDateList(){
		dateCBox.removeAllItems();
		ArrayList<String> dates = model.getDateListPayslips(getClient());
		for(String t : dates)
			dateCBox.addItem(t);		
	}
	
	public void updateViewList(){
		viewCBox.removeAllItems();
		String[] summaryReports = model.getSummaryReports();
		for(String t : summaryReports)
			viewCBox.addItem(t);
	}
	
	public void showError(int i){
		String error = "";
		if(i == 0){
			error = "Lacking Input!";
		}else if(i==1){
			error = "No payslips for client in current period!";
		}
		JOptionPane.showMessageDialog(null, error, error, JOptionPane.ERROR_MESSAGE);
	}
	
}
