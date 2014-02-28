import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class RemoveAdjustmentsView extends JFrame {

	private PayrollSystemModel model;
	
	private JLabel selectClientLbl;
	private JLabel selectPersLbl;
	private JLabel selectAdjLbl;
	private JLabel statusLbl;
	
	private JTable adjTable;
	private JScrollPane scrollPane;
	
	private JLabel titleLbl;

	private JButton cancelBtn;
	private JButton removeBtn;
	private JButton applyBtn;

	private JComboBox personnelCBox;
	private JComboBox clientCBox;
	
	public RemoveAdjustmentsView(PayrollSystemModel model)
	{
		this.model = model;
		
		/*Testing*/
		DefaultTableModel tableModel = new DefaultTableModel() {
		    public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return false;
	        }
		};
		
		Object[][] sample = {{"Sample Adjustment 1", "360.00"},
						     {"Sample Adjustment 2", "360.00"},
						     {"Sample Adjustment 3", "360.00"},
						     {"Sample Adjustment 4", "360.00"},
						     {"Sample Adjustment 5", "360.00"},
						     {"Sample Adjustment 6", "360.00"}};
		
		tableModel.addColumn("Reason");
		tableModel.addColumn("Amount");
		
		for(Object[] x: sample)
			tableModel.addRow(x);
		
		//////////
		
		cancelBtn = new JButton("Cancel");
		applyBtn = new JButton("Apply");
		removeBtn = new JButton("Remove Selected");
		
		titleLbl = new JLabel("Remove Adjustments");
		statusLbl = new JLabel("Status: Successfully Removed!");
		
		adjTable = new JTable(tableModel);
		scrollPane = new JScrollPane(adjTable);
		
		selectClientLbl = new JLabel("Select Client: ");
		selectPersLbl = new JLabel("Select Personnel: ");
		selectAdjLbl = new JLabel("Select Adjustment: ");
		
		personnelCBox = new JComboBox();
		clientCBox = new JComboBox();
		
		modifyUI();
	}
	
	private void modifyUI(){
		setSize(1064, 720);
		setLocationRelativeTo(null);		
		setLayout(new GridBagLayout());	
		
		titleLbl.setFont(new Font("Helvetica", Font.PLAIN, 32));
		
		adjTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
		adjTable.setFillsViewportHeight(true);
		scrollPane.setPreferredSize(new Dimension(500,100));
		
		removeBtn.setPreferredSize(new Dimension(140,30));
		applyBtn.setPreferredSize(new Dimension(140,30));
		cancelBtn.setPreferredSize(new Dimension(140,30));
		
		personnelCBox.setPreferredSize(new Dimension(500,30));
		clientCBox.setPreferredSize(new Dimension(500,30));
		personnelCBox.setBorder(new LineBorder(Color.GRAY));
		clientCBox.setBorder(new LineBorder(Color.GRAY));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0,0,30,0);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(titleLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(selectClientLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(selectPersLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(selectAdjLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 3;
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(clientCBox,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 3;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(personnelCBox,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,40,5,0);
		gbc.gridwidth = 3;
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(scrollPane,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridwidth = 4;
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(removeBtn,gbc);
		
		gbc.insets = new Insets(30,0,0,0);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(statusLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30,70,0,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(applyBtn,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(30,0,0,0);
		gbc.gridwidth = 1;
		gbc.gridx = 3;
		gbc.gridy = 5;
		add(cancelBtn,gbc);
	}
	
	public boolean askConfirmation(){
		int confirmation = JOptionPane.showConfirmDialog(null, "Please confirm!", "Please confirm!",
		JOptionPane.YES_NO_OPTION);
		if(confirmation ==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	public String getPersonnel(){ return null; }
	public void setRemoveListener(){}
	public void setCancelListener(){}
	public float getAdjustment(){
		return 0f;
	}
	public void showSuccess(){}
	public void updatePersonnelList(){}
	public void updateAdjustmentsList(){}
	public String getTIN(){ return new String();}
	public String getTypeAdjustment(){return "";}
	
}
