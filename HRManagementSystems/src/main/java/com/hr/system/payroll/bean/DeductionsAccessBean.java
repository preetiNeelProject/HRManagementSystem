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
@Table(name = "deductions")
public class DeductionsAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deductionsId")
	private Long deductionsId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "deductionsAccessBean")
	private List<DeductionTypesAccessBean> deductionTypesAccessBean;

	@OneToOne(mappedBy = "deductionsAccessBean")
	private DeductionTransAccessBean deductionTransAccessBean;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "dedEffectiveDate")
	private Date dedEffectiveDate;

	@Column(name = "dedEndDate")
	private Date dedEndDate;

	@Column(name = "netDedAmount")
	private Long netDedAmount;

	@Column(name = "dedInstAmt")
	private Long dedInstAmt;

	public Long getDeductionsId() {
		return deductionsId;
	}

	public void setDeductionsId(Long deductionsId) {
		this.deductionsId = deductionsId;
	}

	public Date getDedEffectiveDate() {
		return dedEffectiveDate;
	}

	public void setDedEffectiveDate(Date dedEffectiveDate) {
		this.dedEffectiveDate = dedEffectiveDate;
	}

	public Date getDedEndDate() {
		return dedEndDate;
	}

	public void setDedEndDate(Date dedEndDate) {
		this.dedEndDate = dedEndDate;
	}

	public Long getNetDedAmount() {
		return netDedAmount;
	}

	public void setNetDedAmount(Long netDedAmount) {
		this.netDedAmount = netDedAmount;
	}

	public Long getDedInstAmt() {
		return dedInstAmt;
	}

	public void setDedInstAmt(Long dedInstAmt) {
		this.dedInstAmt = dedInstAmt;
	}

	public List<DeductionTypesAccessBean> getDeductionTypesAccessBean() {
		return deductionTypesAccessBean;
	}

	public void setDeductionTypesAccessBean(List<DeductionTypesAccessBean> deductionTypesAccessBean) {
		this.deductionTypesAccessBean = deductionTypesAccessBean;
	}

	public DeductionTransAccessBean getDeductionTransAccessBean() {
		return deductionTransAccessBean;
	}

	public void setDeductionTransAccessBean(DeductionTransAccessBean deductionTransAccessBean) {
		this.deductionTransAccessBean = deductionTransAccessBean;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

}
