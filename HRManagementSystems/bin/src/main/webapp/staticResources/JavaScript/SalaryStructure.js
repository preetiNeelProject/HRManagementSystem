function createEmpSalaryStructure() {
	var employeeId = $("#employeeId").val();
	var ctc = $("#cTC").val();
	var host = window.location.host;
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'calBasicSalary';
	//urlF='/calBasicSalary'
	//alert(search);
	 if(ctc.length>3){  
	$.ajax({
        type: "POST",
        dataType: 'text',
        url: urlF,
        data: {
        	ctc,
        	employeeId
        },
        dataType: 'json',
        cache: false,
        success : function(response) {
            console.log("success : "+response.basicSalaryMonthly);
            $('#annualBasicSalary').val(response.basicSalaryMonthly);
            $('#pf').val(response.pfMonthly);
            $('#hra').val(response.hraMonthly);
            $('#convey').val(response.conveyanceMonthly);
            $('#annualFlexibleBenifits').val(response.otherMonthly);
            $('#annualRefSalary').val(response.annualRefSalary);
            $('#esi').val(response.esiMonthly);
           // document.getElementById("myBtn").disabled = false;
        },
        
		 error : function(error) {
			 console.log("basicSalaryMonthly "+JSON.stringify(error.basicSalaryMonthly));
	         console.log("error : "+JSON.stringify(error));
	     }

	});
	 }
};

function showNextTaxStep(nextTaxStep) {
    $('.taxStyle').each(function(index) {
         if ($(this).attr("id") == nextTaxStep) {
              $(this).show(200);
         }
         else {
              $(this).hide(600);
         }
    });
}

function openTaxTab(evt, taxDetails) {
	  var i, taxStyle, tablinks;
	  taxStyle = document.getElementsByClassName("taxStyle");
	  for (i = 0; i < taxStyle.length; i++) {
		  taxStyle[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  document.getElementById(taxDetails).style.display = "block";
	  evt.currentTarget.className += " active";
	}

$("#mytable #checkall").click(function () {
    if ($("#mytable #checkall").is(':checked')) {
        $("#mytable input[type=checkbox]").each(function () {
            $(this).prop("checked", true);
        });

    } else {
        $("#mytable input[type=checkbox]").each(function () {
            $(this).prop("checked", false);
        });
    }
});

$("#searchBar").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#salaryRevisionTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });

var Id;
$( "#employeeId" ).load($(this),function employeeInfo(Id) {
	var search = $("#employeeId").val();
	var url = '/getEmployeeDetails/' + Id.value;	
	$.ajax({
	      url: url,
	      data: {}, //parameters go here in object literal form
	      type: 'GET',
	      datatype: 'json',
	      success: function(data) { alert('got here with data'); },
	      error: function() { alert('something bad happened'); }
	    });
});

function salarySlipDownload(){
	var employeeId = document.forms["emloyeeSalaryForm"]["employeeId"].value;
	var joiningDate = document.forms["emloyeeSalaryForm"]["joiningDate"].value;
	var cTC = document.forms["emloyeeSalaryForm"]["cTC"].value;
	var annualBasicSalary = document.forms["emloyeeSalaryForm"]["annualBasicSalary"].value;
	var hra = document.forms["emloyeeSalaryForm"]["hra"].value;
	var convey = document.forms["emloyeeSalaryForm"]["convey"].value;
	var annualFlexibleBenifits = document.forms["emloyeeSalaryForm"]["annualFlexibleBenifits"].value;
	var pf = document.forms["emloyeeSalaryForm"]["pf"].value;
	var cTC = document.forms["emloyeeSalaryForm"]["cTC"].value;
	var esi = document.forms["emloyeeSalaryForm"]["esi"].value;
	var gratuity = document.forms["emloyeeSalaryForm"]["gratuity"].value;
	var annualRefSalary = document.forms["emloyeeSalaryForm"]["annualRefSalary"].value;

	
	var employeeCtc = {
		"employeeId" : employeeId,
		"joiningDate" : joiningDate,
		"cTC" : cTC,
		"annualBasicSalary" : annualBasicSalary,
		"hra" : hra,
		"convey" : convey,
		"annualFlexibleBenifits" : annualFlexibleBenifits,
		"pf" : pf,
		"esi" : esi,
		"gratuity" : gratuity,
		"annualRefSalary" : annualRefSalary

	};

	var employeeCTCAccessBean = JSON.stringify(employeeCtc);

	console.log("jsonString == " + employeeCTCAccessBean);
	var urlF=location.protocol + '/' +window.location.pathname.split('/')[1]+ '/' + 'admin/payroll/monthlySalary';
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : urlF,
		data : employeeCTCAccessBean,
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

