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
@Table(name = "deductiontransaction")
public class DeductionTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dedTransId")
	private Long dedTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deductionsId", referencedColumnName = "deductionsId")
	private DeductionsAccessBean deductionsAccessBean;

	@Column(name = "dedAmount")
	private Long dedAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;

	public Long getDedTransId() {
		return dedTransId;
	}

	public void setDedTransId(Long dedTransId) {
		this.dedTransId = dedTransId;
	}

	public Long getDedAmount() {
		return dedAmount;
	}

	public void setDedAmount(Long dedAmount) {
		this.dedAmount = dedAmount;
	}

	public Date getLastDeductionDate() {
		return lastDeductionDate;
	}

	public void setLastDeductionDate(Date lastDeductionDate) {
		this.lastDeductionDate = lastDeductionDate;
	}

	public DeductionsAccessBean getDeductionsAccessBean() {
		return deductionsAccessBean;
	}

	public void setDeductionsAccessBean(DeductionsAccessBean deductionsAccessBean) {
		this.deductionsAccessBean = deductionsAccessBean;
	}

}
