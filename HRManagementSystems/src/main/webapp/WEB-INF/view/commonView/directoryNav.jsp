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
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/company/employeeList">Employee</a>
					</li>
				</ul>
			</nav>
			<!--   End directory Links -->
			</div>
		
	</div>
</div>

