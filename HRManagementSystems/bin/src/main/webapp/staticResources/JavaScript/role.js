var selDiv = "";

document.addEventListener("DOMContentLoaded", init, false);

function init() {
	/*
	 * document.querySelector('#files').addEventListener('change',
	 * handleFileSelect, false);
	 */
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

function addRole() {

	var roleId = document.forms["roleform"]["roleId"].value;
	var roleName = document.forms["roleform"]["roleName"].value;
	var roleType = document.forms["roleform"]["roleType"].value;
	var roleDesc = document.forms["roleform"]["roleDesc"].value;

	var role = {
		"roleId" : roleId,
		"roleName" : roleName,
		"roleType" : roleType,
		"roleDesc" : roleDesc,

	};

	var roleAccessBean = JSON.stringify(role);

	console.log("jsonString == " + roleAccessBean);
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/company/addRole';
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : urlF,
		data : roleAccessBean,
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

function addSubRole() {
	var subRoleId = document.forms["subRoleform"]["subRoleId"].value;
	var roleName = document.forms["subRoleform"]["roleName"].value;
	var roleId = document.forms["subRoleform"]["roleId"].value;
	var roleType = document.forms["subRoleform"]["roleType"].value;
	var roleDesc = document.forms["subRoleform"]["roleDesc"].value;

	var subRole = {
		"subRoleId" : subRoleId,
		"roleName" : roleName,
		"roleId" : roleId,
		"roleType" : roleType,
		"roleDesc" : roleDesc

	};

	var subRoleAccessBean = JSON.stringify(subRole);

	console.log("jsonString == " + subRoleAccessBean);
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/company/addSubRole';
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : urlF,
		data : subRoleAccessBean,
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