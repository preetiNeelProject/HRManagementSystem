package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.EmployeeTypeAccessBean;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeTypeAccessBean, Long> {

	
	

}
