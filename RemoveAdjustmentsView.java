import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionListener;

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

	private JComboBox<String> personnelCBox;
	private JComboBox<String> clientCBox;
	private JComboBox<String> adjCBox;
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
		
		personnelCBox = new JComboBox<String>();
		clientCBox = new JComboBox<String>();
		adjCBox = new JComboBox<String>();
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
		adjCBox.setPreferredSize(new Dimension(500,30));
		personnelCBox.setBorder(new LineBorder(Color.GRAY));
		clientCBox.setBorder(new LineBorder(Color.GRAY));
		adjCBox.setBorder(new LineBorder(Color.GRAY));
		
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
		add(adjCBox,gbc);
		
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
	
	public void setRemoveListener(ActionListener list){removeBtn.addActionListener(list);}
	public void setCancelListener(ActionListener list){cancelBtn.addActionListener(list);}
	public void setClientListener(ActionListener list){clientCBox.addActionListener(list);}
	public void setPersonnelListener(ActionListener list){personnelCBox.addActionListener(list);}
	public void showSuccess(){
		JOptionPane.showMessageDialog(null, "Successfully removed adjustment!", "Successfully removed adjustment!", JOptionPane.PLAIN_MESSAGE); 
	}

	public void showNoAdjustments(){
		JOptionPane.showMessageDialog(null, "No adjustments to be removed!", "No adjustments to be removed!", JOptionPane.ERROR_MESSAGE); 
	}	
	public void updatePersonnelList(){
		personnelCBox.removeAllItems();
		ArrayList<String> personnel = model.getPersonnelList((String)clientCBox.getSelectedItem());
		for(String t : personnel)
			personnelCBox.addItem(t);
	}
	
	public void updateClientList(){
		clientCBox.removeAllItems();
		ArrayList<String> clients = model.getClientList();
		for(String t : clients)
			clientCBox.addItem(t);
	}
	
	public void updateAdjustmentsList(){
		adjCBox.removeAllItems();
		ArrayList<String> adjustments = model.getAdjustmentsList(getTIN());
		for(String t : adjustments)
			adjCBox.addItem(t);
	}
	
	public String getClient(){ return (String)clientCBox.getSelectedItem(); }
	
	public String getTIN(){ return model.getTIN((String)personnelCBox.getSelectedItem()); }
	
	public String getTypeAdjustment(){
		String s = (String)adjCBox.getSelectedItem();
		int i;
		for(i = 0;i<s.length();i++)
			if(s.charAt(i)=='~')
				break;
		return s.substring(0,i-1);
	}
	public float getAdjustment(){
		String s = (String)adjCBox.getSelectedItem();
		int i;
		for(i = 0;i<s.length();i++)
			if(s.charAt(i)=='~')
				break;
		return Float.parseFloat(s.substring(i+2,s.length()));
	}
	
	public int getNumAdjustments(){
		return adjCBox.getItemCount();
	}

}
