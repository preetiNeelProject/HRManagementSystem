package com.hr.system.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.ProjectAccessBean;

public interface ProjectRepository extends JpaRepository<ProjectAccessBean, Long> {

	ProjectAccessBean findByProjectId(Long projectId);
}
