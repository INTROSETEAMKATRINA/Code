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

	private SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Connection con;
	
	public PayrollSystemModel(Connection con){
		this.con = con;
		
	}
	
	public boolean addPersonnel(File fileDirectory) {
		try{
			File file = fileDirectory;
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			ArrayList<Personnel> personnels = new ArrayList<Personnel>();;
			String name,position,assignment,employeeStatus,tin,taxStatus;
			float sss, sssLoan, phic, hdmf, hdmfLoan, payrollAdvance, houseRental, uniformAndOthers;
			float dailyRate, colaRate, monthlyRate;

			//getCell(column,row)
			int row,column;

			row = 0;
			column = 1;
			assignment = sheet.getCell(column,row).getContents();

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
					tin 		= sheet.getCell(column,row).getContents();
					column++;
					taxStatus 	= sheet.getCell(column,row).getContents();

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
        System.out.println(personnels.size());

        //ADD TO DATABASE
		Statement stmt = null;
		String sql;
        /*for( Personnel personnel: personnels ){
            try{
                sql="INSERT INTO `Payroll System`.`Personnel`\n" +
                "(`Name`,\n" +
                "`Assignment`,\n" +
                "`Position`,\n" +
                "`EducationalAttainment`,\n" +
                "`EmployeeStatus`,\n" +
                "`DailyRate`,\n" +
                "`ColaRate`,\n" +
                "`MonthlyRate`,\n" +
                "`SSS`,\n" +
                "`TIN`,\n" +
                "`PHIC`,\n" +
                "`HDMF`,\n" +
                "`TaxStatus`)\n" +
                "VALUES ('"+ personnel.getName() +"',"
                        + " '"+personnel.getAssignment()+"',"
                        + " '"+personnel.getPosition()+"',"
                        + " '"+personnel.getEducationalAttainment()+"',"
                        + " '"+personnel.getEmployeeStatus()+"',"
                        + " '"+personnel.getDailyRate()+"',"
                        + " '"+personnel.getColaRate()+"',"
                        + " '"+personnel.getMonthlyRate()+"',"
                        + " '"+personnel.getSSS()+"',"
                        + " '"+personnel.getTIN()+"',"
                        + " '"+personnel.getPHIC()+"',"
                        + " '"+personnel.getHDMF()+"',"
                        + " '"+personnel.getTaxStatus()+"');";
                stmt=con.prepareStatement(sql);
                stmt.execute(sql);
            } catch ( SQLException ex ){
            }
        }*/
		return true;
	}
	
	public void addDTR(File fileDirectory) {
		try{
			File file = fileDirectory;
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			ArrayList<DTR> dtrs = new ArrayList<DTR>();;
			String name,tin;
			float regularHoursWorks, regularOvertime, regularNightShiftDifferential,
				  specialHoliday, specialHolidayOvertime, specialHolidayNightShiftDifferential,
				  legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential;
			Date  periodStartDate;
			SimpleDateFormat[] possibleFormats = new SimpleDateFormat[] {
			        new SimpleDateFormat("yyyy-MM-dd"),
			        new SimpleDateFormat("yyyy/MM/dd"),
			        new SimpleDateFormat("MM/dd/yyyy"),
			        new SimpleDateFormat("MM-dd-yyyy") };
			int row,column;

			row = 0;
			column = 1;
			periodStartDate = null;
			for(SimpleDateFormat format : possibleFormats){

				try{
					format.setLenient(false);
					periodStartDate = format.parse(sheet.getCell(column,row).getContents());
				}catch(Exception e){
					System.out.println(e);
					//e.printStackTrace();
				}
			}

			row += 2;
			column = 0;
			while(row < sheet.getRows()){

				name = sheet.getCell(column,row).getContents();

				if(name.length() > 0){

					column++;
					tin = sheet.getCell(column,row).getContents();

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
        /*for(Personnel personnel: personnels){
            if(personnel.getDTR()!=null){
                
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
                    "('"+ personnel.getDTR().getRegularHoursWorks() +"',\n" +
                    "'"+ personnel.getDTR().getRegularOvertime() +"',\n" +
                    "'"+ personnel.getDTR().getRegularNightShiftDifferential() +"',\n" +
                    "'"+ personnel.getDTR().getSpecialHoliday() +"',\n" +
                    "'"+ personnel.getDTR().getSpecialHolidayOvertime() +"',\n" +
                    "'"+ personnel.getDTR().getSpecialHolidayNightShiftDifferential() +"',\n" +
                    "'"+ personnel.getDTR().getLegalHoliday() +"',\n" +
                    "'"+ personnel.getDTR().getLegalHolidayOvertime() +"',\n" +
                    "'"+ personnel.getDTR().getLegalHolidayNightShiftDifferential() +"',\n" +
                    "'"+ sdf.format(personnel.getDTR().getPeriodStartDate()) +"',\n" +
                    "'"+ personnel.getTIN() +"');";
                    stmt=con.prepareStatement(sql);
                    stmt.execute(sql);

                } catch(SQLException ex) {     
                }
            }
        }*/
	}
	
	public void removePersonnel(String client){
	}
	
	public void getPersonnel(String client){ //returns ResultSet
		
	}

	public void addAdjustment(String reason, float adjustment, String tin, Date periodStartDate){
	    Statement stmt = null;
        String sql="INSERT INTO `Payroll System`.`AdjustmentsAndDeductions`\n" +
            "(`amount`,\n" +
            "`type`,\n" +
            "`PeriodStartDate`,\n" +
            "`TIN`)\n" +
            "VALUES\n" +
            "('"+ adjustment +"',\n" +
            "'"+ reason +"',\n" +
            "'"+ periodStartDate +"',\n" +
            "'"+ tin +"');";
        
        stmt=con.prepareStatement(sql);
        stmt.execute(sql);
	}
	
	public void removeAdjustment(String reason, float adjustment, String tin, Date periodStartDate){
		Statement stmt = null;
        String sql="DELETE FROM `Payroll System`.`AdjustmentsAndDeductions`\n" +
            "WHERE `TIN` = \""+ tin+"\" AND `PeriodStartDate` =\""+ periodStartDate+"\" AND `amount` = \""+adjustment+"\" AND `TYPE` = \""+reason+"\";";
        stmt=con.prepareStatement(sql);
        stmt.execute(sql);
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
}
