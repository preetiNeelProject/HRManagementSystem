<%-- 
    Document   : Index
    Created on : 29 Mar, 2018, 10:50:32 AM
    Author     : Swapril Tyagi
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>NEEL</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Form */
.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 450px;
	margin: 0 auto 100px;
	margin-bottom: 0px;
	padding: 30px;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
	border-bottom-left-radius: 3px;
	border-bottom-right-radius: 3px;
	text-align: center;
}

.form .thumbnail {
	width: 250px;
	height: 250px;
	margin: 0 auto 30px;
	padding: 50px 30px;
	border-top-left-radius: 100%;
	border-top-right-radius: 100%;
	border-bottom-left-radius: 100%;
	border-bottom-right-radius: 100%;
	box-sizing: border-box;
}

.form .thumbnail img {
	display: block;
	width: 100%;
}

.form input {
	outline: 0;
	background: #DCDFD9;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
	border-bottom-left-radius: 3px;
	border-bottom-right-radius: 3px;
	box-sizing: border-box;
	font-size: 14px;
}

.form p {
	font-size: 15px;
    float: left;
    font-weight: 600;
    line-height: 7px;
}

.form button {
	outline: 0;
	background: GREEN;
	width: 100%;
	border: 0;
	padding: 15px;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
	border-bottom-left-radius: 3px;
	border-bottom-right-radius: 3px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: GREEN;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.sidebar h1{
margin-top: 73px;
}
.sidebar img{
width: 450px;
    margin-left: 99px;
    margin-top: 11px;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: GREEN;
}
/* END Form */
</style>
</head>
<body style="background-color: #e3c7c4;;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-6">
						<div class="loginBox">
							<div class="loginForm" style="padding: 35px;">
								<%-- <c:if test="${not empty msg}">

									<div id="myModal" class="modal"
										style="display: block; z-index: 9999;">
										<div class="modal-content">
											<div class="modal-header" style="background-color: #387403;">
												<span class="close"
													onclick="document.getElementById('myModal').style.display='none'"
													style="color: #FFFFFF;">&times;</span>
												<p style="text-align: center; color: #FFFFFF;" class="h2">${msg}${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
											</div>
										</div>
									</div>
								</c:if> --%>
								<br>
								
								<div class="form"
									style="box-shadow: 0 9px 15px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
									<h3 style="text-align: center; color: red;">${SPRING_SECURITY_LAST_EXCEPTION.message}</h3><br>
									<h4
										style="margin-top: 0px; padding-top: 0px; font-size: 26px; font-family: cambria math; text-align: center; padding-bottom: 20px;">
										<b>Sign In</b>
										
									</h4>

									<form action="login"
										class="login-form" method="post">
										<p>Email Address</p>
										<input type="text" name="logonId" id="logonId" placeholder="Enter UserId"
											 autocomplete="off" required />
										<p>Password</p>
										<input type="password" name="logonPassword" id="logonPassword"
											placeholder="Enter Password"  required /> <b
											style="float: left; width: 32%;"> <input
											style="width: 10%" type="checkbox" name="remember-me" id="remember-me"
											 />Remember
											Me
										</b><b style="float: right;margin-right: 3px;"> <a>Forget Password?</a><br><br><br><br></b><b> <input type="submit"
											style="background-color: #28a745; color: white; font-size: 14px; "
											value="Login"></b> 
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="sidebar">
						<h1
									style="text-align: center; font-family: cambria math; font-size: 38px;">Neel
									Data Pro It Pvt. Ltd.</h1>
								<br>
						
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<div
					style="margin-left: 38%; width: 390px; height: 40px; margin-top: 100px;">
					<a href="#"
						style="color: black; text-decoration: none; align: center;">©<strong>2020
							Neel Data Industrial Development Authority</strong></a> <br>
				</div>
			</div>
		</div>
	</div>


</body>
</html>