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
@Table(name = "allowancetype")
public class AllowanceTypeAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allowanceTypeId")
	private Long allowanceTypeId;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "allowancesId", nullable = false) private
	 * AllowancesAccessBean allowancesAccessBean;
	 */
	@Column(name = "allowanceType")
	private String allowanceType;

	@Column(name = "description")
	private String description;

	public Long getAllowanceTypeId() {
		return allowanceTypeId;
	}

	public void setAllowanceTypeId(Long allowanceTypeId) {
		this.allowanceTypeId = allowanceTypeId;
	}

	public String getAllowanceType() {
		return allowanceType;
	}

	public void setAllowanceType(String allowanceType) {
		this.allowanceType = allowanceType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
