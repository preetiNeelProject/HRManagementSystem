package com.hr.system.company.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "workshift")
public class WorkshiftAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WorkingShiftId", nullable = false, unique = true)
	private Long workingShiftId;

	@Column(name = "WorkingShiftType")
	private String workingShiftType;

	@Column(name = "WorkingShiftHour")
	private String workingShiftHour;

	public Long getWorkingShiftId() {
		return workingShiftId;
	}

	public void setWorkingShiftId(Long workingShiftId) {
		this.workingShiftId = workingShiftId;
	}

	public String getWorkingShiftType() {
		return workingShiftType;
	}

	public void setWorkingShiftType(String workingShiftType) {
		this.workingShiftType = workingShiftType;
	}

	public String getWorkingShiftHour() {
		return workingShiftHour;
	}

	public void setWorkingShiftHour(String workingShiftHour) {
		this.workingShiftHour = workingShiftHour;
	}

}
