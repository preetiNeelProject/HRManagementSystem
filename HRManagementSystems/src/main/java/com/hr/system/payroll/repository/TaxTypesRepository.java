package com.hr.system.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.payroll.bean.TaxTypesAccessBean;

@Repository
public interface TaxTypesRepository extends JpaRepository<TaxTypesAccessBean, Long> {

}
