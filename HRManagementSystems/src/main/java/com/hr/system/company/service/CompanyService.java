package com.hr.system.company.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.system.company.bean.AnnouncementAccessBean;
import com.hr.system.company.bean.DepartmentAccessBean;
import com.hr.system.company.bean.EmployeeTypeAccessBean;
import com.hr.system.company.bean.JobTitleAccessBean;
import com.hr.system.company.bean.NotificationAccessBean;
import com.hr.system.company.bean.ProjectAccessBean;
import com.hr.system.company.bean.RoleAccessBean;
import com.hr.system.company.bean.SubDepartmentAccessBean;
import com.hr.system.company.bean.SubRoleAccessBean;
import com.hr.system.company.bean.WorkLocationAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.bean.QualificationTypeAccessBean;

public interface CompanyService {

	List<EmployeeTypeAccessBean> findAllEmployeeType();

	List<WorkLocationAccessBean> findAllWorkLocation();

	List<DepartmentAccessBean> findAllDepartment();

	List<Map<String, Object>> findAllSubDepartment();

	List<JobTitleAccessBean> findAllJobTitle();

	List<ProjectAccessBean> findAllProject();

	List<QualificationTypeAccessBean> findAllQuali();

	List<RoleAccessBean> findAllRole();

	List<Map<String, Object>> findAllSubRole();

	EmployeeAccessBean addEmployee(EmployeeAccessBean employeeAccessBean);

	DepartmentAccessBean addDepartment(DepartmentAccessBean departmentAccessBean);

	SubDepartmentAccessBean addSubDepartment(SubDepartmentAccessBean subDepartmentAccessBean);

	RoleAccessBean addRole(RoleAccessBean roleAccessBean);

	SubRoleAccessBean addSubRole(SubRoleAccessBean subRoleAccessBean);

	WorkLocationAccessBean addWorkLocation(WorkLocationAccessBean workLocationAccessBean);

	ProjectAccessBean addProject(ProjectAccessBean projectAccessBean);

	List<Map<String, Object>> findEmployeeList();

	List<DepartmentAccessBean> findDepartmentByWorkLocationId(Long workLocationId);

	WorkLocationAccessBean findByWorkLocationId(Long workLocationId);

	DepartmentAccessBean findByDepartmentId(Long departmentId);

	void deleteDepartment(HttpServletResponse res, RedirectAttributes flashAttributes, Long departmentId);

	void deleteWorkLocation(HttpServletResponse res, RedirectAttributes flashAttributes, Long workLocationId);

	SubDepartmentAccessBean findBySubDepartmentId(Long subDepartmentId);

	void deleteSubDepartment(HttpServletResponse res, RedirectAttributes flashAttributes, Long subDepartmentId);

	RoleAccessBean findByRoleId(Long roleId);

	void deleteRole(HttpServletResponse res, RedirectAttributes flashAttributes, Long roleId);

	SubRoleAccessBean findBySubRoleId(Long subRoleId);

	void deleteSubRole(HttpServletResponse res, RedirectAttributes flashAttributes, Long subRoleId);

	List<AnnouncementAccessBean> findAllAnnouncement();

	AnnouncementAccessBean addAnnouncement(AnnouncementAccessBean announcementAccessBean);

	AnnouncementAccessBean findByAnnouncementId(Long announcementId);

	void deleteAnnouncement(HttpServletResponse res, RedirectAttributes flashAttributes, Long announcementId);

	List<Map<String, Object>> findAllNotitfications(boolean b);

}
