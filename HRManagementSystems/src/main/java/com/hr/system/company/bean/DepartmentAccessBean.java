package com.hr.system.company.bean;

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
@Table(name = "department")
public class DepartmentAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DepartmentId", nullable = false, unique = true)
	private Long departmentId;

	@Column(name = "WorkLocationId")
	private Long workLocationId;

	@Column(name = "ManagerId")
	private Long managerId;

	@Column(name = "DeptName")
	private String deptName;

	@Column(name = "DeptDesc")
	private String deptDesc;

	@Column(name = "WorkDesc")
	private String workDesc;

	@Column(name = "TotalEmployee")
	private String totalEmployee;

	@Column(name = "MaxEmployee")
	private String maxEmployee;

	@Column(name = "MinEmployee")
	private String minEmployee;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	public String getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(String totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public String getMaxEmployee() {
		return maxEmployee;
	}

	public void setMaxEmployee(String maxEmployee) {
		this.maxEmployee = maxEmployee;
	}

	public String getMinEmployee() {
		return minEmployee;
	}

	public void setMinEmployee(String minEmployee) {
		this.minEmployee = minEmployee;
	}

	public Long getWorkLocationId() {
		return workLocationId;
	}

	public void setWorkLocationId(Long workLocationId) {
		this.workLocationId = workLocationId;
	}

}
