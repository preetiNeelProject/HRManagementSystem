<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/staticResources/JavaScript/uploadAndDownload.js"></script>
<script src="${pageContext.request.contextPath}/staticResources/JavaScript/globalSearch.js"></script>
<script
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>


<div class="container-fluid">
<div class="row">
<div class="col-lg-1 col-sm-12" 
   ><jsp:include page="../../commonView/mainNavbar.jsp" /></div>
		<div class="col-lg-11 col-sm-12">
			<div class="col-lg-11 col-sm-12"
				style="width: 100%; padding-right: 0px;"><jsp:include
					page="../../commonView/header.jsp" /></div>
			<div class="col-lg-11 col-sm-12" style="width: 100%;"><jsp:include
					page="../../commonView/attendanceNav.jsp" /></div>

			<div class="col-lg-11 col-sm-12">

<div class="container">
	<div class="row">
		<div class="taxStyle" style="display: block" id="summary">
			<div class="container">
				<div class="row">


					<div class="col-md-12">
						<div class="row">
							<div class="col-md-12" style="margin: 20px;">
								<div class="row">
									<div class="col-sm-6">
										<div id="mainHeadingTitle">Attendance Logs</div>
									</div>
									<div class="col-sm-6">
										<div class="empAttdenDet" style="padding-left: 30%;">
											<h5>
												<b>Department:</b>${records[0].departmentName}
											</h5>
											<h6>
												<b>Manager:</b>${records[0].manager}</h6>
											<h6>
												<b>Location:</b>${records[0].add1},${records[0].add2},${records[0].add3}</h6>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-12" style="padding: 0px 40px;">
								<div class="row"
									style="background: #f2f2f2; border-top-right-radius: 10px; border-top-left-radius: 10px;">

									<div class="col-sm-6">
										<div class="empAttdenDet" style="">
											<h4>
												<b>Employee Name:</b>${records[0].firstName}
												${records[0].lastName}
											</h4>
											<h6>
												<b>EmployeeId:</b>${records[0].employeeCode}</h6>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="row">
											<div class="col-sm-2"></div>
											<div class="col-sm-2"></div>
											<div class="col-sm-4">
												
											</div>
											<div class="col-sm-4">
												
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-12" style="padding: 0px 40px;">
						<div class="row" style="background: #f2f2f2;">
							<div id="allData" style="padding: 10px;">
								<div class="table-responsive">
									<table id="table" class="table table-bordred table-striped">

										<thead style="background: #283655; color: white;">
											<tr>
												<th></th>
												<th>Date</th>
												<th>Status</th>
												<th>In-Time</th>
												<th>Out-Time</th>
												<th>Work Duration</th>
												<th>Breaks</th>
												<th>Break Duration</th>
												<th>Over Time</th>
												<th>Action</th>
											</tr>
										</thead>
										
										<tbody id="salaryRevisionTable">
											<c:forEach items="${records}" var="record">
												<tr>
													<td><input type="checkbox" name="snos"
														value="${record.attendanceId}"></td>
													<td>${record.date}</td>
													<td>${record.status}</td>
													<td>${record.inTime}</td>
													<td>${record.outTime}</td>
													<td>${record.workingHours}</td>

													<td>${record.overTime}</td>
													<td>${record.overTime}</td>
													<td>${record.overTime}</td>


													<td style="display: inline-block; width: 150px;"><a
														class="btn btn-danger"
														onclick="uploadTimeSheetForm('${record.timesheetId}')"><i
															class="fa fa-upload" aria-hidden="true"></i> </a> <a
														class="btn btn-warning"
														onclick="downloadTimeSheetForm('${record.timesheetId}')"><i
															class="fa fa-download" aria-hidden="true"></i> </a>  <a
														class="btn btn-success"
														href="${pageContext.request.contextPath}/admin/attendance/deleteAttendance/${record.timesheetId}'"><i
															class="fa fa-trash" aria-hidden="true"></i> </a>&nbsp;&nbsp;
													</td>
												</tr>
											</c:forEach>
										</tbody>

									</table>

									<div class="clearfix"></div>


								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Start Export Form -->
<div class="form-popup" id="myForm">
	<form class="form-horizontal" action="/attendance/exportData"
		th:action="@{exportData}" method="GET" th:object="${timesheet}">
		<h4>Select Date Range</h4>

		<label for="fromDate"><b>Date</b></label> <input type="date"
			name="fromDate" th:field="*{fromDate}" /><br /> 
		<input type="hidden" name="toDate" th:field="*{toDate}" /><br /> <input
			type="hidden" name="timeshId" id="timeshId" th:field="*{toDate}" /><br />

		<button type="submit" class="btn">Export</button>
		<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
	</form>
</div>
<!-- End Export Form -->
<!-- Start Import Form -->
<div class="form-popup" id="myExportForm">
	<form class="form-horizontal" action="/attendance/uploadAttendance"
		th:action="@{uploadAttendance}" enctype="multipart/form-data"
		method="post">
		<h4>File(CSV only)</h4>
		<br> <input type="file" name="csv" accept=".csv" required><br />
		<br>
		<button type="submit" class="btn">Import</button>
		<button type="button" class="btn cancel" onclick="closeForm1()">Close</button>
	</form>
</div>
<!-- End Import Form -->

</div>
		</div>
	</div>
</div>


</body>
</html>
<script>
	var id;
	var $rows = $('#salaryRevisionTable tr');
	$('#search').keyup(function() {
		var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

		$rows.show().filter(function() {
			var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
			return !~text.indexOf(val);
		}).hide();
	});

	/* var $col1 = $('#employeeCode');

	 $('#search1').keyup(function() {
	 var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
	
	 $col1.show().filter(function() {
	 var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
	 return !~text.indexOf(val);
	 }).hide();
	 }); */

	$('#table tfoot th').each(function() {
		var title = $(this).text();
		$(this).html('<input type="text" placeholder="Search '+title+'" />');
	});

	// DataTable
	var otable = $('#table').DataTable();

	// Apply the search
	otable.columns().every(function() {

		var that = this;
		$('input', this.footer()).on('keyup change', function() {
			if (that.search() !== this.value) {
				that.search(this.value).draw();
			}
		});
	});
	function exportTimeSheetForm() {
		document.getElementById("myForm").style.display = "block";
	}
	function downloadTimeSheetForm(timesheetId) {
		$('#timeshId').val(timesheetId);
		document.getElementById("myForm").style.display = "block";
	}

	function closeForm() {
		document.getElementById("myForm").style.display = "none";
	}

	function uploadTimeSheetForm(timesheetId) {
		$('#timesheeId').val(timesheetId);
		document.getElementById("myExportForm").style.display = "block";
	}

	function closeForm1() {
		document.getElementById("myExportForm").style.display = "none";
	}
</script>