package com.hr.system.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.DepartmentAccessBean;
import com.hr.system.company.bean.RoleAccessBean;

public interface RoleRepository extends JpaRepository<RoleAccessBean, Long> {

	RoleAccessBean findByRoleId(Long roleId);

}
