import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;

import java.sql.Connection;

public class PayrollSystemView extends JFrame {

	private Connection con;
	
	private JLabel appTitle;
	
	private JPanel mainPanel;
	private JPanel titlePane;
	private JPanel menuPane;
	private JPanel addAdjPanel;
	private JPanel changePassPanel;
	private JPanel genPayslipsPanel;
	private JPanel modifyClientPanel;
	private JPanel modifyTaxPanel;
	private JPanel removeAdjPanel;
	private JPanel removePersPanel;
	private JPanel viewPersPanel;
	private JPanel viewSummPanel;
	
	private JButton backupBtn;
	private JButton addPersonnelBtn;
	private JButton addDTRBtn;
	private JButton generateSummaryReportBtn;
	private JButton addAdjustmentBtn;
	private JButton changePasswordBtn;
	private JButton generatePayslipsBtn;
	private JButton modifyClientBtn;
	private JButton modifyTaxTableBtn;
	private JButton removeAdjustmentBtn;
	private JButton removePersonnelBtn;
	private JButton viewPersonnelBtn;
	private JButton viewSummaryReportBtn;
	
	public PayrollSystemView(PayrollSystemModel model, Connection con){
		this.con = con;
		/*Initialize - Panes*/
		mainPanel = new JPanel();
		titlePane = new JPanel();
		menuPane = new JPanel();
		
		//addAdjPanel = new AddAdjustmentsView(); 
		//changePassPanel = new ChangePasswordView(); 
		//genPayslipsPanel = new GeneratePayslipsView(); 
		//modifyClientPanel = new ModifyClientVariablesView(model);
		//modifyTaxPanel = new ModifyTaxTableView(); 
		//removeAdjPanel = new RemoveAdjustmentsView(model); 
		//removePersPanel = new RemovePersonnelView(model); 
		//viewPersPanel = new ViewPersonnelView(model); 
		//viewSummPanel = new ViewSummaryReportView(model); 
		
		
		/*Initialize - Buttons*/
		backupBtn = new JButton("Back Up Data");
		addPersonnelBtn = new JButton("Add Personnel");
		addDTRBtn = new JButton("Add DTR");
		generateSummaryReportBtn = new JButton("Generate Summary Report");
		addAdjustmentBtn = new JButton("Add Adjustments");
		changePasswordBtn = new JButton("Change Password");
		generatePayslipsBtn = new JButton("Generate Payslips");
		modifyClientBtn = new JButton("Modify Client Variables");
		modifyTaxTableBtn = new JButton("Modify Tax Table");
		removeAdjustmentBtn = new JButton("Remove Adjustments");
		removePersonnelBtn = new JButton("Remove Personnel");
		viewPersonnelBtn = new JButton("View Personnel");
		viewSummaryReportBtn = new JButton("View Summary Report");
		
		/*Initialize - Panes*/
		appTitle = new JLabel("A Payroll System");
		
		modifyUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1064, 720);
		setLocationRelativeTo(null);
		setTitle("A Payroll System");
		setContentPane(mainPanel);
		setResizable(true);
		setMinimumSize(new Dimension(1064, 720));
	}
	
	private void modifyUI(){ //Analyst Part
	
		/** 
		 * Main Panel is divided into three panels : 
		 * Title Pane - title of the application (Border Layout)
		 * Menu Pane - navigation buttons for payroll functions (Grid Bag)
		 * Settings Pane - settings menu of the application (Grid Bag)
		 * */
		
		mainPanel.setLayout(new GridBagLayout());
		menuPane.setLayout(new GridBagLayout());
		titlePane.setLayout(new BorderLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		/*Title Pane*/
		appTitle.setFont(new Font("Helvetica", Font.PLAIN, 63));
		titlePane.add(appTitle);
		
		/*Menu Pane*/
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,5,0);
		gbc.ipady = 10;
		gbc.gridx = 0;
		gbc.gridy = 0;
		menuPane.add(addAdjustmentBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		menuPane.add(addDTRBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 0;
		menuPane.add(addPersonnelBtn,gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		menuPane.add(changePasswordBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		menuPane.add(backupBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		menuPane.add(generatePayslipsBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 2;
		menuPane.add(generateSummaryReportBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		menuPane.add(modifyClientBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 3;
		menuPane.add(modifyTaxTableBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 5;
		menuPane.add(removeAdjustmentBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 5;
		menuPane.add(removePersonnelBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 6;
		menuPane.add(viewPersonnelBtn,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 6;
		menuPane.add(viewSummaryReportBtn,gbc);
		
		/*Main Panel*/
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,30,0);
		gbc.ipady = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(titlePane,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridx = 0;
		gbc.gridy = 1;
		mainPanel.add(menuPane,gbc);
		
	}
	
	
	public void setAddPersonnelListener(ActionListener list){
		addPersonnelBtn.addActionListener(list);
	}
	public void setRemovePListener(ActionListener list){}
	public void setViewPListener(ActionListener list){}
	public void setAddDTRListener(ActionListener list){
		addDTRBtn.addActionListener(list);
	}
	public void setAddAdjustmentListener(ActionListener list){
		addAdjustmentBtn.addActionListener(list);
	}
	public void setRemoveAdjustmentListener(ActionListener list){
		removeAdjustmentBtn.addActionListener(list);
	}
	public void setViewSummaryReportListener(ActionListener list){
		viewSummaryReportBtn.addActionListener(list);
	}
	public void setGenerateSummaryReportListener(ActionListener list){}
	public void setModifyTaxTableListener(ActionListener list){}
	public void setModifyClientVarListener(ActionListener list){}
	public void setGeneratePayslipsListener(ActionListener list){
		generatePayslipsBtn.addActionListener(list);
	}
	public void setChangePasswordListener(ActionListener list){
		changePasswordBtn.addActionListener(list);
	}
	public void setBackupDataListener(ActionListener list){}
	
	public File fileChooser(){
		JFileChooser fc = null;
		fc = new JFileChooser();
		//In response to a button click:
		int returnVal = fc.showOpenDialog(this);
			return fc.getSelectedFile();
	}
	
	public void showSuccess(){
		JOptionPane.showMessageDialog(null, "Excel successfully added!", "Excel successfully added!", JOptionPane.PLAIN_MESSAGE); 
	}
}
