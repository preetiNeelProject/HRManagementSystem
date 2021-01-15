package com.hr.system.employee.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "accountDetails")
public class AccountDetailsAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccountDetailId", nullable = false, unique = true)
	private Long accountDetailId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "HolderName")
	private String holderName;

	@Column(name = "BankName")
	private String bankName;

	@Column(name = "City")
	private String city;

	@Column(name = "BranchName")
	private String branchName;

	@Column(name = "IFSCCode")
	private String ifscCode;

	@Column(name = "AccountNumber")
	private Long accountNumber;
	
	@Column(name = "Pf")
	private boolean pf;

	@Column(name = "Esi")
	private boolean esi;


	public Long getAccountDetailId() {
		return accountDetailId;
	}

	public void setAccountDetailId(Long accountDetailId) {
		this.accountDetailId = accountDetailId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isPf() {
		return pf;
	}

	public void setPf(boolean pf) {
		this.pf = pf;
	}

	public boolean isEsi() {
		return esi;
	}

	public void setEsi(boolean esi) {
		this.esi = esi;
	}

	
}
