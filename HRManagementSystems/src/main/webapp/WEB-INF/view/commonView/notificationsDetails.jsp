
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.timeStyle{
    background: #86c5da;
    margin: 2% 5% 2% 2%;
    padding: 2%;
    color: white;
    font-weight: 800;
/*     border: 2px solid cadetblue;
 */    border-radius: 5px;
    }
    
.btn-danger{
margin: 7% 45%;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-1 col-sm-12"><jsp:include
				page="mainNavbar.jsp" /></div>
		<div class="col-lg-11 col-sm-12">
			<div class="col-lg-11 col-sm-12"
				style="width: 100%; padding-right: 0px;"><jsp:include
					page="header.jsp" /></div>
			<div class="col-lg-11 col-sm-12" style="width: 100%;"><jsp:include
					page="companyNav.jsp" /></div>

			<!-- ----------------------Heading-------------------- -->
			<div class="col-md-12" style="padding: 40px 10px 10px;">
				<div class="row" style="background: #c5f5cb;">
					<div class="col-sm-6">
						<div class="row">
							<div style="margin-left: 29px;">
								<h2>
									<b> Notifications</b>
								</h2>
								
							</div>
						</div>
					</div>
					
				</div>
			</div>

			<!-- ----------------------Role Data Table-------------------- -->
			<%-- <c:forEach items="${notifications}" var="notifications">
				<div class="col-md-12" style="padding: 10px 40px 10px;">
					<div class="row" style="background: #f2f2f2;">
						<div id="allData"
							style="padding: 10px; border-top: 5px solid mediumpurple;">
							<div class="row">
								<div class="col-sm-3">
									<div class=""
										style="border-right: 2px solid green; height: 50px;">
										<center><div class="timeStyle">Date : ${notifications.date} <br> Time : ${notifications.time}</div><br></center>
										
									</div>
								</div>
								<div class="col-sm-7">${notifications.activity}<br><br><i>By ${notifications.firstName}  &nbsp;&nbsp;${notifications.lastName}</i></div>
								<div class="col-sm-2">
								<div class=""
										style="border-left: 2px solid green; height: 50px;">
										 <a
													class="btn btn-danger"
													href="${pageContext.request.contextPath}/admincompany/deleteDepartment/${department.departmentId}"><i
														class="fa fa-trash" aria-hidden="true"></i> </a> &nbsp;&nbsp;</td>
														</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach> --%>

			<!-- -----------Form------------------------- -->



		</div>
	</div>
</div>



</body>
</html>
