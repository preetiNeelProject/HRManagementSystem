package com.hr.system.company.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hr.system.employee.bean.EmployeeAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "empworkrelation")
public class EmpWorkRelationAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmpWorkRelationId", nullable = false, unique = true)
	private Long empWorkRelationId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "workLocationId")
	private Long workLocationId;

	@Column(name = "departmentId")
	private Long departmentId;

	@Column(name = "projectId")
	private Long projectId;

	@Column(name = "employeeTypeId")
	private Long employeeTypeId;

	@Column(name = "Manager")
	private String manager;

	@Column(name = "designation")
	private String designation;

	public Long getEmpWorkRelationId() {
		return empWorkRelationId;
	}

	public void setEmpWorkRelationId(Long empWorkRelationId) {
		this.empWorkRelationId = empWorkRelationId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public Long getWorkLocationId() {
		return workLocationId;
	}

	public void setWorkLocationId(Long workLocationId) {
		this.workLocationId = workLocationId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(Long employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
