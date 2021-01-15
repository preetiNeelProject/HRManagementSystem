<script src="${pageContext.request.contextPath}/staticResources/JavaScript/editProfile.js"></script>
<%@ page buffer="8192kb" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-1 col-sm-12"><jsp:include
				page="../commonView/mainNavbar.jsp" /></div>
		<div class="col-lg-11 col-sm-12">
			<div class="col-lg-11 col-sm-12"
				style="width: 100%; padding-right: 0px;"><jsp:include
					page="../commonView/header.jsp" /></div>
			<div class="col-lg-11 col-sm-12" style="width: 100%;"><jsp:include
					page="../commonView/profileNav.jsp" /></div>

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
											<strong>Edit Profile</strong>
										</h2>
										<p>Fill all form field to go to next step</p>
										<div class="row">
											<div class="col-md-12 mx-0">
												<form id="msform" enctype="multipart/form-data">
													<!-- progressbar -->
													<ul id="progressbar">
														<li class="active" id="personal"><strong>Personal</strong></li>
														<li id="work"><strong>Work</strong></li>
														<li id="educations"><strong>Education</strong></li>
														<li id="family"><strong>Family</strong></li>
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
																		<p style="display: none;">${employeeId}</p>
																	</div>
																	<div class="col-sm-9">
																		<div class="form-group" style="padding: 0px;">
																			<label>Person Title:</label>
																			<div>
																				<select name="personTitle" id="personTitle"
																					value=${personTitle}>
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
																					value="${records.firstName}"
																					th:field="*{firstName}" readonly="readonly" />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Middle Name:</label>
																			<div>
																				<input type="text" name="middleName" id="middleName"
																					value="${records.middleName}" th:field="*{}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Last Name:</label>
																			<div>
																				<input type="text" name="lastName" id="lastName"
																					value="${records.lastName}" readonly="readonly"
																					th:field="*{lastName}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Blood Group:</label>
																			<div>
																				<select name="bloodGroup" id="bloodGroup">
																					<option value="A+">A+</option>
																					<option value="A-">A-</option>
																					<option value="A Unknown">A Unknown</option>
																					<option value="B+">B+</option>
																					<option value="B-">B-</option>
																					<option value="B Unknown">B Unknown</option>
																					<option value="AB+">AB+</option>
																					<option value="AB-">AB-</option>
																					<option value="AB Unknown">AB Unknown</option>
																					<option value="O+">O+</option>
																					<option value="O-">O-</option>
																					<option value="O Unknown">O Unknown</option>
																					<option value="Unknown">Unknown</option>
																				</select><br />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Date of Birth:</label>
																			<div>
																				<input type="date" name="dob" id="dob"
																					value="${records.dob}" th:field="*{dob}" /><br />
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
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Martial Status:</label>
																			<div>
																				<select name="martialStatus" id="martialStatus">
																					<option value="Single">Single</option>
																					<option value="Married">Married</option>
																					<option value="Widowed">Widowed</option>
																					<option value="Separated">Separated</option>
																					<option value="Divorced">Divorced</option>
																				</select>
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Caste:</label>
																			<div>
																				<input type="text" name="caste" id="caste"
																					value="${records.caste}" th:field="*{caste}" /><br />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Religions:</label>
																			<div>
																				<input type="text" name="religion" id="religion"
																					value="${records.religion}" th:field="*{religion}" /><br />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Nationality:</label>
																			<div>
																				<input type="text" name="nationality"
																					id="nationality" value="${records.nationality}"
																					th:field="*{nationality}" /><br /> <input
																					type="hidden" name="employeeId" id="employeeId"
																					value="${records.employeeId}"
																					th:field="*{nationality}" />
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
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Primary Email:</label>
																				<div>
																					<input type="text" name="email1" id="email1"
																						value="${records.email1}" th:field="*{email1}" />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Secondary Email(Optional):</label>
																				<div>
																					<input type="text" name="email2" id="email2"
																						value="${records.email2}" th:field="*{email2}" />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Primary Phone:</label>
																				<div>
																					<input type="text" name="phone1" id="phone1"
																						value="${records.phone1}" th:field="*{phone1}" />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Secondary Phone(Optional):</label>
																				<div>
																					<input type="text" name="phone2" id="phone2"
																						value="${records.phone2}" th:field="*{phone2}" />
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
																			<div class="form-group col-sm-12"
																				style="padding: 0px;">
																				<label>Address(Permanent):</label>
																				<div>
																					<textarea rows="3" cols="2" maxlength="50"
																						name="address" id="address" style="height: 70px">${records.address}</textarea>
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>City:</label>
																				<div>
																					<input type="text" name="city" id="city"
																						value="${records.city}" th:field="*{city}" />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>State:</label>
																				<div>
																					<input type="text" name="stateId" id="stateId"
																						value="${records.stateId}" th:field="*{stateId}" />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Country:</label>
																				<div>
																					<input type="text" name="countryId" id="countryId"
																						value="${records.countryId}"
																						th:field="*{countryId}" /><br />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Pincode:</label>
																				<div>
																					<input type="text" name="pincode" id="pincode"
																						value="${records.pincode}"
																						th:field="*{employeeId}" /><br />
																				</div>
																			</div>
																			<div class="form-group col-sm-1"
																				style="padding: 0px;">
																				<div>
																					<input type="checkbox" id="filladdress"
																						onclick="fillAddress();" name="filladdress"
																						value="filladdress" style="width: 50%">
																				</div>
																			</div>
																			<div class="form-group col-sm-11"
																				style="padding: 0px; margin-top: 8px;">
																				<label>Current Address same as Permanent
																					Address</label>
																			</div>
																			<div class="form-group col-sm-12"
																				style="padding: 0px;">
																				<label>Address(Current):</label>
																				<div>
																					<textarea rows="3" cols="2" maxlength="50"
																						name="caddress" id="caddress" style="height: 70px">${records.caddress}</textarea>
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>City:</label>
																				<div>
																					<input type="text" name="ccity" id="ccity"
																						value="${records.ccity}" th:field="*{ccity}" />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>State:</label>
																				<div>
																					<input type="text" name="cstateId" id="cstateId"
																						value="${records.cstateId}" th:field="*{cstateId}" />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Country:</label>
																				<div>
																					<input type="text" name="ccountryId"
																						value="${records.ccountryId}"
																						th:field="*{ccountryId}" id="ccountryId" /><br />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Pincode:</label>
																				<div>
																					<input type="text" name="cpincode" id="cpincode"
																						value="${records.cpincode}" th:field="*{cpincode}" /><br />
																					<input type="hidden" name="addressId"
																						id="addressId" value="${records.addressId}"
																						th:field="*{addressId}" /><br />
																				</div>
																			</div>

																		</div>
																	</div>
																</div>
															</div>

														</div>
														<input type="button" name="next"
															class="next action-button" value="Next Step" />
													</fieldset>
													<!-- 	End Employee Personal Information -->

													<!-- 	Start Employee Work Information -->

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
																					th:field="*{logonId}" value="${records.logonId}"
																					readonly="readonly" />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Logon-Password(Official):</label>
																			<div>
																				<input type="text" name="logonPassword"
																					id="logonPassword" th:field="*{logonPassword}"
																					value="${records.logonPassword}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Employee ID:</label>
																			<div>
																				<input type="text" name="employeeCode"
																					id="employeeCode" value="${records.employeeCode}"
																					th:field="*{employeeCode}" readonly="readonly" />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Employee Type:</label>
																			<div>
																				<select name="employeeTypeId" id="employeeTypeId"
																					disabled="disabled" th:field="*{employeeTypeId}">
																					<c:forEach items="${empType}" var="empType">
      																  <option value="${empType.employeeTypeId}">${empType.typeName}</option>
  																  </c:forEach>
																				</select><br />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Employee Status:</label>
																			<div>
																				<select name="employeeStatus" id="employeeStatus"
																					value="${records.employeeStatus}"
																					readonly="readonly">
																					<option value="Active">Active</option>
																					<option value="Inactive">Inactive</option>
																				</select>
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Date of Joining:</label>
																			<div>
																				<input type="date" name="JoiningDate"
																					id="joiningDate" value="${records.joiningDate}"
																					readonly="readonly" th:field="*{JoiningDate}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Work Experience:</label>
																			<div>
																				<input type="text" name="experience" id="experience"
																					value="${records.experience}" readonly="readonly"
																					style="width: 25%; margin-right: 2%;"
																					th:field="*{experience}" />Year
																				<!-- <input type="text"
																	style="width: 25%; margin-right: 2%;" name="employeeId"
																	th:field="*{employeeId}" />Month -->
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Probation Period:</label>
																			<div>
																				<select name="probationPeriod" id="probationPeriod"
																					disabled="disabled">
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
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">
																			<label>Work Location:</label>
																			<div>
																				<select name="workLocationId" id="workLocationId"
																					disabled="disabled">
																					<c:forEach items="${workLocation}"
																						var="workLocation">
      																  <option value="${workLocation.workLocationId}"
																							${workLocation.workLocationId == records.workLocation ? 'selected="selected"' : ''}>${workLocation.address1}
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
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Designation:</label>
																				<div>
																					<input type="text" name="designation"
																						id="designation" value="${records.designation}"
																						th:field="*{designation}" readonly="readonly" />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Job Title:</label>
																				<div>
																					<select name="jobTitleId" id="jobTitleId"
																						disabled="disabled">
																						<c:forEach items="${jobTitle}" var="jobTitle">
      																  <option value="${jobTitle.jobTitleId}"
																								${jobTitle.jobTitleId == records.jobTitle ? 'selected="selected"' : ''}>${jobTitle.jobTitle}</option>
  																  </c:forEach>
																					</select><br />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Department:</label>
																				<div>
																					<select name="departmentId" id="departmentId"
																						disabled="disabled">
																						<c:forEach items="${department}" var="department">
      																  <option value="${department.departmentId}"
																								${department.departmentId == records.department ? 'selected="selected"' : ''}>${department.deptName}</option>
  																  </c:forEach>
																					</select><br />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Project:</label>
																				<div>
																					<%-- <select name="projectId" id="projectId"
																						disabled="disabled">
																						<c:forEach items="${project}" var="project">
      																  <option value="${project.projectId}"
																								${project.projectId == records.project ? 'selected="selected"' : ''}>${project.projectCode}</option>
  																  </c:forEach>
																					</select> --%><br />
																				</div>
																			</div>
																			<div class="form-group col-sm-6"
																				style="padding: 0px;">
																				<label>Manager:</label>
																				<div>
																					<input type="text" name="manager" id="manager"
																						value="${records.designation}" readonly="readonly"
																						th:field="*{manager}" /> <input type="hidden"
																						name="empWorkRelationId" id="empWorkRelationId"
																						value="${records.empWorkRelationId}" />
																				</div>
																			</div>
																			<%-- <div class="form-group col-sm-6" style="padding: 0px;">
																<label>Sub Department:</label>
																<div>
																	<input type="text" name="" value="${records.firstName}" th:field="*{}" />
																</div>
															</div> --%>
																		</div>
																	</div>
																</div>
																<div class="col-sm-12" style="margin: 20px 0px;">
																	<div class="row">
																		<div class="col-sm-3">
																			<h4 class="fs-title">WORK HISTORY</h4>
																		</div>
																		<div class="col-sm-9">
																			<table class="table">
																				<thead class="thead-light">
																					<tr>
																						<th scope="col">Department</th>
																						<th scope="col">Designation</th>
																						<th scope="col">From</th>
																						<th scope="col">To</th>
																					</tr>
																				</thead>
																				<tbody>
																					<tr>
																						<th scope="row">1</th>
																						<td>Mark</td>
																						<td>Otto</td>
																						<td>@mdo</td>
																					</tr>
																				</tbody>
																			</table>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<input type="button" name="previous"
															class="previous action-button-previous" value="Previous" />
														<input type="button" name="next"
															class="next action-button" value="Next Step" />
													</fieldset>

													<!-- 	Start Employee Work Information -->
													<!-- 	Start Employee Education Information -->



													<fieldset>
														<div class="form-card">
															<div class="col-sm-12" style="margin: 50px 0px;">
																<div class="row">
																	<div class="col-sm-3">
																		<h4 class="fs-title">EDUCATIONAL INFO</h4>
																	</div>
																	<div class="col-sm-9">
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">
																			<label>Qualification Type:</label>
																			<div>
																				<select name="qualiTypeId" id="qualiTypeId">
																					<c:forEach items="${qualification}"
																						var="qualification">
      																  <option value="${qualification.qualiTypeId}">${qualification.qualiTitle}</option>
  																  </c:forEach>
																				</select>
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Course Name:</label>
																			<div>
																				<input type="text" name="cn" id="cn"
																					th:field="*{cn}" /> <input type="hidden"
																					name="educationalId" id="educationalId"
																					th:field="*{cn}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Course Type:</label>
																			<div>

																				<select name="ct" id="ct">
																					<option value="Full Time">Full Time</option>
																					<option value="Part Time">Part Time</option>
																					<option value="Correspondence">Correspondence</option>
																					<option value="Certificate">Certificate</option>
																					<option value="Other">Other</option>
																				</select><br />
																			</div>
																		</div>
																		<div class="form-group col-sm-4" style="padding: 0px;">
																			<label>Stream:</label>
																			<div>
																				<input type="text" name="st" id="st"
																					th:field="*{st}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Course Start Date:</label>
																			<div>
																				<input type="date" name="csd" id="csd"
																					th:field="*{csd}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Course End Date:</label>
																			<div>
																				<input type="date" name="ced" id="ced"
																					th:field="*{ced}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>College:</label>
																			<div>
																				<input type="text" name="college" id="college"
																					th:field="*{college}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>University Name:</label>
																			<div>
																				<input type="text" name="un" id="un"
																					th:field="*{un}" /><br />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">

																			<div>
																				<a class="btn btn-info" onclick="addNewEducation();">+</a>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-sm-12" style="margin: 20px 0px;">
																<div class="row">
																	<table class="table" id="qualificationTable">
																		<thead class="thead-light">
																			<tr>

																				<th title="qualiTypeId" scope="col">Qualification
																					Type</th>
																				<th title="courseName" scope="col">Course Name</th>
																				<th title="courseType" scope="col">Course Type</th>
																				<th title="stream" scope="col">Stream</th>
																				<th title="courseStartDate" scope="col">From</th>
																				<th title="courseEndDate" scope="col">To</th>
																				<th title="collegeName" scope="col">College</th>
																				<th title="universityName" scope="col">University</th>
																				<th title="edit" scope="col">Edit</th>
																				<th style="display: none"></th>
																			</tr>
																		</thead>
																		<tbody id="qualificationBody">
																	<%--		<c:forEach var="i" begin="0"
																				end="${fn:length(records.education)-1}">
																				<tr id="${i}">

																					<td><input type="hidden" name="tqualiTypeId"
																						id="tqualiTypeId"
																						value="${records.education[i].qualiTypeId}" />${records.education[i].qualiTypeId}</td>
																					<td><input type="hidden"
																						value="${records.education[i].courseName}"
																						name="courseName" id="tcourseName">${records.education[i].courseName}</td>
																					<td><input type="hidden"
																						value="${records.education[i].courseType}"
																						name="courseType" id="tcourseType">${records.education[i].courseType}</td>
																					<td><input type="hidden"
																						value="${records.education[i].stream}"
																						name="stream" id="tstream">${records.education[i].stream}</td>
																					<td><input type="hidden"
																						value="${records.education[i].courseStartDate}"
																						name="courseStartDate" id="tcourseStartDate">${records.education[i].courseStartDate}</td>
																					<td><input type="hidden"
																						value="${records.education[i].courseEndDate}"
																						name="courseEndDate" id="tcourseEndDate">${records.education[i].courseEndDate}</td>
																					<td><input type="hidden"
																						value="${records.education[i].collegeName}"
																						name="collegeName" id="tcollegeName">${records.education[i].collegeName}</td>
																					<td><input type="hidden"
																						value="${records.education[i].universityName}"
																						name="universityName" id="tuniversityName">${records.education[i].universityName}</td>
																					<td id="tableEdit"><a id="tableView"
																						onclick="editData('${i}');"><i
																							class="fa fa-pencil"
																							style="font-size: 18px !important; color: darkslateblue !important;"></i></a>
																						<a id="tableView" onclick=""><i
																							class="fa fa-trash-o"
																							style="font-size: 18px !important; color: orangered !important;"></i></a>
																					</td>
																					<td style="display: none"><input type="hidden"
																						value="${records.education[i].educationalId}"
																						name="educationalId" id="teducationalId">${records.education[i].educationalId}</td>
																				</tr>
																			</c:forEach> --%>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
														<input type="button" name="previous"
															class="previous action-button-previous" value="Previous" />
														<input type="button" name="make_payment"
															onclick="getEducation();" class="next action-button"
															value="Next Step" />
													</fieldset>

													<!-- 	Start Employee Education Information -->
													<!-- 	Start Employee Depandant/Emerency Information -->

													<fieldset>
														<div class="form-card">
															<div class="col-sm-12" style="margin: 50px 0px;">
																<div class="row">
																	<div class="col-sm-3">
																		<h4 class="fs-title">DEPENDENT FAMILY MEMBERS</h4>
																	</div>
																	<div class="col-sm-9">
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>First Name:</label>
																			<div>
																				<input type="text" name="dfirstName" id="dfirstName"
																					value="${records.dfirstName}"
																					th:field="*{dfirstName}" /> <input type="hidden"
																					name="ddependentId" id="ddependentId"
																					value="${records.ddependentId}"
																					th:field="*{dfirstName}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Last Name:</label>
																			<div>
																				<input type="text" name="dlastName" id="dlastName"
																					value="${records.dlastName}"
																					th:field="*{dlastName}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Phone Number:</label>
																			<div>
																				<input type="text" name="dphone1" id="dphone1"
																					value="${records.dphone1}" th:field="*{dphone1}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Relationship:</label>
																			<div>

																				<select name="drelationship" id="drelationship"
																					value="${records.drelationship}">
																					<option value="Father">Father</option>
																					<option value="Mother">Mother</option>
																					<option value="Husband">Husband</option>
																					<option value="Wife">Wife</option>
																					<option value="Brother">Brother</option>
																					<option value="Sister">Sister</option>
																					<option value="Son">Son</option>
																					<option value="Daughter">Daughter</option>
																					<option value="Other">Other</option>
																				</select><br />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">

																			<div>
																				<a class="btn btn-info" onclick="addNewDependant();">+</a>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-sm-12" style="margin: 20px 0px;">
																<div class="row">
																	<table class="table" id="dependentTable">
																		<thead class="thead-light">
																			<tr>
																				<th scope="col">First Name</th>
																				<th scope="col">Last Name</th>
																				<th scope="col">Phone Number</th>
																				<th scope="col">Relationship</th>
																				<th scope="col">Edit</th>
																			</tr>
																		</thead>
																		<tbody id="dependentBody">

																		<%--	<c:forEach var="i" begin="0"
																				end="${fn:length(records.dependents)-1}">
																				<tr id="${i}">
																					<td><input type="hidden" name="ddfirstName"
																						id="ddfirstName"
																						value="${records.dependents[i].firstName}" />${records.dependents[i].firstName}</td>
																					<td><input type="hidden"
																						value="${records.dependents[i].lastName}"
																						name="ddlastName" id="ddlastName">${records.dependents[i].lastName}</td>
																					<td><input type="hidden"
																						value="${records.dependents[i].dependentPhone}"
																						name="dddependentPhone" id="dddependentPhone">${records.dependents[i].dependentPhone}</td>
																					<td><input type="hidden"
																						value="${records.dependents[i].relationship}"
																						name="ddrelationship" id="ddrelationship">${records.dependents[i].relationship}</td>
																					<td id="tableEdit"><a id=""
																						onclick="editDependentData('${i}');"><i
																							class="fa fa-pencil"
																							style="font-size: 18px !important; color: darkslateblue !important;"></i></a>
																						<a id="tableView" onclick=""><i
																							class="fa fa-trash-o"
																							style="font-size: 18px !important; color: orangered !important;"></i></a>
																					</td>
																					<td style="display: none"><input type="hidden"
																						value="${records.dependents[i].dependentId}"
																						name="dddependentId" id="dddependentId">${records.dependents[i].dependentId}</td>
																				</tr>

																			</c:forEach> --%>
																		</tbody>
																	</table>
																</div>
															</div>
															<div class="col-sm-12" style="margin: 50px 0px;">
																<div class="row">
																	<div class="col-sm-3">
																		<h4 class="fs-title">EMERGENCY CONTACT</h4>
																	</div>
																	<div class="col-sm-9">
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">
																			<label>Name:</label>
																			<div>
																				<input type="text" name="emergencyName"
																					id="emergencyName" value="${records.emergencyName}"
																					th:field="*{emergencyName}" /> <input
																					type="hidden" name="emergencyId" id="emergencyId"
																					value="${records.emergencyId}"
																					th:field="*{emergencyName}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Phone Number:</label>
																			<div>
																				<input type="text" name="emergencyNumber"
																					id="emergencyNumber"
																					value="${records.emergencyNumber}"
																					th:field="*{emergencyNumber}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Relationship:</label>
																			<div>

																				<select name="emergencyRelationship"
																					value="${records.emergencyRelationship}"
																					id="emergencyRelationship">
																					<option value="Father">Father</option>
																					<option value="Mother">Mother</option>
																					<option value="Husband">Husband</option>
																					<option value="Wife">Wife</option>
																					<option value="Brother">Brother</option>
																					<option value="Sister">Sister</option>
																					<option value="Son">Son</option>
																					<option value="Daughter">Daughter</option>
																					<option value="Other">Other</option>
																				</select><br />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">

																			<div>
																				<a class="btn btn-info" onclick="addNewEmergency();">+</a>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-sm-12" style="margin: 20px 0px;">
																<div class="row">
																	<table class="table" id="emergencyTable">
																		<thead class="thead-light">
																			<tr>
																				<th scope="col">Name</th>
																				<th scope="col">Phone Number</th>
																				<th scope="col">Relationship</th>
																				<th scope="col">Edit</th>
																			</tr>
																		</thead>
																		<tbody id="emergencyBody">
																	<%--		<c:forEach var="i" begin="0"
																				end="${fn:length(records.emergency)-1}">
																				<tr id="${i}">
																					<td><input type="hidden" name="demergencyName"
																						id="demergencyName"
																						value="${records.emergency[i].emergencyName}" />${records.emergency[i].emergencyName}</td>
																					<td><input type="hidden"
																						value="${records.emergency[i].emergencyNumber}"
																						name="demergencyNumber" id="demergencyNumber">${records.emergency[i].emergencyNumber}</td>
																					<td><input type="hidden"
																						value="${records.emergency[i].emergencyRelationship}"
																						name="demergencyRelationship"
																						id="demergencyRelationship">${records.emergency[i].emergencyRelationship}</td>
																					<td id="tableEdit"><a id="tableView"
																						onclick="editEmergencyData('${i}');"><i
																							class="fa fa-pencil"
																							style="font-size: 18px !important; color: darkslateblue !important;"></i></a>
																						<a id="tableView" onclick=""><i
																							class="fa fa-trash-o"
																							style="font-size: 18px !important; color: orangered !important;"></i></a>
																					</td>
																					<td style="display: none"><input type="hidden"
																						value="${records.emergency[i].emergencyId}"
																						name="demergencyId" id="demergencyId">${records.emergency[i].emergencyId}</td>

																				</tr>
																			</c:forEach> --%>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
														<input type="button" name="previous"
															class="previous action-button-previous" value="Previous" />
														<input type="button" name="make_payment"
															onclick="getDependentEmergency();"
															class="next action-button" value="Next Step" />
													</fieldset>


													<!-- 	End Employee Depandant/Emerency Information -->

													<!-- 	Start Employee Work Information -->

													<fieldset>
														<div class="form-card">
															<div class="col-sm-12" style="margin: 50px 15px;">
																<div class="row">
																	<div class="col-sm-3">
																		<h4 class="fs-title">Account Details</h4>
																	</div>
																	<div class="col-sm-9">
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">
																			<label>CTC</label>
																			<div>
																				<input type="text" name="ctc" id="ctc"
																					value="${records.ctc}" th:field="*{ctc}"
																					readonly="readonly" />
																			</div>
																		</div>
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">
																			<label>Account Holder's Name:</label>
																			<div>
																				<input type="text" name="holderName" id="holderName"
																					value="${records.holderName}" readonly="readonly"
																					th:field="*{holderName}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Bank Name:</label>
																			<div>
																				<input type="text" name="bankName" id="bankName"
																					value="${records.bankName}" readonly="readonly"
																					th:field="*{bankName}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>City:</label>
																			<div>
																				<input type="text" name="city" id="city"
																					value="${records.city}" readonly="readonly"
																					th:field="*{city}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>Branch Name:</label>
																			<div>
																				<input type="text" name="branchName" id="branchName"
																					value="${records.branchName}" readonly="readonly"
																					th:field="*{branchName}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-6" style="padding: 0px;">
																			<label>IFSC Code:</label>
																			<div>
																				<input type="text" name="ifscCode" id="ifscCode"
																					value="${records.ifscCode}" readonly="readonly"
																					th:field="*{ifscCode}" />
																			</div>
																		</div>
																		<div class="form-group col-sm-12"
																			style="padding: 0px;">
																			<label>Account No:</label>
																			<div>
																				<input type="text" name="accountNumber"
																					value="${records.accountNumber}"
																					readonly="readonly" id="accountNumber"
																					th:field="*{accountNumber}" /> <input
																					type="hidden" name="accountDetailId"
																					value="${records.accountDetailId}"
																					id="accountDetailId" />
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<input type="button" name="previous"
															class="previous action-button-previous" value="Previous" />
														<input type="button" name="submit"
															onclick="submitEditForm('${employeeId}');"
															class="next action-button" value="Submit" />
													</fieldset>
													<fieldset>
														<div class="form-card">
															<h2 class="fs-title text-center">Success !</h2>
															<br> <br>
															<div class="row justify-content-center">
																<div class="col-3">
																	<img
																		src="https://img.icons8.com/color/96/000000/ok--v2.png"
																		class="fit-image">
																</div>
															</div>
															<br> <br>
															<div class="row justify-content-center">
																<div class="col-7 text-center">
																	<h5>You Have Successfully Signed Up</h5>
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


<style type="text/css">
table {
	page-break-inside: auto
}

tr {
	page-break-inside: avoid;
	page-break-after: auto
}

thead {
	display: table-header-group
}

tfoot {
	display: table-footer-group
}
</style>
<div id="demo"></div>