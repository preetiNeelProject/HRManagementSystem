package com.hr.system.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.payroll.bean.SalaryAccessBean;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryAccessBean, Long> {

}
