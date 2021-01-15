<jsp:include page="${pageContext.request.contextPath}/commonView/header.jsp" />
<script src="${pageContext.request.contextPath}/staticResources/JavaScript/editProfile.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-lg-1 col-sm-12"><jsp:include
				page="${pageContext.request.contextPath}/commonView/mainNavbar.jsp" /></div>
		<div class="col-lg-11 col-sm-12">
			<div class="col-lg-11 col-sm-12"
				style="width: 100%; padding-right: 0px;"><jsp:include
					page="${pageContext.request.contextPath}/commonView/header.jsp" /></div>
			<div class="col-lg-11 col-sm-12" style="width: 100%;"><jsp:include
					page="${pageContext.request.contextPath}/commonView/profileNav.jsp" /></div>

			<div class="col-lg-11 col-sm-12">
				<div class="container">
					<div class="row">
						<!-- MultiStep Form -->
						<div class="container-fluid" id="grad1">
							<div class="row justify-content-center mt-0">
								<div class="col-1 col-md-2 col-sm-2 col-lg-2"></div>
								<div
									class="col-11 col-sm-9 col-md-9 col-lg-9 text-center p-0 mt-3 mb-2">
									<div class="card px-0 pt-4 pb-0 mt-3 mb-3">
										<h2>
											<strong>Add New Document</strong>
										</h2>
										<p>Fill all form field to go to next step</p>
										<div class="row">
											<div class="col-md-12 mx-0">
												<form id="msform" enctype="multipart/form-data"
													action="company/add_Employee" method="POST">
													<!-- progressbar -->
													<ul id="progressbar" style="margin-left: 25%;">
														<li class="active" id="documents"><strong>IDs
																Proof</strong></li>
														<li id="documents"><strong>Certification</strong></li>
														<li id="documents"><strong>Work</strong></li>
														<li id="confirm"><strong>Finish</strong></li>
													</ul>
													<!-- fieldsets -->
													<!-- 	Start Document Information -->
													<fieldset>
														<div class="form-card">
															<div class="col-sm-12" style="margin: 50px 0px;">
																<div class="row">
																	<div class="col-sm-3">
																		<h4 class="fs-title">IDs</h4>
																	</div>
																	<div class="col-sm-9">
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Select ID Type:</label>
																			<div>
																				<select name="type" id="type">
																					<option value=""></option>
																					<option value="PAN Card">PAN Card</option>
																					<option value="Aadhaar Card">Aadhaar Card</option>
																					<option value="Passport">Passport</option>
																					<option value="Driving Licence">Driving
																						Licence</option>
																					<option value="Voter ID">Voter ID</option>
																					<option value="Electricity Bill">Electricity
																						Bill</option>
																					<option value="Phone Bill">Phone Bill</option>
																					<option value="Bank Passbook">Bank
																						Passbook</option>
																					<option value="Rental Agreement">Rental
																						Agreement</option>
																				</select>
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Enter ID:</label>
																			<div>
																				<input type="text" name="title" id="title"
																					value="${records.title}" th:field="*{title}" />
																			</div>
																		</div>

																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label class="input-group-btn"> <span
																				class="btn btn-primary file-selection waves-effect waves-light">
																					SELECT FILE<input type="file" id="files"
																					multiple="" style="display: none;">
																			</span>
																			</label>
																			<p id="selectedFiles" style="margin-left: 5px;"></p>
																			<span class="fileSize"></span>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label class="input-group-btn"> <input
																				type="hidden" id="documentTypeId"
																				name="documentTypeId" value="1"
																				style="display: none;">

																			</label>
																		</div>
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">

																			<div>
																				<a class="btn btn-info" id="addIDs"
																					onclick="addNewIDs();">+</a>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-sm-12" style="margin: 20px 0px;">
																<div class="row">
																	<table class="table" id="idsTable">
																		<thead class="thead-light">
																			<tr>
																				<th scope="col">ID Type</th>
																				<th scope="col">ID</th>
																				<th scope="col">File Name</th>
																				<th scope="col">File</th>
																			</tr>
																		</thead>
																		<tbody id="idsBody">

																		</tbody>
																	</table>
																</div>
															</div>
														</div>
														<input type="button" name="previous"
															class="previous action-button-previous" value="Previous" />
														<input type="button" name="next"
															class="next action-button" onclick="getIDs();"
															value="Next Step" />
													</fieldset>

													<fieldset>
														<div class="form-card">
															<div class="col-sm-12" style="margin: 50px 0px;">
																<div class="row">
																	<div class="col-sm-3">
																		<h4 class="fs-title">CERTIFICATIONS</h4>
																	</div>
																	<div class="col-sm-9">
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Select Course Type:</label>
																			<div>
																				<select name="certiType" id="certiType">
																					<option value="" selected="">---</option>
																					<option value="10">Graduation</option>
																					<option value="11">Post Graduation</option>
																					<option value="18">Doctorate</option>
																					<option value="9">Diploma</option>
																					<option value="19">Pre University</option>
																					<option value="12">Certification</option>
																					<option value="20">Others</option>
																				</select>
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Enter Certification Title:</label>
																			<div>
																				<input type="text" name="certiTitle" id="certiTitle"
																					th:field="*{certiTitle}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label class="input-group-btn"> <span
																				class="btn btn-primary file-selection waves-effect waves-light">
																					SELECT FILE<input type="file" id="files"
																					name="files" style="display: none;">
																			</span>
																			</label>
																			<p id="selectedCertiFiles" style="margin-left: 5px;"></p>
																			<span class="fileSize"></span>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label class="input-group-btn"> <input
																				type="hidden" id="documentTypeId"
																				name="documentTypeId" value="2"
																				style="display: none;">

																			</label>
																		</div>
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">

																			<div>
																				<a class="btn btn-info" onclick="addNewCerti();">+</a>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-sm-12" style="margin: 20px 0px;">
																<div class="row">
																	<table class="table" id="certiTable">
																		<thead class="thead-light">
																			<tr>
																				<th scope="col">Course Type</th>
																				<th scope="col">Course</th>
																				<th scope="col">File Name</th>
																			</tr>
																		</thead>
																		<tbody id="certiBody">

																		</tbody>
																	</table>
																</div>
															</div>
														</div>
														<input type="button" name="previous"
															class="previous action-button-previous" value="Previous" />
														<input type="button" name="next"
															class="next action-button" onclick="getIDs();"
															value="Next Step" />
													</fieldset>

													<fieldset>
														<div class="form-card">
															<div class="col-sm-12" style="margin: 50px 0px;">
																<div class="row">
																	<div class="col-sm-3">
																		<h4 class="fs-title">Work</h4>
																	</div>
																	<div class="col-sm-9">
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Enter Document Title:</label>
																			<div>
																				<input type="text" name="workTitle" id="workTitle"
																					th:field="*{workTitle}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Enter Document Description:</label>
																			<div>
																				<input type="text" name="workDescription"
																					id="workDescription" th:field="*{workDescription}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label class="input-group-btn"> <span
																				class="btn btn-primary file-selection waves-effect waves-light">
																					SELECT FILE<input type="file" id="files"
																					multiple="" style="display: none;">
																			</span>
																			</label>
																			<p id="selectedWorkFiles" style="margin-left: 5px;"></p>
																			<span class="fileSize"></span>
																		</div>
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">

																			<div>
																				<a class="btn btn-info" onclick="addNewWork();">+</a>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-sm-12" style="margin: 20px 0px;">
																<div class="row">
																	<table class="table" id="workTable">
																		<thead class="thead-light">
																			<tr>
																				<th scope="col">Document Title</th>
																				<th scope="col">Document Description</th>
																				<th scope="col">File Name</th>
																			</tr>
																		</thead>
																		<tbody id="workBody">

																		</tbody>
																	</table>
																</div>
															</div>
														</div>
														<input type="button" name="previous"
															class="previous action-button-previous" value="Previous" />
														<input type="button" name="next"
															class="next action-button" value="Submit" />
													</fieldset>

													<!-- 	End Employee Document Information -->
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
																	<h5>You Have Successfully Add Employee</h5>
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
	</div>
</div>
</body>
</html>
<script>
	
</script>