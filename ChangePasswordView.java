import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class ChangePasswordView extends JFrame {
	
	private JButton changeBtn;
	private JButton cancelBtn;
	
	private JLabel titleLbl;
	private JLabel confirmLbl;
	private JLabel newPassLbl;
	private JLabel oldPassLbl;
	
	private JCheckBox showPassBox;
	
	private JTextField confirmTxtFld;
	private JTextField newPassTxtFld;
	private JTextField oldPassTxtFld;
	
	public ChangePasswordView()
	{
		changeBtn = new JButton("Apply Changes");
		cancelBtn = new JButton("Cancel");
		
		titleLbl = new JLabel("Change Password");
		confirmLbl = new JLabel("Confirm Password");
		newPassLbl = new JLabel("New Password");
		oldPassLbl = new JLabel("Old Password");
		
		confirmTxtFld = new JTextField();
		newPassTxtFld = new JTextField();
		oldPassTxtFld = new JTextField();
		
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
		
		oldPassTxtFld.setPreferredSize(new Dimension(300,30));
		newPassTxtFld.setPreferredSize(new Dimension(300,30));
		confirmTxtFld.setPreferredSize(new Dimension(300,30));
		
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
		add(oldPassTxtFld,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(newPassTxtFld,gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(confirmTxtFld,gbc);
		
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
		
	}
	
	public String getOldPass(){ return oldPassTxtFld.getText(); }
	public String getNewPass(){ return newPassTxtFld.getText(); }
	public String getConfirmNewPass(){ return confirmTxtFld.getText(); }
	public void clear(){
		oldPassTxtFld.setText("");
		newPassTxtFld.setText("");
		confirmTxtFld.setText("");
	}
	public void setChangeListener(ActionListener list){changeBtn.addActionListener(list);}
	public void setCancelListener(ActionListener list){cancelBtn.addActionListener(list);}
	public boolean askConfirmation(){ 
		int confirmation = JOptionPane.showConfirmDialog(null, "Please confirm!", "Please confirm!",
		JOptionPane.YES_NO_OPTION);
		if(confirmation ==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	public void showFailed(){JOptionPane.showMessageDialog(null, "Change password failed!", "Change password failed!", JOptionPane.ERROR_MESSAGE);}
	public void showSuccess(){JOptionPane.showMessageDialog(null, "Change password is successful.", "Change password is successful.", JOptionPane.PLAIN_MESSAGE); }
	public void showPasswordNotTheSame(){JOptionPane.showMessageDialog(null, "Password not the same.", "Password not the same.", JOptionPane.ERROR_MESSAGE); }
	public void showWrongOldPassword(){JOptionPane.showMessageDialog(null, "Wrong Password.", "Wrong Password.", JOptionPane.ERROR_MESSAGE); }
}
