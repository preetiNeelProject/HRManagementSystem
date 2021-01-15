package com.hr.system.company.bean;

import java.sql.Date;

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
@Table(name = "announcement")
public class AnnouncementAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AnnouncementId")
	private Long announcementId;

	@Column(name = "EmployeeId")
	private Long employeeId;

	@Column(name = "AnnouncementCode")
	private String announcementCode;

	@Column(name = "ApplyDate")
	private Date applyDate;

	@Column(name = "WorkLocationId")
	private Long workLocationId;

	@Column(name = "DepartmentId")
	private Long departmentId;

	@Column(name = "Message")
	private String message;

	@Column(name = "Status")
	private String status;

	@Column(name = "ManagerId")
	private Long managerId;

	@Column(name = "ApprovedBy")
	private String approvedBy;

	@Column(name = "Comments")
	private String comments;

	public Long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getAnnouncementCode() {
		return announcementCode;
	}

	public void setAnnouncementCode(String announcementCode) {
		this.announcementCode = announcementCode;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
