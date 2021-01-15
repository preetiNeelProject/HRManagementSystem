package com.hr.system.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hr.system.company.bean.SubRoleAccessBean;

public interface SubRoleRepository extends JpaRepository<SubRoleAccessBean, Long> {

	SubRoleAccessBean findBySubRoleId(Long subRoleId);

}
