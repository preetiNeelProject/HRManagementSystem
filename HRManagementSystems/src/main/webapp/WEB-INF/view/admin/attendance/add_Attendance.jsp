<script
	src="${pageContext.request.contextPath}/staticResources/JavaScript/attendance.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
tfoot {
	display: table-header-group;
}

#table_filter {
	float: right;
}

#table_filter input {
	width: 258px;
	height: 30px;
	border-radius: 5px;
	margin-bottom: 10px;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-1 col-sm-12"><jsp:include
				page="../../commonView/mainNavbar.jsp" /></div>
		<div class="col-lg-11 col-sm-12">
			<div class="col-lg-11 col-sm-12"
				style="width: 100%; padding-right: 0px;"><jsp:include
					page="../../commonView/header.jsp" /></div>
			<div class="col-lg-11 col-sm-12" style="width: 100%;"><jsp:include
					page="../../commonView/attendanceNav.jsp" /></div>

			<!-- ----------------------Heading-------------------- -->
			<div class="col-md-12" style="padding: 40px 10px 10px;">
				<div class="row" style="background: #c5f5cb;">
					<div class="col-sm-6">
						<div class="row">
							<div style="margin-left: 29px;">
								<h2>
									<b>Attendance</b>
								</h2>
							</div>

						</div>
					</div>
					<div class="col-sm-6" id="addEmp">
						<div class="row">
						</div>
					</div>
				</div>
			</div>



			<!-- -----------Form------------------------ -->
			<div class="col-lg-11 col-sm-12">
				<!-- MultiStep Form -->
				<div class="" id="grad1">
					<div class="row justify-content-center mt-0">
						<div class="col-1 col-md-1 col-sm-2 col-lg-1"></div>
						<div
							class="col-10 col-sm-10 col-md-9 col-lg-10 text-center p-0 mt-3 mb-2">
							<div class="card px-0 pt-4 pb-0 mt-3 mb-3">
								<h3>
									<c:if test="${not empty dep}">
										<strong>Edit Attendance</strong>
									</c:if>
									<c:if test="${empty dep}">
										<strong>Add New Attendance</strong>
									</c:if>
								</h3>
								<p>Fill all form field to go to next step</p>
								<div class="row">
									<div class="col-md-12 mx-0">
										<form id="attendanceform" class="allform" name="attendanceform"
											action="admin/company/addAttendance" method="POST">
											<!-- progressbar -->
											<ul id="progressbar" style="margin-left: 40%;">
												<li class="active" id="personal"><strong>Attendance</strong></li>
												<li id="confirm"><strong>Finish</strong></li>
											</ul>
											<!-- fieldsets -->
											<fieldset>
												<div class="form-card">
													<div class="col-sm-12" style="">
													<div id="errorAttendanceform" style="color:red;display:none">All field is mandatory!</div>
													</div>
													<%-- <div style="color: midnightblue;
    background: yellow;">
													<h4><center>All fields are mandatory...</center></h4>
													</div> --%>
													<div class="col-sm-12" style="margin: 50px 15px;">
														<div class="row">
															<div class="col-sm-3">
																<h4 class="fs-title">Employee</h4>
															</div>
															<div class="col-sm-9">
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Employee-Id?:</label>
																	<div>
																		<select name="employeeId" id="employeeId">
																			<c:forEach items="${employee}" var="employee">
      																             <option
																					value="${employee.employeeId}">${employee.employeeCode}(${employee.firstName} ${employee.lastName})</option>
																			</c:forEach>
																		</select><br />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Project:</label>
																	<div>
																		<input type="text" name="projectId" id="projectId"
																			value="1" readonly />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Manager:</label>
																	<div>
																		<input type="text" name="managerId" id="managerId"
																			value="1" readonly />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Holiday:</label>
																	<div>
																		<select name="holidayId" id="holidayId">
																			<option value="1">No Holiday</option>
																			<option value="2">Government </option>
																			<option value="3">Company </option>
																			<option value="4">Emergency </option>
																		</select><br />
																	</div>
																</div>
															</div>
														</div>
														<div class="col-sm-12" style="margin: 20px 0px;">
															<div class="row">
																<div class="col-sm-3">
																	<h4 class="fs-title">Attendance</h4>
																</div>
																<div class="col-sm-9">
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Date:</label>
																		<div>
																			<input type="date" name="date" id="date" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Day:</label>
																		<div>
																			<select name="day">
																	          <option value="Sunday">Sunday</option>
																	          <option value="Monday">Monday</option>
																	          <option value="Tuesday">Tuesday</option>
																	          <option value="Wednesday">Wednesday</option>
																	          <option value="Thursday">Thursday</option>
																	          <option value="Friday">Friday</option>
																	          <option value="Saturday">Saturday</option>
																	         </select>
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Check-In Time:</label>
																		<div>
																			<input type="text" name="checkIn" id="checkIn" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Check-Out Time:</label>
																		<div>
																			<input type="text" name="checkOut" id="checkOut" />
																		</div>
																	</div>
																    <div class="form-group col-sm-12" style="padding: 0px;">
																	<label>Status:</label>
																	<div>
																			<select name="status" id="status">
																	          <option value="P">Present</option>
																	          <option value="L">Leave</option>
																	          <option value="P">Sunday</option>
																	          <option value="PL">Paid Leave</option>
																	          <option value="P">Festival</option>
																		         </select>
																	</div>

															</div>
																</div>
															</div>
														</div>
													</div>
												</div>
									<input type="button" name="Submit" value="Submit" id="myBtn"
										onclick="addAttendanceForm();" class="next action-button"
										value="Submit" >
									</fieldset>
									<!-- 	End Attendance Information -->
                                       <fieldset>
										<div class="form-card">
											<h2 class="fs-title text-center">Success !</h2>
											<br> <br>
											<div class="row justify-content-center">
												<div class="col-3">
													<img
														src="https://img.icons8.com/color/96/000000/ok--v2.png"
														style="width: 50%; height: 50%" class="fit-image">
												</div>
											</div>
											<br> <br>
											<div class="row justify-content-center">
												<div class="col-7 text-center">
													<h5>You Have Successfully Add Attendance</h5>
												</div>
											</div>
										</div>
									</fieldset>


									
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>
</div>
</div>


</body>
</html>
<script>
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
</script>