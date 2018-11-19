<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
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
<title>HMS System</title>
</head>
<body>
	<br>
	<br>
	<center>
		<h1 class="text-info">HMS System</h1>
	</center>
	<br>
	<br>
	<div align="center">
		<center>
			<h4 class="text-info">Enter details below to Login</h4>
			<br>
			<div class="jumbotron">
				<form:form action="home" method="post" modelAttribute="employee">
					<table class="text-primary">

						<tr>
							<td>Employee ID:</td>
							<td><form:input path="id" ></form:input></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><form:input type="password" path="password" ></form:input></td>
						</tr>

						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="5" align="center"><input
								class="btn btn-primary" type="submit" value="Login"></td>
						</tr>
					</table>
				</form:form>
			</div>
	</div>
	</center>
	<center>${msg}</center>

</body>
</html>