import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PayrollSystem{
	
	public static void main(String[] args){
	
		Connection con;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/payroll system";
			String uname = "root";
			String pass = "p@ssword";
			con = DriverManager.getConnection (url, uname, pass);
			System.out.println("Connected!");
			String inputPass = null;
			inputPass = JOptionPane.showInputDialog("Please Input Password!");
			if(inputPass!=null){ 
				Statement st = con.createStatement();	
				ResultSet rs = st.executeQuery("select password from password where password = '"+inputPass+"'");
				int rowCount = 0;  
				while ( rs.next() )  {  
					// Process the row.  
					rowCount++;  
				} 
				if(rowCount==1){
					PayrollSystemModel model = new PayrollSystemModel(con);
					PayrollSystemView view = new PayrollSystemView(model, con);
					view.setVisible(true);
					PayrollSystemController controller = new PayrollSystemController(model, view, con);
				}else{
					JOptionPane.showMessageDialog(null, "Wrong Password. Program will now exit.", "Wrong Password. Program will now exit.", JOptionPane.ERROR_MESSAGE); 
				}
					rs.close();
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Database not found! Program will now exit.", "Database not found! Program will now exit.", JOptionPane.ERROR_MESSAGE); 
			System.out.println("Error: " + e.getMessage());
		}	
	}	
}