package com.hr.system.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.AnnouncementAccessBean;

public interface AnnouncementRepository extends JpaRepository<AnnouncementAccessBean, Long> {

	AnnouncementAccessBean findByAnnouncementId(Long announcementId);

}