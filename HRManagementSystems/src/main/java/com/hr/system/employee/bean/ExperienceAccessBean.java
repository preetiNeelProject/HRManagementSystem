package com.hr.system.employee.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "experience")
public class ExperienceAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ExperianceId")
	private Long experianceId;

	@ManyToOne
	@JoinColumn(name = "employeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Department")
	private String department;

	@Column(name = "ResignationDate")
	private Date resignationDate;

	@Column(name = "TerminationDate")
	private Date terminationDate;

	@Column(name = "ResignationStatus")
	private String resignationStatus;

	@Column(name = "NoticePeriod")
	private String noticePeriod;

	public Long getExperianceId() {
		return experianceId;
	}

	public void setExperianceId(Long experianceId) {
		this.experianceId = experianceId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate(Date resignationDate) {
		this.resignationDate = resignationDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getResignationStatus() {
		return resignationStatus;
	}

	public void setResignationStatus(String resignationStatus) {
		this.resignationStatus = resignationStatus;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

}
