package com.hr.system.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.payroll.bean.TaxAccessBean;

@Repository
public interface TaxRepository extends JpaRepository<TaxAccessBean, Long> {

}
