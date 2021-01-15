package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.employee.bean.AccountDetailsAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;

public interface AccountDetailsRepository extends JpaRepository<AccountDetailsAccessBean, Long> {

	AccountDetailsAccessBean findByEmployeeAccessBean(EmployeeAccessBean employeeAccessBean);

}
