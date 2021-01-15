package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.employee.bean.QualificationTypeAccessBean;

public interface QualificationTypeRepository extends JpaRepository<QualificationTypeAccessBean, Long> {

}
