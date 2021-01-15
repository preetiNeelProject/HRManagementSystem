package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.employee.bean.DocumentAccessBean;

public interface DocumentRepository extends JpaRepository<DocumentAccessBean, Long> {
	
	DocumentAccessBean save(DocumentAccessBean documentAccessBean);

}
