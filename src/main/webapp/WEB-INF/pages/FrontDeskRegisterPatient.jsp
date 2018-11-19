<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link href="styles/FrontDeskHomePage.css" rel="stylesheet">
<title>FrontDesk : Register New Patient</title>
</head>

<body>

	<h2 class="text-info">HMS System : Front Desk</h2>
	<h6 class="text-info">Logged in as - ${E.firstname}
		${E.middlename} ${E.lastname}</h6>

	<!-- Nav bar -->
	<nav class="navbar navbar-expand-sm bg-info">

	<ul class="navbar-nav ">
		<li class="nav-item"><a class="nav-link text-white" href="home">Home</a>
		</li>
		<li class="nav-item bg-secondary"><a class="nav-link text-white"
			href="register">Registration</a></li>
		<li class="nav-item"><a class="nav-link text-white"
			href="check-in">Check-in</a></li>
		<li class="nav-item"><a class="nav-link text-white"
			href="checkout">Checkout</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="logout">Logout</a>
		</li>

	</ul>

	</nav>
	<br>

	<center>
		<h4 class=" text-primary">Register New Patient</h4>


		<div class="jumbotron">

			<form:form action="savePatient" method="post"
				modelAttribute="patient">

				<table class="text-primary">
					<form:hidden path="id" />
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstname" /></td>
					</tr>
					<tr>
						<td>Middle Name:</td>
						<td><form:input path="middlename" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastname" /></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><form:input path="address" /></td>
					</tr>
					<tr>
						<td>Telephone:</td>
						<td><form:input path="telephone" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:input path="password" /></td>
					</tr>
					<tr>
						<td colspan="5" align="center"><input type="submit"
							value="Save"></td>

					</tr>
				</table>

			</form:form>

		</div>

	</center>

	<center>
		<h6 class="text-info">${msg}</h6>
	</center>

</body>
</html>