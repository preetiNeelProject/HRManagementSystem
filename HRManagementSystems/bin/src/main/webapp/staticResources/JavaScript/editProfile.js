var selDiv = "";
var educationArray = [];
var dependentArray = [];
var emergencyArray = [];
var documentArray = [];
var data = null;
var fileInput = null;
var title;

var addRowId;
var teducationalId;
var dddependentId;
var demergencyId;

var type;

;
var universityName

document.addEventListener("DOMContentLoaded", init, false);

/*function init() {
	document.querySelector('#files').addEventListener('change',
			handleFileSelect, false);
	selDiv = document.querySelector("#selectedFiles");
}*/

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

function fillAddress() {
	var check = document.getElementById('filladdress');
	if (check.checked) {
		$("#caddress").val($("#address").val());
		$("#ccity").val($("#city").val());
		$("#cstateId").val($("#stateId").val());
		$("#ccountryId").val($("#countryId").val());
		$("#cpincode").val($("#pincode").val());
	} else {
		$("#caddress").val('');
		$("#ccity").val('');
		$("#cstateId").val('');
		$("#ccountryId").val('');
		$("#cpincode").val('');
	}

}

function submitEditForm(employeeId) {
	console.log("json : " + JSON.stringify(educationArray));
	var personTitle = document.forms["msform"]["personTitle"].value;
	var firstName = document.forms["msform"]["firstName"].value;
	var middleName = document.forms["msform"]["middleName"].value;
	var lastName = document.forms["msform"]["lastName"].value;
	var bloodGroup = document.forms["msform"]["bloodGroup"].value;
	var dob = document.forms["msform"]["dob"].value;
	var martialStatus = document.forms["msform"]["martialStatus"].value;
	var gender = document.forms["msform"]["gender"].value;
	var caste = document.forms["msform"]["caste"].value;
	var religion = document.forms["msform"]["religion"].value;
	var nationality = document.forms["msform"]["nationality"].value;
	var email1 = document.forms["msform"]["email1"].value;
	var email2 = document.forms["msform"]["email2"].value;
	var phone1 = document.forms["msform"]["phone1"].value;
	var phone2 = document.forms["msform"]["phone2"].value;
	var address = document.forms["msform"]["address"].value;
	var city = document.forms["msform"]["city"].value;
	var stateId = document.forms["msform"]["stateId"].value;
	var countryId = document.forms["msform"]["countryId"].value;
	var pincode = document.forms["msform"]["pincode"].value;

	var caddress = document.forms["msform"]["caddress"].value;
	var ccity = document.forms["msform"]["ccity"].value;
	var cstateId = document.forms["msform"]["cstateId"].value;
	var ccountryId = document.forms["msform"]["ccountryId"].value;
	var cpincode = document.forms["msform"]["cpincode"].value;

	/* var addressType = document.forms["msform"]["addressType"].value; */
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
	var accountDetailId = document.forms["msform"]["accountDetailId"].value;
	var addressId = document.forms["msform"]["addressId"].value;
	var empWorkRelationId = document.forms["msform"]["empWorkRelationId"].value;
	var employee = {
		"employeeId" : employeeId,
		"employeeStatus" : employeeStatus,
		"employeeCode" : employeeCode,
		"logonId" : logonId,
		"logonPassword" : logonPassword,
		"addressAccessBean" : [ {
			"addressId" : addressId,
			"personTitle" : personTitle,
			"firstName" : firstName,
			"middleName" : middleName,
			"lastName" : lastName,
			"gender" : gender,
			"bloodGroup" : bloodGroup,
			"dob" : dob,
			"caste" : caste,
			"martialStatus" : martialStatus,
			"religion" : religion,
			"nationality" : nationality,
			"email1" : email1,
			"email2" : email2,
			"phone1" : phone1,
			"phone2" : phone2,
			"address" : address,
			"city" : city,
			"stateId" : stateId,
			"countryId" : countryId,
			"pincode" : pincode,
			"caddress" : caddress,
			"ccity" : ccity,
			"cstateId" : cstateId,
			"ccountryId" : ccountryId,
			"cpincode" : cpincode,
			"probationPeriod" : probationPeriod,
			"experience" : experience,
			"ctc" : ctc,
			"employeeTypeId" : employeeTypeId,
			"workLocationId" : workLocationId,
			"jobTitleId" : jobTitleId,
			"departmentId" : departmentId,
		} ],
		"educationAccessBean" : educationArray,
		"emergencyAccessBean" : emergencyArray,
		"dependentsAccessBean" : dependentArray,
		// "documentAccessBean" : documentArray,
		"accountDetailsAccessBean" : {
			"holderName" : holderName,
			"bankName" : bankName,
			"city" : city,
			"branchName" : branchName,
			"ifscCode" : ifscCode,
			"accountNumber" : accountNumber,
			"accountDetailId" : accountDetailId
		},
		"empWorkRelationAccessBean" : {
			"designation" : designation,
			"workLocationId" : workLocationId,
			"departmentId" : departmentId,
			"employeeTypeId" : employeeTypeId,
			"projectId" : projectId,
			"manager" : manager,
			"empWorkRelationId" : empWorkRelationId
		},
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
			uploadFile(response);
		},

		error : function(error) {
			console.log(error);
		}

	});

}
function uploadFile(employeeId) {
	var doc = JSON.stringify(documentArray);
	console.log("documentArray " + doc)
	console.log("employeeId " + employeeId);
	/*
	 * var documentDetails = document.getElementById('files');
	 * 
	 * if($(this).prop('files').length > 0) { file =$(this).prop('files')[0];
	 * formdata.append("multipartFile", documentDetails); }
	 */
	/*
	 * accessBean = new FormData(); accessBean.append("type", "Driving
	 * Licence"); accessBean.append("title", "title");
	 * accessBean.append("fileName", "company-addEmployee-1.png");
	 */
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/company/uploadFile';
	$.ajax({
		url : urlF,
		type : "POST",
		data : doc,
		processData : false,
		contentType : 'application/json',

		success : function(response) {
			uploadFile(response);
		},

		error : function(error) {
			console.log(error);
		}

	});

}

