package com.hr.system.payroll.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.system.payroll.bean.CtcHistoryAccessBean;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;

public interface PayrollService {

	void addEmployeeAllowances(String LogonId,Long allowanceTypeId);

	EmployeeCTCAccessBean addEmployeeSalary(EmployeeCTCAccessBean salary);

	List<CtcHistoryAccessBean> salaryRevision();

	List<EmployeeCTCAccessBean> currentSalaryRevision();

	EmployeeCTCAccessBean salarySlip(Long employeeCTCId, HttpServletRequest request,HttpServletResponse response);

	EmployeeCTCAccessBean monthlySalaryCalculator(Long employeeCTCId, Long month, HttpServletRequest request,HttpServletResponse response);

	EmployeeCTCAccessBean findEmployeeCTCByEmployeeCTCId(Long employeeCTCId);

	
}
