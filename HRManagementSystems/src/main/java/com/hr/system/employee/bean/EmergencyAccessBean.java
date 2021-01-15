package com.hr.system.employee.bean;

import javax.persistence.CascadeType;
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
@Table(name = "emergency")
public class EmergencyAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmergencyId", nullable = false, unique = true)
	private Long emergencyId;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "employeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "EmergencyName")
	private String emergencyName;

	@Column(name = "EmergencyRelationship")
	private String emergencyRelationship;

	@Column(name = "EmergencyNumber")
	private String emergencyNumber;

	public Long getEmergencyId() {
		return emergencyId;
	}

	public void setEmergencyId(Long emergencyId) {
		this.emergencyId = emergencyId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergencyRelationship() {
		return emergencyRelationship;
	}

	public void setEmergencyRelationship(String emergencyRelationship) {
		this.emergencyRelationship = emergencyRelationship;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

}
