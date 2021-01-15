package com.hr.system.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.payroll.bean.GratuityTypesAccessBean;

@Repository
public interface GratuityTypesRepository extends JpaRepository<GratuityTypesAccessBean, Long> {

}
