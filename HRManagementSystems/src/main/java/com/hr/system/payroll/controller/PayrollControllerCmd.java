package com.hr.system.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.system.payroll.service.PayrollService;
import com.hr.system.payroll.service.PfService;

@Controller("/payroll")
public class PayrollControllerCmd {

	@Autowired
	PayrollService payrollService;

	@Autowired
	PfService pfService;
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view dashboard of all employee and call on
	 *          jsp
	 *
	 */
	@RequestMapping(value = "/admin/payroll/dashboard")
	public String dash() {
		return "admin/payroll/dashboard";
	}

	@RequestMapping(value = "admin/viewEmployeeSalary", method = RequestMethod.GET)
	public String viewEmployeeSalary() {

		return null;
	}


	@RequestMapping(value = "/addEmployeeAllowances", method = RequestMethod.GET)
	public String addEmployeeAllowances() {
		String logonId = "Preeti@gmail.com";
		Long allowanceTypeId = 2L;
		payrollService.addEmployeeAllowances(logonId, allowanceTypeId);
		return null;
	}

	@RequestMapping(value = "/addEmployeePf", method = RequestMethod.GET)
	public String addEmployeePf() {
		Long employeeId = 1L;
		return null;
	}

	@RequestMapping(value = "/addEmployeeGratuity", method = RequestMethod.GET)
	public String addEmployeeGratuity() {
		Long employeeId = 1L;
		return null;
	}

}
