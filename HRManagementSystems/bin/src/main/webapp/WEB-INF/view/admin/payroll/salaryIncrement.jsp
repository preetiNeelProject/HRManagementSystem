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
					<center><h3>Salary Increment </h3></center>
					<hr>
					<div class="row">
					<div class="col-sm-5">Hi</div><div class="col-sm-7">
						<form class="form-horizontal" action="addEmployeeSalary" th:action="@{addEmployeeSalary}"
							method="GET" th:object="${emloyeeSalary}">
							<h4>Employee Details</h4>
							<div class="form-group">
								<label class="control-label col-sm-4">Employee-Id:</label>
								<div class="col-sm-8">
									<input type="number" name="employeeId" th:field="*{employeeId}" /><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Full name:</label>
								<div class="col-sm-8">
									<input type="text" name="name" th:field="*{name}" /><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Increment Date:</label>
								<div class="col-sm-8">
									<input type="date" name="incrementDate" th:field="*{incrementDate}" /><br />
								</div>
							</div>
							<h4>Salary Details</h4>
							<div class="form-group">
								<label class="control-label col-sm-4">Old Salary:</label>
								<div class="col-sm-8">
									<input type="number" name="oldCtc" id="oldCtc"
										th:field="*{newCtc}" /><br />
								</div>
							</div>
							
							<h4>New Details</h4>
							<div class="form-group">
								<label class="control-label col-sm-4">New Salary:</label>
								<div class="col-sm-8">
									<select style="width: 30%">
										<option>Year</option>
										<option>Month</option>
									</select> <input type="number" id="cTC" name="cTC" onkeyup="createEmpSalaryStructure();"
										
										style="width: 60%; float: right;"  th:field="*{cTC}" min="1000" /><br />
									<label for="cTC"
										style="float: right; color: red; margin-top: -7px;">CTC
										more than 999...</label>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Basic Salary:</label>
								<div class="col-sm-8">
									<input type="number" name="annualBasicSalary" id="annualBasicSalary"
										th:field="*{annualBasicSalary}"  readonly="true"/><br />
								</div>
							</div>
							<h4>Allowances</h4>							
							<div class="form-group">
								<label class="control-label col-sm-4">HRA:</label>
								<div class="col-sm-8">
									<input type="number" name="hra" id="hra" th:field="*{hra}" readonly="true"/><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Conveyance:</label>
								<div class="col-sm-8">
									<input type="number" name="convey" id="convey" th:field="*{convey}" readonly="true"/><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Other:</label>
								<div class="col-sm-8">
									<input type="number" name="annualFlexibleBenifits" id="annualFlexibleBenifits" th:field="*{annualFlexibleBenifits}" readonly="true"/><br />
								</div>
							</div>
							<h4>Deductions</h4>
							<!-- <div class="form-group">
								<label class="control-label col-sm-4">TDS:</label>
								<div class="col-sm-8">
									<input type="number" id="tds" th:field="*{tds}" readonly="true"/><br />
								</div>
							</div> -->
							<div class="form-group">
								<label class="control-label col-sm-4">PF:</label>
								<div class="col-sm-8">
									<input type="number" name="pf" id="pf" th:field="*{pF}" readonly="true"/><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">ESI:</label>
								<div class="col-sm-8">
									<input type="number" name="esi" id="esi" th:field="*{esi}" readonly="true" /><br />
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
										th:field="*{annualRefSalary}" readonly="true"/><br />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4">Comments:</label>
								<div class="col-sm-8">
									<textarea rows="3" cols="2" name="comments" th:field="*{comments}" /></textarea><br />
								</div>
							</div>
							
							<button type="submit" class="btn btn-success" style="float:right;margin: 5% 3%;">Submit</button>
							<button type="reset" class="btn-cancel" style="float:right;margin: 5% 3%;">Cancel</button>
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