import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.Date;
import java.util.ArrayList;

import java.text.SimpleDateFormat;

import java.io.IOException;
import java.io.File;

import jxl.*;
import jxl.read.biff.BiffException;

public class PayrollSystemModel {

	private SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	private Connection con;
	private Date periodStartDate;

	public PayrollSystemModel(Connection con){
		this.con = con;
	}

	public void setPeriodStartDate(Date psd){
		periodStartDate = psd;
	}

	public boolean addPersonnel(File fileDirectory, Date periodStartDate) {
    	ArrayList<Personnel> personnels = new ArrayList<Personnel>();;
        try{
			File file = fileDirectory;
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			String name,position,assignment,employeeStatus,tin,taxStatus;
			float sss, sssLoan, phic, hdmf, hdmfLoan, payrollAdvance, houseRental, uniformAndOthers;
			float dailyRate, colaRate, monthlyRate;
			Date psd;
			int row,column;

			row = 0;
			column = 1;

			assignment = sheet.getCell(column,row).getContents();

			psd = null;
			row++;
			try{
				sdf.setLenient(false);
				psd = sdf.parse(sheet.getCell(column,row).getContents());
			}catch(Exception e){
				System.out.println(e);
			}

			if(psd != periodStartDate){
				return false;
			}

			row += 2;
			column = 0;

			while(row < sheet.getRows()){

				name = sheet.getCell(column,row).getContents();

				if(name.length() > 0){

					column++;
					position = sheet.getCell(column,row).getContents();
					column++;
					employeeStatus = sheet.getCell(column,row).getContents();

					dailyRate = 0;
					column++;
					try{
						dailyRate 	= Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					colaRate = 0;
					column++;
					try{
						colaRate 	= Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					monthlyRate = 0;
					column++;
					try{
						monthlyRate = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					column++;
					tin = sheet.getCell(column,row).getContents();
					if(tin.length() == 0){
						return false;
					}
					column++;
					taxStatus = sheet.getCell(column,row).getContents();

					sss = 0;
					column++;
					try{
						sss = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					sssLoan = 0;
					column++;
					try{
						sssLoan = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					phic = 0;
					column++;
					try{
						phic = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					hdmf = 0;
					column++;
					try{
						hdmf = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					hdmfLoan = 0;
					column++;
					try{
						hdmfLoan = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					payrollAdvance = 0;
					column++;
					try{
						payrollAdvance = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					houseRental = 0;
					column++;
					try{
						houseRental = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					uniformAndOthers = 0;
					column++;
					try{
						uniformAndOthers = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					personnels.add(new Personnel(name, position, assignment,employeeStatus, tin, taxStatus,
												 sss, sssLoan, phic, hdmf,hdmfLoan, payrollAdvance, houseRental,
												 uniformAndOthers, dailyRate, colaRate, monthlyRate));
				}
				row++;
			}
		}catch(Exception e){
			System.out.println(e);
			//e.printStackTrace();
		}

        //ADD TO DATABASE
        Statement stmt = null;
        String sql;

        try{
            sql="INSERT INTO `Payroll System`.`Client`\n" +
            "(`Name`)\n" +
            "VALUES\n" +
            "(\""+personnels.get(0).getAssignment() +"\");";
            stmt=con.prepareStatement(sql);
            stmt.execute(sql);

        } catch (SQLException ex) {
        }

        for( Personnel personnel: personnels ){
            try{
                sql="INSERT INTO `Payroll System`.`Personnel`\n" +
                "(`Name`,\n" +
                "`Assignment`,\n" +
                "`Position`,\n" +
                "`EmployeeStatus`,\n" +
                "`DailyRate`,\n" +
                "`ColaRate`,\n" +
                "`MonthlyRate`,\n" +
                "`TIN`,\n" +
                "`TaxStatus`)\n" +
                "VALUES ('"+ personnel.getName() +"',"
                        + " '"+personnel.getAssignment()+"',"
                        + " '"+personnel.getPosition()+"',"
                        + " '"+personnel.getEmployeeStatus()+"',"
                        + " '"+personnel.getDailyRate()+"',"
                        + " '"+personnel.getColaRate()+"',"
                        + " '"+personnel.getMonthlyRate()+"',"
                        + " '"+personnel.getTIN()+"',"
                        + " '"+personnel.getTaxStatus()+"');";
                stmt=con.prepareStatement(sql);
                stmt.execute(sql);

                this.addAdjustment("SSS", personnel.getSSS(), personnel.getTIN(), periodStartDate);
                this.addAdjustment("SSS Loan", personnel.getSSS(), personnel.getTIN(), periodStartDate);
                this.addAdjustment("PHIC", personnel.getPHIC(), personnel.getTIN(), periodStartDate);
                this.addAdjustment("HDMF", personnel.getHDMF(), personnel.getTIN(), periodStartDate);
                this.addAdjustment("HDMF Loan", personnel.getHDMFLoan(), personnel.getTIN(), periodStartDate);
                this.addAdjustment("Payroll Advance", personnel.getPayrollAdvance(), personnel.getTIN(), periodStartDate);
                this.addAdjustment("House Rental", personnel.getHouseRental(), personnel.getTIN(), periodStartDate);
                this.addAdjustment("Uniform and Others", personnel.getUniformAndOthers(), personnel.getTIN(), periodStartDate);

            } catch (SQLException ex){
            }
        }
		return true;
	}

	public boolean addDTR(File fileDirectory, Date periodStartDate) {
    	ArrayList<DTR> dtrs = new ArrayList<DTR>();

        try{
			File file = fileDirectory;
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			String name,tin;
			float regularHoursWorks, regularOvertime, regularNightShiftDifferential,
				  specialHoliday, specialHolidayOvertime, specialHolidayNightShiftDifferential,
				  legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential;
			Date psd;
			int row,column;

			row = 0;
			column = 1;
			psd= null;
			try{
				sdf.setLenient(false);
				psd = sdf.parse(sheet.getCell(column,row).getContents());
			}catch(Exception e){
				System.out.println(e);
				//e.printStackTrace();
			}

			if(psd != periodStartDate){
				return false;
			}

			row += 2;
			column = 0;
			while(row < sheet.getRows()){

				name = sheet.getCell(column,row).getContents();

				if(name.length() > 0){

					column++;
					tin = sheet.getCell(column,row).getContents();
					if(tin.length() == 0){
						return false;
					}

					regularHoursWorks = 0;
					column++;
					try{
						regularHoursWorks = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

					regularOvertime = 0;
					column++;
					try{
						regularOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

					regularNightShiftDifferential = 0;
					column++;
					try{
						regularNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	specialHoliday = 0;
				  	column++;
				  	try{
						specialHoliday = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	specialHolidayOvertime = 0;
				  	column++;
				  	try{
						specialHolidayOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	specialHolidayNightShiftDifferential = 0;
				  	column++;
				  	try{
						specialHolidayNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	legalHoliday = 0;
				  	column++;
				  	try{
						legalHoliday = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	legalHolidayOvertime = 0;
				  	column++;
				  	try{
						legalHolidayOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	legalHolidayNightShiftDifferential = 0;
				  	column++;
				  	try{
						legalHolidayNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				    dtrs.add(new DTR(name, tin, regularHoursWorks, regularOvertime, regularNightShiftDifferential,
			   								 specialHoliday, specialHolidayOvertime,specialHolidayNightShiftDifferential,
			   								 legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential,
			   								 periodStartDate));
				}
				row++;
			}

		}catch(Exception e){
		}
        //ADD TO DATABASE
		Statement stmt = null;
		String sql;
            for(DTR dtr: dtrs){

                try{
                    sql= "INSERT INTO `Payroll System`.`DTR`\n" +
                    "(`RHW`,\n" +
                    "`ROT`,\n" +
                    "`RNSD`,\n" +
                    "`SH`,\n" +
                    "`SHOT`,\n" +
                    "`SHNSD`,\n" +
                    "`LH`,\n" +
                    "`LHOT`,\n" +
                    "`LHNSD`,\n" +
                    "`PeriodStartDate`,\n" +
                    "`Personnel`)\n" +
                    "VALUES\n" +
                    "('"+ dtr.getRegularHoursWorks() +"',\n" +
                    "'"+ dtr.getRegularOvertime() +"',\n" +
                    "'"+ dtr.getRegularNightShiftDifferential() +"',\n" +
                    "'"+ dtr.getSpecialHoliday() +"',\n" +
                    "'"+ dtr.getSpecialHolidayOvertime() +"',\n" +
                    "'"+ dtr.getSpecialHolidayNightShiftDifferential() +"',\n" +
                    "'"+ dtr.getLegalHoliday() +"',\n" +
                    "'"+ dtr.getLegalHolidayOvertime() +"',\n" +
                    "'"+ dtr.getLegalHolidayNightShiftDifferential() +"',\n" +
                    "'"+ sdf.format(dtr.getPeriodStartDate()) +"',\n" +
                    "'"+ dtr.getTIN() +"');";
                    stmt=con.prepareStatement(sql);
                    stmt.execute(sql);

                } catch(SQLException ex) {
                }
            }
    	return true;
	}

	public void removePersonnel(String client){
	}

	public void getPersonnel(String client){ //returns ResultSet

	}

	public void addAdjustment(String reason, float adjustment, String tin, Date periodStartDate) {
            Statement stmt = null;
	    try {

            String sql="INSERT INTO `Payroll System`.`AdjustmentsAndDeductions`\n" +
            "(`amount`,\n" +
            "`type`,\n" +
            "`PeriodStartDate`,\n" +
            "`TIN`)\n" +
            "VALUES\n" +
            "('"+ adjustment +"',\n" +
            "'"+ reason +"',\n" +
            "'"+ sdf.format(periodStartDate) +"',\n" +
            "'"+ tin +"');";

            stmt=con.prepareStatement(sql);
            stmt.execute(sql);
            } catch (SQLException ex) {
				System.out.println(ex);
            }
	}

	public void removeAdjustment(String reason, float adjustment, String tin, Date periodStartDate) {
            Statement stmt = null;
            try{
				String sql="DELETE FROM `Payroll System`.`AdjustmentsAndDeductions`\n" +
				"WHERE `TIN` = \""+ tin+"\" AND `PeriodStartDate` =\""+ sdf.format(periodStartDate)+"\" AND `amount` = \""+adjustment+"\" AND `TYPE` = \""+reason+"\";";
				stmt=con.prepareStatement(sql);
				stmt.execute(sql);
            } catch (SQLException ex) {
				System.out.println(ex);
            }
	}

	public int changePassword(String oldPass, String newPass){
		int x = 0;
		try{
			Statement st = con.createStatement();
			x = st.executeUpdate("update password set password = '"+newPass+"' where password = '"+oldPass+"'");
		}catch(Exception e){
			System.out.println(e);
		}
		return x;
	}

	public void modifyTaxTable(String fileDirectory){
	}

	public void modfyClientVariables(float specialHoliday, float legalHoliday){
	}

	public void generatePayslips(File directory, String client){
	}

	public void generateSummaryReport(File directory, String client){
	}

	public void backupDate(){
	}

	public ArrayList<String> getSummaryReport(String client, String report, Date periodStartDate){
		return new ArrayList<String>();
	}

	public ArrayList<String> getClientList(){
		Statement stmt = null;
		ArrayList<String> clients = new ArrayList<>();
            try{
				String sql="Select * FROM `client` order by name";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					clients.add(rs.getString("Name"));
				}
            } catch (Exception ex) {
				System.out.println(ex);
            }
		return clients;
	}

	public ArrayList<String> getPersonnelList(String client){
		Statement stmt = null;
		ArrayList<String> personnel = new ArrayList<>();
            try{
				String sql="Select * FROM `personnel` where assignment = '"+client+"' order by name";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					personnel.add(rs.getString("Name"));
				}
            } catch (Exception ex) {
				System.out.println(ex);
            }
		return personnel;
	}

	public ArrayList<String> getAdjustmentsList(String tin){
		Statement stmt = null;
		ArrayList<String> adjustments = new ArrayList<>();
            try{
				String sql="Select * FROM `adjustmentsanddeductions` where `tin` = '"+tin+"' and `periodstartdate` = '"+sdf.format(periodStartDate)+"'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					adjustments.add(rs.getString("type")+" ~ "+rs.getString("amount"));
				}
            } catch (Exception ex) {
				System.out.println(ex);
            }
		return adjustments;
	}


	public String getTIN(String personnelName){
		try{
			String sql="Select `TIN` FROM `personnel` where name = '"+personnelName+"'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			return rs.getString("TIN");
		}catch(Exception ex){
			System.out.println(ex);
		}
		return "";
	}

}
