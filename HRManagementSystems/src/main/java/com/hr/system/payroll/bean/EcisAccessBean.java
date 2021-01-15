package com.hr.system.payroll.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hr.system.employee.bean.EmployeeAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "ecis")
public class EcisAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ECISId")
	private Long ECISId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ecisAccessBean")
	private List<EcisTypesAccessBean> ecisTypesAccessBean;

	@OneToOne(mappedBy = "ecisAccessBean")
	private EcisTransAccessBean ecisTransAccessBean;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "ECISEffectiveDate")
	private Date ECISEffectiveDate;

	@Column(name = "netECISAmount")
	private Date netECISAmount;

	@Column(name = "ECISTypeId")
	private Long ECISTypeId;

	public Long getECISId() {
		return ECISId;
	}

	public void setECISId(Long eCISId) {
		ECISId = eCISId;
	}

	public Date getECISEffectiveDate() {
		return ECISEffectiveDate;
	}

	public void setECISEffectiveDate(Date eCISEffectiveDate) {
		ECISEffectiveDate = eCISEffectiveDate;
	}

	public Date getNetECISAmount() {
		return netECISAmount;
	}

	public void setNetECISAmount(Date netECISAmount) {
		this.netECISAmount = netECISAmount;
	}

	public Long getECISTypeId() {
		return ECISTypeId;
	}

	public void setECISTypeId(Long eCISTypeId) {
		ECISTypeId = eCISTypeId;
	}

	public List<EcisTypesAccessBean> getEcisTypesAccessBean() {
		return ecisTypesAccessBean;
	}

	public void setEcisTypesAccessBean(List<EcisTypesAccessBean> ecisTypesAccessBean) {
		this.ecisTypesAccessBean = ecisTypesAccessBean;
	}

	public EcisTransAccessBean getEcisTransAccessBean() {
		return ecisTransAccessBean;
	}

	public void setEcisTransAccessBean(EcisTransAccessBean ecisTransAccessBean) {
		this.ecisTransAccessBean = ecisTransAccessBean;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

}
