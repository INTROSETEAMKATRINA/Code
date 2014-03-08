/*******************************************************
	 *  Class name: GeneratePayslipsView
 	 *  Inheritance: JFrame
	 *  Attributes: model, file
	 *  Methods: 	GeneratePayslipsView, setSelectFileListener, setClientListener,
	 *				setGenerateListener, setCancelListener, fileSaver,
	 *				getClient, showSuccess, setFileDirectory,
	 *				getPeriodStartDate, getFileDirectory, showError,
	 *				updateClientList, updateDateList
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;

import java.util.ArrayList;

public class GeneratePayslipsView extends JFrame{

	private PayrollSystemModel model;
	
	private File file;
	
	private JComboBox<String> timePerCBox;
	private JComboBox<String> clientCBox;
	
	
	private JButton selSaveBtn;
	
	private JTextPane statusTxtPane;
	private JScrollPane statusPane;
	
	private JLabel extensionLbl;
	private JLabel saveTxtLbl;
	private JLabel titleLbl;
	private JLabel timeperiodLbl;
	private JLabel selectClientLbl;
	private JLabel personnelLbl;
	private JLabel saveLbl;
	private JLabel extLbl;
	
	private JButton generateBtn;
	private JButton backBtn;
	
	private JScrollPane personnelPane;
	private JTable personnelTable;
	
	public GeneratePayslipsView(PayrollSystemModel model){
		this.model = model;
		
		titleLbl = new JLabel("Generate Payslips");
		
		statusTxtPane = new JTextPane();
		statusPane = new JScrollPane(statusTxtPane);
		
		timePerCBox = new JComboBox<String>();
		clientCBox = new JComboBox<String>();
		
		extensionLbl = new JLabel(".csv");
		saveTxtLbl = new JLabel();
		selSaveBtn = new JButton("...");
		
		timeperiodLbl = new JLabel("Select Time Period: ");
		selectClientLbl = new JLabel("Select Client: ");
		saveLbl = new JLabel("Inpute Save Location: ");
		extLbl = new JLabel("Choose File Extension: ");
		personnelLbl = new JLabel("<Client>'s Personnel List");
		
		generateBtn = new JButton("Generate");
		backBtn = new JButton("Back");
		
		personnelTable = new JTable();
		personnelPane = new JScrollPane(personnelTable);
		
		modifyUI();
	}
	
	private void modifyUI(){
		setSize(1064, 720);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());	
		
		titleLbl.setFont(new Font("Helvetica", Font.PLAIN, 32));
		personnelLbl.setFont(new Font("Helvetica", Font.PLAIN, 16));
		
		saveTxtLbl.setPreferredSize(new Dimension(250,30));
		
		personnelTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
		personnelTable.setFillsViewportHeight(true);
		personnelPane.setPreferredSize(new Dimension(500,200));
		statusPane.setPreferredSize(new Dimension(500,70));
		
		backBtn.setPreferredSize(new Dimension(140,30));
		generateBtn.setPreferredSize(new Dimension(140,30));
		selSaveBtn.setPreferredSize(new Dimension(50,30));
		
		clientCBox.setPreferredSize(new Dimension(300,30));
		clientCBox.setBorder(new LineBorder(Color.GRAY));
		timePerCBox.setPreferredSize(new Dimension(300,30));
		timePerCBox.setBorder(new LineBorder(Color.GRAY));
		extensionLbl.setPreferredSize(new Dimension(80,30));
		extensionLbl.setBorder(new LineBorder(Color.GRAY));
		
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
		gbc.insets = new Insets(0,0,5,20);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(clientCBox,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 3;
		gbc.gridy = 1;
		add(timeperiodLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		gbc.gridy = 1;
		add(timePerCBox,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(saveLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(saveTxtLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(selSaveBtn,gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(30,15,0,0);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		gbc.gridy = 6;
		add(generateBtn,gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(30,0,0,0);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		gbc.gridy = 6;
		add(backBtn,gbc);
	}
	
	public void setSelectFileListener(ActionListener list){
		selSaveBtn.addActionListener(list);
	}
	
	public void setClientListener(ActionListener list){
		clientCBox.addActionListener(list);
	}
	
	public void setGenerateListener(ActionListener list){
		generateBtn.addActionListener(list);
	}
	
	public void setCancelListener(ActionListener list){
		backBtn.addActionListener(list);
	}
	
	public File fileSaver(){
		//Create a file chooser
		JFileChooser fc = new JFileChooser();
		//In response to a button click:
		int returnVal = fc.showSaveDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			if(fc.toString().contains(".csv")){
				return fc.getSelectedFile();
			}
			return new File(fc.getSelectedFile()+".csv");
		}else{
			return null;
		}
	}
	
	public String getClient(){
		return (String)clientCBox.getSelectedItem();
	}
	
	public void showSuccess(){
		JOptionPane.showMessageDialog(null, "Generate payslips success!", "Generate payslips success!", JOptionPane.PLAIN_MESSAGE); 
	}
	
	public void setFileDirectory(File f){
		file = f;
		
		if(f!=null){
			saveTxtLbl.setText(file.getPath());
		}else{
			saveTxtLbl.setText("");
		}
	}
	
	public String getPeriodStartDate(){
		return (String) timePerCBox.getSelectedItem();
	}
	
	public File getFileDirectory(){
		return file;
	}
	
	public void showError(int i){
		String error = "";
		
		if(i == 0){
			error = "No personnel DTR in client!";
		}else if(i==1){
			error = "No file chosen!";
		}else if(i==2){
			error = "File is in use!";
		}
		JOptionPane.showMessageDialog(null, error, error, JOptionPane.ERROR_MESSAGE); 
	}
	
	
	public void updateClientList(){
		clientCBox.removeAllItems();
		ArrayList<String> clients = model.getClientList();
		
		for(String t : clients){
			clientCBox.addItem(t);
		}
	}
	
	public void updateDateList(){
		timePerCBox.removeAllItems();
		ArrayList<String> dates = model.getDateListDTR(getClient());
		
		for(String t : dates){
			timePerCBox.addItem(t);
		}		
	}
	
	public boolean askConfirmation(){
		int confirmation = JOptionPane.showConfirmDialog(null, "Overwrite file?", "Overwrite file?",
		
		JOptionPane.YES_NO_OPTION);
		if(confirmation ==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
}
