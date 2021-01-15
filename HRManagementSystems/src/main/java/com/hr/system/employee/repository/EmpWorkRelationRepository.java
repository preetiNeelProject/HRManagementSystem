package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.EmpWorkRelationAccessBean;

public interface EmpWorkRelationRepository extends JpaRepository<EmpWorkRelationAccessBean, Long> {

	//EmpWorkRelationAccessBean findByEmployeeId(Long employeeId);


}
