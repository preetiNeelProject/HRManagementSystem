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
@Table(name = "payrollpermission")
public class PayrollPermissionAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PayrollPermissionId")
	private Long payrollPermissionId;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "payrollPermissionAccessBean")
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "AddRunPayroll")
	private boolean addRunPayroll;

	@Column(name = "ViewRunPayroll")
	private boolean viewRunPayroll;

	@Column(name = "EditRunPayroll")
	private boolean editRunPayroll;

	@Column(name = "DeleteRunPayroll")
	private boolean deleteRunPayroll;

	@Column(name = "UploadRunPayroll")
	private boolean uploadRunPayroll;

	@Column(name = "DownloadRunPayroll")
	private boolean downloadRunPayroll;

	@Column(name = "ApprovelRunPayroll")
	private boolean approvelRunPayroll;

	@Column(name = "BalanceRunPayroll")
	private boolean balanceRunPayroll;

	@Column(name = "SetRulesRunPayroll")
	private boolean setRulesRunPayroll;

	@Column(name = "SettingRunPayroll")
	private boolean settingRunPayroll;

	@Column(name = "AddSalaryStructure")
	private boolean addSalaryStructure;

	@Column(name = "ViewSalaryStructure")
	private boolean viewSalaryStructure;

	@Column(name = "EditSalaryStructure")
	private boolean editSalaryStructure;

	@Column(name = "DeleteSalaryStructure")
	private boolean deleteSalaryStructure;

	@Column(name = "UploadSalaryStructure")
	private boolean uploadSalaryStructure;

	@Column(name = "DownloadSalaryStructure")
	private boolean downloadSalaryStructure;

	@Column(name = "ApprovelSalaryStructure")
	private boolean approvelSalaryStructure;

	@Column(name = "AssignSalaryStructure")
	private boolean assignSalaryStructure;

	@Column(name = "AddSalaryComponent")
	private boolean addSalaryComponent;

	@Column(name = "ViewSalaryComponent")
	private boolean viewSalaryComponent;

	@Column(name = "EditSalaryComponent")
	private boolean editSalaryComponent;

	@Column(name = "DeleteSalaryComponent")
	private boolean deleteSalaryComponent;

	@Column(name = "AddSalaryOverview")
	private boolean addSalaryOverview;

	@Column(name = "ViewSalaryOverview")
	private boolean viewSalaryOverview;

	@Column(name = "EditSalaryOverview")
	private boolean editSalaryOverview;

	@Column(name = "DeleteSalaryOverview")
	private boolean deleteSalaryOverview;

	@Column(name = "UploadSalaryOverview")
	private boolean uploadSalaryOverview;

	@Column(name = "DownloadSalaryOverview")
	private boolean downloadSalaryOverview;

	@Column(name = "ApprovelSalaryOverview")
	private boolean approvelSalaryOverview;

	@Column(name = "AddDeclaration")
	private boolean addDeclaration;

	@Column(name = "ViewDeclaration")
	private boolean viewDeclaration;

	@Column(name = "EditDeclaration")
	private boolean editDeclaration;

	@Column(name = "DeleteDeclaration")
	private boolean deleteDeclaration;

	@Column(name = "UploadDeclaration")
	private boolean uploadDeclaration;

	@Column(name = "DownloadDeclaration")
	private boolean downloadDeclaration;

	@Column(name = "ApprovelDeclaration")
	private boolean approvelDeclaration;

	public Long getPayrollPermissionId() {
		return payrollPermissionId;
	}

	public void setPayrollPermissionId(Long payrollPermissionId) {
		this.payrollPermissionId = payrollPermissionId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public boolean isAddRunPayroll() {
		return addRunPayroll;
	}

	public void setAddRunPayroll(boolean addRunPayroll) {
		this.addRunPayroll = addRunPayroll;
	}

	public boolean isViewRunPayroll() {
		return viewRunPayroll;
	}

	public void setViewRunPayroll(boolean viewRunPayroll) {
		this.viewRunPayroll = viewRunPayroll;
	}

	public boolean isEditRunPayroll() {
		return editRunPayroll;
	}

	public void setEditRunPayroll(boolean editRunPayroll) {
		this.editRunPayroll = editRunPayroll;
	}

	public boolean isDeleteRunPayroll() {
		return deleteRunPayroll;
	}

	public void setDeleteRunPayroll(boolean deleteRunPayroll) {
		this.deleteRunPayroll = deleteRunPayroll;
	}

	public boolean isUploadRunPayroll() {
		return uploadRunPayroll;
	}

	public void setUploadRunPayroll(boolean uploadRunPayroll) {
		this.uploadRunPayroll = uploadRunPayroll;
	}

	public boolean isDownloadRunPayroll() {
		return downloadRunPayroll;
	}

	public void setDownloadRunPayroll(boolean downloadRunPayroll) {
		this.downloadRunPayroll = downloadRunPayroll;
	}

	public boolean isApprovelRunPayroll() {
		return approvelRunPayroll;
	}

	public void setApprovelRunPayroll(boolean approvelRunPayroll) {
		this.approvelRunPayroll = approvelRunPayroll;
	}

	public boolean isBalanceRunPayroll() {
		return balanceRunPayroll;
	}

	public void setBalanceRunPayroll(boolean balanceRunPayroll) {
		this.balanceRunPayroll = balanceRunPayroll;
	}

	public boolean isSetRulesRunPayroll() {
		return setRulesRunPayroll;
	}

	public void setSetRulesRunPayroll(boolean setRulesRunPayroll) {
		this.setRulesRunPayroll = setRulesRunPayroll;
	}

	public boolean isSettingRunPayroll() {
		return settingRunPayroll;
	}

	public void setSettingRunPayroll(boolean settingRunPayroll) {
		this.settingRunPayroll = settingRunPayroll;
	}

	public boolean isAddSalaryStructure() {
		return addSalaryStructure;
	}

	public void setAddSalaryStructure(boolean addSalaryStructure) {
		this.addSalaryStructure = addSalaryStructure;
	}

	public boolean isViewSalaryStructure() {
		return viewSalaryStructure;
	}

	public void setViewSalaryStructure(boolean viewSalaryStructure) {
		this.viewSalaryStructure = viewSalaryStructure;
	}

	public boolean isEditSalaryStructure() {
		return editSalaryStructure;
	}

	public void setEditSalaryStructure(boolean editSalaryStructure) {
		this.editSalaryStructure = editSalaryStructure;
	}

	public boolean isDeleteSalaryStructure() {
		return deleteSalaryStructure;
	}

	public void setDeleteSalaryStructure(boolean deleteSalaryStructure) {
		this.deleteSalaryStructure = deleteSalaryStructure;
	}

	public boolean isUploadSalaryStructure() {
		return uploadSalaryStructure;
	}

	public void setUploadSalaryStructure(boolean uploadSalaryStructure) {
		this.uploadSalaryStructure = uploadSalaryStructure;
	}

	public boolean isDownloadSalaryStructure() {
		return downloadSalaryStructure;
	}

	public void setDownloadSalaryStructure(boolean downloadSalaryStructure) {
		this.downloadSalaryStructure = downloadSalaryStructure;
	}

	public boolean isApprovelSalaryStructure() {
		return approvelSalaryStructure;
	}

	public void setApprovelSalaryStructure(boolean approvelSalaryStructure) {
		this.approvelSalaryStructure = approvelSalaryStructure;
	}

	public boolean isAssignSalaryStructure() {
		return assignSalaryStructure;
	}

	public void setAssignSalaryStructure(boolean assignSalaryStructure) {
		this.assignSalaryStructure = assignSalaryStructure;
	}

	public boolean isAddSalaryComponent() {
		return addSalaryComponent;
	}

	public void setAddSalaryComponent(boolean addSalaryComponent) {
		this.addSalaryComponent = addSalaryComponent;
	}

	public boolean isViewSalaryComponent() {
		return viewSalaryComponent;
	}

	public void setViewSalaryComponent(boolean viewSalaryComponent) {
		this.viewSalaryComponent = viewSalaryComponent;
	}

	public boolean isEditSalaryComponent() {
		return editSalaryComponent;
	}

	public void setEditSalaryComponent(boolean editSalaryComponent) {
		this.editSalaryComponent = editSalaryComponent;
	}

	public boolean isDeleteSalaryComponent() {
		return deleteSalaryComponent;
	}

	public void setDeleteSalaryComponent(boolean deleteSalaryComponent) {
		this.deleteSalaryComponent = deleteSalaryComponent;
	}

	public boolean isAddSalaryOverview() {
		return addSalaryOverview;
	}

	public void setAddSalaryOverview(boolean addSalaryOverview) {
		this.addSalaryOverview = addSalaryOverview;
	}

	public boolean isViewSalaryOverview() {
		return viewSalaryOverview;
	}

	public void setViewSalaryOverview(boolean viewSalaryOverview) {
		this.viewSalaryOverview = viewSalaryOverview;
	}

	public boolean isEditSalaryOverview() {
		return editSalaryOverview;
	}

	public void setEditSalaryOverview(boolean editSalaryOverview) {
		this.editSalaryOverview = editSalaryOverview;
	}

	public boolean isDeleteSalaryOverview() {
		return deleteSalaryOverview;
	}

	public void setDeleteSalaryOverview(boolean deleteSalaryOverview) {
		this.deleteSalaryOverview = deleteSalaryOverview;
	}

	public boolean isUploadSalaryOverview() {
		return uploadSalaryOverview;
	}

	public void setUploadSalaryOverview(boolean uploadSalaryOverview) {
		this.uploadSalaryOverview = uploadSalaryOverview;
	}

	public boolean isDownloadSalaryOverview() {
		return downloadSalaryOverview;
	}

	public void setDownloadSalaryOverview(boolean downloadSalaryOverview) {
		this.downloadSalaryOverview = downloadSalaryOverview;
	}

	public boolean isApprovelSalaryOverview() {
		return approvelSalaryOverview;
	}

	public void setApprovelSalaryOverview(boolean approvelSalaryOverview) {
		this.approvelSalaryOverview = approvelSalaryOverview;
	}

	public boolean isAddDeclaration() {
		return addDeclaration;
	}

	public void setAddDeclaration(boolean addDeclaration) {
		this.addDeclaration = addDeclaration;
	}

	public boolean isViewDeclaration() {
		return viewDeclaration;
	}

	public void setViewDeclaration(boolean viewDeclaration) {
		this.viewDeclaration = viewDeclaration;
	}

	public boolean isEditDeclaration() {
		return editDeclaration;
	}

	public void setEditDeclaration(boolean editDeclaration) {
		this.editDeclaration = editDeclaration;
	}

	public boolean isDeleteDeclaration() {
		return deleteDeclaration;
	}

	public void setDeleteDeclaration(boolean deleteDeclaration) {
		this.deleteDeclaration = deleteDeclaration;
	}

	public boolean isUploadDeclaration() {
		return uploadDeclaration;
	}

	public void setUploadDeclaration(boolean uploadDeclaration) {
		this.uploadDeclaration = uploadDeclaration;
	}

	public boolean isDownloadDeclaration() {
		return downloadDeclaration;
	}

	public void setDownloadDeclaration(boolean downloadDeclaration) {
		this.downloadDeclaration = downloadDeclaration;
	}

	public boolean isApprovelDeclaration() {
		return approvelDeclaration;
	}

	public void setApprovelDeclaration(boolean approvelDeclaration) {
		this.approvelDeclaration = approvelDeclaration;
	}

}
