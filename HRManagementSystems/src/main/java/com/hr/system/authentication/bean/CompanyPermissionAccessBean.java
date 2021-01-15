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
@Table(name = "companypermission")
public class CompanyPermissionAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CompanyPermissionId")
	private Long companyPermissionId;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "companyPermissionAccessBean")
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "AddBranch")
	private boolean addBranch;

	@Column(name = "ViewBranch")
	private boolean viewBranch;

	@Column(name = "EditBranch")
	private boolean editBranch;

	@Column(name = "DeleteBranch")
	private boolean deleteBranch;

	@Column(name = "AddDepartment")
	private boolean addDepartment;

	@Column(name = "ViewDepartment")
	private boolean viewDepartment;

	@Column(name = "EditDepartment")
	private boolean editDepartment;

	@Column(name = "DeleteDepartment")
	private boolean deleteDepartment;

	@Column(name = "AddJobTitle")
	private boolean addJobTitle;

	@Column(name = "ViewJobTitle")
	private boolean viewJobTitle;

	@Column(name = "EditJobTitle")
	private boolean editJobTitle;

	@Column(name = "DeleteJobTitle")
	private boolean deleteJobTitle;

	@Column(name = "AddAnnouncement")
	private boolean addAnnouncement;

	@Column(name = "ViewAnnouncement")
	private boolean viewAnnouncement;

	@Column(name = "EditAnnouncement")
	private boolean editAnnouncement;

	@Column(name = "DeleteAnnouncement")
	private boolean deleteAnnouncement;

	@Column(name = "AddPolicies")
	private boolean addPolicies;

	@Column(name = "ViewPolicies")
	private boolean viewPolicies;

	@Column(name = "EditPolicies")
	private boolean editPolicies;

	@Column(name = "DeletePolicies")
	private boolean deletePolicies;

	@Column(name = "UploadPolicies")
	private boolean uploadPolicies;

	@Column(name = "DownloadPolicies")
	private boolean downloadPolicies;

	public Long getCompanyPermissionId() {
		return companyPermissionId;
	}

	public void setCompanyPermissionId(Long companyPermissionId) {
		this.companyPermissionId = companyPermissionId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public boolean isAddBranch() {
		return addBranch;
	}

	public void setAddBranch(boolean addBranch) {
		this.addBranch = addBranch;
	}

	public boolean isViewBranch() {
		return viewBranch;
	}

	public void setViewBranch(boolean viewBranch) {
		this.viewBranch = viewBranch;
	}

	public boolean isEditBranch() {
		return editBranch;
	}

	public void setEditBranch(boolean editBranch) {
		this.editBranch = editBranch;
	}

	public boolean isDeleteBranch() {
		return deleteBranch;
	}

	public void setDeleteBranch(boolean deleteBranch) {
		this.deleteBranch = deleteBranch;
	}

	public boolean isAddDepartment() {
		return addDepartment;
	}

	public void setAddDepartment(boolean addDepartment) {
		this.addDepartment = addDepartment;
	}

	public boolean isViewDepartment() {
		return viewDepartment;
	}

	public void setViewDepartment(boolean viewDepartment) {
		this.viewDepartment = viewDepartment;
	}

	public boolean isEditDepartment() {
		return editDepartment;
	}

	public void setEditDepartment(boolean editDepartment) {
		this.editDepartment = editDepartment;
	}

	public boolean isDeleteDepartment() {
		return deleteDepartment;
	}

	public void setDeleteDepartment(boolean deleteDepartment) {
		this.deleteDepartment = deleteDepartment;
	}

	public boolean isAddJobTitle() {
		return addJobTitle;
	}

	public void setAddJobTitle(boolean addJobTitle) {
		this.addJobTitle = addJobTitle;
	}

	public boolean isViewJobTitle() {
		return viewJobTitle;
	}

	public void setViewJobTitle(boolean viewJobTitle) {
		this.viewJobTitle = viewJobTitle;
	}

	public boolean isEditJobTitle() {
		return editJobTitle;
	}

	public void setEditJobTitle(boolean editJobTitle) {
		this.editJobTitle = editJobTitle;
	}

	public boolean isDeleteJobTitle() {
		return deleteJobTitle;
	}

	public void setDeleteJobTitle(boolean deleteJobTitle) {
		this.deleteJobTitle = deleteJobTitle;
	}

	public boolean isAddAnnouncement() {
		return addAnnouncement;
	}

	public void setAddAnnouncement(boolean addAnnouncement) {
		this.addAnnouncement = addAnnouncement;
	}

	public boolean isViewAnnouncement() {
		return viewAnnouncement;
	}

	public void setViewAnnouncement(boolean viewAnnouncement) {
		this.viewAnnouncement = viewAnnouncement;
	}

	public boolean isEditAnnouncement() {
		return editAnnouncement;
	}

	public void setEditAnnouncement(boolean editAnnouncement) {
		this.editAnnouncement = editAnnouncement;
	}

	public boolean isDeleteAnnouncement() {
		return deleteAnnouncement;
	}

	public void setDeleteAnnouncement(boolean deleteAnnouncement) {
		this.deleteAnnouncement = deleteAnnouncement;
	}

	public boolean isAddPolicies() {
		return addPolicies;
	}

	public void setAddPolicies(boolean addPolicies) {
		this.addPolicies = addPolicies;
	}

	public boolean isViewPolicies() {
		return viewPolicies;
	}

	public void setViewPolicies(boolean viewPolicies) {
		this.viewPolicies = viewPolicies;
	}

	public boolean isEditPolicies() {
		return editPolicies;
	}

	public void setEditPolicies(boolean editPolicies) {
		this.editPolicies = editPolicies;
	}

	public boolean isDeletePolicies() {
		return deletePolicies;
	}

	public void setDeletePolicies(boolean deletePolicies) {
		this.deletePolicies = deletePolicies;
	}

	public boolean isUploadPolicies() {
		return uploadPolicies;
	}

	public void setUploadPolicies(boolean uploadPolicies) {
		this.uploadPolicies = uploadPolicies;
	}

	public boolean isDownloadPolicies() {
		return downloadPolicies;
	}

	public void setDownloadPolicies(boolean downloadPolicies) {
		this.downloadPolicies = downloadPolicies;
	}

}
