/*******************************************************
	 *  Class name: PayrollSystemView
 	 *  Inheritance: JFrame
	 *  Attributes: 
	 *  Methods:	PayrollSystemView, setAddPersonnelListener, setRemovePListener,
     *				setViewPListener, setAddDTRListener, setAddAdjustmentListener,
     *				setRemoveAdjustmentListener, setViewSummaryReportListener,
     *				setGenerateSummaryReportListener, setModifyTaxTableListener,
     *				setModifyClientVarListener, setGeneratePayslipsListener,
     *				setChangePasswordListener, setBackupDataListener, fileChooser,
     *				showSuccess, showPeriodStartDateNotFound, showErrorDTR,
     *				showErrorPersonnel
	 *  Functionality: View
	 *  Visibility: public
	 *******************************************************/

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
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import java.sql.Connection;

public class PayrollSystemView extends JFrame {

	private Connection con;
	
	private JLabel appTitle;
	private JLabel viewPeriodLbl;
	
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
	private JButton nextTimePerBtn;
	
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
		nextTimePerBtn = new JButton("Next Time Period");
		
		viewPeriodLbl = new JLabel("Date: ");
		appTitle = new JLabel("A Payroll System");
		
		modifyUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1064, 720);
		setLocationRelativeTo(null);
		setTitle("A Payroll System");
		setContentPane(mainPanel);
		setResizable(true);
		setMinimumSize(new Dimension(1064, 720));
		
		backupBtn.setEnabled(false);
		modifyClientBtn.setEnabled(false);
		modifyTaxTableBtn.setEnabled(false);
		removePersonnelBtn.setEnabled(false);
		viewPersonnelBtn.setEnabled(false);
		generateSummaryReportBtn.setEnabled(false);
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
		gbc.gridx = 2;
		gbc.gridy = 1;
		menuPane.add(nextTimePerBtn,gbc);

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
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 7;
		menuPane.add(viewPeriodLbl,gbc);
		
		/*Main Panel*/
		gbc.gridwidth = 0;
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
	public void setNextTimeListener(ActionListener list){
		nextTimePerBtn.addActionListener(list);
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
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xls");
		fc.setFileFilter(filter);
		//In response to a button click:
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			return fc.getSelectedFile();
		}else{
			return null;
		}
	}
	
	public void showSuccess(){
		JOptionPane.showMessageDialog(null, "Excel successfully added!", "Excel successfully added!", JOptionPane.PLAIN_MESSAGE); 
	}
	
	public void showPeriodStartDateNotFound(){
		String error = "Period Start Date not found. Program will now quit.";
		JOptionPane.showMessageDialog(null, error, error, JOptionPane.ERROR_MESSAGE); 
	}
	
	public void showErrorDTR(int i){
		String error = "";
		if(i == 1){
			error = "B2 is not formtted to Date!";
		}else if(i == 2){
			error = "Date not equal to system date!";
		}else if(i == 3){
			error = "Lacking tin!";
		}else if(i == 4){
			error = "Unknown error.";
		}else if(i == 5){
			error = "Lacking name!";
		}else if(i == 6){
			error = "Negative days worked or hours.";
		}else if(i == 7){
			error = "Adding dtr to a personnel not in the database.";
		}else if(i == 8){
			error = "File is not an excel file.";
		}
		JOptionPane.showMessageDialog(null, error, error, JOptionPane.ERROR_MESSAGE); 
	}
	
	public void showErrorPersonnel(int i){
		String error = "";
		if(i == 1){
			error = "B2 is not formtted to Date!";
		}else if(i == 2){
			error = "Date not equal to system date!";
		}else if(i == 3){
			error = "Lacking tin!";
		}else if(i == 4){
			error = "Unknown error.";
		}else if(i == 5){
			error = "Lacking name!";
		}else if(i == 6){
			error = "Negative deduction or rate.";
		}else if(i == 7){
			error = "No client name in excel file.";
		}else if(i == 8){
			error = "File is not an excel file.";
		}
		JOptionPane.showMessageDialog(null, error, error, JOptionPane.ERROR_MESSAGE); 
	}
	
	public void updateTimePeriod(String psd){
		viewPeriodLbl.setText("Date: " + psd);
	}
	
	public boolean askConfirmation(){
		int confirmation = JOptionPane.showConfirmDialog(null, "Please confirm!", "Please confirm!",
		
		JOptionPane.YES_NO_OPTION);
		if(confirmation ==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
}
