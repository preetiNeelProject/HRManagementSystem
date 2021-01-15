package com.hr.system.payroll.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hr.system.employee.bean.EmployeeAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "salary")
public class SalaryAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "salaryId")
	private Long salaryId;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "HRA")
	private Long HRA;

	@Column(name = "totalDeduction")
	private Long totalDeduction;

	@Column(name = "totalPF")
	private Long totalPF;

	@Column(name = "totalECIS")
	private Long totalECIS;

	@Column(name = "totalTax")
	private Long totalTax;

	@Column(name = "totalGratuity")
	private Long totalGratuity;

	@Column(name = "totalLoan")
	private Long totalLoan;

	@Column(name = "netPay")
	private Long netPay;

	@Column(name = "grossPay")
	private Long grossPay;

	@Column(name = "totalAllowances")
	private Long totalAllowances;

	public Long getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}

	public Long getHRA() {
		return HRA;
	}

	public void setHRA(Long hRA) {
		HRA = hRA;
	}

	public Long getTotalDeduction() {
		return totalDeduction;
	}

	public void setTotalDeduction(Long totalDeduction) {
		this.totalDeduction = totalDeduction;
	}

	public Long getTotalPF() {
		return totalPF;
	}

	public void setTotalPF(Long totalPF) {
		this.totalPF = totalPF;
	}

	public Long getTotalECIS() {
		return totalECIS;
	}

	public void setTotalECIS(Long totalECIS) {
		this.totalECIS = totalECIS;
	}

	public Long getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Long totalTax) {
		this.totalTax = totalTax;
	}

	public Long getTotalGratuity() {
		return totalGratuity;
	}

	public void setTotalGratuity(Long totalGratuity) {
		this.totalGratuity = totalGratuity;
	}

	public Long getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(Long totalLoan) {
		this.totalLoan = totalLoan;
	}

	public Long getNetPay() {
		return netPay;
	}

	public void setNetPay(Long netPay) {
		this.netPay = netPay;
	}

	public Long getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(Long grossPay) {
		this.grossPay = grossPay;
	}

	public Long getTotalAllowances() {
		return totalAllowances;
	}

	public void setTotalAllowances(Long totalAllowances) {
		this.totalAllowances = totalAllowances;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

}
