package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.employee.bean.AddressAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;

@Repository
public interface AddressRepository extends JpaRepository<AddressAccessBean, Long> {

	AddressAccessBean findByEmployeeAccessBean(EmployeeAccessBean employeeAccessBean);

}
