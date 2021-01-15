package com.hr.system.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.SubDepartmentAccessBean;

public interface SubDepartmentRepository extends JpaRepository<SubDepartmentAccessBean, Long> {

	SubDepartmentAccessBean findBySubDepartmentId(Long subDepartmentId);

	void deleteByDepartmentId(Long departmentId);

	boolean existsByDepartmentId(Long departmentId);

}
