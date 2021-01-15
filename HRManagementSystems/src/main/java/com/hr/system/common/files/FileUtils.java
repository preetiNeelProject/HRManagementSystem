package com.hr.system.common.files;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hr.system.attendance.bean.TimesheetAccessBean;
import com.hr.system.company.bean.ProjectAccessBean;
import com.hr.system.company.repository.ProjectRepository;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.EmpWorkRelationRepository;
import com.hr.system.employee.repository.EmployeeRepository;
import com.itextpdf.text.log.SysoCounter;


@Component
public class FileUtils {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmpWorkRelationRepository empWorkRelationRepository;
	
	
	@Autowired
	ProjectRepository projectRepository;
	

	public  void generateTimesheetReport(List<TimesheetAccessBean> records, String location,
			HttpServletResponse response) throws IOException {
		System.out.println("RecordsForTimeSheetDownload:"+records.get(0).getDate());
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=Attendance.csv");
		try (
				
				CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(),
						CSVFormat.DEFAULT.withHeader("S.No", "Employee Id", "Project Id", "Manager Id", "Date", "Day",
								"Check In", "Check Out", "Raw Time", "Round Time", "Status", "Leave Id",
								"Holiday Id"));) {
			System.out.println("============1===========");
			for (TimesheetAccessBean timesheet : records) {
				System.out.println("============1===========");
				System.out.println(timesheet.getEmployeeId());
				Long employeeId=timesheet.getEmployeeId();
				System.out.println(employeeRepository.findByEmployeeId(employeeId));
				System.out.println("============1===========");
				EmployeeAccessBean employeeAccessBean=employeeRepository.findByEmployeeId(employeeId);
				System.out.println(employeeAccessBean.getEmployeeCode());
				System.out.println(timesheet.getProjectId());
				ProjectAccessBean projectAccessBean=projectRepository.findByProjectId(timesheet.getProjectId());
				System.out.println(projectAccessBean.getProjectCode());
				
				List<String> data = Arrays.asList(
						String.valueOf(timesheet.getTimeSheetId()),
						String.valueOf(employeeAccessBean.getEmployeeCode()),
						String.valueOf(timesheet.getManagerId()),
						String.valueOf(projectAccessBean.getProjectCode()),
						String.valueOf(timesheet.getDate()),
						timesheet.getDay(),
						timesheet.getCheckIn(),
						timesheet.getCheckOut(),
						timesheet.getRawTime(),
						timesheet.getRoundTime(),
						timesheet.getStatus(),
						String.valueOf(timesheet.getHolidayId())

				);
				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		}
	}

	
	

}
