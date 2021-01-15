
<script src="${pageContext.request.contextPath}/staticResources/JavaScript/addEmployee.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-1 col-sm-12" 
   ><jsp:include page="../../commonView/mainNavbar.jsp" /></div>
		<div class="col-lg-11 col-sm-12">
			<div class="col-lg-11 col-sm-12"
				style="width: 100%; padding-right: 0px;"><jsp:include
					page="../../commonView/header.jsp" /></div>
			<div class="col-lg-11 col-sm-12" style="width: 100%;"><jsp:include
					page="../../commonView/companyNav.jsp" /></div>

			<div class="col-lg-11 col-sm-12">
				<!-- MultiStep Form -->
				<div class="" id="grad1">
					<div class="row justify-content-center mt-0">
						<div class="col-1 col-md-1 col-sm-2 col-lg-1"></div>
						<div
							class="col-10 col-sm-10 col-md-9 col-lg-10 text-center p-0 mt-3 mb-2">
							<div class="card px-0 pt-4 pb-0 mt-3 mb-3">
								<h2>
									<strong>Add New Company Branch</strong>
								</h2>
								<p>Fill all form field to go to next step</p>
								<div class="row">
									<div class="col-md-12 mx-0">
										<form id="msform" name="msform" action="company/add_Employee"
											method="POST">
											<!-- progressbar -->
											<ul id="progressbar" style="margin-left: 25%;">
												<li class="active" id="personal"><strong>Personal</strong></li>
												<li id="work"><strong>Work</strong></li>
												<li id="account"><strong>Account Details</strong></li>
												<li id="confirm"><strong>Finish</strong></li>
											</ul>
											<!-- fieldsets -->
											<fieldset>
												<div class="form-card">
													<div class="col-sm-12" style="margin: 50px 15px;">
														<div class="row">
															<div class="col-sm-3">
																<h4 class="fs-title">Personal</h4>
															</div>
															<div class="col-sm-9">
																<div class="form-group" style="padding: 0px;">
																	<label>Person Title:</label>
																	<div>
																		<select name="personTitle" id="personTitle">
																			<option value="Mr.">Mr.</option>
																			<option value="Mrs.">Mrs.</option>
																			<option value="Miss">Miss</option>
																		</select><br />
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>First Name:</label>
																	<div>
																		<input type="text" name="firstName" id="firstName"
																			th:field="*{firstName}" />
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Middle Name:</label>
																	<div>
																		<input type="text" name="middleName" id="middleName"
																			th:field="*{middleName}" />
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Last Name:</label>
																	<div>
																		<input type="text" name="lastName" id="lastName"
																			th:field="*{lastName}" />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Gender:</label>
																	<div>
																		<select name="gender" id="gender">
																			<option value="Male">Male</option>
																			<option value="Female">Female</option>
																			<option value="Other">Other</option>
																		</select><br />
																	</div>
																</div>
															</div>
														</div>
														<div class="col-sm-12" style="margin: 20px 0px;">
															<div class="row">
																<div class="col-sm-3">
																	<h4 class="fs-title">Contact</h4>
																</div>
																<div class="col-sm-9">
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Primary Email:</label>
																		<div>
																			<input type="text" name="email1" id="email1"
																				th:field="*{email1}" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Primary Phone:</label>
																		<div>
																			<input type="text" name="phone1" id="phone1"
																				th:field="*{phone1}" />
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="col-sm-12" style="margin: 20px 0px;">
															<div class="row">
																<div class="col-sm-3">
																	<h4 class="fs-title">Address</h4>
																</div>
																<div class="col-sm-9">
																	<div class="form-group col-sm-12" style="padding: 0px;">
																		<label>Address(Permanent):</label>
																		<div>
																			<textarea rows="3" cols="2" maxlength="50"
																				name="address" id="address" th:field="*{address}"
																				style="height: 70px"></textarea>
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>City:</label>
																		<div>
																			<input type="text" name="city" id="city"
																				th:field="*{city}" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>State:</label>
																		<div>
																			<input type="text" name="stateId" id="stateId"
																				th:field="*{stateId}" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Country:</label>
																		<div>
																			<input type="text" name="countryId" id="countryId"
																				th:field="*{countryId}" /><br />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Pincode:</label>
																		<div>
																			<input type="text" name="pincode" id="pincode"
																				th:field="*{pincode}" /><br />
																		</div>
																	</div>
																	<div class="form-group col-sm-12" style="padding: 0px;">
																		<div>
																			<input type="hidden" name="addressType"
																				id="addressType" th:field="*{addressType}" /><br />
																		</div>
																	</div>
																	<!-- <div class="form-group col-sm-1" style="padding: 0px;">
																<div>
																	<input type="checkbox" id="sameAdd" name="sameAdd"
																		style="width: 50%">
																</div>
															</div>
															<div class="form-group col-sm-11"
																style="padding: 0px; margin-top: 8px;">
																<label>Current Address same as Permanent Address</label>
															</div>
															<div class="form-group col-sm-12" style="padding: 0px;">
																<label>Address(Current):</label>
																<div>
																	<textarea rows="3" cols="2" maxlength="50"
																		name="address" id="address" style="height: 70px"></textarea>
																</div>
															</div>
															<div class="form-group col-sm-6" style="padding: 0px;">
																<label>City:</label>
																<div>
																	<input type="text" name="city" id="city" th:field="*{}" />
																</div>
															</div>
															<div class="form-group col-sm-6" style="padding: 0px;">
																<label>State:</label>
																<div>
																	<input type="text" name="stateId" id="stateId"
																		th:field="*{stateId}" />
																</div>
															</div>
															<div class="form-group col-sm-6" style="padding: 0px;">
																<label>Country:</label>
																<div>
																	<input type="text" name="countryId"
																		th:field="*{countryId}" id="countryId" /><br />
																</div>
															</div>
															<div class="form-group col-sm-6" style="padding: 0px;">
																<label>Pincode:</label>
																<div>
																	<input type="text" name="pincode" id="pincode"
																		th:field="*{pincode}" /><br />
																</div>
															</div> -->

																</div>
															</div>
														</div>
													</div>

												</div>
												<input type="button" name="next" class="next action-button"
													value="Next Step" />
											</fieldset>
											<!-- 	End Employee Personal Information -->

											<!-- 	Start Employee Bank Details Information -->

											<fieldset>
												<div class="form-card">
													<div class="col-sm-12" style="margin: 50px 15px;">
														<div class="row">
															<div class="col-sm-3">
																<h4 class="fs-title">BASIC INFO</h4>
															</div>
															<div class="col-sm-9">
																<div class="form-group col-sm-8" style="padding: 0px;">
																	<label>Logon-Id(Official):</label>
																	<div>
																		<input type="text" name="logonId" id="logonId"
																			th:field="*{logonId}" />
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Logon-Password(Official):</label>
																	<div>
																		<input type="text" name="logonPassword"
																			id="logonPassword" th:field="*{logonPassword}" />
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Employee ID:</label>
																	<div>
																		<input type="text" name="employeeCode"
																			id="employeeCode" th:field="*{employeeCode}" />
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Employee Type:</label>
																	<div>
																		<select name="employeeTypeId" id="employeeTypeId"
																			th:field="*{employeeTypeId}">
																			<c:forEach items="${empType}" var="empType">
      																  <option value="${empType.employeeTypeId}">${empType.typeName}</option>
  																  </c:forEach>
																		</select><br />
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Employee Status:</label>
																	<div>
																		<select name="employeeStatus" id="employeeStatus">
																			<option value="Active">Active</option>
																			<option value="Inactive">Inactive</option>
																		</select>
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Date of Joining:</label>
																	<div>
																		<input type="date" name="JoiningDate" id="JoiningDate"
																			th:field="*{JoiningDate}" />
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Work Experience:</label>
																	<div>
																		<input type="text" name="experience" id="experience"
																			style="width: 25%; margin-right: 2%;"
																			th:field="*{experience}" />Year
																		<!-- <input type="text"
																	style="width: 25%; margin-right: 2%;" name="experience"
																	th:field="*{experience}" />Month -->
																	</div>
																</div>
																<div class="form-group col-sm-4" style="padding: 0px;">
																	<label>Probation Period:</label>
																	<div>
																		<select name="probationPeriod" id="probationPeriod">
																			<option value="0">0</option>
																			<option value="15">15</option>
																			<option value="30">30</option>
																			<option value="45">45</option>
																			<option value="60">60</option>
																			<option value="75">75</option>
																			<option value="90">90</option>
																			<option value="120">120</option>
																			<option value="150">150</option>
																			<option value="180">180</option>
																		</select><br />
																	</div>
																</div>
																<div class="form-group col-sm-12" style="padding: 0px;">
																	<label>Work Location:</label>
																	<div>
																		<select name="workLocationId" id="workLocationId">
																			<c:forEach items="${workLocation}" var="workLocation">
      																  <option value="${workLocation.workLocationId}">${workLocation.address1}
																					${workLocation.address2} ${workLocation.address3}</option>
  																  </c:forEach>
																		</select><br />
																	</div>
																</div>
															</div>
														</div>
														<div class="col-sm-12" style="margin: 20px 0px;">
															<div class="row">
																<div class="col-sm-3">
																	<h4 class="fs-title">WORK INFO</h4>
																</div>
																<div class="col-sm-9">
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Designation:</label>
																		<div>
																			<input type="text" name="designation"
																				id="designation" th:field="*{designation}" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Job Title:</label>
																		<div>
																			<select name="jobTitleId" id="jobTitleId">
																				<c:forEach items="${jobTitle}" var="jobTitle">
      																  <option value="${jobTitle.jobTitleId}">${jobTitle.jobTitle}</option>
  																  </c:forEach>
																			</select><br />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Department:</label>
																		<div>
																			<select name="departmentId" id="departmentId">
																				<c:forEach items="${department}" var="department">
      																  <option value="${department.departmentId}">${department.deptName}</option>
  																  </c:forEach>
																			</select><br />
																		</div>
																	</div>

																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Project:</label>
																		<div>
																			<select name="projectId" id="projectId">
																				<c:forEach items="${project}" var="project">
      																  <option value="${project.projectId}">${project.projectCode}</option>
  																  </c:forEach>
																			</select><br />
																		</div>
																	</div>
																	<div class="form-group col-sm-6" style="padding: 0px;">
																		<label>Manager:</label>
																		<div>
																			<input type="text" name="manager" id="manager"
																				th:field="*{manager}" />
																		</div>
																	</div>
																	<!-- <div class="form-group col-sm-6" style="padding: 0px;">
																<label>Sub Department:</label>
																<div>
																	<input type="text" name="" th:field="*{}" />
																</div>
															</div> -->
																</div>
															</div>
														</div>
													</div>
												</div>
												<input type="button" name="previous"
													class="previous action-button-previous" value="Previous" />
												<input type="button" name="next" class="next action-button"
													value="Next Step" />
											</fieldset>

											<!-- 	End Employee Work Information -->
											<!-- 	Start Employee Work Information -->

											<fieldset>
												<div class="form-card">
													<div class="col-sm-12" style="margin: 50px 15px;">
														<div class="row">
															<div class="col-sm-3">
																<h4 class="fs-title">Bank Details</h4>
															</div>
															<div class="col-sm-9">
																<div class="form-group col-sm-12" style="padding: 0px;">
																	<label>CTC</label>
																	<div>
																		<input type="text" name="ctc" id="ctc"
																			th:field="*{ctc}" />
																	</div>
																</div>
																<div class="form-group col-sm-12" style="padding: 0px;">
																	<label>Account Holder's Name:</label>
																	<div>
																		<input type="text" name="holderName" id="holderName"
																			th:field="*{holderName}" />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Bank Name:</label>
																	<div>
																		<input type="text" name="bankName" id="bankName"
																			th:field="*{bankName}" />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>City:</label>
																	<div>
																		<input type="text" name="city" id="city"
																			th:field="*{city}" />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>Branch Name:</label>
																	<div>
																		<input type="text" name="branchName" id="branchName"
																			th:field="*{branchName}" />
																	</div>
																</div>
																<div class="form-group col-sm-6" style="padding: 0px;">
																	<label>IFSC Code:</label>
																	<div>
																		<input type="text" name="ifscCode" id="ifscCode"
																			th:field="*{ifscCode}" />
																	</div>
																</div>
																<div class="form-group col-sm-12" style="padding: 0px;">
																	<label>Account No:</label>
																	<div>
																		<input type="text" name="accountNumber"
																			id="accountNumber" th:field="*{accountNumber}" />
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
												<input type="button" name="previous"
													class="previous action-button-previous" value="Previous" />
												<input type="button" name="submit" value="Submit"
													onclick="submitForm();" class="next action-button"
													value="Submit" />
											</fieldset>

											<!-- 	End Employee Bank Details Information -->
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



</body>
</html>
<script>
	
</script>