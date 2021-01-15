package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.employee.bean.EmployeeAccessBean;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeAccessBean, Long> {

	EmployeeAccessBean findByLogonId(String logonId);
	EmployeeAccessBean findByEmployeeId(Long employeeId);
	EmployeeAccessBean save(EmployeeAccessBean emp);
	EmployeeAccessBean findByEmployeeCode(String employeeCode);
	
	

}
