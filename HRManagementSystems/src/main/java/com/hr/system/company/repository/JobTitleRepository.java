package com.hr.system.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.JobTitleAccessBean;

public interface JobTitleRepository extends JpaRepository<JobTitleAccessBean, Long> {

	JobTitleAccessBean findByJobTitleId(Long jobTitleId);

}
