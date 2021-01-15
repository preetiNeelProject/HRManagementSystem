package com.hr.system.payroll.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.system.common.service.CommonService;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.payroll.bean.AllowanceTransAccessBean;
import com.hr.system.payroll.bean.AllowancesAccessBean;
import com.hr.system.payroll.bean.CtcHistoryAccessBean;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;
import com.hr.system.payroll.repository.AllowancesTransRepository;
import com.hr.system.payroll.repository.CtcHistoryRepository;
import com.hr.system.payroll.repository.EmployeeCTCRepository;
import com.hr.system.payroll.repository.PayrollRepository;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	AllowancesTransRepository allowancesTransRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeCTCRepository employeeCTCRepository;
	
	@Autowired
	CtcHistoryRepository ctcHistoryRepository;
	
	@Autowired
	PayrollRepository payrollRepository;

	@Autowired
	CommonService commonService;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addEmployeeAllowances(String LogonId, Long allowanceTypeId) {

		EmployeeAccessBean empAB = employeeRepository.findByLogonId("Preeti@gmail.com");

		AllowancesAccessBean allowancesAccessBean = new AllowancesAccessBean();
		allowancesAccessBean.setEmployeeAccessBean(empAB);
		allowancesAccessBean.setAllowancesAmt(1301L);
		allowancesAccessBean.setEffectiveDate(new Date());
		allowancesAccessBean.setEndDate(new Date());
		allowancesAccessBean.setAllowanceTypeId(allowanceTypeId);

		AllowanceTransAccessBean allowanceTransAccessBean = new AllowanceTransAccessBean();
		allowanceTransAccessBean.setAllowanceAmt(1201L);
		allowanceTransAccessBean.setAllowancesAccessBean(allowancesAccessBean);

		allowancesTransRepository.saveAndFlush(allowanceTransAccessBean);
	}

	@Override
	public EmployeeCTCAccessBean addEmployeeSalary(EmployeeCTCAccessBean salary) {
		Long employeeId = salary.getEmployeeId();
		boolean checkFlag = employeeCTCRepository.existsByEmployeeId(salary.getEmployeeId());
		if(checkFlag == true) {
			EmployeeCTCAccessBean emp=employeeCTCRepository.findByEmployeeId(salary.getEmployeeId());
			 Long ctcId=emp.getEmployeeCTCId();
			 employeeCTCRepository.deleteById(ctcId);
			 return employeeCTCRepository.save(salary);
		}
			return employeeCTCRepository.save(salary);
			/*
			 * Optional<EmployeeCTCAccessBean> empSalary =
			 * employeeCTCRepository.findById(employeeId);
			 * commonService.savePreviousSalary(empSalary);
			 * employeeCTCRepository.deleteById(empSalary.get().getEmployeeId());
			 * employeeCTCRepository.save(salary);
			 * System.out.println(empSalary.get().getName());
			 */
	}

	@Override
	public List<CtcHistoryAccessBean> salaryRevision() {
		 return ctcHistoryRepository.findAll();
	}

	@Override
	public List<EmployeeCTCAccessBean> currentSalaryRevision() {
		return employeeCTCRepository.findAll();
	}

	@Override
	public EmployeeCTCAccessBean salarySlip(Long employeeCTCId,HttpServletRequest request,HttpServletResponse response) {
		Long month=null;
		commonService.salarySlip(employeeCTCId,month,request,response);
		return null;
	}

	@Override
	public EmployeeCTCAccessBean monthlySalaryCalculator(Long employeeCTCId, Long month, HttpServletRequest request,HttpServletResponse response) {
		commonService.salarySlip(employeeCTCId,month,request,response);
		return null;
	}

	@Override
	public EmployeeCTCAccessBean findEmployeeCTCByEmployeeCTCId(Long employeeCTCId) {
		return employeeCTCRepository.findEmployeeCTCByEmployeeCTCId(employeeCTCId);
	}

}
