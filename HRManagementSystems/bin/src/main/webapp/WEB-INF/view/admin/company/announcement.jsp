
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
									<b>Live Announcement</b>
								</h2>
								
							</div>
						</div>
					</div>
					<div class="col-sm-6" id="addEmp">
						<div class="row">
							<ul style="float: right; margin-right: 10%;">
								<li><a class="btn btn-danger" style="color: white;"
									href="${pageContext.request.contextPath}/admin/company/addAnnouncement">
										Add Announcement</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!-- ----------------------Role Data Table-------------------- -->
			<c:forEach items="${announcement}" var="announcement">
				<div class="col-md-12" style="padding: 10px 40px 10px;">
					<div class="row" style="background: #f2f2f2;">
						<div id="allData"
							style="padding: 10px; border-top: 5px solid lightsteelblue;">
							<div class="row">
								<div class="col-sm-2">
									<div class=""
										style="border-right: 2px solid green; height: 50px;">
										<center>${announcement.applyDate}<br></center>
										
									</div>
								</div>
								<div class="col-sm-8">${announcement.message}</div>
								<div class="col-sm-2">
								<div class=""
										style="border-left: 2px solid green; height: 50px;">
										<center>
								<a
													class="btn btn-danger"
													href="${pageContext.request.contextPath}/admin/company/editAnnouncement/${announcement.announcementId}"><i
														class="fa fa-pencil" aria-hidden="true"></i> </a>
								 <a
													class="btn btn-success"
													href="${pageContext.request.contextPath}/admin/company/deleteAnnouncement/${announcement.announcementId}"><i
														class="fa fa-trash" aria-hidden="true"></i> </a></center>
														</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

			<!-- -----------Form----- ------------------- -->



		</div>
	</div>
</div>



</body>
</html>
