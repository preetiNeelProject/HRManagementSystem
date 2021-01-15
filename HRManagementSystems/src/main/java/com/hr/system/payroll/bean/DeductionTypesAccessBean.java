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
@Table(name = "deductiontypes")
public class DeductionTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deductionTypesId")
	private Long deductionTypesId;

	@ManyToOne
	@JoinColumn(name = "deductionsId", nullable = false)
	private DeductionsAccessBean deductionsAccessBean;

	@Column(name = "deductionType")
	private String deductionType;

	@Column(name = "deductionDescription")
	private String deductionDescription;

	public Long getDeductionTypesId() {
		return deductionTypesId;
	}

	public void setDeductionTypesId(Long deductionTypesId) {
		this.deductionTypesId = deductionTypesId;
	}

	public String getDeductionType() {
		return deductionType;
	}

	public void setDeductionType(String deductionType) {
		this.deductionType = deductionType;
	}

	public String getDeductionDescription() {
		return deductionDescription;
	}

	public void setDeductionDescription(String deductionDescription) {
		this.deductionDescription = deductionDescription;
	}

	public DeductionsAccessBean getDeductionsAccessBean() {
		return deductionsAccessBean;
	}

	public void setDeductionsAccessBean(DeductionsAccessBean deductionsAccessBean) {
		this.deductionsAccessBean = deductionsAccessBean;
	}

}
