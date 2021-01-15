package com.hr.system.payroll.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "taxtypes")
public class TaxTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaxTypeId")
	private Long taxTypeId;

	@Column(name = "TaxType")
	private Long taxType;

	@Column(name = "TaxDescription")
	private String taxDescription;

	public Long getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(Long taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public Long getTaxType() {
		return taxType;
	}

	public void setTaxType(Long taxType) {
		this.taxType = taxType;
	}

	public String getTaxDescription() {
		return taxDescription;
	}

	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}

}
