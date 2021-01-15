package com.hr.system.payroll.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "ctchistory")
public class CtcHistoryAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CtcHistoryId")
	private Long ctcHistoryId;

	@Column(name = "EmployeeId")
	private Long employeeId;

	@Column(name = "Name")
	private String name;

	@Column(name = "JoiningDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;

	@Column(name = "AnnualBasicSalary")
	private Long annualBasicSalary;

	@Column(name = "AnnualRefSalary")
	private Long annualRefSalary;

	@Column(name = "PF")
	private Long pf;

	@Column(name = "HRA")
	private Long hra;

	@Column(name = "CONVEY")
	private Long convey;

	@Column(name = "ESI")
	private Long esi;

	@Column(name = "Gratuity")
	private Long gratuity;

	@Column(name = "CTC")
	private Long cTC;

	@Column(name = "IncrementDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date incrementDate;

	@Column(name = "newCtc")
	private Long newCtc;

	@Column(name = "Comments")
	private String comments;

	@Column(name = "AnnualFlexibleBenifits")
	private Long annualFlexibleBenifits;

	public Long getCtcHistoryId() {
		return ctcHistoryId;
	}

	public void setCtcHistoryId(Long ctcHistoryId) {
		this.ctcHistoryId = ctcHistoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Long getAnnualBasicSalary() {
		return annualBasicSalary;
	}

	public void setAnnualBasicSalary(Long annualBasicSalary) {
		this.annualBasicSalary = annualBasicSalary;
	}

	public Long getAnnualRefSalary() {
		return annualRefSalary;
	}

	public void setAnnualRefSalary(Long annualRefSalary) {
		this.annualRefSalary = annualRefSalary;
	}

	public Long getPf() {
		return pf;
	}

	public void setPf(Long pf) {
		this.pf = pf;
	}

	public Long getGratuity() {
		return gratuity;
	}

	public void setGratuity(Long gratuity) {
		this.gratuity = gratuity;
	}

	public Long getcTC() {
		return cTC;
	}

	public void setcTC(Long cTC) {
		this.cTC = cTC;
	}

	public Long getAnnualFlexibleBenifits() {
		return annualFlexibleBenifits;
	}

	public void setAnnualFlexibleBenifits(Long annualFlexibleBenifits) {
		this.annualFlexibleBenifits = annualFlexibleBenifits;
	}

	public Long getHra() {
		return hra;
	}

	public void setHra(Long hra) {
		this.hra = hra;
	}

	public Long getConvey() {
		return convey;
	}

	public void setConvey(Long convey) {
		this.convey = convey;
	}

	public Long getEsi() {
		return esi;
	}

	public void setEsi(Long esi) {
		this.esi = esi;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getIncrementDate() {
		return incrementDate;
	}

	public void setIncrementDate(Date incrementDate) {
		this.incrementDate = incrementDate;
	}

	public Long getNewCtc() {
		return newCtc;
	}

	public void setNewCtc(Long newCtc) {
		this.newCtc = newCtc;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
