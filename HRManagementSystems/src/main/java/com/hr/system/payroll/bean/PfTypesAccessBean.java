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
@Table(name = "PFTypes")
public class PfTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PFTypeId")
	private Long PFTypeId;

	@ManyToOne
	@JoinColumn(name = "PFId", nullable = false)
	private PfAccessBean pfAccessBean;

	@Column(name = "PFType")
	private Long PFType;

	@Column(name = "PFDescription")
	private String PFDescription;

	public Long getPFTypeId() {
		return PFTypeId;
	}

	public void setPFTypeId(Long pFTypeId) {
		PFTypeId = pFTypeId;
	}

	public Long getPFType() {
		return PFType;
	}

	public void setPFType(Long pFType) {
		PFType = pFType;
	}

	public String getPFDescription() {
		return PFDescription;
	}

	public void setPFDescription(String pFDescription) {
		PFDescription = pFDescription;
	}

	public PfAccessBean getPfAccessBean() {
		return pfAccessBean;
	}

	public void setPfAccessBean(PfAccessBean pfAccessBean) {
		this.pfAccessBean = pfAccessBean;
	}

}