function addNewEducation() {

	var table = document.getElementById('qualificationTable');
	var tblBody = document.getElementById('qualificationBody');
	for (var i = 1; i < 2; i++) {
		var tr = document.createElement('tr');
		var rows=table.getElementsByTagName("tr");
		var num;
		
		if(addRowId == undefined){
			var num = Number(rows.length)-1;
			tr.id = num;
		}
		else
			{
			tr.id = addRowId;
			num=addRowId;
			addRowId = undefined;
			}
		
	
		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');
		var td6 = document.createElement('td');
		var td7 = document.createElement('td');
		var td8 = document.createElement('td');
		var td9 = document.createElement('td');
		var td10 = document.createElement('td');

		 teducationalId = document
				.createTextNode(teducationalId)
		var tqualiTypeId = document.createTextNode($('#qualiTypeId').val());
		var tcourseName = document.createTextNode($('#cn').val());
		var tcourseType = document.createTextNode($('#ct').val());
		var tstream = document.createTextNode($('#st').val());
		var tcourseStartDate = document.createTextNode($('#csd').val());
		var tcourseEndDate = document.createTextNode($('#ced').val());
		var tcollegeName = document.createTextNode($('#college').val());
		var tuniversityName = document.createTextNode($('#un').val());
		// var tableEdit = document.createTextNode($('#tableEdit')).append('<i
		// class="fa fa-trash-o" aria-hidden="true">');

		td1.appendChild(tqualiTypeId);
		td1.id = "tqualiTypeId";
		td1.value = qualiTypeId;

		td2.appendChild(tcourseName);
		td2.id = "tcourseName";

		td3.appendChild(tcourseType);
		td3.id = "tcourseType";

		td4.appendChild(tstream);
		td4.id = "tstream";

		td5.appendChild(tcourseStartDate);
		td5.id = "tcourseStartDate";

		td6.appendChild(tcourseEndDate);
		td6.id = "tcourseEndDate";

		td7.appendChild(tcollegeName);
		td7.id = "tcollegeName";

		td8.appendChild(tuniversityName);
		td8.id = "tuniversityName";

		td9.innerHTML += '<a id="tableView" onclick="editData('+"'"+num+"'"+');"><i class="fa fa-pencil" style="font-size: 18px !important; color: darkslateblue !important;"></i></a>';
		td9.id="tableEdit";
		
		td10.appendChild(teducationalId);
		td10.id = "teducationalId";
		// td10.style.display=none;

		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tr.appendChild(td7);
		tr.appendChild(td8);
		tr.appendChild(td9);
		tr.appendChild(td9);
		tr.appendChild(td10).style.display = 'none';

		tblBody.appendChild(tr);

	}
	table.appendChild(tblBody);
	// document.body.appendChild(table);
	teducationalId = undefined;

}

