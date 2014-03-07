/*******************************************************
	 *  Class name: AddAdjustmentsView
 	 *  Inheritance:
	 *  Attributes: model
	 *  Methods:	AddAdjustmentsView, askConfirmation, setAddListener, setCancelListener,
	 * 				setClientListener, getTypeAdjustment, getAdjustment,
	 *				getClient, getTIN, showSuccess, showWrongInput, clear,
	 *				updatePersonnelList, updateClientList
	 *  Functionality: View
	 *  Visibility: public
	 *******************************************************/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.util.ArrayList;

public class AddAdjustmentsView extends JFrame{
	
	private PayrollSystemModel model;
	
	private JLabel selectClientLbl;
	private JLabel selectPersLbl;
	private JLabel titleLbl;
	private JLabel amountLbl;
	private JLabel reasonLbl;
	private JLabel statusLbl;

	private JTextField amountTextFld;
	private JTextField reasonTextFld;

	private JButton cancelBtn;
	private JButton applyBtn;
	private JButton addBtn;

	private JComboBox<String> personnelCBox;
	private JComboBox<String> clientCBox;
	
	public AddAdjustmentsView(PayrollSystemModel model){
		this.model = model;
		
		cancelBtn = new JButton("Back");
		applyBtn = new JButton("Apply");
		addBtn = new JButton("Add");
		
		titleLbl = new JLabel("Add Adjustments");
		
		selectClientLbl = new JLabel("Select Client: ");
		selectPersLbl = new JLabel("Select Personnel: ");
		amountLbl = new JLabel("Amount: ");
		reasonLbl = new JLabel("Reason: ");
		statusLbl = new JLabel("Status: Successfully Added!");
		
		amountTextFld = new JTextField();
		reasonTextFld = new JTextField();
		
		personnelCBox = new JComboBox<String>();
		clientCBox = new JComboBox<String>();
		
		modifyUI();
	}
	
	private void modifyUI(){
		setSize(1064, 720);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		
		titleLbl.setFont(new Font("Helvetica", Font.PLAIN, 32));
		
		addBtn.setPreferredSize(new Dimension(160,30));
		cancelBtn.setPreferredSize(new Dimension(160,30));
		applyBtn.setPreferredSize(new Dimension(160,30));
		
		personnelCBox.setPreferredSize(new Dimension(500,30));
		clientCBox.setPreferredSize(new Dimension(500,30));
		personnelCBox.setBorder(new LineBorder(Color.GRAY));
		clientCBox.setBorder(new LineBorder(Color.GRAY));
		
		amountTextFld.setPreferredSize(new Dimension(300,30));
		reasonTextFld.setPreferredSize(new Dimension(300,30));
		
		/* Adds a 30px margin.
		 * PS: So that I will not estimate anymore in case 
		 * 	   I change the size of the text field. (Please do not delete)
		 * 											 - Ken
			Dimension s = personnelCBox.getPreferredSize();
			Dimension t = addBtn.getPreferredSize();
			setPreferredSize(new Dimension((int) (s.getWidth() + t.getWidth() + 70),
													(int) (s.getHeight() + 370)));
		*/
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0,0,30,0);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(titleLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(selectClientLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(clientCBox,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(selectPersLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(personnelCBox,gbc);

		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(30,0,5,0);
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(amountLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(30,0,5,0);
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(amountTextFld,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(reasonLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(reasonTextFld,gbc);

		/*gbc.insets = new Insets(30,0,0,0);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 4;
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(statusLbl,gbc);*/
		
		gbc.insets = new Insets(30,10,0,0);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 6;
		add(addBtn,gbc);
		
		/*gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 2;
		gbc.gridy = 6;
		add(applyBtn,gbc);*/
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 3;
		gbc.gridy = 6;
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
	
	public void setAddListener(ActionListener list){
		addBtn.addActionListener(list);
	}
	
	public void setCancelListener(ActionListener list){
		cancelBtn.addActionListener(list);
	}
	
	public void setClientListener(ActionListener list){
		clientCBox.addActionListener(list);
	}
	
	public String getTypeAdjustment(){ 
		return reasonTextFld.getText(); 
	}
	
	public float getAdjustment(){
		try{
			return Float.parseFloat(amountTextFld.getText());
		}catch(Exception e){
			return 0;
		}
	}
	
	public String getClient(){
		return (String)clientCBox.getSelectedItem(); 
	}
	
	public String getTIN(){
		String s = (String)personnelCBox.getSelectedItem();
		int i;
		
		for(i = 0;i<s.length();i++){
			if(s.charAt(i)=='~')
				break;
		}
		return s.substring(i+2,s.length());
	}
	
	public void showSuccess(){
		JOptionPane.showMessageDialog(null, "Successfully added adjustment!", "Successfully added adjustment!", JOptionPane.PLAIN_MESSAGE); 
	}
	
	public void showWrongInput(){
		JOptionPane.showMessageDialog(null, "Wrong input!", "Wrong input!", JOptionPane.ERROR_MESSAGE); 
	}
	
	public void clear(){
		amountTextFld.setText("");
		reasonTextFld.setText("");
	}
	
	public void updatePersonnelList(){
		personnelCBox.removeAllItems();
		ArrayList<String> personnel = model.getPersonnelList((String)clientCBox.getSelectedItem());
		
		for(String t : personnel){
			personnelCBox.addItem(t);
		}
	}
	
	public void updateClientList(){
		clientCBox.removeAllItems();
		ArrayList<String> clients = model.getClientList();
		for(String t : clients){
			clientCBox.addItem(t);
		}
	}
	
}
