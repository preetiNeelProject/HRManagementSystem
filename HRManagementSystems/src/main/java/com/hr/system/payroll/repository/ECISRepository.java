package com.hr.system.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.system.payroll.bean.EcisAccessBean;

@Repository
public interface ECISRepository extends JpaRepository<EcisAccessBean, Long> {

}
