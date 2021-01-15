package com.hr.system.payroll.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hr.system.common.files.Keys;
import com.hr.system.common.files.Utils;
import com.hr.system.common.service.CommonService;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.employee.service.EmployeeService;
import com.hr.system.payroll.bean.CtcHistoryAccessBean;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;
import com.hr.system.payroll.repository.EmployeeCTCRepository;
import com.hr.system.payroll.service.PayrollService;

@Controller
public class SalaryControllerCmd {

	@Autowired
	PayrollService payrollService;

	@Autowired
	CommonService commonService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeCTCRepository employeeCTCRepository;
	
	@Autowired
	private Keys keys;
	
	@Autowired
	Utils utils;

	@RequestMapping(value = "admin/payroll/addEmployeeSalary", method = RequestMethod.POST)
	public ModelAndView addEmployeeSalary(@ModelAttribute("emloyeeSalary") EmployeeCTCAccessBean emloyeeSalary,
			Model model,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("emloyeeSalary", emloyeeSalary);
		EmployeeCTCAccessBean flag = payrollService.addEmployeeSalary(emloyeeSalary);
		commonService.salarySlip(flag.getEmployeeCTCId(), 0L, request,response);
		Utils.downloadFile(request,response,flag.getName() + "_Salary-Slip",keys.getTimesheetDownloadLocation());
		modelAndView.setViewName("redirect:/admin/payroll/salaryStructure");
		return modelAndView;

	}

	@RequestMapping(value = "admin/payroll/addIncrementSalary", method = RequestMethod.GET)
	public String addIncrementSalary() {
		return "admin/payroll/salaryIncrement";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for monthly Salary Revision of a employee jsp
	 *
	 */
	@RequestMapping(value = "admin/payroll/monthlySalary", method = RequestMethod.GET)
	public ModelAndView monthlySalary() {
		ModelAndView modelAndView = new ModelAndView();
		List<CtcHistoryAccessBean> records = payrollService.salaryRevision();
		modelAndView.addObject("records", records);
		List<EmployeeCTCAccessBean> currentRecords = payrollService.currentSalaryRevision();
		modelAndView.addObject("currentRecords", currentRecords);
		modelAndView.addObject("employee", employeeService.findAllEmployee());
		modelAndView.setViewName("admin/payroll/monthlySalary");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for salary Revision of a employee jsp
	 *
	 */
	@RequestMapping(value = "admin/payroll/salaryRevision", method = RequestMethod.GET)
	public ModelAndView salaryRevision() {
		ModelAndView modelAndView = new ModelAndView();
		List<CtcHistoryAccessBean> records = payrollService.salaryRevision();
		modelAndView.addObject("records", records);
		List<EmployeeCTCAccessBean> currentRecords = payrollService.currentSalaryRevision();
		modelAndView.addObject("currentRecords", currentRecords);
		modelAndView.setViewName("admin/payroll/salaryRevision");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for generate salarySlip of a employee jsp
	 *
	 */
	@RequestMapping(value = "admin/payroll/salarySlip/{id}", method = RequestMethod.GET )
	public ModelAndView salarySlip(@PathVariable("id") Long employeeCTCId, HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		Long month = 0L;
		EmployeeCTCAccessBean flag = payrollService.findEmployeeCTCByEmployeeCTCId(employeeCTCId);
		commonService.salarySlip(employeeCTCId, month, request,response);
		Utils.downloadFile(request,response,flag.getName() + "_Salary-Slip",keys.getTimesheetDownloadLocation());
		modelAndView.setViewName("redirect:/admin/payroll/salaryRevision");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for monthly Salary of all employee and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/payroll/monthlySalary", method = RequestMethod.POST)
	public ModelAndView monthlySalaryCalculator(@RequestParam("employeeCode") String employeeCode,
			@RequestParam("month") Long month, HttpServletRequest request,HttpServletResponse response) {
		EmployeeAccessBean employeeAccessBean = employeeRepository.findByEmployeeCode(employeeCode);
		ModelAndView modelAndView = new ModelAndView();
		Long employeeId = employeeAccessBean.getEmployeeId();
		EmployeeCTCAccessBean employeeCTCAccessBean = employeeCTCRepository.findByEmployeeId(employeeId);
		commonService.salarySlip(employeeCTCAccessBean.getEmployeeCTCId(), month, request,response);
		Utils.downloadFile(request,response,employeeCTCAccessBean.getName() + "_Salary-Slip",keys.getTimesheetDownloadLocation());
		modelAndView.setViewName("redirect:/admin/payroll/monthlySalary");
		return modelAndView;
	}
	
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for monthly Salary of all employee and call a jsp
	 *
	 */
	@RequestMapping(value = "admin/payroll/SalarySlips", method = RequestMethod.POST)
	public String SalarySlip(@ModelAttribute("emloyeeCtc") EmployeeCTCAccessBean employeeCTCAccessBean, HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		Long employeeId = employeeCTCAccessBean.getEmployeeId();
		EmployeeCTCAccessBean employeeCTCAccessBean1 = employeeCTCRepository.findByEmployeeId(employeeId);
		commonService.salarySlip(employeeCTCAccessBean1.getEmployeeCTCId(), 0L, request,response);
		Utils.downloadFile(request,response,employeeCTCAccessBean1.getName() + "_Salary-Slip",keys.getTimesheetDownloadLocation());
		return null;
	}
}
