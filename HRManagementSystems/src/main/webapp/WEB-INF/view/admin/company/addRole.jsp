<script src="${pageContext.request.contextPath}/staticResources/JavaScript/role.js"></script>
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

input[type=checkbox]
{
height:13px !important;
width:4% !important;
/* margin-right: 5px !important; */
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
									<b>Role</b>
								</h2>
							</div>

						</div>
					</div>
					<div class="col-sm-6" id="addEmp">
						<div class="row">
							<ul style="float: right; margin-right: 10%;">
								<li>
									<a class="btn btn-danger" style="color: white;"
										href="${pageContext.request.contextPath}/admin/company/addRole">Add
										role</a>
									<a class="btn btn-danger" style="color: white;"
										href="${pageContext.request.contextPath}/admin/company/addSubRole">Add
										Sub-Role</a>

								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>



			<!-- -----------Start role Form------------------------ -->
			<div class="col-lg-11 col-sm-12">
				<!-- MultiStep Form -->
				<div class="" id="grad1">
					<div class="row justify-content-center mt-0">
						<div class="col-1 col-md-1 col-sm-3 col-lg-1"></div>
						<div
							class="col-10 col-sm-12 col-md-9 col-lg-10 text-center p-0 mt-3 mb-2">
							<div class="card px-0 pt-4 pb-0 mt-3 mb-3">
								<h2>
									<c:if test="${not empty role}">
										<strong>Edit Role</strong>
									</c:if>
									<c:if test="${empty role}">
										<strong>Add New Role</strong>
									</c:if>
								</h2>
								<p>Fill all form field to go to next step</p>
								<div class="row">
									<div class="col-md-12 mx-0">
										<form id="roleform" class="allform" name="roleform" action="admin/company/addRole"
											method="POST">
											<!-- progressbar -->
											<ul id="progressbar" style="margin-left: 25%;">
												<li class="active" id="personal"><strong>Role</strong></li>
												<li  id="work"><strong>Permission</strong></li>
												<li id="confirm"><strong>Finish</strong></li>
											</ul>
											<!-- fieldsets -->
											<fieldset>
												<div class="form-card">
													<div class="col-sm-12" style="margin: 50px 15px ;">
														<div class="row">
															<div class="col-sm-3">
																<h4 class="fs-title">Role</h4>
															</div>
															<div class="col-sm-9">
																<div class="form-group col-sm-12" style="padding: 0px;">
																	<label>Role Name:</label>
																	<div>
																		<input type="text" name="roleName" id="roleName" value="${role.roleName}"
																			 />
																			 <input type="hidden" name="roleId" id="roleId" value="${role.roleId}"
																			 />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Role Type:</label>
																	<div>
																		<input type="text" name="roleType" id="roleType" value="${role.roleType}"
																			 />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Role Description:</label>
																	<div>
																		<input type="text" name="roleDesc" id="roleDesc" value="${role.roleDesc}"
																			 />
																	</div>
																</div>
																
															</div>
													</div>
												</div>
												</div>
												<input type="button" name="submit" value="Submit" onclick="addRole();" class="next action-button">
												
											</fieldset>
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
															<h5>You Have Successfully Add Role</h5>
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