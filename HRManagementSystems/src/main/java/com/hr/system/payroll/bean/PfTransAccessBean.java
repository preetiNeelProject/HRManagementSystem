package com.hr.system.payroll.bean;

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
@Table(name = "pftransaction")
public class PfTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PFTransId")
	private Long PFTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PFId", referencedColumnName = "PFId")
	private PfAccessBean pfAccessBean;

	@Column(name = "PFAmount")
	private Long PFAmount;

	@Column(name = "lastDeductionDate")
	private String lastDeductionDate;

	public Long getPFTransId() {
		return PFTransId;
	}

	public void setPFTransId(Long pFTransId) {
		PFTransId = pFTransId;
	}

	public Long getPFAmount() {
		return PFAmount;
	}

	public void setPFAmount(Long pFAmount) {
		PFAmount = pFAmount;
	}

	public String getLastDeductionDate() {
		return lastDeductionDate;
	}

	public void setLastDeductionDate(String lastDeductionDate) {
		this.lastDeductionDate = lastDeductionDate;
	}

	public PfAccessBean getPfAccessBean() {
		return pfAccessBean;
	}

	public void setPfAccessBean(PfAccessBean pfAccessBean) {
		this.pfAccessBean = pfAccessBean;
	}

}
