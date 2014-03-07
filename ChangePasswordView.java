/*******************************************************
	 *  Class name: ChangePasswordView
 	 *  Inheritance: JFrame
	 *  Attributes: 
	 *  Methods:	ChangePasswordView, getOldPass, getNewPass,
	 *				getConfirmNewPass, clear, setChangeListener,
	 *				setCancelListener, setShowListener, askConfirmation,
	 *				showPassword, showError, showSuccess
	 *  Functionality: View
	 *  Visibility: public
	 *******************************************************/


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class ChangePasswordView extends JFrame{
	
	private JButton changeBtn;
	private JButton cancelBtn;
	
	private JLabel titleLbl;
	private JLabel confirmLbl;
	private JLabel newPassLbl;
	private JLabel oldPassLbl;
	
	private JCheckBox showPassBox;
	
	private JPasswordField confirmPwdFld;
	private JPasswordField newPassPwdFld;
	private JPasswordField oldPassPwdFld;
	
	char defaultEchoChar;
	
	public ChangePasswordView(){
		changeBtn = new JButton("Apply Changes");
		cancelBtn = new JButton("Cancel");
		
		titleLbl = new JLabel("Change Password");
		confirmLbl = new JLabel("Confirm Password");
		newPassLbl = new JLabel("New Password");
		oldPassLbl = new JLabel("Old Password");
		
		confirmPwdFld = new JPasswordField();
		newPassPwdFld = new JPasswordField();
		oldPassPwdFld = new JPasswordField();
		
		showPassBox = new JCheckBox("Show Password");
		
		modifyUI();
	}
	
	private void modifyUI(){
		setSize(1064, 720);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		
		titleLbl.setFont(new Font("Helvetica", Font.PLAIN, 32));
		
		changeBtn.setPreferredSize(new Dimension(160,30));
		cancelBtn.setPreferredSize(new Dimension(160,30));
		
		oldPassPwdFld.setPreferredSize(new Dimension(300,30));
		newPassPwdFld.setPreferredSize(new Dimension(300,30));
		confirmPwdFld.setPreferredSize(new Dimension(300,30));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,30,0);
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(titleLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,5,0);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(oldPassPwdFld,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(newPassPwdFld,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(confirmPwdFld,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(oldPassLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(newPassLbl,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(confirmLbl,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(showPassBox,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(30,0,0,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(changeBtn,gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(cancelBtn,gbc);

		defaultEchoChar = confirmPwdFld.getEchoChar();
	}
	
	public String getOldPass(){ 
		return new String(oldPassPwdFld.getPassword()); 
	}
	
	public String getNewPass(){ 
		return new String(newPassPwdFld.getPassword()); 
	}
	
	public String getConfirmNewPass(){
		return new String(confirmPwdFld.getPassword());
	}
	
	public void clear(){
		oldPassPwdFld.setText("");
		newPassPwdFld.setText("");
		confirmPwdFld.setText("");
	}
	
	public void setChangeListener(ActionListener list){
		changeBtn.addActionListener(list);
	}
	
	public void setCancelListener(ActionListener list){
		cancelBtn.addActionListener(list);
	}
	
	public void setShowListener(ItemListener list){
		showPassBox.addItemListener(list);
	}
	
	public boolean askConfirmation(){ 
		int confirmation = JOptionPane.showConfirmDialog(null, "Please confirm!", "Please confirm!",
		
		JOptionPane.YES_NO_OPTION);
		if(confirmation ==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	
	public void showPassword(boolean b){
		if(b){
			oldPassPwdFld.setEchoChar(defaultEchoChar);
			newPassPwdFld.setEchoChar(defaultEchoChar);
			confirmPwdFld.setEchoChar(defaultEchoChar);
		}else{
			oldPassPwdFld.setEchoChar((char) 0);
			newPassPwdFld.setEchoChar((char) 0);
			confirmPwdFld.setEchoChar((char) 0);
		}
	}
	
	public void showError(int i){
		String error = "";
		
		if(i == 0){
			error = "Change password failed!";
		}else if(i == 1){
			error = "New and confirm password not the same.";
		}else if(i == 2){
			error = "Wrong old password.";
		}
		JOptionPane.showMessageDialog(null, error, error, JOptionPane.ERROR_MESSAGE);
	}

	public void showSuccess(){
		JOptionPane.showMessageDialog(null, "Change password is successful.", "Change password is successful.", JOptionPane.PLAIN_MESSAGE);
	}

}
