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
@EntityScan("com.hr.system")
@Table(name = "attendance")
public class AttendanceAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AttendanceId")
	private Long attendanceId;

	@Column(name = "EmployeeId")
	private Long employeeId;

	@Column(name = "ProjectId")
	private Long projectId;

	@Column(name = "ManagerId")
	private Long managerId;

	@Column(name = "Date")
	private String date;

	@Column(name = "WorkingHours")
	private String workingHours;

	@Column(name = "OverTime")
	private String overTime;

	@Column(name = "workingShiftId")
	private Long WorkingShiftId;

	@Column(name = "TimeSheetId")
	private Long timeSheetId;

	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
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

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public Long getWorkingShiftId() {
		return WorkingShiftId;
	}

	public void setWorkingShiftId(Long workingShiftId) {
		WorkingShiftId = workingShiftId;
	}

	public Long getTimeSheetId() {
		return timeSheetId;
	}

	public void setTimeSheetId(Long timeSheetId) {
		this.timeSheetId = timeSheetId;
	}

}
