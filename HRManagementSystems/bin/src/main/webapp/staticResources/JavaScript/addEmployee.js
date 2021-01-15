var selDiv = "";

document.addEventListener("DOMContentLoaded", init, false);

function init() {
	/*document.querySelector('#files').addEventListener('change',
			handleFileSelect, false);*/
	selDiv = document.querySelector("#selectedFiles");
}

function handleFileSelect(e) {

	if (!e.target.files)
		return;

	selDiv.innerHTML = "";

	var files = e.target.files;
	for (var i = 0; i < files.length; i++) {
		var f = files[i];

		selDiv.innerHTML += f.name + "<br/>";

	}

}
function submitForm() {
	var personTitle = document.forms["msform"]["personTitle"].value;
	var firstName = document.forms["msform"]["firstName"].value;
	var middleName = document.forms["msform"]["middleName"].value;
	var lastName = document.forms["msform"]["lastName"].value;
	var gender = document.forms["msform"]["gender"].value;
	var email1 = document.forms["msform"]["email1"].value;
	var phone1 = document.forms["msform"]["phone1"].value;
	var address = document.forms["msform"]["address"].value;
	var city = document.forms["msform"]["city"].value;
	var stateId = document.forms["msform"]["stateId"].value;
	var countryId = document.forms["msform"]["countryId"].value;
	var pincode = document.forms["msform"]["pincode"].value;
	var employeeCode = document.forms["msform"]["employeeCode"].value;
	var employeeTypeId = document.forms["msform"]["employeeTypeId"].value;
	var employeeStatus = document.forms["msform"]["employeeStatus"].value;
	/* var JoiningDate = document.forms["msform"]["JoiningDate"].value; */
	var experience = document.forms["msform"]["experience"].value;
	var logonId = document.forms["msform"]["logonId"].value;
	var logonPassword = document.forms["msform"]["logonPassword"].value;
	var probationPeriod = document.forms["msform"]["probationPeriod"].value;
	var projectId = document.forms["msform"]["projectId"].value;
	var manager = document.forms["msform"]["manager"].value;
	var workLocationId = document.forms["msform"]["workLocationId"].value;
	var designation = document.forms["msform"]["designation"].value;
	var jobTitleId = document.forms["msform"]["jobTitleId"].value;
	var departmentId = document.forms["msform"]["departmentId"].value;
	var ctc = document.forms["msform"]["ctc"].value;
	var holderName = document.forms["msform"]["holderName"].value;
	var bankName = document.forms["msform"]["bankName"].value;
	var city = document.forms["msform"]["city"].value;
	var branchName = document.forms["msform"]["branchName"].value;
	var ifscCode = document.forms["msform"]["ifscCode"].value;
	var accountNumber = document.forms["msform"]["accountNumber"].value;
	var pf = document.forms["msform"]["pf"].checked;
	var esi = document.forms["msform"]["esi"].checked;
	
	var addBranch = document.forms["msform"]["addBranch"].checked;
	var viewBranch = document.forms["msform"]["viewBranch"].checked;
	var editBranch = document.forms["msform"]["editBranch"].checked;
	var deleteBranch = document.forms["msform"]["deleteBranch"].checked;
	var addDepartment = document.forms["msform"]["addDepartment"].checked;
	var viewDepartment = document.forms["msform"]["viewDepartment"].checked;
	var editDepartment = document.forms["msform"]["editDepartment"].checked;
	var deleteDepartment = document.forms["msform"]["deleteDepartment"].checked;
	var addJobTitle = document.forms["msform"]["addJobTitle"].checked;
	var viewJobTitle = document.forms["msform"]["viewJobTitle"].checked;
	var editJobTitle = document.forms["msform"]["editJobTitle"].checked;
	var deleteJobTitle = document.forms["msform"]["deleteJobTitle"].checked;
	var addAnnouncement = document.forms["msform"]["addAnnouncement"].checked;
	var viewAnnouncement = document.forms["msform"]["viewAnnouncement"].checked;
	var editAnnouncement = document.forms["msform"]["editAnnouncement"].checked;
	var deleteAnnouncement = document.forms["msform"]["deleteAnnouncement"].checked;
	var addPolicies = document.forms["msform"]["addPolicies"].checked;
	var viewPolicies = document.forms["msform"]["viewPolicies"].checked;
	var editPolicies = document.forms["msform"]["editPolicies"].checked;
	var deletePolicies = document.forms["msform"]["deletePolicies"].checked;
	var uploadPolicies = document.forms["msform"]["uploadPolicies"].checked;
	var downloadPolicies = document.forms["msform"]["downloadPolicies"].checked;

	var addEmployee = document.forms["msform"]["addEmployee"].checked;
	var viewEmployee = document.forms["msform"]["viewEmployee"].checked;
	var editEmployee = document.forms["msform"]["editEmployee"].checked;
	var deleteEmployee = document.forms["msform"]["deleteEmployee"].checked;
	var uploadEmployee = document.forms["msform"]["uploadEmployee"].checked;
	var downloadEmployee = document.forms["msform"]["downloadEmployee"].checked;

	var addAttendance = document.forms["msform"]["addAttendance"].checked;
	var viewAttendance = document.forms["msform"]["viewAttendance"].checked;
	var editAttendance = document.forms["msform"]["editAttendance"].checked;
	var deleteAttendance = document.forms["msform"]["deleteAttendance"].checked;
	var uploadAttendance = document.forms["msform"]["uploadAttendance"].checked;
	var downloadAttendance = document.forms["msform"]["downloadAttendance"].checked;
	var approvelAttendance = document.forms["msform"]["approvelAttendance"].checked;
	var setRulesAttendance = document.forms["msform"]["setRulesAttendance"].checked;
	var settingAttendance = document.forms["msform"]["settingAttendance"].checked;

	var addLeave = document.forms["msform"]["addLeave"].checked;
	var viewLeave = document.forms["msform"]["viewLeave"].checked;
	var editLeave = document.forms["msform"]["editLeave"].checked;
	var deleteLeave = document.forms["msform"]["deleteLeave"].checked;
	var uploadLeave = document.forms["msform"]["uploadLeave"].checked;
	var downloadLeave = document.forms["msform"]["downloadLeave"].checked;
	var approvelLeave = document.forms["msform"]["approvelLeave"].checked;
	var balanceLeave = document.forms["msform"]["balanceLeave"].checked;
	var setRulesLeave = document.forms["msform"]["setRulesLeave"].checked;
	var settingLeave = document.forms["msform"]["settingLeave"].checked;

	var addRunPayroll = document.forms["msform"]["addRunPayroll"].checked;
	var viewRunPayroll = document.forms["msform"]["viewRunPayroll"].checked;
	var editRunPayroll = document.forms["msform"]["editRunPayroll"].checked;
	var deleteRunPayroll = document.forms["msform"]["deleteRunPayroll"].checked;
	var uploadRunPayroll = document.forms["msform"]["uploadRunPayroll"].checked;
	var downloadRunPayroll = document.forms["msform"]["downloadRunPayroll"].checked;
	var approvelRunPayroll = document.forms["msform"]["approvelRunPayroll"].checked;
	var balanceRunPayroll = document.forms["msform"]["balanceRunPayroll"].checked;
	var setRulesRunPayroll = document.forms["msform"]["setRulesRunPayroll"].checked;
	var settingRunPayroll = document.forms["msform"]["settingRunPayroll"].checked;
	var addSalaryStructure = document.forms["msform"]["addSalaryStructure"].checked;
	var viewSalaryStructure = document.forms["msform"]["viewSalaryStructure"].checked;
	var editSalaryStructure = document.forms["msform"]["editSalaryStructure"].checked;
	var deleteSalaryStructure = document.forms["msform"]["deleteSalaryStructure"].checked;
	var uploadSalaryStructure = document.forms["msform"]["uploadSalaryStructure"].checked;
	var downloadSalaryStructure = document.forms["msform"]["downloadSalaryStructure"].checked;
	var approvelSalaryStructure = document.forms["msform"]["approvelSalaryStructure"].checked;
	var assignSalaryStructure = document.forms["msform"]["assignSalaryStructure"].checked;
	var addSalaryComponent = document.forms["msform"]["addSalaryComponent"].checked;
	var viewSalaryComponent = document.forms["msform"]["viewSalaryComponent"].checked;
	var editSalaryComponent = document.forms["msform"]["editSalaryComponent"].checked;
	var deleteSalaryComponent = document.forms["msform"]["deleteSalaryComponent"].checked;
	var addSalaryOverview = document.forms["msform"]["addSalaryOverview"].checked;
	var viewSalaryOverview = document.forms["msform"]["viewSalaryOverview"].checked;
	var editSalaryOverview = document.forms["msform"]["editSalaryOverview"].checked;
	var deleteSalaryOverview = document.forms["msform"]["deleteSalaryOverview"].checked;
	var uploadSalaryOverview = document.forms["msform"]["uploadSalaryOverview"].checked;
	var downloadSalaryOverview = document.forms["msform"]["downloadSalaryOverview"].checked;
	var approvelSalaryOverview = document.forms["msform"]["approvelSalaryOverview"].checked;
	var addDeclaration = document.forms["msform"]["addDeclaration"].checked;
	var viewDeclaration = document.forms["msform"]["viewDeclaration"].checked;
	var editDeclaration = document.forms["msform"]["editDeclaration"].checked;
	var deleteDeclaration = document.forms["msform"]["deleteDeclaration"].checked;
	var uploadDeclaration = document.forms["msform"]["uploadDeclaration"].checked;
	var downloadDeclaration = document.forms["msform"]["downloadDeclaration"].checked;
	var approvelDeclaration = document.forms["msform"]["approvelDeclaration"].checked
	
	var employee = {
		"employeeStatus" : employeeStatus,
		"employeeCode" : employeeCode,
		"logonPassword" : logonPassword,
		"logonId" : logonId,
		"addressAccessBean" : [ {
			"personTitle" : personTitle,
			"firstName" : firstName,
			"middleName" : middleName,
			"lastName" : lastName,
			"gender" : gender,
			"email1" : email1,
			"phone1" : phone1,
			"address" : address,
			"city" : city,
			"stateId" : stateId,
			"countryId" : countryId,
			"pincode" : pincode,
			"probationPeriod" : probationPeriod,
			"experience" : experience,
			"ctc" : ctc,
			"employeeTypeId" : employeeTypeId,
			"workLocationId" : workLocationId,
			"jobTitleId" : jobTitleId,
			"departmentId" : departmentId,
		} ],
		"accountDetailsAccessBean" : {
			"holderName" : holderName,
			"bankName" : bankName,
			"city" : city,
			"branchName" : branchName,
			"ifscCode" : ifscCode,
			"accountNumber" : accountNumber,
			"pf" : pf,
			"esi" : esi
		},
		"empWorkRelationAccessBean" : {
			"designation" : designation,
			"workLocationId" : workLocationId,
			"departmentId" : departmentId,
			"employeeTypeId" : employeeTypeId,
			"projectId" : projectId,
			"manager" : manager,
		},
		"companyPermissionAccessBean" : {
			"addBranch" : addBranch,
			"viewBranch" : viewBranch,
			"editBranch" : editBranch,
			"deleteBranch" : deleteBranch,
			"addDepartment" : addDepartment,
			"viewDepartment" : viewDepartment,
			"editDepartment" : editDepartment,
			"deleteDepartment" : deleteDepartment,
			"addJobTitle" : addJobTitle,
			"viewJobTitle" : viewJobTitle,
			"editJobTitle" : editJobTitle,
			"deleteJobTitle" : deleteJobTitle,
			"addAnnouncement" : addAnnouncement,
			"viewAnnouncement" : viewAnnouncement,
			"editAnnouncement" : editAnnouncement,
			"deleteAnnouncement" : deleteAnnouncement,
			"addPolicies" : addPolicies,
			"viewPolicies" : viewPolicies,
			"editPolicies" : editPolicies,
			"deletePolicies" : deletePolicies,
			"uploadPolicies" : uploadPolicies,
			"downloadPolicies" : downloadPolicies
		},
		"directoryPermissionAccessBean" : {
			"addEmployee" : addEmployee,
			"viewEmployee" : viewEmployee,
			"editEmployee" : editEmployee,
			"deleteEmployee" : deleteEmployee,
			"uploadEmployee" : uploadEmployee,
			"downloadEmployee" : downloadEmployee
		},
		"attendancePermissionAccessBean" : {
			"addAttendance" : addAttendance,
			"viewAttendance" : viewAttendance,
			"editAttendance" : editAttendance,
			"deleteAttendance" : deleteAttendance,
			"uploadAttendance" : uploadAttendance,
			"downloadAttendance" : downloadAttendance,
			"approvelAttendance" : approvelAttendance,
			"setRulesAttendance" : setRulesAttendance,
			"settingAttendance" : settingAttendance
		},
		"leavePermissionAccessBean" : {
			"addLeave" : addLeave,
			"viewLeave" : viewLeave,
			"editLeave" : editLeave,
			"deleteLeave" : deleteLeave,
			"uploadLeave" : uploadLeave,
			"downloadLeave" : downloadLeave,
			"approvelLeave" : approvelLeave,
			"balanceLeave" : balanceLeave,
			"setRulesLeave" : setRulesLeave,
			"settingLeave" : settingLeave
		},
		"payrollPermissionAccessBean" : {
			"addRunPayroll" : addRunPayroll,
			"viewRunPayroll" : viewRunPayroll,
			"editRunPayroll" : editRunPayroll,
			"deleteRunPayroll" : deleteRunPayroll,
			"uploadRunPayroll" : uploadRunPayroll,
			"downloadRunPayroll" : downloadRunPayroll,
			"approvelRunPayroll" : approvelRunPayroll,
			"balanceRunPayroll" : balanceRunPayroll,
			"setRulesRunPayroll" : setRulesRunPayroll,
			"settingRunPayroll" : settingRunPayroll,
			"addSalaryStructure" : addSalaryStructure,
			"viewSalaryStructure" : viewSalaryStructure,
			"editSalaryStructure" : editSalaryStructure,
			"deleteSalaryStructure" : deleteSalaryStructure,
			"uploadSalaryStructure" : uploadSalaryStructure,
			"downloadSalaryStructure" : downloadSalaryStructure,
			"approvelSalaryStructure" : approvelSalaryStructure,
			"assignSalaryStructure" : assignSalaryStructure,
			"addSalaryComponent" : addSalaryComponent,
			"viewSalaryComponent" : viewSalaryComponent,
			"editSalaryComponent" : editSalaryComponent,
			"deleteSalaryComponent" : deleteSalaryComponent,
			"addSalaryOverview" : addSalaryOverview,
			"viewSalaryOverview" : viewSalaryOverview,
			"editSalaryOverview" : editSalaryOverview,
			"deleteSalaryOverview" : deleteSalaryOverview,
			"uploadSalaryOverview" : uploadSalaryOverview,
			"downloadSalaryOverview" : downloadSalaryOverview,
			"addDeclaration" : addDeclaration,
			"viewDeclaration" : viewDeclaration,
			"editDeclaration" : editDeclaration,
			"deleteDeclaration" : deleteDeclaration,
			"uploadDeclaration" : uploadDeclaration,
			"downloadDeclaration" : downloadDeclaration,
			"approvelDeclaration" : approvelDeclaration
		}
	};
	var employeeAccessBean = JSON.stringify(employee);

	console.log("jsonString == " + employeeAccessBean);
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/company/add_Employee';
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : urlF,
		data : employeeAccessBean,
		dataType : 'json',
		cache : false,
		success : function(response) {
			console.log(response);
		},

		error : function(error) {
			console.log(error);
		}

	});

}

function work_department(){
	
}

