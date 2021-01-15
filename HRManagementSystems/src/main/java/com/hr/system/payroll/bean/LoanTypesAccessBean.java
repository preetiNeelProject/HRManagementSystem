package com.hr.system.payroll.bean;

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
@Table(name = "loantypes")
public class LoanTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LoanTypeId")
	private Long loanTypeId;

	@ManyToOne
	@JoinColumn(name = "LoanId", nullable = false)
	private LoanAccessBean loanAccessBean;

	@Column(name = "LoanType")
	private String loanType;

	@Column(name = "LoanDescription")
	private String loanDescription;

	public Long getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(Long loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getLoanDescription() {
		return loanDescription;
	}

	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}

	public LoanAccessBean getLoanAccessBean() {
		return loanAccessBean;
	}

	public void setLoanAccessBean(LoanAccessBean loanAccessBean) {
		this.loanAccessBean = loanAccessBean;
	}

}
