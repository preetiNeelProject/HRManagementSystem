package com.hr.system.company.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.system.common.controller.CommonControllerCmd;
import com.hr.system.company.bean.AnnouncementAccessBean;
import com.hr.system.company.bean.DepartmentAccessBean;
import com.hr.system.company.bean.EmpWorkRelationAccessBean;
import com.hr.system.company.bean.EmployeeTypeAccessBean;
import com.hr.system.company.bean.JobTitleAccessBean;
import com.hr.system.company.bean.NotificationAccessBean;
import com.hr.system.company.bean.ProjectAccessBean;
import com.hr.system.company.bean.RoleAccessBean;
import com.hr.system.company.bean.SubDepartmentAccessBean;
import com.hr.system.company.bean.SubRoleAccessBean;
import com.hr.system.company.bean.WorkLocationAccessBean;
import com.hr.system.company.controller.CompanyControllerCmd;
import com.hr.system.company.repository.AnnouncementRepository;
import com.hr.system.company.repository.DepartmentRepository;
import com.hr.system.company.repository.JobTitleRepository;
import com.hr.system.company.repository.ProjectRepository;
import com.hr.system.company.repository.RoleRepository;
import com.hr.system.company.repository.SubDepartmentRepository;
import com.hr.system.company.repository.SubRoleRepository;
import com.hr.system.employee.bean.AccountDetailsAccessBean;
import com.hr.system.employee.bean.AddressAccessBean;
import com.hr.system.employee.bean.DependentsAccessBean;
import com.hr.system.employee.bean.EducationAccessBean;
import com.hr.system.employee.bean.EmergencyAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.bean.QualificationTypeAccessBean;
import com.hr.system.employee.repository.AddressRepository;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.employee.repository.EmployeeTypeRepository;
import com.hr.system.employee.repository.QualificationTypeRepository;
import com.hr.system.employee.repository.WorkLocationRepository;
import com.hr.system.company.repository.NotificationRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeTypeRepository employeeTypeRepository;

	@Autowired
	WorkLocationRepository workLocationRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	SubDepartmentRepository subDepartmentRepository;

	@Autowired
	JobTitleRepository jobTitleRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	QualificationTypeRepository qualificationRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	SubRoleRepository subRoleRepository;

	@Autowired
	AnnouncementRepository announcementRepository;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CommonControllerCmd commonControllerCmd;

	@Override
	public List<EmployeeTypeAccessBean> findAllEmployeeType() {
		return employeeTypeRepository.findAll();
	}

	@Override
	public List<WorkLocationAccessBean> findAllWorkLocation() {
		return workLocationRepository.findAll();
	}

	@Override
	public List<DepartmentAccessBean> findAllDepartment() {
		return departmentRepository.findAll();
	}

	@Override
	public List<Map<String, Object>> findAllSubDepartment() {
		List<SubDepartmentAccessBean> subDepartmentList = subDepartmentRepository.findAll();
		/*******************
		 * LOGIC TO DISPLAY ONLY SELECTED VALUES IN DEPARTMENT DISPLAY PAGE
		 **************************************/
		List<Map<String, Object>> responseSubDepartmentList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < subDepartmentList.size(); i++) {

			Map<String, Object> departmentMap = new HashMap<String, Object>();
			departmentMap.put("subDepartmentId", subDepartmentList.get(i).getSubDepartmentId());
			DepartmentAccessBean departmentAccessBean = departmentRepository
					.getOne(subDepartmentList.get(i).getDepartmentId());
			departmentMap.put("departmentName", departmentAccessBean.getDeptName());
			departmentMap.put("deptName", subDepartmentList.get(i).getDeptName());
			departmentMap.put("deptDesc", subDepartmentList.get(i).getDeptDesc());
			departmentMap.put("workDesc", subDepartmentList.get(i).getWorkDesc());
			departmentMap.put("managerId", departmentAccessBean.getManagerId());
			departmentMap.put("totalEmployee", subDepartmentList.get(i).getTotalEmployee());
			departmentMap.put("maxEmployee", subDepartmentList.get(i).getMaxEmployee());
			departmentMap.put("minEmployee", subDepartmentList.get(i).getMinEmployee());

			responseSubDepartmentList.add(departmentMap);
		}

		return responseSubDepartmentList;
	}

	@Override
	public List<JobTitleAccessBean> findAllJobTitle() {
		return jobTitleRepository.findAll();
	}

	@Override
	public List<ProjectAccessBean> findAllProject() {
		return projectRepository.findAll();
	}

	@Override
	public List<QualificationTypeAccessBean> findAllQuali() {
		return qualificationRepository.findAll();
	}

	@Override
	public List<RoleAccessBean> findAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public List<Map<String, Object>> findAllSubRole() {

		List<SubRoleAccessBean> subRoleList = subRoleRepository.findAll();

		/*******************
		 * LOGIC TO DISPLAY ONLY SELECTED VALUES IN SUB-ROLE DISPLAY PAGE
		 **************************************/
		List<Map<String, Object>> responseSubRoleList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < subRoleList.size(); i++) {

			Map<String, Object> roleMap = new HashMap<String, Object>();
			roleMap.put("subRoleId", subRoleList.get(i).getSubRoleId());
			RoleAccessBean roleAccessBean = roleRepository.getOne(subRoleList.get(i).getRoleId());
			roleMap.put("roleNames", roleAccessBean.getRoleName());
			roleMap.put("roleName", subRoleList.get(i).getRoleName());
			roleMap.put("roleType", subRoleList.get(i).getRoleType());
			roleMap.put("roleDesc", subRoleList.get(i).getRoleDesc());

			responseSubRoleList.add(roleMap);
		}

		return responseSubRoleList;
	}

	@Override
	public EmployeeAccessBean addEmployee(EmployeeAccessBean employeeAccessBean) {

		commonControllerCmd.addNotifications(employeeAccessBean.getEmployeeId(),
				"Add New Employee by " + employeeAccessBean.getEmpWorkRelationAccessBean().getManager() + ".");

		List<AddressAccessBean> manageEmployeeAddressSet = new ArrayList<AddressAccessBean>();
		List<AccountDetailsAccessBean> manageEmployeeAccountSet = new ArrayList<AccountDetailsAccessBean>();
		List<EmpWorkRelationAccessBean> manageEmployeeWorkSet = new ArrayList<EmpWorkRelationAccessBean>();
		List<EducationAccessBean> manageEmployeeEducationSet = new ArrayList<EducationAccessBean>();
		List<DependentsAccessBean> manageEmployeeDependentsSet = new ArrayList<DependentsAccessBean>();
		List<EmergencyAccessBean> manageEmployeeEmergencySet = new ArrayList<EmergencyAccessBean>();
		// List<DocumentAccessBean> manageDocumentSet = new
		// ArrayList<DocumentAccessBean>();

		if (employeeAccessBean.getAddressAccessBean() != null) {
			Iterator<AddressAccessBean> employeeAddressItr = employeeAccessBean.getAddressAccessBean().iterator();
			while (employeeAddressItr.hasNext()) {
				AddressAccessBean employeeAddress = employeeAddressItr.next();
				employeeAddress.setEmployeeAccessBean(employeeAccessBean);
				manageEmployeeAddressSet.add(employeeAddress);
			}
		}

		if (employeeAccessBean.getAccountDetailsAccessBean() != null) {
			AccountDetailsAccessBean employeeAccountItr = employeeAccessBean.getAccountDetailsAccessBean();
			employeeAccountItr.setEmployeeAccessBean(employeeAccessBean);
			manageEmployeeAccountSet.add(employeeAccountItr);
		}

		if (employeeAccessBean.getEmpWorkRelationAccessBean() != null) {
			EmpWorkRelationAccessBean employeeWorkItr = employeeAccessBean.getEmpWorkRelationAccessBean();
			employeeWorkItr.setEmployeeAccessBean(employeeAccessBean);
			manageEmployeeWorkSet.add(employeeWorkItr);
		}

		if (employeeAccessBean.getEducationAccessBean() != null) {
			Iterator<EducationAccessBean> employeeEducationItr = employeeAccessBean.getEducationAccessBean().iterator();
			while (employeeEducationItr.hasNext()) {

				EducationAccessBean employeeEducation = employeeEducationItr.next();
				employeeEducation.setEmployeeAccessBean(employeeAccessBean);
				manageEmployeeEducationSet.add(employeeEducation);
			}
		}

		if (employeeAccessBean.getDependentsAccessBean() != null) {
			Iterator<DependentsAccessBean> employeeDependentsItr = employeeAccessBean.getDependentsAccessBean()
					.iterator();
			while (employeeDependentsItr.hasNext()) {
				DependentsAccessBean employeeDependents = employeeDependentsItr.next();
				employeeDependents.setEmployeeAccessBean(employeeAccessBean);
				manageEmployeeDependentsSet.add(employeeDependents);
			}
		}

		if (employeeAccessBean.getEmergencyAccessBean() != null) {
			Iterator<EmergencyAccessBean> employeeEmergencyItr = employeeAccessBean.getEmergencyAccessBean().iterator();
			while (employeeEmergencyItr.hasNext()) {
				EmergencyAccessBean employeeEmergency = employeeEmergencyItr.next();
				employeeEmergency.setEmployeeAccessBean(employeeAccessBean);
				manageEmployeeEmergencySet.add(employeeEmergency);
			}
		}

		return employeeRepository.save(employeeAccessBean);
	}

	@Override
	public List<Map<String, Object>> findEmployeeList() {
		List<EmployeeAccessBean> manageEmployeeList = employeeRepository.findAll();
		/***********************************************
		 * LOGIC TO DISPLAY ONLY SELECTED VALUES IN EMPLOYEE DISPLAY PAGE
		 **************************************/
		List<Map<String, Object>> responseEmployeeList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < manageEmployeeList.size(); i++) {

			Map<String, Object> employeeMap = new HashMap<String, Object>();
			employeeMap.put("employeeId", manageEmployeeList.get(i).getEmployeeId());
			System.out.println(manageEmployeeList.get(i).getEmployeeId());
			employeeMap.put("employeeCode", manageEmployeeList.get(i).getEmployeeCode());
			employeeMap.put("loginId", manageEmployeeList.get(i).getLogonId());
			if (manageEmployeeList.get(i).getAddressAccessBean() != null) {
				Iterator<AddressAccessBean> itr = manageEmployeeList.get(i).getAddressAccessBean().iterator();
				while (itr.hasNext()) {
					AddressAccessBean addressAccessBean=itr.next();
					System.out.println(addressAccessBean.getFirstName() +"=="+addressAccessBean.getLastName());
					employeeMap.put("fname", addressAccessBean.getFirstName());
					employeeMap.put("lname", addressAccessBean.getLastName());
					break;
				}
			}
			if (manageEmployeeList.get(i).getEmpWorkRelationAccessBean() != null) {
				EmpWorkRelationAccessBean itr = manageEmployeeList.get(i).getEmpWorkRelationAccessBean();
				employeeMap.put("designation", itr.getDesignation());
				employeeMap.put("manager", itr.getManager());
				if(itr.getDepartmentId() != null) {
					Optional<DepartmentAccessBean> department = departmentRepository.findById(itr.getDepartmentId());
					employeeMap.put("department", department);
				}
				else {
				employeeMap.put("department", "HR");
				}
			}

			responseEmployeeList.add(employeeMap);
		}

		return responseEmployeeList;
	}

	@Override
	public DepartmentAccessBean addDepartment(DepartmentAccessBean departmentAccessBean) {
		commonControllerCmd.addNotifications(110L, "Add New Department : " + departmentAccessBean.getDeptName() + ".");
		return departmentRepository.save(departmentAccessBean);
	}

	@Override
	public SubDepartmentAccessBean addSubDepartment(SubDepartmentAccessBean subDepartmentAccessBean) {
		return subDepartmentRepository.save(subDepartmentAccessBean);
	}

	@Override
	public RoleAccessBean addRole(RoleAccessBean roleAccessBean) {
		commonControllerCmd.addNotifications(110L, "Add New Role : " + roleAccessBean.getRoleName() + ".");
		return roleRepository.save(roleAccessBean);
	}

	@Override
	public SubRoleAccessBean addSubRole(SubRoleAccessBean subRoleAccessBean) {
		return subRoleRepository.save(subRoleAccessBean);
	}

	@Override
	public WorkLocationAccessBean addWorkLocation(WorkLocationAccessBean workLocationAccessBean) {
		return workLocationRepository.save(workLocationAccessBean);
	}

	@Override
	public ProjectAccessBean addProject(ProjectAccessBean projectAccessBean) {
		return projectRepository.save(projectAccessBean);
	}

	@Override
	public List<DepartmentAccessBean> findDepartmentByWorkLocationId(Long workLocationId) {
		return departmentRepository.findByWorkLocationId(workLocationId);
	}

	@Override
	public WorkLocationAccessBean findByWorkLocationId(Long workLocationId) {
		return workLocationRepository.findByWorkLocationId(workLocationId);
	}

	@Override
	public void deleteWorkLocation(HttpServletResponse res, RedirectAttributes flashAttributes, Long workLocationId) {
		workLocationRepository.deleteById(workLocationId);
	}

	@Override
	public DepartmentAccessBean findByDepartmentId(Long departmentId) {
		return departmentRepository.findByDepartmentId(departmentId);
	}

	@Override
	public void deleteDepartment(HttpServletResponse res, RedirectAttributes flashAttributes, Long departmentId) {
		departmentRepository.deleteById(departmentId);
		System.out.println("department deleted");
		boolean flag=subDepartmentRepository.existsByDepartmentId(departmentId);
		System.out.println("existsByDepartmentId"+flag);
		if(flag==true) {
			subDepartmentRepository.deleteByDepartmentId(departmentId);
			System.out.println("sub-department deleted");
		}
		
	}

	@Override
	public SubDepartmentAccessBean findBySubDepartmentId(Long subDepartmentId) {
		return subDepartmentRepository.findBySubDepartmentId(subDepartmentId);
	}

	@Override
	public void deleteSubDepartment(HttpServletResponse res, RedirectAttributes flashAttributes, Long subDepartmentId) {
		subDepartmentRepository.deleteById(subDepartmentId);
	}

	@Override
	public RoleAccessBean findByRoleId(Long roleId) {
		return roleRepository.findByRoleId(roleId);
	}

	@Override
	public void deleteRole(HttpServletResponse res, RedirectAttributes flashAttributes, Long roleId) {
		roleRepository.deleteById(roleId);
		System.out.println("Delete By Id:"+roleId);
	}

	@Override
	public SubRoleAccessBean findBySubRoleId(Long subRoleId) {
		return subRoleRepository.findBySubRoleId(subRoleId);
	}

	@Override
	public void deleteSubRole(HttpServletResponse res, RedirectAttributes flashAttributes, Long subRoleId) {
		subRoleRepository.deleteById(subRoleId);
	}

	@Override
	public List<AnnouncementAccessBean> findAllAnnouncement() {
		return announcementRepository.findAll();
	}

	@Override
	public AnnouncementAccessBean addAnnouncement(AnnouncementAccessBean announcementAccessBean) {
		return announcementRepository.save(announcementAccessBean);
	}

	@Override
	public AnnouncementAccessBean findByAnnouncementId(Long announcementId) {
		return announcementRepository.findByAnnouncementId(announcementId);
	}

	@Override
	public void deleteAnnouncement(HttpServletResponse res, RedirectAttributes flashAttributes, Long announcementId) {
		announcementRepository.deleteById(announcementId);
	}

	@Override
	public List<Map<String, Object>> findAllNotitfications(boolean b) {
		List<NotificationAccessBean> notificationData;
		if (b == true)
			notificationData= notificationRepository.findTop3ByOrderByNotificationIdDesc();
		else {
			notificationData = notificationRepository.findByOrderByNotificationIdDesc();
		}
			List<Map<String, Object>> responseNotificationData = new ArrayList<Map<String, Object>>();

			for (int i = 0; i < notificationData.size(); i++) {
				
				Map<String, Object> notificationMap = new HashMap<String, Object>();
				notificationMap.put("notificationId", notificationData.get(i).getNotificationId());
				String str=commonControllerCmd.dateFromDatabase(notificationData.get(i).getDate());
				notificationMap.put("date", str);
				notificationMap.put("time", notificationData.get(i).getTime());
				notificationMap.put("activity", notificationData.get(i).getActivity());
				if (notificationData.get(i).getEmployeeId() != null) {
					AddressAccessBean addressAccessBean = addressRepository
							.findByEmployeeAccessBean(employeeRepository.findByEmployeeId(notificationData.get(i).getEmployeeId()));
					if (addressRepository.findByEmployeeAccessBean(employeeRepository.findByEmployeeId(notificationData.get(i).getEmployeeId())) != null) {
						Map<String, Object> map = new HashMap<String, Object>();
						notificationMap.put("firstName", addressAccessBean.getFirstName());
						notificationMap.put("lastName", addressAccessBean.getLastName());
						//notificationMap.put("name",map);
					}

				}
				responseNotificationData.add(notificationMap);
			}

			return responseNotificationData;
		

	}

}
