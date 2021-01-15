package com.hr.system.leave.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.system.attendance.bean.TimesheetAccessBean;
import com.hr.system.attendance.repository.AttendanceRepository;
import com.hr.system.attendance.repository.TimesheetRepository;
import com.hr.system.common.controller.CommonControllerCmd;
import com.hr.system.common.files.FileUtils;
import com.hr.system.common.files.Utils;
import com.hr.system.company.bean.DepartmentAccessBean;
import com.hr.system.company.bean.EmpWorkRelationAccessBean;
import com.hr.system.company.bean.WorkLocationAccessBean;
import com.hr.system.company.repository.DepartmentRepository;
import com.hr.system.employee.bean.AddressAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.employee.repository.WorkLocationRepository;
import com.hr.system.leave.bean.LeaveTypeAccessBean;
import com.hr.system.leave.bean.LeavesAccessBean;
import com.hr.system.leave.repository.LeaveRepository;
import com.hr.system.leave.repository.LeaveTypeRepository;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	Utils utils;

	@Autowired
	FileUtils fileUtils;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	CommonControllerCmd commonControllerCmd;

	@Autowired
	TimesheetRepository timesheetRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	AttendanceRepository attendanceRepository;

	@Autowired
	WorkLocationRepository workLocationRepository;

	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	@Autowired
	LeaveRepository leaveRepository;

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view Attendance Log of all employee and call on
	 *          jsp in service
	 * @param records used for fetch the all employees attendance data from database
	 *
	 */
	@Override
	public List<Map<String, Object>> leaveRevision(Long attendanceId, String date) {

		/*******************
		 * LOGIC TO DISPLAY ONLY SELECTED VALUES IN ATTENDANCE DISPLAY PAGE
		 **************************************/
		List<TimesheetAccessBean> timesheetData = null;
		if (date != "") {
			timesheetData = timesheetRepository.findByDate(date);
		} else {
			TimesheetAccessBean timesheetAccessBean = timesheetRepository.findByTimeSheetId(attendanceId);
			Long employeeId = timesheetAccessBean.getEmployeeId();
			timesheetData = timesheetRepository.findByEmployeeId(employeeId);
		}

		List<Map<String, Object>> responseAttendanceList = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < timesheetData.size(); i++) {

			Map<String, Object> attendanceMap = new HashMap<String, Object>();
			attendanceMap.put("timesheetId", timesheetData.get(i).getTimeSheetId());
			attendanceMap.put("inTime", timesheetData.get(i).getCheckIn());
			attendanceMap.put("outTime", timesheetData.get(i).getCheckOut());
			attendanceMap.put("status", timesheetData.get(i).getStatus());
			attendanceMap.put("date", timesheetData.get(i).getDate());
			attendanceMap.put("employeeId", timesheetData.get(i).getEmployeeId());

			EmployeeAccessBean employeeAccessBean = employeeRepository.getOne(timesheetData.get(i).getEmployeeId());
			attendanceMap.put("employeeCode", employeeAccessBean.getEmployeeCode());

			if (employeeAccessBean.getAddressAccessBean() != null) {
				List<AddressAccessBean> addressAccessBeans = employeeAccessBean.getAddressAccessBean();
				if (addressAccessBeans != null) {
					attendanceMap.put("addressId", addressAccessBeans.get(0).getAddressId());
					attendanceMap.put("firstName", addressAccessBeans.get(0).getFirstName());
					attendanceMap.put("lastName", addressAccessBeans.get(0).getLastName());
					Long worklocationId = addressAccessBeans.get(0).getWorkLocationId();
					WorkLocationAccessBean workLocationAccessBean = workLocationRepository.getOne(worklocationId);
					attendanceMap.put("add1", workLocationAccessBean.getAddress1());
					attendanceMap.put("add2", workLocationAccessBean.getAddress2());
					attendanceMap.put("add3", workLocationAccessBean.getAddress3());
				}
			}
			if (employeeAccessBean.getEmpWorkRelationAccessBean() != null) {
				EmpWorkRelationAccessBean empWorkRelationAccessBean = employeeAccessBean.getEmpWorkRelationAccessBean();
				attendanceMap.put("empWorkRelation", empWorkRelationAccessBean.getEmpWorkRelationId());
				attendanceMap.put("manager", empWorkRelationAccessBean.getManager());
				attendanceMap.put("departmentId", empWorkRelationAccessBean.getDepartmentId());

				DepartmentAccessBean departmentAccessBean = departmentRepository
						.getOne(empWorkRelationAccessBean.getDepartmentId());
				attendanceMap.put("departmentName", departmentAccessBean.getDeptName());

			}

			responseAttendanceList.add(attendanceMap);
		}

		return responseAttendanceList;
	}

	/*
	 * @Override public void exportData(String fromDate, String toDate) {
	 * List<TimesheetAccessBean>
	 * data=timesheetRepository.findDataWithDateRange(Date.valueOf(fromDate),
	 * Date.valueOf(toDate)); System.out.println(data); }
	 */

	@Transactional
	public void exportData(HttpServletResponse response, RedirectAttributes flashAttributes, String fromDate,
			String toDate, Long timesheetId) {

		String home = System.getProperty("user.home");
		String location = home + "/Downloads/";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = null, sqlDate2 = null;

		try {
			java.util.Date utilDate = format.parse(fromDate);
			sqlDate = new java.sql.Date(utilDate.getTime());
			java.util.Date utilDate2 = format.parse(toDate);
			sqlDate2 = new java.sql.Date(utilDate2.getTime());
		} catch (Exception e) {
			System.out.println(e);
		}
		// employeeId for timesheet...
		Long employeeId = null;
		if (timesheetId != null) {
			TimesheetAccessBean timesheetAccessBean = timesheetRepository.getOne(timesheetId);
			employeeId = timesheetAccessBean.getEmployeeId();
		}
		Query q = null;
		if (sqlDate2 != null) {
			q = entityManager.createNativeQuery(
					"SELECT * FROM Timesheet WHERE date BETWEEN '" + sqlDate + "' AND '" + sqlDate2 + "'",
					TimesheetAccessBean.class);
		} else {
			q = entityManager.createNativeQuery("SELECT * FROM Timesheet WHERE date ='" + sqlDate + "'",
					TimesheetAccessBean.class);
		}
		@SuppressWarnings("unchecked")
		List<TimesheetAccessBean> dataAll = q.getResultList();
		List<TimesheetAccessBean> data = new ArrayList<TimesheetAccessBean>();
		if (timesheetId != null) {
			if (dataAll.size() > 0) {
				for (int i = 0; i < dataAll.size(); i++) {
					if (dataAll.get(i).getEmployeeId() != null) {
						if (dataAll.get(i).getEmployeeId().equals(employeeId)) {
							data.add(dataAll.get(i));
						}
					}
				}
				if (data != null)
					try {
						fileUtils.generateTimesheetReport(data, location, response);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else
					flashAttributes.addFlashAttribute("msg", "Sorry! No match found...");
			} else {
				flashAttributes.addFlashAttribute("msg", "Sorry! No match found...");
			}

		} else {
			try {
				fileUtils.generateTimesheetReport(dataAll, location, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for delete Attendance of employee
	 * @param timesheetId used delete employee attendance data from database
	 *
	 */
	@Override
	public void deleteLeave(HttpServletResponse res, RedirectAttributes flashAttributes, Long timesheetId) {
		commonControllerCmd.addNotifications(110L, "Delete Leave : "+timesheetId+".");
		timesheetRepository.deleteById(timesheetId);
	}

	@Override
	public List<LeaveTypeAccessBean> leavesType() {
		return leaveTypeRepository.findAll();
	}

	@Override
	public LeavesAccessBean applyLeave(LeavesAccessBean leavesAccessBean) {
		commonControllerCmd.addNotifications(110L, "Employee "+leavesAccessBean.getEmployeeId()+" applied for leave.");
		return leaveRepository.save(leavesAccessBean);
	}

	@Override
	public List<Map<String, Object>> appliedLeaveLogs(String status) {
		List<LeavesAccessBean> manageLeaveList = leaveRepository.findAllByStatus(status);
		/*******************
		 * LOGIC TO DISPLAY ONLY SELECTED VALUES IN EMPLOYEE Leave DISPLAY PAGE
		 **************************************/
		List<Map<String, Object>> responseLeaveList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < manageLeaveList.size(); i++) {

			Map<String, Object> pendingLeaveMap = new HashMap<String, Object>();
			pendingLeaveMap.put("employeeId", manageLeaveList.get(i).getEmployeeId());
			pendingLeaveMap.put("leavesId", manageLeaveList.get(i).getLeavesId());
			EmployeeAccessBean employeeList = employeeRepository
					.findByEmployeeId(manageLeaveList.get(i).getEmployeeId());
			if (employeeList != null) {
				pendingLeaveMap.put("employeeCode", employeeList.getEmployeeCode());
				List<AddressAccessBean> addressList=employeeList.getAddressAccessBean();
				if (!addressList.isEmpty()) {
				pendingLeaveMap.put("employeeName", addressList.get(0).getFirstName());
				pendingLeaveMap.put("employeeLastName", addressList.get(0).getLastName());
				}
			}
			pendingLeaveMap.put("status", manageLeaveList.get(i).getStatus());
			System.out.println(manageLeaveList.get(i).getLeaveTypeId());
			pendingLeaveMap.put("leaveType",
					leaveTypeRepository.findByLeaveTypeId(manageLeaveList.get(i).getLeaveTypeId()).getLeaveName());
			
			pendingLeaveMap.put("fromDate",commonControllerCmd.dateFromDatabase(manageLeaveList.get(i).getFromDate()));
			pendingLeaveMap.put("toDate",commonControllerCmd.dateFromDatabase(manageLeaveList.get(i).getToDate()));
			pendingLeaveMap.put("applyDate",commonControllerCmd.dateFromDatabase(manageLeaveList.get(i).getApplyDate()));
			pendingLeaveMap.put("reason", manageLeaveList.get(i).getReason());


			responseLeaveList.add(pendingLeaveMap);
		}

		return responseLeaveList;
	}

	@Override
	public LeavesAccessBean acceptLeave(Long leavesId) {
		
		LeavesAccessBean leavesData=leaveRepository.findByLeavesId(leavesId);
		leavesData.setApprovedBy("Mr MK Sharma");
		leavesData.setComments("Ok I approved your leave");
		leavesData.setManagerId(111L);
		leavesData.setStatus("Approved");
		commonControllerCmd.addNotifications(110L, "Approved Leave of employee Id: "+leavesData.getEmployeeId()+".");
		return leaveRepository.save(leavesData);
	}

	@Override
	public LeavesAccessBean rejectLeave(LeavesAccessBean leavesAccessBean) {
		LeavesAccessBean leavesData=leaveRepository.findByLeavesId(leavesAccessBean.getLeavesId());
		leavesData.setLeavesId(leavesAccessBean.getLeavesId());
		leavesData.setComments(leavesAccessBean.getComments());
		leavesData.setManagerId(leavesAccessBean.getManagerId());
		leavesData.setStatus(leavesAccessBean.getStatus());
		commonControllerCmd.addNotifications(110L, "Reject Leave by: "+leavesData.getEmployeeId()+".");
		return leaveRepository.save(leavesData);
	}

}
