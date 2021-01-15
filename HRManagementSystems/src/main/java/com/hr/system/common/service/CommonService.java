package com.hr.system.common.service;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.hr.system.company.bean.NotificationAccessBean;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;

public interface CommonService {

	void savePreviousSalary(Optional<EmployeeCTCAccessBean> empSalary) ;

	String uploadFiles(MultipartFile csv,String type,Long timesheet) throws IOException;

	boolean addNotification(NotificationAccessBean notificationAccessBean);

	 void salarySlip(Long employeeCTCId, Long month, HttpServletRequest request,HttpServletResponse response);


}
