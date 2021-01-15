<jsp:include page="${pageContext.request.contextPath}/commonView/header.jsp" />
	<div class="container">
		<div class="row">
		<div class="taxStyle" style="display: block" id="summary">
							<h4>Summary</h4>
							<form>
							<table class="table display" style="margin-left: 1%; width: 99%;">
								<thead>
									<tr>
										<th></th>
										<th>Post-Budget (New Scheme) FY(2020-2021)</th>
										<th>Post-Budget (Old Scheme) FY(2020-2021)</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Gross Total Income</td>
										<td>${taxAmount.newGrossTaxableIncome}</td>
										<td>${taxAmount.oldGrossTaxableIncome}</td>
									</tr>
									<tr>
										<td>Deductions</td>
										<td>0</td>
										<td>${taxAmount.deductions}</td>
									</tr>
									<tr>
										<td>Tax due on above</td>
										<td>${taxAmount.newTaxAmount}</td>
										<td>${taxAmount.oldTaxAmount}</td>
									</tr>
								</tbody>
							</table>
							</form>
						</div>
			</div>
	</div>
</body>
</html>