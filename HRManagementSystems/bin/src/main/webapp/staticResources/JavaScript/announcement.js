function addAnnouncement() {

	var announcementId = document.forms["announcementform"]["announcementId"].value;
	var message = document.forms["announcementform"]["message"].value;
	var employeeId = document.forms["announcementform"]["employeeId"].value;

	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); // January is 0!
	var yyyy = today.getFullYear();

	today = yyyy + '-' + mm + '-' + dd;
	if(message == ''){
		document.getElementById("errorAnnouncementform").style.display = "block";
		var element = document.getElementById("announcementform");
		$('head script[src*="/formSteps.js"]').remove(); 
		  return;
	}
	else{
	var announcement = {
		"announcementId" : announcementId,
		"message" : message,
		"employeeId" : employeeId,
		"applyDate" : today

	};

	var announcementAccessBean = JSON.stringify(announcement);

	console.log("jsonString == " + announcementAccessBean);
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/company/addAnnouncement';
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : urlF,
		data : announcementAccessBean,
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