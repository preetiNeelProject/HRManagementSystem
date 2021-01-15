package com.hr.system.leave.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.system.leave.bean.LeaveTypeAccessBean;
import com.hr.system.leave.bean.LeavesAccessBean;

public interface LeaveService {

	void exportData(HttpServletResponse res, RedirectAttributes flashAttributes, String fromDate, String toDate,
			Long timesheetId);

	List<Map<String, Object>> leaveRevision(Long leaveId, String date);

	void deleteLeave(HttpServletResponse res, RedirectAttributes flashAttributes, Long timesheetId);

	List<LeaveTypeAccessBean> leavesType();

	LeavesAccessBean applyLeave(LeavesAccessBean leavesAccessBean);

	List<Map<String, Object>> appliedLeaveLogs(String status);

	LeavesAccessBean acceptLeave(Long leavesId);

	LeavesAccessBean rejectLeave(LeavesAccessBean leavesAccessBean);



}
