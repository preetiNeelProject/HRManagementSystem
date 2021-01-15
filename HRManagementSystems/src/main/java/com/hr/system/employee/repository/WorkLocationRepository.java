package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.WorkLocationAccessBean;

public interface WorkLocationRepository extends JpaRepository<WorkLocationAccessBean, Long> {

	WorkLocationAccessBean findByWorkLocationId(Long workLocationId);

}
