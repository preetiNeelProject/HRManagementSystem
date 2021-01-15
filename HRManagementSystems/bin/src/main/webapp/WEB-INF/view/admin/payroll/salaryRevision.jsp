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
					page="../../commonView/payrollNav.jsp" /></div>

			<!-- ----------------------Heading-------------------- -->
			<div class="col-md-12" style="padding: 40px 10px 10px;">
				<div class="row" style="background: #c5f5cb;">
					<div class="col-sm-6">
						<div class="row">
							<div style="margin-left: 29px;">
								<h2>
									<b>Salary Revision</b>
								</h2>
							</div>
						</div>
					</div>
					<div class="col-sm-6" id="addEmp">
						<div class="row">
							<ul style="float: right; margin-right: 10%;">
								<li>
									<button class="btn btn-danger" style="color: white;"
										onclick="location.href='../../admin/payroll/salary-structure'">
										Add Salary</button>
									<button class="btn btn-danger" style="color: white;"
										onclick="location.href='../../admin/payroll/addIncrementSalary'">
										Increment Salary</button>


								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!-- ----------------------Department Data Table-------------------- -->
			<div class="col-md-12" style="padding: 10px 40px 40px;">
				<div class="row" style="background: #f2f2f2;">
					<div id="allData" style="padding: 10px;">
						<div class="table-responsive">
							<table id="table" class="table table-bordred table-striped">

								<thead style="background: #283655; color: white;">
									<tr>
										<th><input type="checkbox" id="checkall"/></th>
										<th>Employee Id</th>
										<th>Employee Name</th>
										<th>CTC(Rs)</th>
										<th>Basic(Rs)</th>
										<th>HRA(Rs)</th>
										<th>Convey(Rs)</th>
										<th>Other(Rs)</th>
										<th>PF(Rs)</th>
										<th>ESI(Rs)</th>
										<th>Edit</th>
										<th>Download</th>
									</tr>
								</thead>
								<tbody id="salaryRevisionTable">
								<%-- 	<c:forEach items="${records}" var="record">
										<tr>
											<td><input type="checkbox" name="snos"
												value="${record.ctcHistoryId}"></td>
											<td>${record.employeeId}</td>
											<td>${record.name}</td>
											<td>${record.cTC}</td>
											<td>${record.newCtc}</td>
											<td>${record.incrementDate}</td>
											<td>${record.comments}</td>
											<td style="display: inline-block; width: auto;"><a
													class="btn btn-danger"
													href="${pageContext.request.contextPath}/admin/payroll/salarySlip/${record.ctcHistoryId}">Slip </a> <a
													class="btn btn-warning"
													onclick=""><i
														class="fa fa-download" aria-hidden="true"></i> </a> <a
													class="btn btn-success"
													onclick=""><i
														class="fa fa-trash" aria-hidden="true"></i> </a>
															&nbsp;&nbsp;</td>
											
										</tr>
									</c:forEach> --%>
									<c:forEach items="${currentRecords}" var="currentRecord">
										<tr>
											<td><input type="checkbox" name="snos"
												value="${currentRecord.employeeCTCId}"></td>
											<td>${currentRecord.employeeId}</td>
											<td>${currentRecord.name}</td>
											<td>${currentRecord.cTC}</td>
											<td>${currentRecord.annualBasicSalary}</td>
											<td>${currentRecord.hra}</td>
											<td>${currentRecord.convey}</td>
											<td>${currentRecord.annualFlexibleBenifits}</td>
											<td>${currentRecord.pf}</td>
											<td>${currentRecord.esi}</td>
											<td style="display: inline-block;"><a
													class="btn btn-warning"
													onclick=""><i
														class="fa fa-download" aria-hidden="true"></i> </a> <a
													class="btn btn-success"
													onclick=""><i
														class="fa fa-trash" aria-hidden="true"></i> </a>
															&nbsp;&nbsp;</td>
															<td><a
													class="btn btn-danger"
													href="${pageContext.request.contextPath}/admin/payroll/salarySlip/${currentRecord.employeeCTCId}">Salary Slip </a> </td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

							<div class="clearfix"></div>


						</div>
					</div>
				</div>
			</div>


			<!-- -----------Form------------------------ -->



		</div>
	</div>
</div>



</body>
</html>
