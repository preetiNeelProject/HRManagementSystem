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

import org.springframework.format.annotation.DateTimeFormat;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "allowancetransaction")
public class AllowanceTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allowanceTransId")
	private Long allowanceTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "allowancesId", referencedColumnName = "allowancesId")
	private AllowancesAccessBean allowancesAccessBean;

	@Column(name = "allowanceAmt")
	private Long allowanceAmt;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "lastTransDate")
	private Date lastTransDate;

	public Long getAllowanceTransId() {
		return allowanceTransId;
	}

	public void setAllowanceTransId(Long allowanceTransId) {
		this.allowanceTransId = allowanceTransId;
	}

	public Long getAllowanceAmt() {
		return allowanceAmt;
	}

	public void setAllowanceAmt(Long allowanceAmt) {
		this.allowanceAmt = allowanceAmt;
	}

	public Date getLastTransDate() {
		return lastTransDate;
	}

	public void setLastTransDate(Date lastTransDate) {
		this.lastTransDate = lastTransDate;
	}

	public AllowancesAccessBean getAllowancesAccessBean() {
		return allowancesAccessBean;
	}

	public void setAllowancesAccessBean(AllowancesAccessBean allowancesAccessBean) {
		this.allowancesAccessBean = allowancesAccessBean;
	}

}
