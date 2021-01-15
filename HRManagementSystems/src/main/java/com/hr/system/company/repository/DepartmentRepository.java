package com.hr.system.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.DepartmentAccessBean;

public interface DepartmentRepository extends JpaRepository<DepartmentAccessBean, Long> {

	List<DepartmentAccessBean> findByWorkLocationId(Long WorkLocationId);

	DepartmentAccessBean findByDepartmentId(Long departmentId);

}