function getEducation() {
	var educationDetails = document.getElementById("qualificationTable");
	for (var i = 1; i < educationDetails.rows.length; i++) {
		var education = {
			"qualiTypeId" : educationDetails.rows[i].cells[0].innerText,
			"courseName" : educationDetails.rows[i].cells[1].innerText,
			"courseType" : educationDetails.rows[i].cells[2].innerText,
			"stream" : educationDetails.rows[i].cells[3].innerText,
			"courseStartDate" : educationDetails.rows[i].cells[4].innerText,
			"courseEndDate" : educationDetails.rows[i].cells[5].innerText,
			"collegeName" : educationDetails.rows[i].cells[6].innerText,
			"universityName" : educationDetails.rows[i].cells[7].innerText,
			"educationalId" : educationDetails.rows[i].cells[9].innerText,
		};

		educationArray[i - 1] = education;
	}
	console.log("education " + JSON.stringify(educationArray));
}

function addNewDependant() {

	var table = document.getElementById('dependentTable');
	var tblBody = document.getElementById('dependentBody');
	for (var i = 1; i < 2; i++) {
		var tr = document.createElement('tr');
		
		var rows=table.getElementsByTagName("tr");
		var num;
		
		if(addRowId == undefined){
			var num = Number(rows.length)-1;
			tr.id = num;
		}
		else
			{
			tr.id = addRowId;
			num=addRowId;
			addRowId = undefined;
			}

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');
		var td6 = document.createElement('td');

		var ddfirstName = document.createTextNode($('#dfirstName').val());
		var ddlastName = document.createTextNode($('#dlastName').val());
		var ddphone1 = document.createTextNode($('#dphone1').val());
		var ddrelationship = document.createTextNode($('#drelationship').val());
		dddependentId = document.createTextNode(dddependentId);

		td1.appendChild(ddfirstName);
		td1.id = ddfirstName;

		td2.appendChild(ddlastName);
		td2.id = ddlastName;

		td3.appendChild(ddphone1);
		td3.id = ddphone1;

		td4.appendChild(ddrelationship);
		td4.id = ddrelationship;

		td5.innerHTML += '<a id="tableView" onclick="editDependentData('+"'"+num+"'"+');"><i class="fa fa-pencil" style="font-size: 18px !important; color: darkslateblue !important;"></i></a>';

		td6.appendChild(dddependentId);
		td6.id = dddependentId;

		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6).style.display = 'none';

		tblBody.appendChild(tr);
	}
	table.appendChild(tblBody);
	dddependentId=undefined;
}

function addNewEmergency() {

	var table = document.getElementById('emergencyTable');
	var tblBody = document.getElementById('emergencyBody');
	for (var i = 1; i < 2; i++) {
		var tr = document.createElement('tr');

		var rows=table.getElementsByTagName("tr");
		var num;
		
		if(addRowId == undefined){
			var num = Number(rows.length)-1;
			tr.id = num;
		}
		else
			{
			tr.id = addRowId;
			num=addRowId;
			addRowId = undefined;
			}
		
		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');

		var demergencyName = document.createTextNode($('#emergencyName').val());
		var demergencyNumber = document.createTextNode($('#emergencyNumber')
				.val());
		var demergencyRelationship = document.createTextNode($(
				'#emergencyRelationship').val());
		demergencyId = document.createTextNode(
				demergencyId);

		td1.appendChild(demergencyName);
		td1.id="demergencyName";
		
		td2.appendChild(demergencyNumber);
		td2.id="demergencyNumber";
		
		td3.appendChild(demergencyRelationship);
		td3.id="demergencyRelationship";
		
		td4.innerHTML += '<a id="tableView" onclick="editEmergencyData('+"'"+num+"'"+');"><i class="fa fa-pencil" style="font-size: 18px !important; color: darkslateblue !important;"></i></a>';
		td4.id="tableEdit";
		
		
		td5.appendChild(demergencyId);
		td5.id="demergencyId";

		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5).style.display='none';
		

		tblBody.appendChild(tr);
	}
	table.appendChild(tblBody);

	demergencyId=undefined;
}

