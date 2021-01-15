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
@Table(name = "directorypermission")
public class DirectoryPermissionAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DirectoryPermissionId")
	private Long directoryPermissionId;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "directoryPermissionAccessBean")
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "AddEmployee")
	private boolean addEmployee;

	@Column(name = "ViewEmployee")
	private boolean viewEmployee;

	@Column(name = "EditEmployee")
	private boolean editEmployee;

	@Column(name = "DeleteEmployee")
	private boolean deleteEmployee;

	@Column(name = "UploadEmployee")
	private boolean uploadEmployee;

	@Column(name = "DownloadEmployee")
	private boolean downloadEmployee;

	public Long getDirectoryPermissionId() {
		return directoryPermissionId;
	}

	public void setDirectoryPermissionId(Long directoryPermissionId) {
		this.directoryPermissionId = directoryPermissionId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public boolean isAddEmployee() {
		return addEmployee;
	}

	public void setAddEmployee(boolean addEmployee) {
		this.addEmployee = addEmployee;
	}

	public boolean isViewEmployee() {
		return viewEmployee;
	}

	public void setViewEmployee(boolean viewEmployee) {
		this.viewEmployee = viewEmployee;
	}

	public boolean isEditEmployee() {
		return editEmployee;
	}

	public void setEditEmployee(boolean editEmployee) {
		this.editEmployee = editEmployee;
	}

	public boolean isDeleteEmployee() {
		return deleteEmployee;
	}

	public void setDeleteEmployee(boolean deleteEmployee) {
		this.deleteEmployee = deleteEmployee;
	}

	public boolean isUploadEmployee() {
		return uploadEmployee;
	}

	public void setUploadEmployee(boolean uploadEmployee) {
		this.uploadEmployee = uploadEmployee;
	}

	public boolean isDownloadEmployee() {
		return downloadEmployee;
	}

	public void setDownloadEmployee(boolean downloadEmployee) {
		this.downloadEmployee = downloadEmployee;
	}

}
