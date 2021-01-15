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
@Table(name = "ecistransaction")
public class EcisTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ECISTransId")
	private Long ECISTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ECISId", referencedColumnName = "ECISId")
	private EcisAccessBean ecisAccessBean;

	@Column(name = "ECISAmount")
	private Long ECISAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;

	public Long getECISTransId() {
		return ECISTransId;
	}

	public void setECISTransId(Long eCISTransId) {
		ECISTransId = eCISTransId;
	}

	public Long getECISAmount() {
		return ECISAmount;
	}

	public void setECISAmount(Long eCISAmount) {
		ECISAmount = eCISAmount;
	}

	public Date getLastDeductionDate() {
		return lastDeductionDate;
	}

	public void setLastDeductionDate(Date lastDeductionDate) {
		this.lastDeductionDate = lastDeductionDate;
	}

	public EcisAccessBean getEcisAccessBean() {
		return ecisAccessBean;
	}

	public void setEcisAccessBean(EcisAccessBean ecisAccessBean) {
		this.ecisAccessBean = ecisAccessBean;
	}

}
