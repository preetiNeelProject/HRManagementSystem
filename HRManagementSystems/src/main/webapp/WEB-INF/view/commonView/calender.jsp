
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="mainHeadingCalender">
	<form action="${pageContext.request.contextPath}/admin/attendance/viewAttendanceLog" id="viewTImeSheet"
		method="get">
		<input type="date" onchange='this.form.submit()'
			id="filterDate" name="filterDate" value=""> 
	</form>

</div>

<style>
#mainHeadingCalender {
	margin-left: 30%;
}

#btnPrevYear, #btnPrevMonth {
	background: transparent;
	border: none;
	color: darkslateblue;
	font-size: 20px;
}

#btnNextYear, #btnNextMonth {
	background: transparent;
	border: none;
	color: darkslateblue;
	font-size: 20px;
}

#filterDate {
	border: 1px solid lightgray;
	font-size: 14px;
	border-radius: 4px;
	padding: 1px 6px;
	width: 225px;
}
</style>

<script>




	if ($("#filterDate").val() != null) {
		setToday();
	}

	var theDate = Date.now();

	//Set thisYear, thisMonth, thisDay to Today
	//So that we can highlight today on the calendar
	function setToday() {
		var now = new Date();

		var day = ("0" + now.getDate()).slice(-2);
		var month = ("0" + (now.getMonth() + 1)).slice(-2);

		var today = now.getFullYear() + "-" + (month) + "-" + (day);
		$("#filterDate").val(today);

	}

	document
			.getElementById('btnPrevMonth')
			.addEventListener(
					"click",
					function() {
						theDate -= 86400000;
						document.getElementById('filterDate').innerText = getTheDate(theDate)
					})

	function getTheDate(getDate) {
		var theCDate = new Date(getDate);
		var day = ("0" + theCDate.getDate()).slice(-2);
		var month = ("0" + (theCDate.getMonth() + 1)).slice(-2);
		return $("#filterDate").val(
				theCDate.getFullYear() + "-" + (month) + "-" + (day));
	}

	/*-------------- Send Filter Date for employee data---------------- */

	function allAttandenceDataByDate() {

		document.getElementById("viewTImeSheet").submit();
		 var filter = $("#filterDate").val();
		date=filter.split('&')[0];
		//alert(search);
		$.ajax({
		    type: "POST",
		    headers: {
		        "Accept": "application/json",
		        "Content-Type": "application/json"
		    },
		    url: "/attendance/viewAttendanceLogDate",
		    data:date,
		    dataType: 'json',
		    cache: false,
		    success : function(records) {
		        console.log("datas : "+JSON.stringify(records));
		    },
		    
			 error : function(error) {
		        console.log("error : "+JSON.stringify(error));
		     }

		});
	};
</script>