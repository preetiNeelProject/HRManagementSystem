

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
		
		<div id="on_company">
			<!--  Start Company links -->
			<nav class="navbar navbar-expand-lg"
				style="background: transparent; color: white !important">
				<ul class="nav navbar-nav">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/company/dashboard">Overview
					</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/company/workLocation">Address</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/company/department">Department</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="${pageContext.request.contextPath}/admin/company/role">Designation</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="${pageContext.request.contextPath}/admin/company/announcement">Announcement</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Policies</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Admin</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Statutory</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">My
							Plan</a></li>
				</ul>
			</nav>
			<!--   End Company Links -->
		</div>
		
	</div>
</div>

