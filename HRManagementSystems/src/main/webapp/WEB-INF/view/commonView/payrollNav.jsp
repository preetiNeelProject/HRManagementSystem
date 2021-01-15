

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <jsp:include page="../commonView/header.jsp" /> --%>
<style>
.navbar {
  overflow: unset !important;
    background-color: none;
  width: auto !important; 
}
</style>
<div class="base-bar" style="">
	<div class="navBody"
		style="border-radius: 5px; background-color: #387403; height: 75px; padding: 10px;">
	
		<div id="on_payroll">
		<!--   Start payroll Links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/payroll/dashboard">Overview
					</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/payroll/salaryStructure">Salary Structure</a>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/payroll/salaryRevision">Salary Revision</a>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/payroll/monthlySalary">Monthly Salary</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Forms</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Reports</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/payroll/taxCalculator">Tax</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Bank Integration</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Holiday</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Setting</a></li>
				</ul>
			</nav>
			<!--   End payroll Links -->
		</div>
		
	</div>
</div>

