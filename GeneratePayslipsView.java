import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JFileChooser;

import java.io.File;

public class GeneratePayslipsView extends JPanel {

	private File file;
	
	private JComboBox timePerCBox;
	private JComboBox clientCBox;
	
	private JComboBox extCBox;
	private JTextField saveTxtField;
	
	private JButton selSaveBtn;
	
	private JTextPane statusTxtPane;
	private JScrollPane statusPane;
	
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
	
	public GeneratePayslipsView()
	{
		titleLbl = new JLabel("Generate Payslips");
		
		statusTxtPane = new JTextPane();
		statusPane = new JScrollPane(statusTxtPane);
		
		timePerCBox = new JComboBox();
		clientCBox = new JComboBox();
		
		extCBox = new JComboBox();
		saveTxtField = new JTextField();
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
	
	private void modifyUI()
	{
setLayout(new GridBagLayout());	
		
		titleLbl.setFont(new Font("Helvetica", Font.PLAIN, 32));
		personnelLbl.setFont(new Font("Helvetica", Font.PLAIN, 16));
		
		saveTxtField.setPreferredSize(new Dimension(250,30));
		
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
		extCBox.setPreferredSize(new Dimension(80,30));
		extCBox.setBorder(new LineBorder(Color.GRAY));
		
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
		add(saveTxtField,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(selSaveBtn,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 3;
		gbc.gridy = 2;
		add(extLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		gbc.gridy = 2;
		add(extCBox,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(30,0,5,0);
		gbc.gridwidth = 5;
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(personnelLbl,gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 5;
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(personnelPane,gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridwidth = 5;
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(statusPane,gbc);
		
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
	
	public File fileSaver(){
		//Create a file chooser
		JFileChooser fc = new JFileChooser();
		//In response to a button click:
		int returnVal = fc.showSaveDialog(this);
		return fc.getSelectedFile();
	}
	
	public String getClient(){return new String();}
	public void showSuccess(){}
	public void setFileDirectory(File f){}
	public File getFileDirectory(){return file;}
}
