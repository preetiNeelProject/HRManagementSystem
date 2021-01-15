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
@Table(name = "allowances")
public class AllowancesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allowancesId")
	private Long allowancesId;

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "allowancesAccessBean") private List<AllowanceTypeAccessBean>
	 * allowanceTypeAccessBean;
	 */

	@Column(name = "allowanceTypeId")
	private Long allowanceTypeId;

	@OneToOne(mappedBy = "allowancesAccessBean")
	private AllowanceTransAccessBean allowanceTransAccessBean;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "effectiveDate")
	private Date effectiveDate;

	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "allowancesAmt")
	private Long allowancesAmt;

	public Long getAllowancesId() {
		return allowancesId;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getAllowancesAmt() {
		return allowancesAmt;
	}

	public void setAllowancesAmt(Long allowancesAmt) {
		this.allowancesAmt = allowancesAmt;
	}

	public void setAllowancesId(Long allowancesId) {
		this.allowancesId = allowancesId;
	}

	/*
	 * public List<AllowanceTypeAccessBean> getAllowanceTypeAccessBean() { return
	 * allowanceTypeAccessBean; }
	 * 
	 * public void setAllowanceTypeAccessBean(List<AllowanceTypeAccessBean>
	 * allowanceTypeAccessBean) { this.allowanceTypeAccessBean =
	 * allowanceTypeAccessBean; }
	 */

	public AllowanceTransAccessBean getAllowanceTransAccessBean() {
		return allowanceTransAccessBean;
	}

	public void setAllowanceTransAccessBean(AllowanceTransAccessBean allowanceTransAccessBean) {
		this.allowanceTransAccessBean = allowanceTransAccessBean;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public Long getAllowanceTypeId() {
		return allowanceTypeId;
	}

	public void setAllowanceTypeId(Long allowanceTypeId) {
		this.allowanceTypeId = allowanceTypeId;
	}

}
