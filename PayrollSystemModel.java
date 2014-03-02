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
    	ArrayList<Personnel> personnels = new ArrayList<Personnel>();
		String assignment = "";
        try{
			File file = fileDirectory;
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			String name,position,employeeStatus,tin,taxStatus;
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
				Cell cell = sheet.getCell(column,row);
				if(cell.getType() == CellType.DATE){
					DateCell date = (DateCell)cell;
					psd = sdf.parse(sdf.format(date.getDate()));
				}
				else{
					return false;
				}
			}catch(Exception e){
				System.out.println(e);
			}

			if(!sdf.format(psd).equals(sdf.format(periodStartDate))){
				return false;
			}

			row += 2;

			while(row < sheet.getRows()){

				column = 0;
				name = sheet.getCell(column,row).getContents();

				if(name.length() > 0){

					column++;
					position = sheet.getCell(column,row).getContents();
					column++;
					employeeStatus = sheet.getCell(column,row).getContents();

					column++;
					try{
						dailyRate = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						dailyRate = 0;
					}

					column++;
					try{
						colaRate = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						colaRate = 0;
					}

					column++;
					try{
						monthlyRate = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						monthlyRate = 0;
					}

					column++;
					tin = sheet.getCell(column,row).getContents();
					if(tin.length() == 0){
						return false;
					}
					column++;
					taxStatus = sheet.getCell(column,row).getContents();

					column++;
					try{
						sss = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						sss = 0;
					}

					column++;
					try{
						sssLoan = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						sssLoan = 0;
					}

					column++;
					try{
						phic = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						phic = 0;
					}
					
					column++;
					try{
						hdmf = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						hdmf = 0;
					}

					column++;
					try{
						hdmfLoan = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						hdmfLoan = 0;
					}

					column++;
					try{
						payrollAdvance = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						payrollAdvance = 0;
					}

					column++;
					try{
						houseRental = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						houseRental = 0;
					}

					column++;
					try{
						uniformAndOthers = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						uniformAndOthers = 0;
					}

					personnels.add(new Personnel(name, position, assignment,employeeStatus, tin, taxStatus,
												 sss, sssLoan, phic, hdmf,hdmfLoan, payrollAdvance, houseRental,
												 uniformAndOthers, dailyRate, colaRate, monthlyRate));
				}
				row++;
			}
		}catch(Exception e){
			System.out.println(e);
			return false;
		}

        //ADD TO DATABASE
        Statement stmt = null;
        String sql;

        try{
            sql="INSERT INTO `Payroll System`.`Client`\n" +
            "(`Name`)\n" +
            "VALUES\n" +
            "(\""+assignment+"\");";
            stmt=con.prepareStatement(sql);
            stmt.execute(sql);

        } catch (SQLException ex) {
			if(ex.getErrorCode()!=1062){
				System.out.println(ex);
			}
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
				String pTIN = personnel.getTIN();
                if(personnel.getSSS()!=0){
                    this.addAdjustment("SSS", personnel.getSSS(), pTIN, periodStartDate);
                }
                if(personnel.getSSSLoan()!=0){                
                    this.addAdjustment("SSS Loan", personnel.getSSSLoan(), pTIN, periodStartDate);
                }
                if(personnel.getPHIC()!=0){
                    this.addAdjustment("PHIC", personnel.getPHIC(), pTIN, periodStartDate);
                }
                if(personnel.getHDMF()!=0){
                    this.addAdjustment("HDMF", personnel.getHDMF(), pTIN, periodStartDate);
                }
                if(personnel.getHDMFLoan()!=0){
                    this.addAdjustment("HDMF Loan", personnel.getHDMFLoan(), pTIN, periodStartDate);
                }
                if(personnel.getPayrollAdvance()!=0){
                    this.addAdjustment("Payroll Advance", personnel.getPayrollAdvance(), pTIN, periodStartDate);
                }
                if(personnel.getHouseRental()!=0){
                    this.addAdjustment("House Rental", personnel.getHouseRental(), pTIN, periodStartDate);
                }
                if(personnel.getUniformAndOthers()!=0){
                    this.addAdjustment("Uniform and Others", personnel.getUniformAndOthers(), pTIN, periodStartDate);
                }
            } catch (SQLException ex){
		
                if(ex.getErrorCode()==1062){
                    try{
                            sql ="UPDATE `Payroll System`.`Personnel`\n" +
                            "SET\n" +
                            "`Name` = '"+ personnel.getName() +"',\n" +
                            "`Assignment` = '"+personnel.getAssignment()+"',\n" +
                            "`Position` = '"+personnel.getPosition()+"',\n" +
                            "`EmployeeStatus` = '"+personnel.getEmployeeStatus()+"',\n" +
                            "`DailyRate` = '"+personnel.getDailyRate()+"',\n" +
                            "`ColaRate` = '"+personnel.getColaRate()+"',\n" +
                            "`MonthlyRate` = '"+personnel.getMonthlyRate()+"',\n" +
                            "`TaxStatus` = '"+personnel.getTaxStatus()+"'\n" +
                            "WHERE `TIN` = \""+personnel.getTIN()+"\";";
                            stmt=con.prepareStatement(sql);
                            stmt.execute(sql);
                    } catch (SQLException ex1) {
						System.out.println(ex);
                    }
                } else {
                    System.out.println(ex);
                }                
                                
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
			float regularDaysWorks, regularOvertime, regularNightShiftDifferential,
				  specialHoliday, specialHolidayOvertime, specialHolidayNightShiftDifferential,
				  legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential,
				  specialHolidayOnRestDay, legalHolidayOnRestDay, late;
			Date psd;
			int row,column;

			row = 0;
			column = 1;
			psd= null;
			try{
				Cell cell = sheet.getCell(column,row);
				if(cell.getType() == CellType.DATE){
					DateCell date = (DateCell)cell;
					psd = sdf.parse(sdf.format(date.getDate()));
				}
				else{
					return false;
				}
			}catch(Exception e){
				System.out.println(e);
			}

			if(!sdf.format(psd).equals(sdf.format(periodStartDate))){
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

					column++;
					try{
						regularDaysWorks = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						regularDaysWorks = 0;
					}

					column++;
					try{
						regularOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						regularOvertime = 0;
					}

					column++;
					try{
						regularNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						regularNightShiftDifferential = 0;
					}

				  	column++;
				  	try{
						specialHoliday = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){	
					  	specialHoliday = 0;
					}

				  	column++;
				  	try{
						specialHolidayOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					  	specialHolidayOvertime = 0;
					}

				  	column++;
				  	try{
						specialHolidayNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					  	specialHolidayNightShiftDifferential = 0;
					}

				  	column++;
				  	try{
						legalHoliday = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					  	legalHoliday = 0;
					}

				  	column++;
				  	try{
						legalHolidayOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					  	legalHolidayOvertime = 0;
					}

				  	column++;
				  	try{
						legalHolidayNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					  	legalHolidayNightShiftDifferential = 0;
					}
					
					column++;
				  	try{
						specialHolidayOnRestDay = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					  	specialHolidayOnRestDay = 0;
					}
					
					column++;
				  	try{
						legalHolidayOnRestDay = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					  	legalHolidayOnRestDay = 0;
					}
					
					column++;
				  	try{
						late = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					  	late = 0;
					}
					
				    dtrs.add(new DTR(name, tin, regularDaysWorks, regularOvertime, regularNightShiftDifferential,
			   								 specialHoliday, specialHolidayOvertime,specialHolidayNightShiftDifferential,
			   								 legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential,
			   								 legalHolidayOnRestDay, specialHolidayOnRestDay, late, periodStartDate));
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
                    "(`RDW`,\n" +
                    "`ROT`,\n" +
                    "`RNSD`,\n" +
                    "`SH`,\n" +
                    "`SHOT`,\n" +
                    "`SHNSD`,\n" +
                    "`LH`,\n" +
                    "`LHOT`,\n" +
                    "`LHNSD`,\n" +
                    "`PeriodStartDate`,\n" +
					"`LHRD`,\n" +
					"`SHRD`,\n" +
					"`late`,\n" +
                    "`TIN`)\n" +
                    "VALUES\n" +
                    "('"+ dtr.getRegularDaysWorks() +"',\n" +
                    "'"+ dtr.getRegularOvertime() +"',\n" +
                    "'"+ dtr.getRegularNightShiftDifferential() +"',\n" +
                    "'"+ dtr.getSpecialHoliday() +"',\n" +
                    "'"+ dtr.getSpecialHolidayOvertime() +"',\n" +
                    "'"+ dtr.getSpecialHolidayNightShiftDifferential() +"',\n" +
                    "'"+ dtr.getLegalHoliday() +"',\n" +
                    "'"+ dtr.getLegalHolidayOvertime() +"',\n" +
                    "'"+ dtr.getLegalHolidayNightShiftDifferential() +"',\n" +
                    "'"+ sdf.format(dtr.getPeriodStartDate()) +"',\n" +
					"'"+ dtr.getLegalHolidayOnRestDay() +"',\n" +
					"'"+ dtr.getSpecialHolidayOnRestDay() +"',\n" +
					"'"+ dtr.getLate() +"',\n" +
                    "'"+ dtr.getTIN() +"');";
                    stmt=con.prepareStatement(sql);
                    stmt.execute(sql);

                } catch(SQLException ex) {
                    if(ex.getErrorCode()==1062){
                        try{
                            sql="UPDATE `Payroll System`.`DTR`\n" +
                                "SET\n" +
                                "`RDW` = " + dtr.getRegularDaysWorks() + ",\n" +
                                "`ROT` = "+dtr.getRegularOvertime()+",\n" +
                                "`RNSD` = "+dtr.getRegularNightShiftDifferential()+",\n" +
                                "`SH` = "+dtr.getSpecialHoliday()+",\n" +
                                "`SHOT` = "+dtr.getSpecialHolidayOvertime()+",\n" +
                                "`SHNSD` = "+dtr.getSpecialHolidayNightShiftDifferential()+",\n" +
                                "`LH` = "+dtr.getLegalHoliday()+",\n" +
                                "`LHOT` = "+dtr.getLegalHolidayOvertime()+",\n" +
                                "`LHNSD` = "+dtr.getLegalHolidayNightShiftDifferential()+",\n" +
								"`LHRD` = "+dtr.getLegalHolidayOnRestDay()+",\n" +
								"`SHRD` = "+dtr.getSpecialHolidayOnRestDay()+",\n" +
								"`late` = "+dtr.getLate()+"\n" +
                                "WHERE `PeriodStartDate` = \"" + sdf.format(dtr.getPeriodStartDate()) + "\" AND"
                                        + " `TIN` = \""+dtr.getTIN()+"\";";
                                stmt=con.prepareStatement(sql);
                                stmt.execute(sql);
                        
                        } catch(SQLException ex1){
							System.out.println(ex);
                        }
                    } else{
                        System.out.println(ex);
                    }
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
			"(`amount`, `type`, `PeriodStartDate`,\n `TIN`) VALUES\n" +
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

	public void generatePayslips(File directory, String client, String psd){
		Statement stmt = null;
		ArrayList<Payslip> payslips = new ArrayList<>();
            try{
				String sql = "Select * FROM `client`,`dtr`,`personnel` where client.name = '"+client+"' and personnel.assignment = client.name " + 
							" and dtr.tin = personnel.tin and dtr.periodstartdate = '"+psd+"'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				float rotVar = 1.25f;
				float rnsdVar = .10f;
				float lhRate = 30f;
				float lhVar = 1.00f;
				float lhOTVar = 1.30f;
				float lhNSDVar = 1.00f*.10f;
				float lhRDVar = 2.60f;
				float shRate = 30f;
				float shVar = .30f;
				float shOTVar = .30f*.30f;
				float shNSDVar = .30f*.10f;
				float shRDVar = 1.5f;
				
				while(rs.next()){
					String tin = rs.getString("TIN");
					
					sql = "Select * FROM `adjustmentsanddeductions`,`personnel` where personnel.tin = adjustmentsanddeductions.tin" +
								 " and personnel.tin = '"+tin+"' and periodstartdate = '"+psd+"'";
					st = con.createStatement();
					ResultSet rs2 = st.executeQuery(sql);
					
					
					String assignment = rs.getString("assignment");
					String name = rs.getString("personnel.name");
					Date periodStartDate = rs.getDate("PeriodStartDate");
					String position = rs.getString("Position");
					float regularDaysWork = rs.getFloat("RDW");
					float dailyRate = rs.getFloat("DailyRate");
					float late = rs.getFloat("late");
					float regularOvertime = rs.getFloat("RDW");
					float regularNightShiftDifferential = rs.getFloat("RNSD");
					float legalHoliday = rs.getFloat("LH");
					float legalHolidayOvertime = rs.getFloat("LHOT");
					float legalHolidayNightShiftDifferential = rs.getFloat("LHNSD");
					float legalHolidayOnRestDay = rs.getFloat("LHRD");
					float specialHoliday = rs.getFloat("SH");
					float specialHolidayOvertime = rs.getFloat("SHOT");
					float specialHolidayNightShiftDifferential = rs.getFloat("SHNSD");
					float specialHolidayOnRestDay = rs.getFloat("SHRD");
					float colaRate = rs.getFloat("ColaRate");
					float sss = 0;
					float phic = 0;
					float hdmf = 0;
					float sssLoan = 0;
					float hdmfLoan = 0;
					float payrollAdvance = 0;
					float houseRental = 0;
					float uniformAndOthers = 0;	
					float adjustments = 0;
					float transpoAllow = 0;
					String type;
					while(rs2.next()){
						type = rs.getString("type");
						switch(type){
							case "SSS":
								sss = rs.getFloat("amount");
								break;
							case "PHIC":
								phic = rs.getFloat("amount");
								break;
							case "SSS Loan":
								sssLoan = rs.getFloat("amount");
								break;
							case "HDMF":
								hdmf = rs.getFloat("amount");
								break;
							case "HDMF Loan":
								hdmfLoan = rs.getFloat("amount");
								break;
							case "Payroll Advance":
								payrollAdvance = rs.getFloat("amount");
								break;
							case "House Rental":
								houseRental = rs.getFloat("amount");
								break;
							case "Uniform and Others":
								uniformAndOthers = rs.getFloat("amount");
								break;
							default:
								adjustments += rs.getFloat("amount");
								break;
						}
					}
					
					float totalDeductions = sss + phic + sssLoan + hdmf + 
											hdmfLoan + payrollAdvance +
											houseRental + uniformAndOthers;
					
					float hourlyRate = dailyRate/8;
					float shHourlyRate = (dailyRate + shRate)/8;
					float lhHourlyRate = (dailyRate + lhRate)/8;
					float basicPay = regularDaysWork * dailyRate;
					float deductionFromTardiness = dailyRate/8/60 * late;
					float colaAllowance = colaRate/30 * regularDaysWork;
					
					float regularPay = basicPay + colaAllowance - deductionFromTardiness;
					float regularOvertimePay = regularOvertime * rotVar * hourlyRate;
					float regularNightShiftDifferentialPay = regularNightShiftDifferential * rnsdVar * hourlyRate;
					float legalHolidayPay = legalHoliday * lhVar * lhHourlyRate;
					float legalHolidayOvertimePay = legalHolidayOvertime * lhOTVar * lhHourlyRate;
					float legalHolidayNightShiftDifferentialPay = legalHolidayNightShiftDifferential * lhNSDVar * lhHourlyRate;
					float legalHolidayOnRestDayPay = legalHolidayOnRestDay * lhRDVar * lhHourlyRate;
					float specialHolidayPay = specialHoliday * shVar * shHourlyRate;
					float specialHolidayOvertimePay = specialHolidayOvertime * shOTVar * shHourlyRate;
					float specialHolidayNightShiftDifferentialPay = specialHolidayNightShiftDifferential * shNSDVar * shHourlyRate;
					float specialHolidayOnRestDayPay = specialHolidayOnRestDay * shHourlyRate * shRDVar;
					float wTax = 0;
					float otPay = regularOvertimePay + 
								legalHolidayOvertimePay + 
								specialHolidayOvertimePay;
					float nsdPay = regularNightShiftDifferentialPay +
									legalHolidayNightShiftDifferentialPay +
									specialHolidayNightShiftDifferentialPay;
					float grossPay = regularPay + legalHolidayPay + specialHolidayPay + 
									adjustments + legalHolidayOnRestDayPay + specialHolidayOnRestDayPay;
					float netPay = grossPay - totalDeductions;

					new Payslip(assignment,  name, periodStartDate,
					position, regularDaysWork, dailyRate,
					grossPay, late, regularPay,
					regularOvertime, regularOvertimePay,
					regularNightShiftDifferential,
					regularNightShiftDifferentialPay,
					legalHoliday, legalHolidayPay,
					legalHolidayOvertime, legalHolidayOvertimePay,
					legalHolidayNightShiftDifferential,
					legalHolidayNightShiftDifferentialPay,
					legalHolidayOnRestDay, legalHolidayOnRestDayPay,
					specialHoliday, specialHolidayPay,
					specialHolidayOvertime, specialHolidayOvertimePay,
					specialHolidayNightShiftDifferential,
					specialHolidayNightShiftDifferentialPay,
					specialHolidayOnRestDay, specialHolidayOnRestDayPay,
					transpoAllow, adjustments, wTax,
					sss, phic, hdmf, sssLoan,
					hdmfLoan, payrollAdvance, houseRental,
					uniformAndOthers, netPay);
				}
            } catch (Exception ex) {
				System.out.println(ex);
            }
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
	
	public ArrayList<String> getDateList(String client){
		Statement stmt = null;
		ArrayList<String> dates = new ArrayList<>();
            try{
				String sql = "Select distinct periodstartdate FROM `client`,`dtr`,`personnel` where client.name = '"+client+"' and personnel.assignment = client.name "
							+ " and dtr.tin = personnel.tin order by periodstartdate";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					dates.add(rs.getString("periodstartdate"));
				}
            } catch (Exception ex) {
				System.out.println(ex);
            }
		return dates;
	}
	
	public boolean checkPeriodForDTR(String client, String psd){
		Statement stmt = null;
            try{
				String sql = "Select * FROM `client`,`dtr`,`personnel` where client.name = '"+client+"' and personnel.assignment = client.name " + 
							" and dtr.tin = personnel.tin and dtr.periodstartdate = '"+psd+"'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					return true;
				}
            } catch (Exception ex) {
				System.out.println(ex);
            }
		return false;
		
	}
	
}
