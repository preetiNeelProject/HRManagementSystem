package com.hr.system.payroll.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hr.system.employee.bean.EmployeeAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "tax")
public class TaxAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaxId")
	private Long taxId;

	@OneToOne(mappedBy = "taxAccessBean")
	private TaxTransAccessBean taxTransAccessBean;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "TaxEffectiveDate")
	private Date taxEffectiveDate;

	@Column(name = "TaxEndDate")
	private Date taxEndDate;

	@Column(name = "netTaxAmount")
	private Long netTaxAmount;

	@Column(name = "TaxTypeId")
	private Long taxTypeId;

	public Long getTaxId() {
		return taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public Date getTaxEffectiveDate() {
		return taxEffectiveDate;
	}

	public void setTaxEffectiveDate(Date taxEffectiveDate) {
		this.taxEffectiveDate = taxEffectiveDate;
	}

	public Date getTaxEndDate() {
		return taxEndDate;
	}

	public void setTaxEndDate(Date taxEndDate) {
		this.taxEndDate = taxEndDate;
	}

	public Long getNetTaxAmount() {
		return netTaxAmount;
	}

	public void setNetTaxAmount(Long netTaxAmount) {
		this.netTaxAmount = netTaxAmount;
	}

	public Long getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(Long taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public TaxTransAccessBean getTaxTransAccessBean() {
		return taxTransAccessBean;
	}

	public void setTaxTransAccessBean(TaxTransAccessBean taxTransAccessBean) {
		this.taxTransAccessBean = taxTransAccessBean;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

}
