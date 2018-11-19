<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/styles/FrontDeskHomePage.css"
	rel="stylesheet">
<title>Diagnosis Portal : HomePage</title>
</head>

<script>

$(document).ready(function(){
	
	$("#nextbutton").attr("disabled","disabled");
	var loginprofile = '${E.profile}';
	//alert(loginprofile);	
	if(loginprofile == 'Doctor')
	{
		$("#nextbutton").removeAttr("disabled");
	}
	
});

</script>

<body>


	<h2 class="text-info">HMS System : Diagnosis Portal</h2>
	<h6 class="text-info">Logged in as - ${E.firstname}
		${E.middlename} ${E.lastname}</h6>

	<!-- Nav bar -->
	<nav class="navbar navbar-expand-sm bg-info">

	<ul class="navbar-nav ">
		<li class="nav-item"><a class="nav-link text-white" href="home">Home</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="logout">Logout</a>
		</li>
	</ul>
	</nav>
	<br>

	<div id="patientinfo" class="jumbotron">
		<h5>Patient Information</h5>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td style="width: 20%;">Patient Name:</td>
					<td>${p.firstname}${p.middlename}${p.lastname}</td>
				</tr>
				<tr>
					<td>Reason For Visit:</td>
					<td>${pr.reasonforvisit}</td>
				</tr>

			</tbody>
		</table>
	</div>

	<div id="vitals" class="jumbotron">
		<h5>Patient Vitals</h5>

		<form:form action="savevitals" method="post" modelAttribute="record">
			<table>
				<form:hidden path="visitid" />
				<tr>
					<td>Height:</td>
					<td><form:input path="height" /></td>
				</tr>
				<tr>
					<td>Weight:</td>
					<td><form:input path="weight" /></td>
				</tr>
				<tr>
					<td>Temperature:</td>
					<td><form:input path="temperature" /></td>
				</tr>

				<tr>
					<td>Blood Pressure:</td>
					<td><form:input path="bloodpressure" /></td>
				</tr>
				<tr>
					<td>Smoking status:</td>
					<td><form:input path="smokingstatus" /></td>
				</tr>
				<tr>
					<td>Allergies</td>
					<td><form:input path="allergies" /></td>
				</tr>
				<tr>
					<td>Symptoms</td>
					<td><form:input path="symptoms" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
		<center>
			<button id="nextbutton">Next [Diagnosis] -></button>
		</center>
	</div>


	<h6>${msg}</h6>





</body>
</html>