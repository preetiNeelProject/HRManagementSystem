function addAttendanceForm() {

	var employeeId = document.forms["attendanceform"]["employeeId"].value;
	var projectId = document.forms["attendanceform"]["projectId"].value;
	var managerId = document.forms["attendanceform"]["managerId"].value;
	var holidayId = document.forms["attendanceform"]["holidayId"].value;
	var date = document.forms["attendanceform"]["date"].value;
	var day = document.forms["attendanceform"]["day"].value;
	var checkIn = document.forms["attendanceform"]["checkIn"].value;
	var checkOut = document.forms["attendanceform"]["checkOut"].value;
	var status = document.forms["attendanceform"]["status"].value;
	
	if(checkIn == '' && checkOut==''){
		document.getElementById("errorAttendanceform").style.display = "block";
	}
	else{
		document.getElementById("errorAttendanceform").style.display = "none";
	var timesheet = {
		"employeeId" : employeeId,
		"projectId" : projectId,
		"managerId" : managerId,
		"holidayId" : holidayId,
		"date" : date,
		"day" : day,
		"checkIn" : checkIn,
		"checkOut" : checkOut,
		"status" : status

	};

	var timesheetAccessBean = JSON.stringify(timesheet);

	console.log("jsonString == " + timesheetAccessBean);
	//var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/attendance/add_Attendance';
	var urlF='/admin/attendance/add_Attendance';
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : urlF,
		data : timesheetAccessBean,
		dataType : 'json',
		cache : false,
		success : function(response) {
			console.log(response);
		},

		error : function(error) {
			console.log(error);
		}

	});
	}
}