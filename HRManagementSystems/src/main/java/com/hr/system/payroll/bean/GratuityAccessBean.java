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
@Table(name = "gratuity")
public class GratuityAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GratuityId")
	private Long gratuityId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "gratuityAccessBean")
	private List<GratuityTypesAccessBean> gratuityTypesAccessBean;

	@OneToOne(mappedBy = "gratuityAccessBean")
	private GratuityTransAccessBean gratuityTransAccessBean;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "GratuityEffectiveDate")
	private Date gratuityEffectiveDate;

	@Column(name = "GratuityEndDate")
	private Date gratuityEndDate;

	@Column(name = "netGratuityAmount")
	private Long netGratuityAmount;

	@Column(name = "GratuityTypeId")
	private Long gratuityTypeId;

	public Long getGratuityId() {
		return gratuityId;
	}

	public void setGratuityId(Long gratuityId) {
		this.gratuityId = gratuityId;
	}

	public Date getGratuityEffectiveDate() {
		return gratuityEffectiveDate;
	}

	public void setGratuityEffectiveDate(Date gratuityEffectiveDate) {
		this.gratuityEffectiveDate = gratuityEffectiveDate;
	}

	public Date getGratuityEndDate() {
		return gratuityEndDate;
	}

	public void setGratuityEndDate(Date gratuityEndDate) {
		this.gratuityEndDate = gratuityEndDate;
	}

	public Long getNetGratuityAmount() {
		return netGratuityAmount;
	}

	public void setNetGratuityAmount(Long netGratuityAmount) {
		this.netGratuityAmount = netGratuityAmount;
	}

	public Long getGratuityTypeId() {
		return gratuityTypeId;
	}

	public void setGratuityTypeId(Long gratuityTypeId) {
		this.gratuityTypeId = gratuityTypeId;
	}

	public List<GratuityTypesAccessBean> getGratuityTypesAccessBean() {
		return gratuityTypesAccessBean;
	}

	public void setGratuityTypesAccessBean(List<GratuityTypesAccessBean> gratuityTypesAccessBean) {
		this.gratuityTypesAccessBean = gratuityTypesAccessBean;
	}

	public GratuityTransAccessBean getGratuityTransAccessBean() {
		return gratuityTransAccessBean;
	}

	public void setGratuityTransAccessBean(GratuityTransAccessBean gratuityTransAccessBean) {
		this.gratuityTransAccessBean = gratuityTransAccessBean;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

}
