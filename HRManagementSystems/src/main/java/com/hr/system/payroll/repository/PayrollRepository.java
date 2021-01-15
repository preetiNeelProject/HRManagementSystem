package com.hr.system.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.payroll.bean.EmployeeCTCAccessBean;
import com.hr.system.payroll.bean.PayrollAccessBean;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollAccessBean, Long> {

}
