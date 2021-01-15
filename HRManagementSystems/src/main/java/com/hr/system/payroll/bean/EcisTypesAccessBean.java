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
@Table(name = "ecistypes")
public class EcisTypesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ECISTypeId")
	private Long ECISTypeId;

	@ManyToOne
	@JoinColumn(name = "ECISId", nullable = false)
	private EcisAccessBean ecisAccessBean;

	@Column(name = "ECISType")
	private String ECISType;

	@Column(name = "LogonPassword")
	private String logonPassword;

	public Long getECISTypeId() {
		return ECISTypeId;
	}

	public void setECISTypeId(Long eCISTypeId) {
		ECISTypeId = eCISTypeId;
	}

	public String getECISType() {
		return ECISType;
	}

	public void setECISType(String eCISType) {
		ECISType = eCISType;
	}

	public String getLogonPassword() {
		return logonPassword;
	}

	public void setLogonPassword(String logonPassword) {
		this.logonPassword = logonPassword;
	}

	public EcisAccessBean getEcisAccessBean() {
		return ecisAccessBean;
	}

	public void setEcisAccessBean(EcisAccessBean ecisAccessBean) {
		this.ecisAccessBean = ecisAccessBean;
	}

}
