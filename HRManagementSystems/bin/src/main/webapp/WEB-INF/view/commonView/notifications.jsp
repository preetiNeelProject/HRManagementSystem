
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.navbar {
	overflow: hidden;
	background-color: none;
	width: 87px;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 24px;
	border: none;
	outline: none;
	color: #283655;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}

.dropdown-content {
	position: fixed;
	display: none;
	/*  position: absolute; */
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
    color: #283655;
    padding: 8px 15px;
    text-decoration: none;
    display: block;
    text-align: left;
    font-size: 14px;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown-content p {
font-size: 12px;
    padding: 0px 15px;
    }
    
 .dropdown-content center {   
    font-size: 12px;
    color: blue;
    }

.dropdown:hover .dropdown-content {
	display: block;
}

hr {
    margin-top: 5px;
    margin-bottom: 5px;
    }
</style>
</head>
<body>

	<div class="navbar">
		<div class="dropdown">
			<button class="dropbtn">
				<i class="fa fa-bell"></i> <span class="badge">3</span>
			</button>
			<div class="dropdown-content">
				<!--  Notification Start div -->
				<c:forEach items="${notifications}" var="notifications">
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<a href="#"> By ${notifications.firstName}&nbsp;${notifications.lastName} </a>
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<center>${notifications.date}<br>${notifications.time}</center>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12 pd-l0">
							<p>${notifications.activity}</p>
							
						</div>

					</div>
					<!--  Notification End div -->
					<hr>
				</c:forEach>
				<p class="time" >
			<a href="${pageContext.request.contextPath}/commonView/notifications" >Notifications All</a>
				</p>

			</div>
		</div>
	</div>