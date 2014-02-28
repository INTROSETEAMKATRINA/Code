import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

public class ViewSummaryReportView extends JFrame {

	private PayrollSystemModel model;
	
	private JLabel titleLbl;
	
	private JButton viewBtn;
	private JButton backBtn;
	
	private JLabel selectSummLbl;
	private JLabel selectClientLbl;
	private JLabel statusLbl;
	private JComboBox viewCBox;
	private JComboBox clientCBox;
	private JTable summaryTable;
	private JScrollPane summaryPane;
	
	public ViewSummaryReportView(PayrollSystemModel model)
	{
		this.model = model;
		
		titleLbl = new JLabel("View Summary Reports");
		statusLbl = new JLabel("Status: You are now viewing DTR.");
		
		viewBtn = new JButton("View Report");
		backBtn = new JButton("Back");
		
		selectSummLbl = new JLabel("Select Summary Report: ");
		selectClientLbl = new JLabel("Select Client: ");

		clientCBox = new JComboBox();
		viewCBox = new JComboBox();
		
		/*Testing*/
		DefaultTableModel tableModel = new DefaultTableModel() {
		    public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return false;
	        }
		};
		
		Object[][] sample = {{8,10,0,0,1,8},
						     {8,10,3,0,2,2},
						     {3,0,4,0,4,2},
						     {5,10,8,0,5,2},
						     {8,0,6,0,1,7},
						     {8,10,2,0,1,2}};
		
		String[] columnName = {"RHW","ROT","RNSD","SH","SH/OT","SH/NSD"};
		for(String x: columnName)
			tableModel.addColumn(x);
		
		for(Object[] x: sample)
			tableModel.addRow(x);
		
		//////////
		
		summaryTable = new JTable(tableModel);
		summaryPane = new JScrollPane(summaryTable);
		
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
		gbc.insets = new Insets(30,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
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
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(viewCBox,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,0,5,0);
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(summaryPane,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(statusLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(viewBtn,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 6;
		add(backBtn,gbc);
	}
	
	public String getClient(){ return new String();}
	public String getReport(){ return new String();}
	public void updateTable(ArrayList<String> table){}
}
