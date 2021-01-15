package com.hr.system.payroll.bean;

import java.util.Date;

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
@Table(name = "loantransaction")
public class LoanTransactionAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LoanTransId")
	private Long loanTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loanId", referencedColumnName = "loanId")
	private LoanAccessBean loanAccessBean;

	@Column(name = "LoanAmount")
	private Long loanAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;

	public Long getLoanTransId() {
		return loanTransId;
	}

	public void setLoanTransId(Long loanTransId) {
		this.loanTransId = loanTransId;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLastDeductionDate() {
		return lastDeductionDate;
	}

	public void setLastDeductionDate(Date lastDeductionDate) {
		this.lastDeductionDate = lastDeductionDate;
	}

	public LoanAccessBean getLoanAccessBean() {
		return loanAccessBean;
	}

	public void setLoanAccessBean(LoanAccessBean loanAccessBean) {
		this.loanAccessBean = loanAccessBean;
	}

}
