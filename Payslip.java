import java.util.Date;

class Payslip{
	
	private String assignment;
	private String name;
	private Date periodStartDate;
	private String position;
	private float regularDaysWork;
	private float dailyRate;
	private float grossPay;
	private float late;
	private float regularPay;
	private float regularOvertime;
	private float regularOvertimePay;
	private float regularNightShiftDifferential;
	private float regularNightShiftDifferentialPay;
	private float legalHoliday;
	private float legalHolidayPay;
	private float legalHolidayOvertime;
	private float legalHolidayOvertimePay;
	private float legalHolidayNightShiftDifferential;
	private float legalHolidayNightShiftDifferentialPay;
	private float specialHoliday;
	private float specialHolidayPay;
	private float specialHolidayOvertime;
	private float specialHolidayOvertimePay;
	private float specialHolidayNightShiftDifferential;
	private float specialHolidayNightShiftDifferentialPay;
	private float transpoAllow;
	private float adjustments;
	private float wTax;
	private float sss;
	private float phic;
	private float hdmf;
	private float sssLoan;
	private float hdmfLoan;
	private float payrollAdvance;
	private float houseRental;
	private float uniformAndOthers;
	private float netPay;
	
	public Payslip(String assignment, String name, Date periodStartDate,
	String position, float regularDaysWork, float dailyRate,
	float grossPay, float late, float regularPay,
	float regularOvertime, float regularOvertimePay,
	float regularNightShiftDifferential,
	float regularNightShiftDifferentialPay,
	float legalHoliday, float legalHolidayPay,
	float legalHolidayOvertime, float legalHolidayOvertimePay,
	float legalHolidayNightShiftDifferential,
	float legalHolidayNightShiftDifferentialPay,
	float specialHoliday, float specialHolidayPay,
	float specialHolidayOvertime, float specialHolidayOvertimePay,
	float specialHolidayNightShiftDifferential,
	float specialHolidayNightShiftDifferentialPay,
	float transpoAllow, float adjustments, float wTax,
	float sss, float phic, float hdmf, float sssLoan,
	float hdmfLoan, float payrollAdvance, float houseRental,
	float uniformAndOthers, float netPay){
		this.assignment = assignment;
		this.name = name;
		this.periodStartDate = periodStartDate;
		this.position = position;
		this.regularDaysWork = regularDaysWork;
		this.dailyRate = dailyRate;
		this.grossPay = grossPay;
		this.late = late;
		this.regularPay = regularPay;
		this.regularOvertime = regularOvertime;
		this.regularOvertimePay = regularOvertimePay;
		this.regularNightShiftDifferential = regularNightShiftDifferential;
		this.regularNightShiftDifferentialPay = regularNightShiftDifferentialPay;
		this.legalHoliday = legalHoliday;
		this.legalHolidayPay = legalHolidayPay;
		this.legalHolidayOvertime = legalHolidayOvertime;
		this.legalHolidayOvertimePay = legalHolidayOvertimePay;
		this.legalHolidayNightShiftDifferential = legalHolidayNightShiftDifferential;
		this.legalHolidayNightShiftDifferentialPay = legalHolidayNightShiftDifferentialPay;
		this.specialHoliday = specialHoliday;
		this.specialHolidayPay = specialHolidayPay;
		this.specialHolidayOvertime = specialHolidayOvertime;
		this.specialHolidayOvertimePay = specialHolidayOvertimePay;
		this.specialHolidayNightShiftDifferential = specialHolidayNightShiftDifferential;
		this.specialHolidayNightShiftDifferentialPay = specialHolidayNightShiftDifferentialPay;
		this.transpoAllow = transpoAllow;
		this.adjustments = adjustments;
		this.wTax = wTax;
		this.sss = sss;
		this.phic = phic;
		this.hdmf = hdmf;
		this.sssLoan = sssLoan;
		this.hdmfLoan = hdmfLoan;
		this.payrollAdvance = payrollAdvance;
		this.houseRental = houseRental;
		this.uniformAndOthers = uniformAndOthers;
		this.netPay = netPay;
	}
	
	public String getAssignment(){
		return assignment;
	}
	public String getName(){
		return name;
	}
	public Date getPeriodStartDate(){
		return periodStartDate;
	}
	public String getPosition(){
		return position;
	}
	public float getRegularDaysWork(){
		return regularDaysWork;
	}
	public float getDailyRate(){
		return dailyRate;
	}
	public float getGrossPay(){
		return grossPay;
	}
	public float getLate(){
		return late;
	}
	public float getRegularPay(){
		return regularPay;
	}
	public float getRegularOvertime(){
		return regularOvertime;
	}
	public float getRegularOvertimePay(){
		return regularOvertimePay;
	}
	public float getRegularNightShiftDifferential(){
		return regularNightShiftDifferential;
	}
	public float getRegularNightShiftDifferentialPay(){
		return regularNightShiftDifferentialPay;
	}
	public float getLegalHoliday(){
		return legalHoliday;
	}
	public float getLegalHolidayPay(){
		return legalHolidayPay;
	}
	public float getLegalHolidayOvertime(){
		return legalHolidayOvertime;
	}
	public float getLegalHolidayOvertimePay(){
		return legalHolidayOvertimePay;
	}
	public float getLegalHolidayNightShiftDifferential(){
		return legalHolidayNightShiftDifferential;
	}
	public float getLegalHolidayNightShiftDifferentialPay(){
		return legalHolidayNightShiftDifferentialPay;
	}
	public float getSpecialHoliday(){
		return specialHoliday;
	}
	public float getSpecialHolidayPay(){
		return specialHolidayPay;
	}
	public float getSpecialHolidayOvertime(){
		return specialHolidayOvertime;
	}
	public float getSpecialHolidayOvertimePay(){
		return specialHolidayOvertimePay;
	}
	public float getSpecialHolidayNightShiftDifferential(){
		return specialHolidayNightShiftDifferential;
	}
	public float getSpecialHolidayNightShiftDifferentialPay(){
		return specialHolidayNightShiftDifferentialPay;
	}
	public float getTranspoAllow(){
		return transpoAllow;
	}
	public float getAdjustments(){
		return adjustments;
	}
	public float getWTax(){
		return wTax;
	}
	public float getSSS(){
		return sss;
	}
	public float getPHIC(){
		return phic;
	}
	public float getHDMF(){
		return hdmf;
	}
	public float getSSSLoan(){
		return sssLoan;
	}
	public float getHDMFLoan(){
		return hdmfLoan;
	}
	public float getPayrollAdvance(){
		return payrollAdvance;
	}
	public float getHouseRental(){
		return houseRental;
	}
	public float getuniformAndOthers(){
		return uniformAndOthers;
	}
	public float getNetPay(){
		return netPay;
	}
	
}