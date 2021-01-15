package com.hr.system.attendance.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.hr.system.attendance.bean.TimesheetAccessBean;
import com.hr.system.attendance.service.AttendanceService;
import com.hr.system.common.service.CommonService;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.service.EmployeeService;

/**
 * 
 * @author Preeti Rani
 * @since 1 Sep 2020
 * @apiNote This controller used for Attendance management of employee
 *
 */

@Controller
public class AttendanceControllerCmd {

	@Autowired
	CommonService commonService;

	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	EmployeeService employeeService;
	

	

	ModelAndView modelAndView = new ModelAndView();
	
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view dashboard of all employee and call on
	 *          jsp
	 *
	 */
	@RequestMapping(value = "/admin/attendance/dashboard")
	public String dash() {
		return "admin/attendance/dashboard";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view Attendance Log of all employee and call on
	 *          jsp
	 * @param records used for fetch the all employees attendance data from database
	 * @throws ParseException
	 *
	 */
	@RequestMapping(value = "admin/attendance/viewAttendanceLog", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView viewAttendanceLog() throws ParseException {
		Long attendanceId = null;
		String date=null;
		Date fdate = null;
		if (date == null) {
			fdate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			date = format.format(fdate);
		}
		modelAndView.addObject("records", attendanceService.attendanceRevision(attendanceId,date));
		modelAndView.setViewName("admin/attendance/viewAttendanceLog");
		return modelAndView;
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view Attendance Log of all employee and call on
	 *          jsp
	 * @param records used for fetch the all employees attendance data from database
	 *                to date filter
	 *
	 */
	@RequestMapping(value = "admin/attendance/viewAttendanceLogDate", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView  viewAttendanceLogDate(@RequestParam("filterDate") String date,HttpServletRequest req,HttpServletResponse res,ModelMap model,RedirectAttributes flashAttributes) {
		Long attendanceId = null;
		ModelAndView modelAndView=new  ModelAndView();
		List<Map<String,Object>> records=attendanceService.attendanceRevision(attendanceId,date);
		if(records.isEmpty()) {
			flashAttributes.addFlashAttribute("msg","Sorry! No records found...");
		}
		else
		{	
		modelAndView.addObject("records", records);
		}
		modelAndView.setViewName("/admin/attendance/viewAttendanceLog");
		return modelAndView; 
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for upload Attendance excel sheet on
	 *          viewAttendanceLog.jsp
	 * @param csv used for get the all employees attendance data in excel sheet from
	 *            jsp
	 *
	 */
	@RequestMapping(value = "admin/attendance/uploadAttendance", method = RequestMethod.POST)
	public String uploadBulk(HttpServletRequest request,@RequestParam("csv") MultipartFile csv,RedirectAttributes flashAttributes) throws IOException {
		Long id=0L;
		String flage = commonService.uploadFiles(csv, "timesheet",id);
		if(flage.equals("Success"))
			flashAttributes.addFlashAttribute("msg","All files have been uploaded successfully.");
		else
		{
			flashAttributes.addFlashAttribute("err","1");
			if(flage.equals("Failed"))
				flashAttributes.addFlashAttribute("msg","Files couldn't be uploaded!");
			else
				flashAttributes.addFlashAttribute("msg","All files can't be uploaded successfully!");
		}
		return "redirect:viewAttendanceLog";
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for upload Attendance excel sheet for One day for Update Purpose
	 *          viewAttendanceLog.jsp
	 * @param csv used for get the all employees attendance data in excel sheet from
	 *            jsp
	 *
	 */
	@RequestMapping(value = "admin/attendance/updateAttendanceByUpload", method = RequestMethod.POST)
	public String updateAttendanceByUpload(HttpServletRequest request,@RequestParam("csv") MultipartFile csv,@RequestParam("timesheeId") Long timesheet,RedirectAttributes flashAttributes) throws IOException {
		String flage = commonService.uploadFiles(csv, "timesheet",timesheet);
		if(flage.equals("Success"))
			flashAttributes.addFlashAttribute("msg","All files have been uploaded successfully.");
		else
		{
			flashAttributes.addFlashAttribute("err","1");
			if(flage.equals("Failed"))
				flashAttributes.addFlashAttribute("msg","Files couldn't be uploaded!");
			else
				flashAttributes.addFlashAttribute("msg","All files can't be uploaded successfully!");
		}
		return "redirect:admin/attendance/viewAttendanceLog";
	}

	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for download Attendance excel sheet on
	 *          viewAttendanceLog.jsp
	 * @param records used for fetch the all employees attendance data from database
	 *                in excel form datewise
	 *
	 */
	@RequestMapping(value = "admin/attendance/exportData", method = RequestMethod.GET)
	public String exportData(HttpServletRequest rep,HttpServletResponse res,@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,RedirectAttributes flashAttributes) {
		Long timesheetId=null;
		attendanceService.exportData(res,flashAttributes,fromDate, toDate,timesheetId);
		return null;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for download Attendance excel sheet of a employeeon
	 *          viewAttendanceLog.jsp
	 * @param records used for fetch of an employes attendance data from database
	 *                in excel form datewise
	 *
	 */
	@RequestMapping(value = "admin/attendance/exportDataEmployee", method = RequestMethod.GET)
	public String exportData(HttpServletRequest rep,HttpServletResponse res,@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,@RequestParam("timeshId") Long timesheetId,RedirectAttributes flashAttributes) {
		attendanceService.exportData(res,flashAttributes,fromDate, toDate,timesheetId);
		return null;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for delete Attendance of an employee
	 *          viewAttendanceLog.jsp
	 * @param timesheetId only
	 *
	 */
	@RequestMapping(value = "admin/attendance/deleteAttendance/{timesheetId}", method = RequestMethod.GET)
	public String deleteAttendance(HttpServletRequest rep,HttpServletResponse res,@PathVariable("timesheetId") Long timesheetId,RedirectAttributes flashAttributes) {
		attendanceService.deleteAttendance(res,flashAttributes,timesheetId);
		flashAttributes.addFlashAttribute("msg","Delete successfully!");
		return "redirect:admin/attendance/viewAttendanceLog";
	}
	
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for view Attendance Log of all employee and call on
	 *          jsp
	 * @param records used for fetch the all employees attendance data from database
	 * @throws ParseException
	 *
	 */
	@RequestMapping(value = "admin/attendance/viewEmpAttendanceLog/{attendanceId}", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView viewEmpAttendanceLog(@PathVariable("attendanceId") Long attendanceId) throws ParseException {
		String date="";
		modelAndView.addObject("records", attendanceService.attendanceRevision(attendanceId,date));
		modelAndView.setViewName("admin/attendance/viewEmpAttendanceLog");
		return modelAndView;
	}
	

	/**
	 * @Error --> no need attendence id
	 * @author Preeti Rani
	 * @apiNote This method used for view Attendance Log of all employee and call on
	 *          jsp
	 * @param records used for fetch the all employees attendance data from database
	 * @throws ParseException
	 *
	 */
	@RequestMapping(value = "admin/attendance/viewEmpAttendanceLog", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView viewEmpAttendanceLog() throws ParseException {
		String date="";
		//Long attendanceId=1L;
		//modelAndView.addObject("records", "hi");
		modelAndView.setViewName("admin/attendance/viewEmpAttendanceLog");
		return modelAndView;
	}
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add Attendance 
	 *          jsp page call
	 *
	 * @throws ParseException
	 *
	 */
	@RequestMapping(value = "admin/attendance/add_Attendance", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView addAttendance() {
		ModelAndView modelAndView=new ModelAndView();
		System.out.println("-------------hi2");
		        modelAndView.addObject("employee", employeeService.findAllEmployee());
				modelAndView.setViewName("admin/attendance/add_Attendance");
				return modelAndView;
	}
	
	
	/**
	 * 
	 * @author Preeti Rani
	 * @apiNote This method used for add Attendance 
	 *         on database
	 *
	 * @throws ParseException
	 *
	 */
	@RequestMapping(value = "admin/attendance/add_Attendance", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public @ResponseBody Long add_Attendance(@RequestBody TimesheetAccessBean timesheetAccessBean) {
		System.out.println("-------------hi");
		TimesheetAccessBean timesheetAB = attendanceService.add_Attendance(timesheetAccessBean);
		return timesheetAB.getEmployeeId();
	}
}
