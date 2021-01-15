package com.hr.system.employee.service;

import java.util.List;
import java.util.Map;

import com.hr.system.employee.bean.EmployeeAccessBean;

public interface EmployeeService {

	Map<String, Object> findByEmployeeId(Long employeeId);

	EmployeeAccessBean editProfile(EmployeeAccessBean employeeAccessBean);

	List<Map<String, Object>> findAllEmployee();

}
