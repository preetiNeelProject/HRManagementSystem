package com.hr.system.employee.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hr.system.company.service.CompanyService;
import com.hr.system.employee.bean.DocumentAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.DocumentRepository;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.employee.service.EmployeeService;

@Controller
public class EmployeeControllerCmd {

	// private static Session session;
	//

	/*
	 * @PersistenceContext private EntityManager entityManager;
	 */

	ModelAndView modelAndView = new ModelAndView();

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	CompanyService companyService;

	@Autowired
	DocumentRepository documentRepository;
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view dashboard of all employee and call on
	 *          jsp
	 *
	 */
	@RequestMapping(value = "/employee/dashboard")
	public String dash() {
		return "employee/dashboard";
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view profile page of all employee and call on
	 *          jsp
	 *
	 */
	@RequestMapping(value = "/employee/profile", method = RequestMethod.GET)
	public String profile() {
		return "employee/profile";
	}



	@RequestMapping(value = "admin/payroll/salaryStructure", method = RequestMethod.GET)
	public ModelAndView salaryStructure() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("records", employeeService.findAllEmployee());
		System.out.println("records");
		modelAndView.setViewName("admin/payroll/salaryStructure");
		return modelAndView;
	}

	@RequestMapping(value = "/employee/profile/{employeeId}", method = RequestMethod.GET)
	public String myProfile(@PathVariable("id") int id) {
		return "employee/profile";
	}

	@RequestMapping(value = "/employee/editProfile/{employeeId}", method = RequestMethod.GET)
	public ModelAndView editMyProfile(@PathVariable("employeeId") Long employeeId) {

		/*---------------Employee  Form Dropdown Data------------------*/
        ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("empType", companyService.findAllEmployeeType());
		modelAndView.addObject("workLocation", companyService.findAllWorkLocation());
		modelAndView.addObject("department", companyService.findAllDepartment());
		modelAndView.addObject("jobTitle", companyService.findAllJobTitle());
		modelAndView.addObject("project", companyService.findAllProject());
		modelAndView.addObject("qualification", companyService.findAllQuali());

		/*---------------Employee Data------------------*/

		modelAndView.addObject("records", employeeService.findByEmployeeId(employeeId));

		modelAndView.setViewName("employee/editProfile");
		return modelAndView;
	}

	@RequestMapping(value = "employee/editProfile", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json; charset=UTF-8")
	public @ResponseBody Long editProfile(@RequestBody EmployeeAccessBean employeeAccessBean) {
		EmployeeAccessBean empAB = employeeService.editProfile(employeeAccessBean);
		return empAB.getEmployeeId();
	}

	@RequestMapping(value = "employee/employeeDocument/{employeeId}", method = RequestMethod.GET)
	public ModelAndView employeeDocument(@PathVariable("employeeId") Long employeeId) {
		modelAndView.setViewName("employee/employeeDocument");
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "company/uploadFile", method = RequestMethod.POST,
	 * produces = "multipart/form-data") public @ResponseBody boolean
	 * uploadFile(@ModelAttribute Document accessBean) throws IOException {
	 * 
	 * EmployeeAccessBean employeeAccessBean =
	 * employeeRepository.findByEmployeeId(20L); DocumentAccessBean docAB = new
	 * DocumentAccessBean(); MultipartFile[] multipartFile =
	 * accessBean.getMultipartFile();
	 * docAB.setEmployeeAccessBean(employeeAccessBean);
	 * docAB.setFileValue(multipartFile[0].getBytes());
	 * docAB.setFileName(multipartFile[0].getName());
	 * docAB.setFileSize(String.valueOf(multipartFile[0].getSize()));
	 * docAB.setDescription(accessBean.getDescription());
	 * docAB.setTitle(accessBean.getTitle()); docAB.setType(accessBean.getType());
	 * 
	 * documentRepository.save(docAB);
	 * 
	 * return true; }
	 */

	/*
	 * @RequestMapping(value = "employee/uploadFile", method = RequestMethod.POST,
	 * produces = "multipart/form-data") public @ResponseBody boolean
	 * uploadFile(@ModelAttribute DocumentAccessBean
	 * document,@RequestParam("multipart") MultipartFile file) throws IOException {
	 * EmployeeAccessBean employeeAccessBean =
	 * employeeRepository.findByEmployeeId(20L); System.out.println("Name:" +
	 * document.getTitle()); System.out.println("Desc:" + document.getType());
	 * System.out.println("File:" + file.getName());
	 * System.out.println("ContentType:" + file.getContentType());
	 * System.out.println("File:" + file.getInputStream());
	 * System.out.println("ContentType:" + file.getSize());
	 * 
	 * 
	 * FileInputStream inputStream = (FileInputStream) file.getInputStream(); //Blob
	 * blob = Hibernate.getLobCreator().createBlob(inputStream);
	 * //document.setFileValue(blob); byte[] bytes =
	 * IOUtils.toByteArray(inputStream); Blob blob = null; try { blob = new
	 * SerialBlob(bytes); } catch (SerialException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } document.setFileValue(blob);
	 * document.setEmployeeAccessBean(employeeAccessBean);
	 * documentRepository.save(document);
	 * 
	 * return true; }
	 */

	@RequestMapping(value = "employee/uploadFile/{employeeId}", method = RequestMethod.POST, produces = "multipart/form-data")
	public @ResponseBody boolean uploadFile(@ModelAttribute DocumentAccessBean doc,
			@RequestParam("multipart") MultipartFile file, @PathVariable("employeeId") Long employeeId)
			throws IOException {
		EmployeeAccessBean employeeAccessBean = employeeRepository.findByEmployeeId(employeeId);

		DocumentAccessBean document = new DocumentAccessBean();
		FileInputStream inputStream = (FileInputStream) file.getInputStream();
		// Blob blob = Hibernate.getLobCreator().createBlob(inputStream);
		// document.setFileValue(blob);
		byte[] bytes = IOUtils.toByteArray(inputStream);
		Blob blob = null;
		try {
			blob = new SerialBlob(bytes);
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		document.setFileName(file.getOriginalFilename());
		document.setTitle(doc.getTitle());
		document.setType(doc.getType());
		document.setFileSize(String.valueOf(file.getSize()));
		document.setFileValue(blob);
		document.setEmployeeAccessBean(employeeAccessBean);
		documentRepository.save(document);

		return true;
	}
}
