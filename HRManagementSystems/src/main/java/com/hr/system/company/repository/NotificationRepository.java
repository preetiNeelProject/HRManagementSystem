package com.hr.system.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.company.bean.NotificationAccessBean;

public interface NotificationRepository extends JpaRepository<NotificationAccessBean, Long> {

	//List<NotificationAccessBean> findTop3ByNotificationId();

	List<NotificationAccessBean> findTop3ByOrderByNotificationIdDesc();

	List<NotificationAccessBean> findByOrderByNotificationIdDesc();

}