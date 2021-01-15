package com.hr.system.leave.bean;

import java.sql.*;

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
@Table(name = "leaves")
public class LeavesAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeavesId")
	private Long leavesId;

	@Column(name = "EmployeeId")
	private Long employeeId;

	@Column(name = "LeaveTypeId")
	private Long leaveTypeId;

	@Column(name = "FromDate")
	private Date fromDate;

	@Column(name = "ToDate")
	private Date toDate;

	@Column(name = "ApplyDate")
	private Date applyDate;

	@Column(name = "Reason")
	private String reason;

	@Column(name = "Status")
	private String status;

	@Column(name = "ManagerId")
	private Long managerId;

	@Column(name = "ApprovedBy")
	private String approvedBy;

	@Column(name = "Comments")
	private String comments;

	public Long getLeavesId() {
		return leavesId;
	}

	public void setLeavesId(Long leavesId) {
		this.leavesId = leavesId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
