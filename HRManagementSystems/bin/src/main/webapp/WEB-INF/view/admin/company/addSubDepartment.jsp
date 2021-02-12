<script src="${pageContext.request.contextPath}/staticResources/JavaScript/department.js"></script>
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
					page="../../commonView/companyNav.jsp" /></div>

			<!-- ----------------------Heading-------------------- -->
			<div class="col-md-12" style="padding: 40px 10px 10px;">
				<div class="row" style="background: #c5f5cb;">
					<div class="col-sm-6">
						<div class="row">
							<div style="margin-left: 29px;">
								<h2>
									<b>Sub-Department</b>
								</h2>
							</div>

						</div>
					</div>
					<div class="col-sm-6" id="addEmp">
						<div class="row">
							<ul style="float: right; margin-right: 10%;">
								<li>
									<a class="btn btn-danger" style="color: white;"
										href="${pageContext.request.contextPath}/admin/company/addDepartment">Add
										Department</a>
									<a class="btn btn-danger" style="color: white;"
										href="${pageContext.request.contextPath}/admin/company/subDepartment">
										Sub-Department</a>

								</li>
							</ul>
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
									<c:if test="${not empty subdep}">
										<strong>Edit Sub-Department</strong>
									</c:if>
									<c:if test="${empty subdep}">
										<strong>Add New Sub-Department</strong>
									</c:if>
								</h3>
								<p>Fill all form field to go to next step</p>
								<div class="row">
									<div class="col-md-12 mx-0">
										<form id="deptform" class="allform" name="deptform"
											action="admin/company/addSubDepartment" method="POST">
											<!-- progressbar -->
											<ul id="progressbar" style="margin-left: 25%;">
												<li class="active" id="personal"><strong>Sub-Department</strong></li>
												<li id="confirm"><strong>Finish</strong></li>
											</ul>
											<!-- fieldsets -->
											<fieldset>
												<div class="form-card">
													<div class="col-sm-12" style="margin: 50px 15px;">
														<div class="row">
															<div class="col-sm-3">
																<h4 class="fs-title">Sub-Department</h4>
															</div>
															<div class="col-sm-9">
																<div class="form-group col-sm-12" style="padding: 0px;">
																	<label>Which department do you want to add
																		sub-department?:</label>
																	<div>
																		<select name="departmentId" id="departmentId">
																			<c:forEach items="${department}" var="department">
																				
																				<c:if test="${not empty subdep}">
																					 <option value="${department.departmentId}"
																						${department.departmentId == subdep.departmentId ? 'selected="selected"' : ''}>${department.deptName}</option>
																				</c:if>
																				<c:if test="${empty subdep}">
      																             <option
																						value="${department.departmentId}">${department.deptName}</option>
																				</c:if>
  																  </c:forEach>
																		</select><br />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Sub-Department Name:</label>
																	<div>
																		<input type="text" name="deptName" id="deptName"
																			value="${subdep.deptName}" />
																			<input type="hidden" name="subDepartmentId" id="subDepartmentId"
																			value="${subdep.subDepartmentId}" />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Sub-Department Description:</label>
																	<div>
																		<input type="text" name="deptDesc" id="deptDesc"
																			value="${subdep.deptDesc}" />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Manager:(Value-1to9)</label>
																	<div>
																		<input type="text" name="managerId" id="managerId"
																			value="${subdep.managerId}" />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Total Employee:</label>
																	<div>
																		<input type="text" name="totalEmployee"
																			id="totalEmployee" value="${subdep.totalEmployee}" />
																	</div>
																</div>
															</div>
														</div>
														<div class="col-sm-12" style="margin: 20px 0px;">
															<div class="row">
																<div class="col-sm-3">
																	<h4 class="fs-title">Employee</h4>
																</div>
																<div class="col-sm-9">
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Maximum Employee:</label>
																		<div>
																			<input type="text" name="maxEmployee"
																				id="maxEmployee" value="${subdep.maxEmployee}" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Minimum Employee:</label>
																		<div>
																			<input type="text" name="minEmployee"
																				id="minEmployee" value="${subdep.minEmployee}" />
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="col-sm-12" style="margin: 20px 0px;">
															<div class="row">
																<div class="col-sm-3">
																	<h4 class="fs-title">Work</h4>
																</div>
																<div class="col-sm-9">
																	<div class="form-group col-sm-12" style="padding: 0px;">
																		<label>Work Description:</label>
																		<div>
																			<textarea rows="3" cols="2" maxlength="50"
																				name="workDesc" id="workDesc" style="height: 70px">${subdep.workDesc}</textarea>
																		</div>
																	</div>

																</div>
															</div>
														</div>
													</div>
												</div>
												<input type="button" name="submit" value="Submit"
													onclick="submitAddSubDepartmentForm();"
													class="next action-button" value="Submit" />
											</fieldset>
											<!-- 	End Department Information -->



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
															<h5>You Have Successfully Add Sub-Department</h5>
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