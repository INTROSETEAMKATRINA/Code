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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class AddAdjustmentsView extends JFrame {
	
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

	private JComboBox personnelCBox;
	private JComboBox clientCBox;
	
	public AddAdjustmentsView(){
		
		cancelBtn = new JButton("Cancel");
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
		
		personnelCBox = new JComboBox();
		clientCBox = new JComboBox();
		
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

		gbc.insets = new Insets(30,0,0,0);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 4;
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(statusLbl,gbc);
		
		gbc.insets = new Insets(30,10,0,0);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 6;
		add(addBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 2;
		gbc.gridy = 6;
		add(applyBtn,gbc);
		
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
	
	public void setAddListener(){}
	
	public void setCancelListener(){}
	
	public String getTypeAdjustment(){ return null; }
	
	public float getAdjustment(){ return 0f; }
	
	public String getClient(){ return null; }
	
	public String getTIN(){ return null; }
	
	public void showSuccess(){
	}
	
	public void clear(){
	}
	
	public void updatePersonnelList(){
	}
	
}
