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
@Table(name = "attendancepermission")
public class AttendancePermissionAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AttendancePermissionId")
	private Long attendancePermissionId;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "attendancePermissionAccessBean")
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "AddAttendance")
	private boolean addAttendance;

	@Column(name = "ViewAttendance")
	private boolean viewAttendance;

	@Column(name = "EditAttendance")
	private boolean editAttendance;

	@Column(name = "DeleteAttendance")
	private boolean deleteAttendance;

	@Column(name = "UploadAttendance")
	private boolean uploadAttendance;

	@Column(name = "DownloadAttendance")
	private boolean downloadAttendance;

	@Column(name = "ApprovelAttendance")
	private boolean approvelAttendance;

	@Column(name = "SetRulesAttendance")
	private boolean setRulesAttendance;

	@Column(name = "SettingAttendance")
	private boolean settingAttendance;

	public Long getAttendancePermissionId() {
		return attendancePermissionId;
	}

	public void setAttendancePermissionId(Long attendancePermissionId) {
		this.attendancePermissionId = attendancePermissionId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public boolean isAddAttendance() {
		return addAttendance;
	}

	public void setAddAttendance(boolean addAttendance) {
		this.addAttendance = addAttendance;
	}

	public boolean isViewAttendance() {
		return viewAttendance;
	}

	public void setViewAttendance(boolean viewAttendance) {
		this.viewAttendance = viewAttendance;
	}

	public boolean isEditAttendance() {
		return editAttendance;
	}

	public void setEditAttendance(boolean editAttendance) {
		this.editAttendance = editAttendance;
	}

	public boolean isDeleteAttendance() {
		return deleteAttendance;
	}

	public void setDeleteAttendance(boolean deleteAttendance) {
		this.deleteAttendance = deleteAttendance;
	}

	public boolean isUploadAttendance() {
		return uploadAttendance;
	}

	public void setUploadAttendance(boolean uploadAttendance) {
		this.uploadAttendance = uploadAttendance;
	}

	public boolean isDownloadAttendance() {
		return downloadAttendance;
	}

	public void setDownloadAttendance(boolean downloadAttendance) {
		this.downloadAttendance = downloadAttendance;
	}

	public boolean isApprovelAttendance() {
		return approvelAttendance;
	}

	public void setApprovelAttendance(boolean approvelAttendance) {
		this.approvelAttendance = approvelAttendance;
	}

	public boolean isSetRulesAttendance() {
		return setRulesAttendance;
	}

	public void setSetRulesAttendance(boolean setRulesAttendance) {
		this.setRulesAttendance = setRulesAttendance;
	}

	public boolean isSettingAttendance() {
		return settingAttendance;
	}

	public void setSettingAttendance(boolean settingAttendance) {
		this.settingAttendance = settingAttendance;
	}

}
