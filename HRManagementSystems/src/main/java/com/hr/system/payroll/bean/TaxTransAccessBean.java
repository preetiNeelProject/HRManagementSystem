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
@Table(name = "taxtransaction")
public class TaxTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaxTransId")
	private Long taxTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taxId", referencedColumnName = "taxId")
	private TaxAccessBean taxAccessBean;

	@Column(name = "TaxAmount")
	private Long taxAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;

	public Long getTaxTransId() {
		return taxTransId;
	}

	public void setTaxTransId(Long taxTransId) {
		this.taxTransId = taxTransId;
	}

	public Long getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Long taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Date getLastDeductionDate() {
		return lastDeductionDate;
	}

	public void setLastDeductionDate(Date lastDeductionDate) {
		this.lastDeductionDate = lastDeductionDate;
	}

	public TaxAccessBean getTaxAccessBean() {
		return taxAccessBean;
	}

	public void setTaxAccessBean(TaxAccessBean taxAccessBean) {
		this.taxAccessBean = taxAccessBean;
	}

}
