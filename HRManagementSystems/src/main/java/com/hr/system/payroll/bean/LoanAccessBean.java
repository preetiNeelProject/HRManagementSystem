package com.hr.system.payroll.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hr.system.employee.bean.EmployeeAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "loan")
public class LoanAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LoanId")
	private Long loanId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loanAccessBean")
	private List<LoanTypesAccessBean> loanTypesAccessBean;

	@OneToOne(mappedBy = "loanAccessBean")
	private LoanTransactionAccessBean loanTransactionAccessBean;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "LoanEffectiveDate")
	private Date loanEffectiveDate;

	@Column(name = "LoanEndDate")
	private Date loanEndDate;

	@Column(name = "netLoanAmount")
	private Long netLoanAmount;

	@Column(name = "LoanTypeId")
	private Long loanTypeId;

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Date getLoanEffectiveDate() {
		return loanEffectiveDate;
	}

	public void setLoanEffectiveDate(Date loanEffectiveDate) {
		this.loanEffectiveDate = loanEffectiveDate;
	}

	public Date getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public Long getNetLoanAmount() {
		return netLoanAmount;
	}

	public void setNetLoanAmount(Long netLoanAmount) {
		this.netLoanAmount = netLoanAmount;
	}

	public Long getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(Long loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public List<LoanTypesAccessBean> getLoanTypesAccessBean() {
		return loanTypesAccessBean;
	}

	public void setLoanTypesAccessBean(List<LoanTypesAccessBean> loanTypesAccessBean) {
		this.loanTypesAccessBean = loanTypesAccessBean;
	}

	public LoanTransactionAccessBean getLoanTransactionAccessBean() {
		return loanTransactionAccessBean;
	}

	public void setLoanTransactionAccessBean(LoanTransactionAccessBean loanTransactionAccessBean) {
		this.loanTransactionAccessBean = loanTransactionAccessBean;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

}
