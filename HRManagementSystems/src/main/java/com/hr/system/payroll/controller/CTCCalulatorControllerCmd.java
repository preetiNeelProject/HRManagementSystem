package com.hr.system.payroll.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hr.system.employee.bean.AccountDetailsAccessBean;
import com.hr.system.employee.repository.AccountDetailsRepository;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.employee.service.EmployeeService;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;
import com.hr.system.payroll.service.PayrollService;
import com.hr.system.payroll.service.PfService;

@Controller
public class CTCCalulatorControllerCmd {

	@Autowired
	PayrollService payrollService;

	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	PfService pfService;

	@RequestMapping(value = "/calBasicSalary", method = RequestMethod.POST)
	public @ResponseBody Map<String, Long> calculateBasicSalary(Long ctc, Long employeeId) {
		System.out.println("ctc " + employeeId);
		boolean year = false;
		
		AccountDetailsAccessBean accDetails = accountDetailsRepository.findByEmployeeAccessBean(employeeRepository.findByEmployeeId(employeeId));
		boolean pf = accDetails.isEsi();
		boolean esi = accDetails.isPf();
		Map<String, Long> ctcMAP = new HashMap<String, Long>();
		if (year) {

			Long basicSalaryYearly, pfYearly, hraYearly, allowances, grossPay, esiYearly, otherYearly, annualRefSalary,
					tdsYearly, conveyanceYearly;

			basicSalaryYearly = pfService.calculateBasicSalary(ctc, false);
			pfYearly = pfService.calculatePf(basicSalaryYearly, true);
			hraYearly = pfService.calculateHRA(basicSalaryYearly, 50);
			conveyanceYearly = pfService.calculateConveyance(true);

			otherYearly = ctc - (basicSalaryYearly + hraYearly + conveyanceYearly);

			allowances = hraYearly + otherYearly + conveyanceYearly;
			grossPay = basicSalaryYearly + allowances;

			if (esi == true)
				esiYearly = pfService.calculateESI(grossPay,true);
				else
					esiYearly=0L;
			tdsYearly = 0L;
			annualRefSalary = grossPay - (pfYearly + esiYearly + tdsYearly);

			ctcMAP.put("basicSalaryYearly", basicSalaryYearly);
			ctcMAP.put("pfYearly", pfYearly);
			ctcMAP.put("hraYearly", hraYearly);
			ctcMAP.put("conveyanceYearly", conveyanceYearly);
			ctcMAP.put("allowances", allowances);
			ctcMAP.put("grossPay", grossPay);
			ctcMAP.put("esiYearly", esiYearly);
			ctcMAP.put("otherYearly", otherYearly);
			ctcMAP.put("tdsYearly", tdsYearly);
			ctcMAP.put("annualRefSalary", annualRefSalary);
			return ctcMAP;
		} else {

			Long basicSalaryMonthly, pfMonthly, hraMonthly, allowances, grossPay, esiMonthly, otherMonthly,
					annualRefSalary, tdsMonthly, conveyanceMonthly;

			basicSalaryMonthly = pfService.calculateBasicSalary(ctc, false);
			if (pf == true)
				pfMonthly = pfService.calculatePf(basicSalaryMonthly, true);
			else
				pfMonthly = 0L;
			hraMonthly = pfService.calculateHRA(basicSalaryMonthly, 50);
			conveyanceMonthly = pfService.calculateConveyance(true);

			otherMonthly = ctc - (basicSalaryMonthly + hraMonthly + conveyanceMonthly);

			allowances = hraMonthly + otherMonthly + conveyanceMonthly;
			grossPay = basicSalaryMonthly + allowances;
			if (esi == true)
			   esiMonthly = pfService.calculateESI(grossPay,true);
			else
				esiMonthly=0L;
			tdsMonthly = 0L;
			annualRefSalary = grossPay - (pfMonthly + esiMonthly + tdsMonthly);

			ctcMAP.put("basicSalaryMonthly", basicSalaryMonthly);
			ctcMAP.put("pfMonthly", pfMonthly);
			ctcMAP.put("hraMonthly", hraMonthly);
			ctcMAP.put("conveyanceMonthly", conveyanceMonthly);
			ctcMAP.put("allowances", allowances);
			ctcMAP.put("grossPay", grossPay);
			ctcMAP.put("esiMonthly", esiMonthly);
			ctcMAP.put("otherMonthly", otherMonthly);
			ctcMAP.put("tdsMonthly", tdsMonthly);
			ctcMAP.put("annualRefSalary", annualRefSalary);
			return ctcMAP;
		}

	}

	@RequestMapping(value = "/monthlySalaryCalculate", method = RequestMethod.POST, produces = "application/json")
	public EmployeeCTCAccessBean monthlySalaryCalculate(Long ctc, int count, boolean pfCheck, boolean esiCheck) {
		System.out.println("ctc " + ctc);
		ctc = (ctc / 30) * count;
		boolean year = false;
		EmployeeCTCAccessBean ctcMAP = new EmployeeCTCAccessBean();

		Long basicSalaryYearly, pfYearly, hraYearly, allowances, grossPay, esiYearly, otherYearly, annualRefSalary,
				tdsYearly, conveyanceYearly;

		basicSalaryYearly = pfService.calculateBasicSalary(ctc, false);
		pfYearly = pfService.calculatePf(basicSalaryYearly, pfCheck);
		hraYearly = pfService.calculateHRA(basicSalaryYearly, 50);
		
		conveyanceYearly = pfService.calculateConveyance(true);
         if(hraYearly <=1601)
        	 conveyanceYearly=0L; 
         
		otherYearly = ctc - (basicSalaryYearly + hraYearly + conveyanceYearly);

		allowances = hraYearly + otherYearly + conveyanceYearly;
		grossPay = basicSalaryYearly + allowances;

		esiYearly = pfService.calculateESI(grossPay,esiCheck);
		tdsYearly = 0L;
		annualRefSalary = grossPay - (pfYearly + esiYearly + tdsYearly);
		

		ctcMAP.setAnnualBasicSalary(basicSalaryYearly);
		ctcMAP.setAnnualFlexibleBenifits(annualRefSalary);
		ctcMAP.setAnnualRefSalary(annualRefSalary);
		ctcMAP.setConvey(conveyanceYearly);
		ctcMAP.setEsi(esiYearly);
		ctcMAP.setHra(hraYearly);
		ctcMAP.setPf(pfYearly);
		ctcMAP.setcTC(ctc);
		ctcMAP.setGratuity(otherYearly);
		// ctcMap.se

		/*
		 * ctcMAP.put("basicSalaryYearly", basicSalaryYearly); ctcMAP.put("pfYearly",
		 * pfYearly); ctcMAP.put("hraYearly", hraYearly); ctcMAP.put("conveyanceYearly",
		 * conveyanceYearly); ctcMAP.put("allowances", allowances);
		 * ctcMAP.put("grossPay", grossPay); ctcMAP.put("esiYearly", esiYearly);
		 * ctcMAP.put("otherYearly", otherYearly); ctcMAP.put("tdsYearly", tdsYearly);
		 * ctcMAP.put("annualRefSalary", annualRefSalary);
		 */

		return ctcMAP;
	}
}
