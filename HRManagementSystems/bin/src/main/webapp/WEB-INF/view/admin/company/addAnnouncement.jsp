<script src="${pageContext.request.contextPath}/staticResources/JavaScript/announcement.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
									<b>Announcement</b>
								</h2>
							</div>

						</div>
					</div>
					<div class="col-sm-6" id="addEmp">
						<div class="row">
							<ul style="float: right; margin-right: 10%;">
								<li><a class="btn btn-danger" style="color: white;"
									href="${pageContext.request.contextPath}/admin/company/announcement">Announcement</a>

								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>



			<!-- -----------Start announcement Form------------------------ -->
			<div class="col-lg-11 col-sm-12">
				<!-- MultiStep Form -->
				<div class="" id="grad1">
					<div class="row justify-content-center mt-0">
						<div class="col-1 col-md-1 col-sm-3 col-lg-1"></div>
						<div
							class="col-10 col-sm-12 col-md-9 col-lg-10 text-center p-0 mt-3 mb-2">
							<div class="card px-0 pt-4 pb-0 mt-3 mb-3">
								<h2>
									 <c:if test="${not empty announcement}">
										<strong>Edit Announcement</strong>
									</c:if>
									<c:if test="${empty announcement}">
										<strong>Add New Announcement</strong>
									</c:if> 
								</h2>
								<div class="alert" id="errorAnnouncementform" style="display:none">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong>Danger!</strong> Indicates a dangerous or potentially negative action.
</div>
								<div class="row">
									<div class="col-md-12 mx-0">
										<form id="announcementform" class="allform"
											name="announcementform"
											action="admin/company/addAnnouncement" method="POST">
											<!-- progressbar -->
											<!-- fieldsets -->
											<fieldset>
												<div class="form-card">
													<div class="col-sm-12" style="margin: 50px 15px;">
														<div class="row">
															<div class="col-sm-3">
																<h4 class="fs-title">Announcement</h4>
															</div>
															<div class="col-sm-9">
																<div class="form-group col-sm-12" style="padding: 0px;">
																	<div>
																		<textarea rows="10" cols="50" maxlength="500"
																			id="message" name="message" 
																			style="margin-bottom: 5px; height: auto">${announcement.message}</textarea>
																		<p>Max 500 length</p>
																	<input type="hidden" name="announcementId"
																			id="announcementId" value="${announcement.announcementId}"
																			<%-- value="${announcement.announcementId}"  --%>/>
																			<input type="hidden" name="employeeId"
																			id="employeeId"
																			value="112" /> 
																	</div>
																</div>

															</div>
														</div>
													</div>
												</div>
												<input type="button" name="submit" value="Submit" id="errorButton"
													onclick="addAnnouncement();" class="next action-button">

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
															<h5>You Have Successfully Add Announcement</h5>
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
<style>
.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
</style>


</body>
</html>
