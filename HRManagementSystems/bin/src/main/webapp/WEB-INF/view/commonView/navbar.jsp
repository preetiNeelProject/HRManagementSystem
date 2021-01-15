

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <jsp:include page="../commonView/header.jsp" /> --%>
<div class="base-bar" style="">
	<div class="navBody"
		style="border-radius: 5px; background-color: #387403; height: 75px; padding: 10px;">
		<div id="on_home">
		<!--  Start dashboard links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard">Overview
					</a></li>
				</ul>
			</nav>
			<!--   End dashboard Links -->
		</div>
		<div id="on_company">
			<!--  Start Company links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item"><a class="nav-link" href="Overview">Overview
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Address</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Department</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Designation</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Announcement</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Policies</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Admin</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Statutory</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">My
							Plan</a></li>
				</ul>
			</nav>
			<!--   End Company Links -->
		</div>
		<div id="on_profile">
			<!--   Start Profile Links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="Overview">Overview</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Profile</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Work</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Team</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Education</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Family</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Document</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="${pageContext.request.contextPath}/admin/attendance/viewEmpAttendanceLog/${employeeId}">Attendance</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="">Leave</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Payroll</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">File
							Manager</a></li>
				</ul>
			</nav>
			<!--   End Profile Links -->
		</div>
		<div id="on_attendance">
			<!--   Start Profile Links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="Overview">Overview
					</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/attendance/viewAttendanceLog">Attendance Logs</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Approvals</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Rules</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Analytics</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Setting</a></li>
				</ul>
			</nav>
			<!--   End Profile Links -->
		</div>
		<div id="on_directory">
		<!--   Start directory Links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="Overview">Overview
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Verify</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="admin/company/employeeList">Employee</a>
					</li>
				</ul>
			</nav>
			<!--   End directory Links -->
			</div>
		<div id="on_leave">
		<!--   Start leave Links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="Overview">Overview
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Leaves Logs</a>
					<li class="nav-item"><a class="nav-link" href="#">Applied Leaves</a></li>
					<li class="nav-item"><a class="nav-link" href="">My Team List</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Leave Approval</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Holiday</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Rules</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Balance</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Setting</a></li>
				</ul>
			</nav>
			<!--   End leave Links -->
		</div>
		<div id="on_payroll">
		<!--   Start payroll Links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="Overview">Overview
					</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/payroll/calBasicSalary">Salary Structure</a>
					<li class="nav-item"><a class="nav-link" href="#">Forms</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Reports</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/payroll/taxCalculator">Tax</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Bank Integration</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Holiday</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Declaration</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Audit History</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Setting</a></li>
				</ul>
			</nav>
			<!--   End payroll Links -->
		</div>
		<div id="on_setting">bye</div>
	</div>
</div>

