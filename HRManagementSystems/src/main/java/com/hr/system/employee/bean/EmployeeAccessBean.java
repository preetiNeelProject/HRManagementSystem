package com.hr.system.employee.bean;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hr.system.authentication.bean.AttendancePermissionAccessBean;
import com.hr.system.authentication.bean.CompanyPermissionAccessBean;
import com.hr.system.authentication.bean.DirectoryPermissionAccessBean;
import com.hr.system.authentication.bean.LeavePermissionAccessBean;
import com.hr.system.authentication.bean.PayrollPermissionAccessBean;
import com.hr.system.company.bean.EmpWorkRelationAccessBean;
import com.hr.system.company.bean.RoleAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "employee")
public class EmployeeAccessBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId", nullable = false, unique = true)
	private Long employeeId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<AddressAccessBean> addressAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<EmergencyAccessBean> emergencyAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<DependentsAccessBean> dependentsAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<ExperienceAccessBean> experienceAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<EducationAccessBean> educationAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<DocumentAccessBean> documentAccessBean;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeAccessBean")
	private EmpWorkRelationAccessBean empWorkRelationAccessBean;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeAccessBean")
	private AccountDetailsAccessBean accountDetailsAccessBean;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "attendancePermissionId", referencedColumnName = "attendancePermissionId")
	private AttendancePermissionAccessBean attendancePermissionAccessBean;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "companyPermissionId", referencedColumnName = "companyPermissionId")
	private CompanyPermissionAccessBean companyPermissionAccessBean;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "directoryPermissionId", referencedColumnName = "directoryPermissionId")
	private DirectoryPermissionAccessBean directoryPermissionAccessBean;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "leavePermissionId", referencedColumnName = "leavePermissionId")
	private LeavePermissionAccessBean leavePermissionAccessBean;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payrollPermissionId", referencedColumnName = "payrollPermissionId")
	private PayrollPermissionAccessBean payrollPermissionAccessBean;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_roles", joinColumns = @JoinColumn(name = "employeeId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<RoleAccessBean> role = new HashSet<>();

	@Column(name = "LogonId")
	private String logonId;

	@Column(name = "LogonPassword")
	private String logonPassword;

	@Column(name = "Roles")
	private String roles;

	@Column(name = "EmployeeCode")
	private String employeeCode;

	@Column(name = "EmployeeStatus")
	private String employeeStatus;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getLogonId() {
		return logonId;
	}

	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}

	public String getLogonPassword() {
		return logonPassword;
	}

	public void setLogonPassword(String logonPassword) {
		this.logonPassword = new BCryptPasswordEncoder(10, new SecureRandom()).encode(logonPassword);
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public List<AddressAccessBean> getAddressAccessBean() {
		return addressAccessBean;
	}

	public void setAddressAccessBean(List<AddressAccessBean> addressAccessBean) {
		this.addressAccessBean = addressAccessBean;
	}

	public List<EmergencyAccessBean> getEmergencyAccessBean() {
		return emergencyAccessBean;
	}

	public void setEmergencyAccessBean(List<EmergencyAccessBean> emergencyAccessBean) {
		this.emergencyAccessBean = emergencyAccessBean;
	}

	public List<DependentsAccessBean> getDependentsAccessBean() {
		return dependentsAccessBean;
	}

	public void setDependentsAccessBean(List<DependentsAccessBean> dependentsAccessBean) {
		this.dependentsAccessBean = dependentsAccessBean;
	}

	public List<ExperienceAccessBean> getExperienceAccessBean() {
		return experienceAccessBean;
	}

	public void setExperienceAccessBean(List<ExperienceAccessBean> experienceAccessBean) {
		this.experienceAccessBean = experienceAccessBean;
	}

	public List<EducationAccessBean> getEducationAccessBean() {
		return educationAccessBean;
	}

	public void setEducationAccessBean(List<EducationAccessBean> educationAccessBean) {
		this.educationAccessBean = educationAccessBean;
	}

	public EmpWorkRelationAccessBean getEmpWorkRelationAccessBean() {
		return empWorkRelationAccessBean;
	}

	public void setEmpWorkRelationAccessBean(EmpWorkRelationAccessBean empWorkRelationAccessBean) {
		this.empWorkRelationAccessBean = empWorkRelationAccessBean;
	}

	public AccountDetailsAccessBean getAccountDetailsAccessBean() {
		return accountDetailsAccessBean;
	}

	public void setAccountDetailsAccessBean(AccountDetailsAccessBean accountDetailsAccessBean) {
		this.accountDetailsAccessBean = accountDetailsAccessBean;
	}

	public List<DocumentAccessBean> getDocumentAccessBean() {
		return documentAccessBean;
	}

	public AttendancePermissionAccessBean getAttendancePermissionAccessBean() {
		return attendancePermissionAccessBean;
	}

	public void setAttendancePermissionAccessBean(AttendancePermissionAccessBean attendancePermissionAccessBean) {
		this.attendancePermissionAccessBean = attendancePermissionAccessBean;
	}

	public CompanyPermissionAccessBean getCompanyPermissionAccessBean() {
		return companyPermissionAccessBean;
	}

	public void setCompanyPermissionAccessBean(CompanyPermissionAccessBean companyPermissionAccessBean) {
		this.companyPermissionAccessBean = companyPermissionAccessBean;
	}

	public DirectoryPermissionAccessBean getDirectoryPermissionAccessBean() {
		return directoryPermissionAccessBean;
	}

	public void setDirectoryPermissionAccessBean(DirectoryPermissionAccessBean directoryPermissionAccessBean) {
		this.directoryPermissionAccessBean = directoryPermissionAccessBean;
	}

	public LeavePermissionAccessBean getLeavePermissionAccessBean() {
		return leavePermissionAccessBean;
	}

	public void setLeavePermissionAccessBean(LeavePermissionAccessBean leavePermissionAccessBean) {
		this.leavePermissionAccessBean = leavePermissionAccessBean;
	}

	public PayrollPermissionAccessBean getPayrollPermissionAccessBean() {
		return payrollPermissionAccessBean;
	}

	public void setPayrollPermissionAccessBean(PayrollPermissionAccessBean payrollPermissionAccessBean) {
		this.payrollPermissionAccessBean = payrollPermissionAccessBean;
	}

	public List<String> getRoleList() {
		if (this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}

	public Set<RoleAccessBean> getRole() {
		return role;
	}

	public void setRole(Set<RoleAccessBean> role) {
		this.role = role;
	}

	/*
	 * public List<String> getPermissionList(){
	 * if(this.attendancePermissionAccessBean.equals(0)){ return
	 * Arrays.asList(this.attendancePermissionAccessBean.split(",")); } return new
	 * ArrayList<>(); }
	 */

	/*
	 * public void setDocumentAccessBean(List<DocumentAccessBean>
	 * documentAccessBean) { this.documentAccessBean = documentAccessBean; }
	 */
}