function getDependentEmergency() {
	var dependentDetails = document.getElementById("dependentTable");
	var emergencyDetails = document.getElementById("emergencyTable");
	for (var i = 1; i < dependentDetails.rows.length; i++) {
		var dependent = {
			"firstName" : dependentDetails.rows[i].cells[0].innerText,
			"lastName" : dependentDetails.rows[i].cells[1].innerText,
			"phone1" : dependentDetails.rows[i].cells[2].innerText,
			"relationship" : dependentDetails.rows[i].cells[3].innerText,
			"dependentId" : dependentDetails.rows[i].cells[5].innerText,
		};

		dependentArray[i - 1] = dependent;
	}
	for (var i = 1; i < emergencyDetails.rows.length; i++) {
		var emergency = {
			"emergencyName" : emergencyDetails.rows[i].cells[0].innerText,
			"emergencyNumber" : emergencyDetails.rows[i].cells[1].innerText,
			"emergencyRelationship" : emergencyDetails.rows[i].cells[2].innerText,
			"emergencyId":emergencyDetails.rows[i].cells[4].innerText,
		};

		emergencyArray[i - 1] = emergency;
	}
	console.log("emergency " + JSON.stringify(emergencyArray));
	console.log("dependentArray " + JSON.stringify(dependentArray));
}

function addNewIDs() {

	var table = document.getElementById('idsTable');
	var tblBody = document.getElementById('idsBody');
	for (var i = 1; i < 2; i++) {
		var tr = document.createElement('tr');

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');

		type = document.createTextNode($('#type').val());
		title = document.createTextNode($('#title').val());
		var fileName = document.createTextNode($('#selectedFiles').text());
		fileInput = $('#files')[0].files[0];
		var files = document.createTextNode(fileInput);

		td1.appendChild(type);
		td2.appendChild(title);
		td3.appendChild(fileName);
		td4.appendChild(files);

		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);

		tblBody.appendChild(tr);

	}
	table.appendChild(tblBody);
	// document.body.appendChild(table);

	accessBean = new FormData();

	file = $('#files')[0].files[0];
	accessBean.append("multipart", file);
	accessBean.append("type", $('#type').val());
	accessBean.append("title", $('#title').val());
	accessBean.append("fileName", $('#selectedFiles').val());

	JSON.stringify(accessBean);
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/employee/uploadFile' + employeeId;
	$.ajax({
		
		url : urlF,
		type : "POST",
		data : accessBean,
		enctype : 'multipart/form-data',
		processData : false, // Important!
		contentType : false,

		success : function(data) {

			console.log("SUCCESS : ", data);

		},
		error : function(e) {

			console.log("ERROR : ", e);

		}

	});
}

function getIDs() {

	var documentDetails = document.getElementById('idsTable');

	for (var i = 1; i < documentDetails.rows.length; i++) {
		var documentData = {
			"type" : documentDetails.rows[i].cells[0].innerText,
			"title" : documentDetails.rows[i].cells[1].innerText,
			"fileName" : documentDetails.rows[i].cells[2].innerText,
			"files" : documentDetails.rows[i].cells[3],

		};

		documentArray[i - 1] = documentData;
	}
	console.log("document " + JSON.stringify(documentArray));
}

function addNewCerti() {

	var table = document.getElementById('certiTable');
	var tblBody = document.getElementById('certiBody');
	for (var i = 1; i < 2; i++) {
		var tr = document.createElement('tr');

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');

		var type = document.createTextNode($('#certiType').val());
		var title = document.createTextNode($('#certiTitle').val());
		var fileName = document.createTextNode($('#selectedFiles').text());

		td1.appendChild(type);
		td2.appendChild(title);
		td3.appendChild(fileName);

		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);

		tblBody.appendChild(tr);

	}
	table.appendChild(tblBody);
	// document.body.appendChild(table);

}

function addNewWork() {

	var table = document.getElementById('workTable');
	var tblBody = document.getElementById('workBody');
	for (var i = 1; i < 2; i++) {
		var tr = document.createElement('tr');

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');

		var title = document.createTextNode($('#workTitle').val());
		var description = document.createTextNode($('#workDescription').val());
		var fileName = document.createTextNode($('#selectedWorkFiles').text());

		td1.appendChild(title);
		td2.appendChild(description);
		td3.appendChild(fileName);

		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);

		tblBody.appendChild(tr);

	}
	table.appendChild(tblBody);

}

