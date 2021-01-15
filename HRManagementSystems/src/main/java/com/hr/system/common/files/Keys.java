package com.hr.system.common.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("keys")
public class Keys {

	@Value("#{'${TimesheetHeader}'.split(',')}")
	private String[] timesheetHeader;

	@Value("#{'${EmployeeListHeader}'.split(',')}")
	private String[] employeeListHeader;
	
	@Value("${TimesheetDownloadLocation}")
	private String timesheetDownloadLocation;

	public String[] getTimesheetHeader() {
		return timesheetHeader;
	}

	public void setTimesheetHeader(String[] timesheetHeader) {
		this.timesheetHeader = timesheetHeader;
	}

	public String[] getEmployeeListHeader() {
		return employeeListHeader;
	}

	public void setEmployeeListHeader(String[] employeeListHeader) {
		this.employeeListHeader = employeeListHeader;
	}

	public String getTimesheetDownloadLocation() {
		return timesheetDownloadLocation;
	}

	public void setTimesheetDownloadLocation(String timesheetDownloadLocation) {
		this.timesheetDownloadLocation = timesheetDownloadLocation;
	}
	
	

}