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
@Table(name = "gratuitytransaction")
public class GratuityTransAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GratuityTransId")
	private Long gratuityTransId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gratuityId", referencedColumnName = "gratuityId")
	private GratuityAccessBean gratuityAccessBean;

	@Column(name = "GratuityAmount")
	private Long gratuityAmount;

	@Column(name = "lastDeductionDate")
	private Date lastDeductionDate;

	public Long getGratuityTransId() {
		return gratuityTransId;
	}

	public void setGratuityTransId(Long gratuityTransId) {
		this.gratuityTransId = gratuityTransId;
	}

	public Long getGratuityAmount() {
		return gratuityAmount;
	}

	public void setGratuityAmount(Long gratuityAmount) {
		this.gratuityAmount = gratuityAmount;
	}

	public Date getLastDeductionDate() {
		return lastDeductionDate;
	}

	public void setLastDeductionDate(Date lastDeductionDate) {
		this.lastDeductionDate = lastDeductionDate;
	}

	public GratuityAccessBean getGratuityAccessBean() {
		return gratuityAccessBean;
	}

	public void setGratuityAccessBean(GratuityAccessBean gratuityAccessBean) {
		this.gratuityAccessBean = gratuityAccessBean;
	}

}
