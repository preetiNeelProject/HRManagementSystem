package com.hr.system.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hr.system.payroll.bean.EmployeeCTCAccessBean;

@Transactional
@Repository
public interface EmployeeCTCRepository extends JpaRepository<EmployeeCTCAccessBean, Long> {

	boolean existsByEmployeeId(Long employeeId);

	EmployeeCTCAccessBean findByEmployeeId(Long employeeId);

	EmployeeCTCAccessBean findEmployeeCTCByEmployeeCTCId(Long employeeCTCId);

	

}
