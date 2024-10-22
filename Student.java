package com.besant.model;

public class Student {
	
	private String ROLLNUMBER;
	private String STUDENTNAME;
	private String COURSE;
	private String ATTENDANCESTATUS;
	private String ATTENDANCEDATE;
	private int CREATOR_ID;
	private String CREATED_AT;
	public String getROLLNUMBER() {
		return ROLLNUMBER;
	}
	public void setROLLNUMBER(String rOLLNUMBER) {
		ROLLNUMBER = rOLLNUMBER;
	}
	public String getSTUDENTNAME() {
		return STUDENTNAME;
	}
	public void setSTUDENTNAME(String sTUDENTNAME) {
		STUDENTNAME = sTUDENTNAME;
	}
	public String getCOURSE() {
		return COURSE;
	}
	public void setCOURSE(String cOURSE) {
		COURSE = cOURSE;
	}
	public String getATTENDANCESTATUS() {
		return ATTENDANCESTATUS;
	}
	public void setATTENDANCESTATUS(String aTTENDANCESTATUS) {
		ATTENDANCESTATUS = aTTENDANCESTATUS;
	}
	public String getATTENDANCEDATE() {
		return ATTENDANCEDATE;
	}
	public void setATTENDANCEDATE(String aTTENDANCEDATE) {
		ATTENDANCEDATE = aTTENDANCEDATE;
	}
	public int getCREATOR_ID() {
		return CREATOR_ID;
	}
	public void setCREATOR_ID(int cREATOR_ID) {
		CREATOR_ID = cREATOR_ID;
	}
	public String getCREATED_AT() {
		return CREATED_AT;
	}
	public void setCREATED_AT(String cREATED_AT) {
		CREATED_AT = cREATED_AT;
	}
	
}
