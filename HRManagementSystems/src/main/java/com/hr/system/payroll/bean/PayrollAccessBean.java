package com.hr.system.payroll.bean;

import java.util.Date;

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
@Table(name = "payroll")
public class PayrollAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payrollId")
	private Long payrollId;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "startDay")
	private Date startDay;

	@Column(name = "hoursWorked")
	private Long hoursWorked;

	@Column(name = "grossPay")
	private Long grossPay;

	@Column(name = "deduction")
	private Long deduction;

	@Column(name = "netPay")
	private Long netPay;

	@Column(name = "accountId")
	private Long accountId;

	@Column(name = "endDay")
	private Long endDay;

	@Column(name = "col2")
	private String col2;

	@Column(name = "col3")
	private String col3;

	public Long getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Long getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(Long hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public Long getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(Long grossPay) {
		this.grossPay = grossPay;
	}

	public Long getDeduction() {
		return deduction;
	}

	public void setDeduction(Long deduction) {
		this.deduction = deduction;
	}

	public Long getNetPay() {
		return netPay;
	}

	public void setNetPay(Long netPay) {
		this.netPay = netPay;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getEndDay() {
		return endDay;
	}

	public void setEndDay(Long endDay) {
		this.endDay = endDay;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

}
