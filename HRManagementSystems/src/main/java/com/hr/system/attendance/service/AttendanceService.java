package com.hr.system.attendance.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.system.attendance.bean.TimesheetAccessBean;

public interface AttendanceService {

	List<Map<String, Object>> attendanceRevision(Long attendanceId, String Date);

	void exportData(HttpServletResponse res, RedirectAttributes flashAttributes, String fromDate, String toDate,
			Long timesheetId);

	void deleteAttendance(HttpServletResponse res, RedirectAttributes flashAttributes, Long timesheetId);

	TimesheetAccessBean add_Attendance(TimesheetAccessBean timesheetAccessBean);

}
