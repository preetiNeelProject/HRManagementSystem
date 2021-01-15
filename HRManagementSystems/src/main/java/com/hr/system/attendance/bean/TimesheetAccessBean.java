package com.hr.system.attendance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@EntityScan("com.hr.system.attendance.bean")
@Table(name = "timesheet")
public class TimesheetAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TimeSheetId")
	private Long timeSheetId;

	@Column(name = "EmployeeId")
	private Long employeeId;

	@Column(name = "ProjectId")
	private Long projectId;

	@Column(name = "ManagerId")
	private Long managerId;

	@Column(name = "Date")
	private String date;

	@Column(name = "Day")
	private String day;

	@Column(name = "CheckIn")
	private String checkIn;

	@Column(name = "CheckOut")
	private String checkOut;

	@Column(name = "RawTime")
	private String rawTime;

	@Column(name = "RoundTime")
	private String roundTime;

	@Column(name = "Status")
	private String status;
	
	@Column(name = "HolidayId")
	private Long holidayId;

	public Long getTimeSheetId() {
		return timeSheetId;
	}

	public void setTimeSheetId(Long timeSheetId) {
		this.timeSheetId = timeSheetId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getRawTime() {
		return rawTime;
	}

	public void setRawTime(String rawTime) {
		this.rawTime = rawTime;
	}

	public String getRoundTime() {
		return roundTime;
	}

	public void setRoundTime(String roundTime) {
		this.roundTime = roundTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(Long holidayId) {
		this.holidayId = holidayId;
	}

}
