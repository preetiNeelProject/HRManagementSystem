package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.employee.bean.EducationAccessBean;

public interface EducationRepository extends JpaRepository<EducationAccessBean, Long> {

}
