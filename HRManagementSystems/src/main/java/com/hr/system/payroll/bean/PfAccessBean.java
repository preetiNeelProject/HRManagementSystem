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
@Table(name = "pf")
public class PfAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PFId")
	private Long PFId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pfAccessBean")
	private List<PfTypesAccessBean> PfTypesAccessBean;

	@OneToOne(mappedBy = "pfAccessBean")
	private PfTransAccessBean pfTransAccessBean;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "PFEffectiveDate")
	private Date PFEffectiveDate;

	@Column(name = "PFEndDate")
	private Date PFEndDate;

	@Column(name = "netPFAmount")
	private Long netPFAmount;

	public Long getPFId() {
		return PFId;
	}

	public void setPFId(Long pFId) {
		PFId = pFId;
	}

	public Date getPFEffectiveDate() {
		return PFEffectiveDate;
	}

	public void setPFEffectiveDate(Date pFEffectiveDate) {
		PFEffectiveDate = pFEffectiveDate;
	}

	public Date getPFEndDate() {
		return PFEndDate;
	}

	public void setPFEndDate(Date pFEndDate) {
		PFEndDate = pFEndDate;
	}

	public Long getNetPFAmount() {
		return netPFAmount;
	}

	public void setNetPFAmount(Long netPFAmount) {
		this.netPFAmount = netPFAmount;
	}

	public List<PfTypesAccessBean> getPfTypesAccessBean() {
		return PfTypesAccessBean;
	}

	public void setPfTypesAccessBean(List<PfTypesAccessBean> pfTypesAccessBean) {
		PfTypesAccessBean = pfTypesAccessBean;
	}

	public PfTransAccessBean getPfTransAccessBean() {
		return pfTransAccessBean;
	}

	public void setPfTransAccessBean(PfTransAccessBean pfTransAccessBean) {
		this.pfTransAccessBean = pfTransAccessBean;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

}
