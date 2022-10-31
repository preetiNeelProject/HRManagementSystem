package com.hr.system.company.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.system.common.service.CommonService;
import com.hr.system.company.bean.AnnouncementAccessBean;
import com.hr.system.company.bean.DepartmentAccessBean;
import com.hr.system.company.bean.ProjectAccessBean;
import com.hr.system.company.bean.RoleAccessBean;
import com.hr.system.company.bean.SubDepartmentAccessBean;
import com.hr.system.company.bean.SubRoleAccessBean;
import com.hr.system.company.bean.WorkLocationAccessBean;
import com.hr.system.company.service.CompanyService;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.DocumentRepository;
import com.hr.system.employee.repository.EmployeeRepository;

@Controller
public class CompanyControllerCmd {

	@Autowired
	CommonService commonService;

	@Autowired
	CompanyService companyService;

	@Autowired
	DocumentRepository documentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view company dashboard and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "admin/company/dashboard";
	}
	

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view directory dashboard and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/directory/dashboard", method = RequestMethod.GET)
	public String dashboardDirectory() {
		return "admin/directory/dashboard";
	}
	
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view company dashboard and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/validationAng", method = RequestMethod.GET)
	public String validationAng() {
		return "admin/company/validationAng";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view company department List and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/departmentList", method = RequestMethod.GET)
	public String departmentList() {
		return "admin/company/departmentList";
	}

	@RequestMapping(value = "admin/company/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(ModelMap model) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("empType", companyService.findAllEmployeeType());
		modelAndView.addObject("role", companyService.findAllRole());
		modelAndView.addObject("workLocation", companyService.findAllWorkLocation());
		modelAndView.addObject("jobTitle", companyService.findAllJobTitle());
		modelAndView.addObject("project", companyService.findAllProject());
		modelAndView.addObject("department", companyService.findAllDepartment());
		modelAndView.setViewName("admin/company/addEmployee");
		return modelAndView;
	}

	@RequestMapping(value = "admin/company/add_Employee", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_Employee(@RequestBody EmployeeAccessBean employeeAccessBean) {
		EmployeeAccessBean empAB = companyService.addEmployee(employeeAccessBean);
		return empAB.getEmployeeId();
	}

	@RequestMapping(value = "admin/company/employeeList", method = RequestMethod.GET)
	public ModelAndView employeeList() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("records", companyService.findEmployeeList());
		modelAndView.setViewName("admin/company/employeeList");
		return modelAndView;
	}

	@RequestMapping(value = "admin/company/uploadEmployeeList", method = RequestMethod.POST)
	public String uploadBulk(@RequestParam("csv") MultipartFile csv) throws IOException {
		Long id = 0L;
		commonService.uploadFiles(csv, "employeeList", id);
		return "admin/attendance/uploadAttendance";
	}

	@PostMapping(value = "/addEmployee2", consumes = "application/form-data;charset=UTF-8", produces = "application/form-datan;charset=UTF-8")
	public @ResponseBody Long addEmployee(@RequestBody EmployeeAccessBean employeeAccessBean) {
		EmployeeAccessBean empAB = companyService.addEmployee(employeeAccessBean);
		return empAB.getEmployeeId();
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of department and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/department", method = RequestMethod.GET)
	public ModelAndView department() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("department", companyService.findAllDepartment());
		System.out.println("Department:======="+companyService.findAllDepartment());
		modelAndView.setViewName("admin/company/department");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add department and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/addDepartment", method = RequestMethod.GET)
	public ModelAndView addDepartment() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("workLocation", companyService.findAllWorkLocation());
		modelAndView.setViewName("admin/company/addDepartment");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add department and save data in database a
	 *
	 */
	@RequestMapping(value = "admin/company/addDepartment", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_Department(@RequestBody 	n) {
		DepartmentAccessBean depAB = companyService.addDepartment(departmentAccessBean);
		return depAB.getDepartmentId();
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of department and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/department", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> getdepartment(@RequestBody Long workLocationId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("department", companyService.findDepartmentByWorkLocationId(workLocationId));
		return  map;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for edit department(Company) data and again save data in database 
	 *
	 */
	@RequestMapping(value = "admin/company/editDepartment/{departmentId}", method = RequestMethod.GET)
	public ModelAndView editDepartment(@PathVariable("departmentId") Long departmentId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("department", companyService.findByDepartmentId(departmentId));
		modelAndView.addObject("workLocation", companyService.findAllWorkLocation());
		modelAndView.setViewName("admin/company/addDepartment");
		return modelAndView;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for delete department of an company
	 * @param departmentId only
	 *
	 */
	@RequestMapping(value = "admin/company/deleteDepartment/{departmentId}", method = RequestMethod.GET)
	public String deleteDepartment(HttpServletRequest rep,HttpServletResponse res,@PathVariable("departmentId") Long departmentId,RedirectAttributes flashAttributes) {
		companyService.deleteDepartment(res,flashAttributes,departmentId);
		flashAttributes.addFlashAttribute("msg","Delete Successfully!");
		return "redirect:department";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of subDepartment and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/subDepartment", method = RequestMethod.GET)
	public ModelAndView subDepartment() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("department", companyService.findAllSubDepartment());
		modelAndView.setViewName("admin/company/subDepartment");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add subDepartment and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/addSubDepartment", method = RequestMethod.GET)
	public ModelAndView addSubDepartment() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("department", companyService.findAllDepartment());
		mv.setViewName("admin/company/addSubDepartment");
		return mv;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add sub department and save data in database a
	 *
	 */
	@RequestMapping(value = "admin/company/addSubDepartment", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_SubDepartment(@RequestBody SubDepartmentAccessBean subDepartmentAccessBean) {
		SubDepartmentAccessBean depAB = companyService.addSubDepartment(subDepartmentAccessBean);
		return depAB.getSubDepartmentId();
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for edit subdepartment(Company) data and again save data in database 
	 *
	 */
	@RequestMapping(value = "admin/company/editSubDepartment/{subDepartmentId}", method = RequestMethod.GET)
	public ModelAndView editSubDepartment(@PathVariable("subDepartmentId") Long subDepartmentId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("subdep", companyService.findBySubDepartmentId(subDepartmentId));
		modelAndView.addObject("department", companyService.findAllDepartment());
		modelAndView.setViewName("admin/company/addSubDepartment");
		return modelAndView;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for delete subdepartment of an company
	 * @param departmentId only
	 *
	 */
	@RequestMapping(value = "admin/company/deleteSubDepartment/{subDepartmentId}", method = RequestMethod.GET)
	public String deleteSubDepartment(HttpServletRequest rep,HttpServletResponse res,@PathVariable("subDepartmentId") Long subDepartmentId,RedirectAttributes flashAttributes) {
		companyService.deleteSubDepartment(res,flashAttributes,subDepartmentId);
		flashAttributes.addFlashAttribute("msg","Delete Successfully!");
		return "redirect:admin/company/subDepartment";
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of role and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/role", method = RequestMethod.GET)
	public ModelAndView role() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("role", companyService.findAllRole());
		modelAndView.setViewName("admin/company/role");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add role and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/addRole", method = RequestMethod.GET)
	public String addRole() {
		return "admin/company/addRole";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add role and save data in database a
	 *
	 */
	@RequestMapping(value = "admin/company/addRole", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_Role(@RequestBody RoleAccessBean roleAccessBean) {
		RoleAccessBean roleAB = companyService.addRole(roleAccessBean);
		return roleAB.getRoleId();
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for edit role data and again save data in database 
	 *
	 */
	@RequestMapping(value = "admin/company/editRole/{roleId}", method = RequestMethod.GET)
	public ModelAndView editRole(@PathVariable("roleId") Long roleId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("role", companyService.findByRoleId(roleId));
		modelAndView.setViewName("admin/company/addRole");
		return modelAndView;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for delete role of an company
	 * @param departmentId only
	 *
	 */
	@RequestMapping(value = "admin/company/deleteRole/{roleId}", method = RequestMethod.GET)
	public String deleteRole(HttpServletRequest rep,HttpServletResponse res,@PathVariable("roleId") Long roleId,RedirectAttributes flashAttributes) {
		companyService.deleteRole(res,flashAttributes,roleId);
		flashAttributes.addFlashAttribute("msg","Delete Successfully!");
		return "redirect:admin/company/role";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of subRole and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/subRole", method = RequestMethod.GET)
	public ModelAndView subRole() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("role", companyService.findAllSubRole());
		modelAndView.setViewName("admin/company/subRole");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add role and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/addSubRole", method = RequestMethod.GET)
	public ModelAndView addSubRole() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("role", companyService.findAllRole());
		modelAndView.setViewName("admin/company/addSubRole");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add role and save data in database a
	 *
	 */
	@RequestMapping(value = "admin/company/addSubRole", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_SubRole(@RequestBody SubRoleAccessBean subRoleAccessBean) {
		SubRoleAccessBean roleAB = companyService.addSubRole(subRoleAccessBean);
		return roleAB.getSubRoleId();
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for edit subRole data and again save data in database 
	 *
	 */
	@RequestMapping(value = "admin/company/editSubRole/{subRoleId}", method = RequestMethod.GET)
	public ModelAndView editSubRole(@PathVariable("subRoleId") Long subRoleId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("subRole", companyService.findBySubRoleId(subRoleId));
		modelAndView.addObject("role", companyService.findAllRole());
		modelAndView.setViewName("admin/company/addSubRole");
		return modelAndView;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for delete SubRole of an company
	 * @param subRoleId only
	 *
	 */
	@RequestMapping(value = "admin/company/deleteSubRole/{subRoleId}", method = RequestMethod.GET)
	public String deleteSubRole(HttpServletRequest rep,HttpServletResponse res,@PathVariable("subRoleId") Long subRoleId,RedirectAttributes flashAttributes) {
		companyService.deleteSubRole(res,flashAttributes,subRoleId);
		flashAttributes.addFlashAttribute("msg","Delete Successfully!");
		return "redirect:subRole";
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of work location(Company) and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/workLocation", method = RequestMethod.GET)
	public ModelAndView workLocation() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("location", companyService.findAllWorkLocation());
		modelAndView.setViewName("admin/company/workLocation");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add work location(Company) and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/addWorkLocation", method = RequestMethod.GET)
	public String addWorkLocation() {
		return "admin/company/addWorkLocation";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add work location(Company) and save data in database a
	 *
	 */
	@RequestMapping(value = "admin/company/addWorkLocation", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_WorkLocation(@RequestBody WorkLocationAccessBean workLocationAccessBean) {
		WorkLocationAccessBean worklocAB = companyService.addWorkLocation(workLocationAccessBean);
		return worklocAB.getWorkLocationId();
	}
	
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for edit work location(Company) data and again save data in database 
	 *
	 */
	@RequestMapping(value = "admin/company/editWorkLocation/{workLocationId}", method = RequestMethod.GET)
	public ModelAndView editWorkLocation(@PathVariable("workLocationId") Long workLocationId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("location", companyService.findByWorkLocationId(workLocationId));
		modelAndView.setViewName("admin/company/addWorkLocation");
		return modelAndView;
	}
	

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for delete workLOcation of an company
	 * @param WorkLocationId only
	 *
	 */
	@RequestMapping(value = "admin/company/deleteWorkLocation/{workLocationId}", method = RequestMethod.GET)
	public String deleteWorkLocation(HttpServletRequest rep,HttpServletResponse res,@PathVariable("workLocationId") Long workLocationId,RedirectAttributes flashAttributes) {
		companyService.deleteWorkLocation(res,flashAttributes,workLocationId);
		flashAttributes.addFlashAttribute("msg","Delete Successfully!");
		return "redirect:workLocation";
	}

	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of Project and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/project", method = RequestMethod.GET)
	public ModelAndView project() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("project", companyService.findAllProject());
		modelAndView.setViewName("admin/company/project");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add Project and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/addProject", method = RequestMethod.GET)
	public String addProject() {
		return "admin/company/addProject";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add Project and save data in database a
	 *
	 */
	@RequestMapping(value = "admin/company/addProject", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_Project(@RequestBody ProjectAccessBean projectAccessBean) {
		ProjectAccessBean projectAB = companyService.addProject(projectAccessBean);
		return projectAB.getProjectId();
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of announcement and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/announcement", method = RequestMethod.GET)
	public ModelAndView announcement() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("announcement", companyService.findAllAnnouncement());
		modelAndView.setViewName("admin/company/announcement");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add announcement and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/addAnnouncement", method = RequestMethod.GET)
	public ModelAndView addAnnouncement() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("admin/company/addAnnouncement");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add announcement and save data in database a
	 *
	 */
	@RequestMapping(value = "admin/company/addAnnouncement", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_Announcement(@RequestBody AnnouncementAccessBean announcementAccessBean) {
		AnnouncementAccessBean annAB = companyService.addAnnouncement(announcementAccessBean);
		return annAB.getAnnouncementId();
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for List of announcement and view and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/company/announcement", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> getannouncement(@RequestBody Long workLocationId) {
		Map<String,Object> map=new HashMap<String,Object>();
		//map.put("announcement", companyService.findAnnouncementByWorkLocationId(workLocationId));
		return  map;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for edit announcement(Company) data and again save data in database 
	 *
	 */
	@RequestMapping(value = "admin/company/editAnnouncement/{announcementId}", method = RequestMethod.GET)
	public ModelAndView editAnnouncement(@PathVariable("announcementId") Long announcementId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("announcement", companyService.findByAnnouncementId(announcementId));
		modelAndView.setViewName("admin/company/addAnnouncement");
		return modelAndView;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for delete announcement of an company
	 * @param announcementId only
	 *
	 */
	@RequestMapping(value = "admin/company/deleteAnnouncement/{announcementId}", method = RequestMethod.GET)
	public String deleteAnnouncement(HttpServletRequest rep,HttpServletResponse res,@PathVariable("announcementId") Long announcementId,RedirectAttributes flashAttributes) {
		companyService.deleteAnnouncement(res,flashAttributes,announcementId);
		flashAttributes.addFlashAttribute("msg","Delete Successfully!");
		return "redirect:announcement";
	}
	

}
