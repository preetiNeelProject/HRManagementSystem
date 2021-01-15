<script src="${pageContext.request.contextPath}/staticResources/JavaScript/SalaryStructure.js"></script>
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
					page="../../commonView/payrollNav.jsp" /></div>

			<div class="col-lg-11 col-sm-12">
				<!-- MultiStep Form -->
				<div class="" id="grad1">
						
		
			
				<div class="form-box">
					<center><h3>Salary Structure</h3></center>
					<hr>
					<div class="row">
					<div class="col-sm-5">Hi</div><div class="col-sm-7">
						<form class="form-horizontal" action="addEmployeeSalary" th:action="@{addEmployeeSalary}"
							method="POST" th:object="${emloyeeSalary}" id="emloyeeSalaryForm">
							<h5>Employee Details</h5>
							<div class="form-group">
								<label class="control-label col-sm-4">Employee-Id:</label>
								<div class="col-sm-8">
								<select name="employeeId" id="employeeId">
								<c:forEach items="${records}" var="record">
      									<option value="${record.employeeId}">${record.employeeCode} - ${record.firstName} ${record.lastName}</option>
                                 </c:forEach>
											</select>
								</div>
							</div>
						<div class="form-group">
								<label class="control-label col-sm-4">Full name:</label>
								<div class="col-sm-8">
									<input type="text" id="name" name="name" /><br />
								</div>
							</div>  
							<div class="form-group" style="display:none">
								<label class="control-label col-sm-4">Joining Date:</label>
								<div class="col-sm-8">
									<input type="date" id="joiningDate" name="joiningDate" /><br />
								</div>
							</div> 
							<h5>Salary Details</h5>
							<div class="form-group">
								<label class="control-label col-sm-4">Salary:</label>
								<div class="col-sm-8">
                            <input type="number" id="cTC" name="cTC" onkeyup="createEmpSalaryStructure();"
										
										 min="1000" /><br />
									<label for="cTC"
										style="float: right; color: red; margin-top: -7px;">CTC
										more than 999...</label>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Basic Salary:</label>
								<div class="col-sm-8">
									<input type="number" name="annualBasicSalary" id="annualBasicSalary"
										  readonly="true"/><br />
								</div>
							</div>
														<h5>Allowances</h5>
							<div class="form-group">
								<label class="control-label col-sm-4">HRA:</label>
								<div class="col-sm-8">
									<input type="number" name="hra" id="hra"  readonly="true"/><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Special allowance
:</label>
								<div class="col-sm-8">
									<input type="number" name="convey" id="convey"  readonly="true"/><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Other:</label>
								<div class="col-sm-8">
									<input type="number" name="annualFlexibleBenifits" id="annualFlexibleBenifits"  readonly="true"/><br />
								</div>
							</div>
							<h5>Deductions</h5>
							<!-- <div class="form-group">
								<label class="control-label col-sm-4">TDS:</label>
								<div class="col-sm-8">
									<input type="number" id="tds" th:field="*{tds}" readonly="true"/><br />
								</div>
							</div> -->
							<div class="form-group">
								<label class="control-label col-sm-4">PF:</label>
								<div class="col-sm-8">
									<input type="number" name="pf" id="pf" onkeyup="pfNo();"  readonly="true"/><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">ESI:</label>
								<div class="col-sm-8">
									<input type="number" name="esi" id="esi" onkeyup="esiNo();" readonly="true" /><br />
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="control-label col-sm-4">Gratuity:</label>
								<div class="col-sm-8">
									<input type="number" id="gratuity" th:field="*{gratuity}" /><br />
								</div>
							</div> -->
							<div class="form-group">
								<label class="control-label col-sm-4"><h6><b>Net Amount:</b></h6></label>
								<div class="col-sm-8">
									<input type="number" name="annualRefSalary" id="annualRefSalary"
										 readonly="true"/><br />
								</div>
							</div>
							<button type="button" style="display:none" class="btn" onclick="salarySlipDownload();"><i class="fa fa-download" style="font-size: 18px;"></i> &nbsp Slip</button>
							<button type="submit" class="btn btn-warning" style="">Submit</button>
							<button type="reset" class="btn-cancel" style="">Cancel</button>
						</form>
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