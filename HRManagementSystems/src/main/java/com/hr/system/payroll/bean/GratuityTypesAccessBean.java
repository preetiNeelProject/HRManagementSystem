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
@Table(name = "gratuitytypes")
public class GratuityTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GratuityTypeId")
	private Long gratuityTypeId;

	@ManyToOne
	@JoinColumn(name = "GratuityId", nullable = false)
	private GratuityAccessBean gratuityAccessBean;

	@Column(name = "GratuityType")
	private String gratuityType;

	@Column(name = "GratuityDescription")
	private String gratuityDescription;

	public Long getGratuityTypeId() {
		return gratuityTypeId;
	}

	public void setGratuityTypeId(Long gratuityTypeId) {
		this.gratuityTypeId = gratuityTypeId;
	}

	public String getGratuityType() {
		return gratuityType;
	}

	public void setGratuityType(String gratuityType) {
		this.gratuityType = gratuityType;
	}

	public String getGratuityDescription() {
		return gratuityDescription;
	}

	public void setGratuityDescription(String gratuityDescription) {
		this.gratuityDescription = gratuityDescription;
	}

}
