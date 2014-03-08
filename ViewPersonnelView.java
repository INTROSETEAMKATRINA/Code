/*******************************************************
	 *  Class name: ViewPersonnelView
 	 *  Inheritance: JFrame
	 *  Attributes: model
	 *  Methods:	ViewPersonnelView, getClient, setPickerListener
	 *  Functionality: View
	 *  Visibility: public
	 *******************************************************/

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
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;


public class ViewPersonnelView extends JFrame {

	private PayrollSystemModel model;
	
	private JLabel titleLbl;
	
	private JButton viewBtn;
	private JButton backBtn;
	
	private JLabel selectSummLbl;
	private JLabel selectClientLbl;
	private JLabel statusLbl;
	private JComboBox viewCBox;
	private JComboBox clientCBox;
	private JTextPane personnelPanel;
	private JScrollPane personnelPane;
	
	public ViewPersonnelView(PayrollSystemModel model){
		this.model = model;
		
		titleLbl = new JLabel("View Personnel");
		statusLbl = new JLabel("Status: ...");
		
		viewBtn = new JButton("View Personnel");
		backBtn = new JButton("Back");
		
		selectSummLbl = new JLabel("Select Personnel: ");
		selectClientLbl = new JLabel("Select Client: ");

		clientCBox = new JComboBox();
		viewCBox = new JComboBox();
		
		personnelPanel = new JTextPane();
		personnelPane = new JScrollPane(personnelPanel);
		
		modifyUI();
	}
	
	private void modifyUI(){
		setSize(1064, 720);
		setLocationRelativeTo(null);	
		setLayout(new GridBagLayout());	
		
		titleLbl.setFont(new Font("Helvetica", Font.PLAIN, 32));
		
		personnelPane.setPreferredSize(new Dimension(500,280));
		
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
		add(personnelPane,gbc);
		
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

	public String getClient(){ 
		return null; 
	}
	
	public void setPickerListener(){}
}