function editData(rowId) {
	 addRowId=rowId;;
	var num = Number(rowId)+1;
	var educationDetails = document.getElementById("qualificationTable");
	for (var i = num; i < educationDetails.rows.length; i++) {
		var tqualiTypeId = educationDetails.rows[i].cells[0].innerText;
		var tcourseName = educationDetails.rows[i].cells[1].innerText;
		var tcourseType = educationDetails.rows[i].cells[2].innerText;
		var tstream = educationDetails.rows[i].cells[3].innerText;
		var tcourseStartDate = educationDetails.rows[i].cells[4].innerText;
		var tcourseEndDate = educationDetails.rows[i].cells[5].innerText;
		var tcollegeName = educationDetails.rows[i].cells[6].innerText;
		var tuniversityName = educationDetails.rows[i].cells[7].innerText;
		teducationalId = educationDetails.rows[i].cells[9].innerText;

		var parent = document.getElementById(qualificationBody);
		
		$("#educationalId").val(teducationalId);

		$("#qualiTypeId").val(tqualiTypeId);

		$("#cn").val(tcourseName);

		$("#ct").val(tcourseType);

		$("#st").val(tstream);

		var dateString1 = tcourseStartDate;
		var OnlyDate1 = dateString1.split(" ");
		var dateParts1 = OnlyDate1[0].split("-");
		var dateObject1 = dateParts1[0] + "-" + dateParts1[1] + "-"
				+ dateParts1[2];
		$("#csd").val(dateObject1);

		var dateString = tcourseEndDate;
		var OnlyDate = dateString.split(" ");
		var dateParts = OnlyDate[0].split("-");
		var dateObject = dateParts[0] + "-" + dateParts[1] + "-" + dateParts[2];
		$("#ced").val(dateObject);

		$("#un").val(tuniversityName);

		$("#college").val(tcollegeName);
		
		// remove row withthe help of table unique
	
		document.getElementById("qualificationTable").rows[num].remove();
		  
		break;
	}
	;

}

/*
 * ================================================================= 
 *                 Edit Dependent Button call Method
 * =================================================================
 */

function editDependentData(rowId) {
	addRowId=rowId;;
	var num = Number(rowId)+1;
	var dependentDetails = document.getElementById("dependentTable");
	for (var i = num; i < dependentDetails.rows.length; i++) {
		var ddfirstName = dependentDetails.rows[i].cells[0].innerText;
		var ddlastName = dependentDetails.rows[i].cells[1].innerText;
		var dddependentPhone = dependentDetails.rows[i].cells[2].innerText;
		var ddrelationship = dependentDetails.rows[i].cells[3].innerText;
		dddependentId = dependentDetails.rows[i].cells[5].innerText;

		var parent = document.getElementById(dependentBody);
		
		$("#ddependentId").val(dddependentId);

		$("#dfirstName").val(ddfirstName);

		$("#dlastName").val(ddlastName);

		$("#dphone1").val(dddependentPhone);

		$("#drelationship").val(ddrelationship);

		document.getElementById("dependentTable").rows[num].remove();
		  
		break;
	}
	;

}

/*
 * ================================================================= 
 *                 Edit Emergency Button call Method
 * =================================================================
 */

function editEmergencyData(rowId){
	addRowId=rowId;;
	var num = Number(rowId)+1;
	var emergencyDetails = document.getElementById("emergencyTable");
	for (var i = num; i < emergencyDetails.rows.length; i++) {
		var demergencyName= emergencyDetails.rows[i].cells[0].innerText;
		var	demergencyNumber = emergencyDetails.rows[i].cells[1].innerText;
		var	demergencyRelationship = emergencyDetails.rows[i].cells[2].innerText;
		demergencyId= emergencyDetails.rows[i].cells[4].innerText;
		
		
	var parent = document.getElementById(qualificationBody);
	
	    $("#emergencyId").val(demergencyId);
	
		$("#emergencyName").val(demergencyName);
		
		$("#emergencyNumber").val(demergencyNumber);
		
		$("#emergencyRelationship").val(demergencyRelationship);
		
		document.getElementById("emergencyTable").rows[num].remove();
		break;
		};
	
	
			
}
