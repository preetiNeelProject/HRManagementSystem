function applyLeaveForm() {
	
	
	
	var leaveTypeId = document.forms["applyLeaveform"]["leaveTypeId"].value;
	var fromDate = document.forms["applyLeaveform"]["fromDate"].value;
	var toDate = document.forms["applyLeaveform"]["toDate"].value;
	var reason = document.forms["applyLeaveform"]["reason"].value;
	var status = document.forms["applyLeaveform"]["status"].value;
	var leaveId = document.forms["applyLeaveform"]["leId"].value;
	
	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); // January is 0!
	var yyyy = today.getFullYear();

	today = yyyy + '-' + mm + '-' + dd;
	
	// var employeeId = document.forms["applyLeaveform"]["empId"].value;
	if(fromDate == '' || toDate == '' || reason == '' || leaveTypeId == ''){
		document.getElementById("errorApplyLeave").style.display = "block";
	}
	else if(Date.parse(fromDate) > Date.parse(toDate)){
		document.getElementById("errorApplyLeave").style.display = "none";
		document.getElementById("errorDateApplyLeave").style.display = "block";
	} else{
		document.getElementById("errorDateApplyLeave").style.display = "none";
	
	var leave = {
		"leaveTypeId" : leaveTypeId,
		"fromDate" : fromDate,
		"toDate" : toDate,
		"reason" : reason,
		"status" : status,
		"applyDate" : today,
		"leavesId" : leaveId,
	// "employeeId" : employeeId,
	};
	var leaveAccessBean = JSON.stringify(leave);

	console.log("jsonString == " + leaveAccessBean);
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/leave/applyLeave';
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : urlF,
		data : leaveAccessBean,
		dataType : 'json',
		cache : false,
		success : function(response) {
			console.log(response);
			document.getElementById("successApplyLeave").style.display = "block";
			document.getElementById("applyLeaveform").reset();
			setTimeout(function() {
				document.location.reload()
		  }, 2000);
		},

		error : function(error) {
			console.log(error);
		}

	});
	}

}

function rejectedForm() {
	var comments = document.forms["rejectLeaveform"]["comments"].value;
	var empId = document.forms["rejectLeaveform"]["empIdL"].value;
	var leavesId = document.forms["rejectLeaveform"]["leIdL"].value;
	var status = document.forms["rejectLeaveform"]["status"].value;
	if(comments == ''){
		document.getElementById("errorRejectLeave").style.display = "block";
	}
	else{
		document.getElementById("errorRejectLeave").style.display = "none";


	var leave = {
		"comments" : comments,
		"managerId" : empId,
		"leavesId" : leavesId,
		"status" : status,
	};
	var leaveAccessBean = JSON.stringify(leave);

	console.log("jsonString == " + leaveAccessBean);
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/leave/rejectLeave';
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : urlF,
		data : leaveAccessBean,
		dataType : 'json',
		cache : false,
		success : function(response) {
			console.log(response);
			document.getElementById("successRejectLeave").style.display = "block";
			document.getElementById("rejectLeaveform").reset();
			setTimeout(function() {
				document.location.reload()
		  }, 2000);
		},

		error : function(error) {
			console.log(error);
		}

	});
	}
}
