import java.util.Date;

public class DTR {
	private String name;
	private String tin;
	private float regularHoursWorks;
	private float regularOvertime;
	private float regularNightShiftDifferential;
	private float specialHoliday;
	private float specialHolidayOvertime;
	private float specialHolidayNightShiftDifferential;
	private float legalHoliday;
	private float legalHolidayOvertime;
	private float legalHolidayNightShiftDifferential;
	private Date  periodStartDate;

	public DTR(String name, String tin, float regularHoursWorks, float regularOvertime, float regularNightShiftDifferential,
			   float specialHoliday, float specialHolidayOvertime, float specialHolidayNightShiftDifferential,
			   float legalHoliday, float legalHolidayOvertime, float legalHolidayNightShiftDifferential,
			   Date periodStartDate){
		this.regularHoursWorks = regularHoursWorks;
		this.regularOvertime = regularOvertime;
		this.regularNightShiftDifferential = regularNightShiftDifferential;
		this.specialHoliday = specialHoliday;
		this.specialHolidayOvertime = specialHolidayOvertime;
		this.specialHolidayNightShiftDifferential = specialHolidayNightShiftDifferential;
		this.legalHoliday = legalHoliday;
		this.legalHolidayOvertime = legalHolidayOvertime;
		this.legalHolidayNightShiftDifferential = legalHolidayNightShiftDifferential;
		this.periodStartDate = periodStartDate;
	}
	public float getRegularHoursWorks(){
		return regularHoursWorks;
	}
	public void setRegularHoursWorks(float regularHoursWorks){
		this.regularHoursWorks = regularHoursWorks;
	}
	public float getRegularOvertime(){
		return regularOvertime;
	}
	public void setRegularOvertime(float regularOvertime){
		this.regularOvertime = regularOvertime;
	}
	public float getRegularNightShiftDifferential(){
		return regularNightShiftDifferential;
	}
	public void setRegularNightShiftDifferential(float regularNightShiftDifferential){
		this.regularNightShiftDifferential = regularNightShiftDifferential;
	}
	public float getSpecialHoliday(){
		return specialHoliday;
	}
	public void setSpecialHoliday(float specialHoliday){
		this.specialHoliday = specialHoliday;
	}
	public float getSpecialHolidayOvertime(){
		return specialHolidayOvertime;
	}
	public void setSpecialHolidayOvertime(float specialHolidayOvertime){
		this.specialHolidayOvertime = specialHolidayOvertime;
	}
	public float getSpecialHolidayNightShiftDifferential(){
		return specialHolidayNightShiftDifferential;
	}
	public void setSpecialHolidayNightShiftDifferential(float specialHolidayNightShiftDifferential){
		this.specialHolidayNightShiftDifferential = specialHolidayNightShiftDifferential;
	}
	public float getLegalHoliday(){
		return legalHoliday;
	}
	public void setLegalHoliday(float legalHoliday){
		this.legalHoliday = legalHoliday;
	}
	public float getLegalHolidayOvertime(){
		return legalHolidayOvertime;
	}
	public void setLegalHolidayOvertime(float legalHolidayOvertime){
		this.legalHolidayOvertime = legalHolidayOvertime;
	}
	public float getLegalHolidayNightShiftDifferential(){
		return legalHolidayNightShiftDifferential;
	}
	public void setLegalHolidayNightShiftDifferential(float legalHolidayNightShiftDifferential){
		this.legalHolidayNightShiftDifferential = legalHolidayNightShiftDifferential;
	}
	public Date getPeriodStartDate(){
		return periodStartDate;
	}
	public void setPeriodStartDate(Date periodStartDate){
		this.periodStartDate = periodStartDate;
	}
        public String getTIN(){
                return tin;
        }
        
}
