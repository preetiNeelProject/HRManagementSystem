package com.hr.system.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.system.common.controller.CommonControllerCmd;
import com.hr.system.company.bean.ProjectAccessBean;
import com.hr.system.company.repository.ProjectRepository;
import com.hr.system.employee.bean.AccountDetailsAccessBean;
import com.hr.system.employee.bean.DependentsAccessBean;
import com.hr.system.employee.bean.EducationAccessBean;
import com.hr.system.employee.bean.EmergencyAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.AccountDetailsRepository;
import com.hr.system.employee.repository.EducationRepository;
import com.hr.system.employee.repository.EmpWorkRelationRepository;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.employee.repository.QualificationTypeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmpWorkRelationRepository empWorkRelationRepository;

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	QualificationTypeRepository qualificationTypeRepository;

	@Autowired
	EducationRepository educationRepository;
	
	@Autowired
	CommonControllerCmd commonControllerCmd;

	@Override
	public Map<String, Object> findByEmployeeId(Long employeeId) {
		EmployeeAccessBean employeeData = employeeRepository.findByEmployeeId(employeeId);
		Map<String, Object> employeeMap = new HashMap<String, Object>();

		/*-----------Employee Data--------------*/
		
		employeeMap.put("employeeId", employeeData.getEmployeeId());
		employeeMap.put("logonId", employeeData.getLogonId());
		employeeMap.put("logonPassword", employeeData.getLogonPassword());
		employeeMap.put("employeeCode", employeeData.getEmployeeCode());
		employeeMap.put("employeeStatus", employeeData.getEmployeeStatus());

		/*-----------Address Data--------------*/
		
		employeeMap.put("addressId", employeeData.getAddressAccessBean().get(0).getAddressId());
		employeeMap.put("addressType", employeeData.getAddressAccessBean().get(0).getAddressType());
		employeeMap.put("address", employeeData.getAddressAccessBean().get(0).getAddress());
		employeeMap.put("personTitle", employeeData.getAddressAccessBean().get(0).getPersonTitle());
		employeeMap.put("firstName", employeeData.getAddressAccessBean().get(0).getFirstName());
		employeeMap.put("middleName", employeeData.getAddressAccessBean().get(0).getMiddleName());
		employeeMap.put("lastName", employeeData.getAddressAccessBean().get(0).getLastName());
		employeeMap.put("businessTitle", employeeData.getAddressAccessBean().get(0).getBusinessTitle());
		employeeMap.put("gender", employeeData.getAddressAccessBean().get(0).getGender());
		employeeMap.put("age", employeeData.getAddressAccessBean().get(0).getAge());
		employeeMap.put("bloodGroup", employeeData.getAddressAccessBean().get(0).getBloodGroup());
		employeeMap.put("religion", employeeData.getAddressAccessBean().get(0).getReligion());
		employeeMap.put("dob", employeeData.getAddressAccessBean().get(0).getDob());
		employeeMap.put("caste", employeeData.getAddressAccessBean().get(0).getCaste());
		employeeMap.put("nationality", employeeData.getAddressAccessBean().get(0).getNationality());
		employeeMap.put("martialStatus", employeeData.getAddressAccessBean().get(0).getMartialStatus());
		employeeMap.put("phone1", employeeData.getAddressAccessBean().get(0).getPhone1());
		employeeMap.put("phone2", employeeData.getAddressAccessBean().get(0).getPhone2());
		employeeMap.put("email1", employeeData.getAddressAccessBean().get(0).getEmail1());
		employeeMap.put("email2", employeeData.getAddressAccessBean().get(0).getEmail2());
		employeeMap.put("address", employeeData.getAddressAccessBean().get(0).getAddress());
		employeeMap.put("city", employeeData.getAddressAccessBean().get(0).getCity());
		employeeMap.put("stateId", employeeData.getAddressAccessBean().get(0).getStateId());
		employeeMap.put("countryId", employeeData.getAddressAccessBean().get(0).getCountryId());
		employeeMap.put("pincode", employeeData.getAddressAccessBean().get(0).getPincode());
		employeeMap.put("lastCreate", employeeData.getAddressAccessBean().get(0).getLastCreate());
		employeeMap.put("ctc", employeeData.getAddressAccessBean().get(0).getCtc());
		employeeMap.put("experience", employeeData.getAddressAccessBean().get(0).getExperience());
		employeeMap.put("probationPeriod", employeeData.getAddressAccessBean().get(0).getProbationPeriod());
		employeeMap.put("employeeTypeId", employeeData.getAddressAccessBean().get(0).getEmployeeTypeId());
		/*
		 * employeeMap.put("name",employeeData.getAddressAccessBean().get(0).
		 * getPayrollId());
		 */
		
		/*-----------Work Data--------------*/
		
		employeeMap.put("workLocationId", employeeData.getAddressAccessBean().get(0).getWorkLocationId());
		employeeMap.put("jobTitle", employeeData.getAddressAccessBean().get(0).getJobTitleId());
		employeeMap.put("department", employeeData.getEmpWorkRelationAccessBean().getDepartmentId());
		employeeMap.put("designation", employeeData.getEmpWorkRelationAccessBean().getDesignation());
		employeeMap.put("manager", employeeData.getEmpWorkRelationAccessBean().getManager());
		employeeMap.put("empWorkRelationId", employeeData.getEmpWorkRelationAccessBean().getEmpWorkRelationId());

		/*-----------Account Data--------------*/
		
		Optional<AccountDetailsAccessBean> accountDetails = accountDetailsRepository
				.findById(employeeData.getAccountDetailsAccessBean().getAccountDetailId());

		employeeMap.put("accountDetailId", accountDetails.get().getAccountDetailId());
		employeeMap.put("holderName", accountDetails.get().getHolderName());
		employeeMap.put("bankName", accountDetails.get().getBankName());
		employeeMap.put("city", accountDetails.get().getCity());
		employeeMap.put("branchName", accountDetails.get().getBranchName());
		employeeMap.put("ifscCode", accountDetails.get().getIfscCode());
		employeeMap.put("accountNumber", accountDetails.get().getAccountNumber());

		/*-----------Project Data--------------*/
		ProjectAccessBean projectDetail = projectRepository
				.findByProjectId(employeeData.getEmpWorkRelationAccessBean().getProjectId());
		employeeMap.put("project", projectDetail.getProjectCode());

		/*-----------Education Data--------------*/
		
		List<Object> educationlist = new ArrayList<Object>();
		if (employeeData.getEducationAccessBean() != null) {
			
			Iterator<EducationAccessBean> educationItr = employeeData.getEducationAccessBean().iterator();
			while (educationItr.hasNext()) {
				Map<String, Object> manageEducationSet = new HashMap<String, Object>();
				EducationAccessBean educationDetails = educationItr.next();
				manageEducationSet.put("educationalId", educationDetails.getEducationalId());
				manageEducationSet.put("qualiTypeId", educationDetails.getQualiTypeId());
				manageEducationSet.put("courseName", educationDetails.getCourseName());
				manageEducationSet.put("courseType", educationDetails.getCourseType());
				manageEducationSet.put("stream", educationDetails.getStream());
				manageEducationSet.put("courseStartDate", educationDetails.getCourseStartDate());
				manageEducationSet.put("courseEndDate", educationDetails.getCourseEndDate());
				manageEducationSet.put("collegeName", educationDetails.getCollegeName());
				manageEducationSet.put("universityName", educationDetails.getUniversityName());
				educationlist.add(manageEducationSet);
				
			}
			
		}
		employeeMap.put("education",educationlist);
		
/*-----------Dependents Data--------------*/
		
		List<Object> dependentlist = new ArrayList<Object>();
		if (employeeData.getEducationAccessBean() != null) {
			
			Iterator<DependentsAccessBean> dependentItr = employeeData.getDependentsAccessBean().iterator();
			while (dependentItr.hasNext()) {
				Map<String, Object> manageDependentSet = new HashMap<String, Object>();
				DependentsAccessBean dependentDetails = dependentItr.next();
				manageDependentSet.put("dependentId", dependentDetails.getDependentId());
				manageDependentSet.put("firstName", dependentDetails.getFirstName());
				manageDependentSet.put("lastName", dependentDetails.getLastName());
				manageDependentSet.put("relationship", dependentDetails.getRelationship());
				manageDependentSet.put("dependentPhone", dependentDetails.getPhone1());
				dependentlist.add(manageDependentSet);
				
			}
			
		}
		employeeMap.put("dependents",dependentlist);
		
		
    /*-----------Emergency Data--------------*/
		
		List<Object> emergencylist = new ArrayList<Object>();
		if (employeeData.getEmergencyAccessBean() != null) {
			
			Iterator<EmergencyAccessBean> emergencyItr = employeeData.getEmergencyAccessBean().iterator();
			while (emergencyItr.hasNext()) {
				Map<String, Object> manageEmergencySet = new HashMap<String, Object>();
				EmergencyAccessBean emergencyDetails = emergencyItr.next();
				manageEmergencySet.put("emergencyId", emergencyDetails.getEmergencyId());
				manageEmergencySet.put("emergencyName", emergencyDetails.getEmergencyName());
				manageEmergencySet.put("emergencyRelationship", emergencyDetails.getEmergencyRelationship());
				manageEmergencySet.put("emergencyNumber", emergencyDetails.getEmergencyNumber());
				emergencylist.add(manageEmergencySet);
				
			}
			
		}
		employeeMap.put("emergency",emergencylist);
		
		return employeeMap;
	}

	@Override
	public EmployeeAccessBean editProfile(EmployeeAccessBean employeeAccessBean) {
		commonControllerCmd.addNotifications(110L, "Edit Employee Profile : "+employeeAccessBean.getAddressAccessBean().get(0).getFirstName()+".");
		EmployeeAccessBean employeeDetails = employeeRepository.findByEmployeeId(employeeAccessBean.getEmployeeId());

		/*
		 * List<AddressAccessBean> addressDetails=
		 * employeeDetails.getAddressAccessBean(); Iterator
		 * addItr=addressDetails.iterator(); while(addItr.hasNext()) { addItr.s }
		 * addressDetails.set(index, element)
		 * 
		 * AccountDetailsAccessBean
		 * accountDetails=employeeDetails.getAccountDetailsAccessBean();
		 * accountDetails.setEmployeeAccessBean(employeeAccessBean);
		 * 
		 * EmpWorkRelationAccessBean
		 * empWorkDetails=employeeDetails.getEmpWorkRelationAccessBean(); emp
		 */

		return null;
	}

	@Override
	public List<Map<String, Object>> findAllEmployee() {
		List<EmployeeAccessBean> employeeData=employeeRepository.findAll();
		List<Map<String, Object>> responseEmpList = new ArrayList<Map<String, Object>>();
		
		for(int i=0;i<employeeData.size();i++) {
			Map<String, Object> employeeMap = new HashMap<String, Object>();
			employeeMap.put("employeeId", employeeData.get(i).getEmployeeId());
			employeeMap.put("employeeCode", employeeData.get(i).getEmployeeCode());
			System.out.println(employeeData.get(i).getAddressAccessBean());
			
			if(!employeeData.get(i).getAddressAccessBean().isEmpty()) {
				employeeMap.put("firstName", employeeData.get(i).getAddressAccessBean().get(0).getFirstName());
				employeeMap.put("lastName", employeeData.get(i).getAddressAccessBean().get(0).getLastName());
			}
			else {
				employeeMap.put("firstName", "Admin");
				employeeMap.put("lastName", "");
			}
			responseEmpList.add(employeeMap);
			}
		return responseEmpList;
	}

}
