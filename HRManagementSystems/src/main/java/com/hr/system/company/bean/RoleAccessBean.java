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

import com.hr.system.authentication.bean.AttendancePermissionAccessBean;
import com.hr.system.authentication.bean.CompanyPermissionAccessBean;
import com.hr.system.authentication.bean.DirectoryPermissionAccessBean;
import com.hr.system.authentication.bean.LeavePermissionAccessBean;
import com.hr.system.authentication.bean.PayrollPermissionAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "role")
public class RoleAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleId", nullable = false, unique = true)
	private Long roleId;

	

	@Column(name = "RoleName")
	private String roleName;

	@Column(name = "RoleType")
	private String roleType;

	@Column(name = "RoleDesc")
	private String roleDesc;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
