<jsp:include page="${pageContext.request.contextPath}/commonView/header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-sm-5">
			 <div class="from-explain">
			   <h2><b>INDIA INCOME TAX EXPLAINED</b></h2>
			   <h3>Income Details</h3>
			   <hr>
			   <p>><u> Income from Salary</u> : Salary before reducing exemptions (HRA, LTA), standard deduction & professional tax.</p>
			   <p>><u> Income from Interest</u> : Includes interest from savings bank, deposits and other interest.</p>
			   <p>><u> Interest Paid on Home Loan</u> : Interest paid on housing loan taken for self-occupied property.</p>
			   <p>><u> Rental Income Received</u> : Annual rent received on let-out property.</p>
			   <p>><u> Exemptions & Deductions from Salary</u> : HRA, LTA, Standard Deduction, etc..</p>
			   <p>><u> Other Income</u> : Includes taxable freelancing income or any other taxable income.</p>
			   <p>><u> Interest Paid on Loan</u> : Interest paid on housing loan taken for rented/let-out property.</p><br>
			   
			   <h3>Deductions Details</h3>
			   <hr>
			   <p>><u> Basic Deductions - 80C</u> : Amount invested/paid in tax saving instruments such as PPF, ELSS mutual funds, LIC premium, etc..</p><br>
			   <p>><u> Medical Insurance - 80D</u> : Medical premium & preventive health checkup fees paid for self & family including parents.</p><br>
			   <p>><u> Interest on Educational Loan - 80E</u> : Amount of interest paid on loan taken for higher education.</p><br>
			   <p>><u> Employee's contribution to NPS - 80CCD</u> : Includes voluntary contribution to National Pension Scheme (NPS) under section 80CCD(1) and 80CCD(1B).</p><br>
			   <p>><u> Interest from Deposits - 80TTA</u> : Amount of interest income on deposits in savings account (includes fixed/recurring deposit interest in case of senior citizen).</p><br>
			   <p>><u> Donations to Charity - 80G</u> : Amount paid as donation to charitable insitutions or certain recognized funds.</p><br>
			   <p>><u> Interest on Housing Loan - 80EEA</u> : Amount of interest paid on housing loan sanctioned during FY 19-20.</p><br>
			 </div>
			</div>
			<div class="col-sm-7">
				<div class="form-box">
					<h2>Tax Calculator</h2>
					<hr>
					<div class="row">
						<form class="form-horizontal" action="/calculateTax"
							th:action="@{calculateTax}" method="GET" th:object="${tax}">
							<div class="nav">
								<div class="tab">
									<button class="tablinks"
										onclick="openTaxTab(event, 'taxBasicDetails')">Basic
										Details</button>
									<button class="tablinks"
										onclick="openTaxTab(event, 'taxIncomeDetails')">Income
										Details</button>
									<button class="tablinks"
										onclick="openTaxTab(event, 'taxDeductionDetails')">Deduction
										Details</button>
								</div>
							</div>
							<div class="taxBox">
								<div class="form-group m20">
									<label class="headLabel"><b>Which Financial Year do
											you want to calculate taxes for?</b></label>
									<div class="radio-container clearfix">
										<div class="control-group">
											<label class="radio" style="width: 100%"> <span></span>
												<input checked="checked" id="Year" name="Year" type="radio"
												value="2020-2021" th:field="*{2020-2021}" /> <span>2020-2021</span>
												<span class="label label-warning">Latest Budget</span> <span>(Return
													to be filed between 1st April 2021 - 31st March 2022)</span>
											</label>
										</div>
									</div>
								</div>
								<br> <br>
								<div class="taxStyle" id="taxBasicDetails"
									style="display: block">
									<h4>Basic Details</h4>
									<div class="form-group">
										<label class="control-label col-sm-4">Your Age:</label><br>
										<div class="col-sm-8">
											<label class="radio"> <input checked="checked"
												data-val="true"
												data-val-required="The AgeGroup field is required."
												id="ageGroup" name="ageGroup" type="radio" value="NotSenior"
												th:field="*{NotSenior}" /> 0 to 60
											</label> <label class="radio"> <input id="ageGroup"
												name="ageGroup" type="radio" value="Senior"
												th:field="*{Senior}" /> 60 to 80
											</label> <label class="radio"> <input id="ageGroup"
												name="ageGroup" type="radio" value="SuperSenior"
												th:field="*{SuperSenior}" /> 80 to above
											</label>
										</div>
									</div>
									<a id="taxBasicDetails" data-toggle="tab"
										href="javascript:showNextTaxStep('taxIncomeDetails');"
										class="btn btn-Success right">Go to Next Step</a>
								</div>
								<div class="taxStyle" id="taxIncomeDetails"
									style="display: none">
									<h4>Income Details</h4>
									<label class="control-label col-sm-4">Your Income:</label><br>
									<br>
									<div class="form-group">
										<div class="col-sm-6">
											<label class="control-label">Income from Salary</label> <input
												type="text" value="0" id="taxableSalary"
												name="taxableSalary" th:field="*{taxableSalary}" /><br />
										</div>
										<div class="col-sm-6">
											<label class="control-label">Income from Interest </label> <input
												type="text" value="0" id="interestIncome"
												name="interestIncome" th:field="*{interestIncome}" /><br />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6">
											<label class="control-label">Interest Paid on Home
												Loan</label> <input type="text" value="0"
												id="occupiedPropertyInterest"
												name="occupiedPropertyInterest"
												th:field="*{occupiedPropertyInterest}" /><br />
										</div>
										<div class="col-sm-6">
											<label class="control-label">Rental Income Received </label>
											<input type="text" value="0" id="rentalPropertyIncome"
												name="rentalPropertyIncome"
												th:field="*{rentalPropertyIncome}" /><br />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6">
											<label class="control-label">Exmptions & Deductions
												from Salary</label> <input class="form-control" type="text"
												value="0" name="exemptIncome" id="exemptIncome"
												th:field="*{exemptIncome}" /><br />
										</div>
										<div class="col-sm-6">
											<label class="control-label" style="line-height: 2.7">Other
												Income </label> <input type="text" value="0" id="otherIncome"
												name="otherIncome" th:field="*{otherIncome}" /><br />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6">
											<label class="control-label"></label>
											<!-- <input type="text" value="0" th:field="*{employeeId}" /><br /> -->
										</div>
										<div class="col-sm-6">
											<label class="control-label">Interest Paid on Loan </label> <input
												type="text" value="0" id="interestLoan" name="interestLoan"
												th:field="*{interestLoan}" /><br />
										</div>
									</div>
									<a id="taxIncomeDetails" data-toggle="tab"
										href="javascript:showNextTaxStep('taxDeductionDetails');"
										class="btn btn-Success right">Go to Next Step</a>
								</div>
								<div class="taxStyle" id="taxDeductionDetails"
									style="display: none">
									<h4>Deduction Details</h4>
									<label class="control-label col-sm-4">Your Deductions:</label><br>
									<br>
									<div class="form-group">
										<div class="col-sm-6">
											<label class="control-label">Basic Deductions - 80C</label> <input
												type="text" value="0" id="section80C" name="section80C"
												th:field="*{section80C}" /><br />
										</div>
										<div class="col-sm-6">
											<label class="control-label">Medical Insurance - 80D
											</label> <input type="text" value="0" id="section80D"
												name="section80D" th:field="*{section80D}" /><br />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6">
											<label class="control-label">Interest on Educational
												Loan - 80E </label> <input type="text" value="0" id="section80E"
												name="section80E" th:field="*{section80E}" /><br />
										</div>
										<div class="col-sm-6">
											<label class="control-label">Employee's contribution
												to NPS - 80CCD </label> <input type="text" value="0"
												id="section80CCD" name="section80CCD"
												th:field="*{section80CCD}" /><br />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6">
											<label class="control-label">Interest from Deposits -
												80TTA </label> <input type="text" value="0" id="section80TTA"
												name="section80TTA" th:field="*{section80TTA}" /><br />
										</div>
										<div class="col-sm-6">
											<label class="control-label" style="line-height: 2.7;">Donations
												to Charity - 80G </label> <input type="text" value="0"
												id="section80G" name="section80G" th:field="*{section80G}" /><br />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6">
											<label class="control-label"></label>
											<!-- <input type="text" value="0" th:field="*{employeeId}" /><br /> -->
										</div>
										<div class="col-sm-6">
											<label class="control-label">Interest on Housing Loan
												- 80EEA </label> <input type="text" value="0" id="section80EEA"
												name="section80EEA" th:field="*{section80EEA}" /><br />
										</div>
									</div>
									<a id="taxDeductionDetails" data-toggle="tab"
											href="javascript:showNextTaxStep('summary');"><button type="submit" name="submitButton" 
										id="next-step-btn-summary" class="btn btn-success"
										style="margin: 25px auto; float: right;">
										Calculate
									</button></a>
								</div>
								<br></br>
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>