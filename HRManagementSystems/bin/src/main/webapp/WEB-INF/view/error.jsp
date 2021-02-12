<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<body>
<center>
<h1 style="color:red">Something went wrong! </h1>
<h2>Our Engineers are on it</h2>
<div><img width="50%" src="${pageContext.request.contextPath}/staticResources/images/error2.jpg"></div>
 <h1>${errorMsg}</h1>
 <a href="${pageContext.request.contextPath}/login">Go Home</a>
 </center>
</body>
</html>