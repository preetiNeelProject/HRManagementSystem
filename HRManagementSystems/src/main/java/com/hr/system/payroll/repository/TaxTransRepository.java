package com.hr.system.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.payroll.bean.TaxTransAccessBean;

@Repository
public interface TaxTransRepository extends JpaRepository<TaxTransAccessBean, Long> {

}
