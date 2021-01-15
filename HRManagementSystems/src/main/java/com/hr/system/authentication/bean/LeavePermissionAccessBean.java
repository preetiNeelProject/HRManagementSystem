package com.hr.system.authentication.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hr.system.employee.bean.EmployeeAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "leavepermission")
public class LeavePermissionAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeavePermissionId")
	private Long leavePermissionId;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "leavePermissionAccessBean")
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "AddLeave")
	private boolean addLeave;

	@Column(name = "ViewLeave")
	private boolean viewLeave;

	@Column(name = "EditLeave")
	private boolean editLeave;

	@Column(name = "DeleteLeave")
	private boolean deleteLeave;

	@Column(name = "UploadLeave")
	private boolean uploadLeave;

	@Column(name = "DownloadLeave")
	private boolean downloadLeave;

	@Column(name = "ApprovelLeave")
	private boolean approvelLeave;

	@Column(name = "BalanceLeave")
	private boolean balanceLeave;

	@Column(name = "SetRulesLeave")
	private boolean setRulesLeave;

	@Column(name = "SettingLeave")
	private boolean settingLeave;

	public Long getLeavePermissionId() {
		return leavePermissionId;
	}

	public void setLeavePermissionId(Long leavePermissionId) {
		this.leavePermissionId = leavePermissionId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public boolean isAddLeave() {
		return addLeave;
	}

	public void setAddLeave(boolean addLeave) {
		this.addLeave = addLeave;
	}

	public boolean isViewLeave() {
		return viewLeave;
	}

	public void setViewLeave(boolean viewLeave) {
		this.viewLeave = viewLeave;
	}

	public boolean isEditLeave() {
		return editLeave;
	}

	public void setEditLeave(boolean editLeave) {
		this.editLeave = editLeave;
	}

	public boolean isDeleteLeave() {
		return deleteLeave;
	}

	public void setDeleteLeave(boolean deleteLeave) {
		this.deleteLeave = deleteLeave;
	}

	public boolean isUploadLeave() {
		return uploadLeave;
	}

	public void setUploadLeave(boolean uploadLeave) {
		this.uploadLeave = uploadLeave;
	}

	public boolean isDownloadLeave() {
		return downloadLeave;
	}

	public void setDownloadLeave(boolean downloadLeave) {
		this.downloadLeave = downloadLeave;
	}

	public boolean isApprovelLeave() {
		return approvelLeave;
	}

	public void setApprovelLeave(boolean approvelLeave) {
		this.approvelLeave = approvelLeave;
	}

	public boolean isBalanceLeave() {
		return balanceLeave;
	}

	public void setBalanceLeave(boolean balanceLeave) {
		this.balanceLeave = balanceLeave;
	}

	public boolean isSetRulesLeave() {
		return setRulesLeave;
	}

	public void setSetRulesLeave(boolean setRulesLeave) {
		this.setRulesLeave = setRulesLeave;
	}

	public boolean isSettingLeave() {
		return settingLeave;
	}

	public void setSettingLeave(boolean settingLeave) {
		this.settingLeave = settingLeave;
	}

}
