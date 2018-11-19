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
<link href="${pageContext.request.contextPath}/resources/styles/FrontDeskHomePage.css" rel="stylesheet">
<title>Admin : Manage Patient</title>
</head>
<body>


	<h2 class="text-info">HMS System : Admin Manage Patient</h2>
	<h6 class="text-info">Logged in as - ${E.firstname}
		${E.middlename} ${E.lastname}</h6>

	<!-- Nav bar -->
	<nav class="navbar navbar-expand-sm bg-info">

	<ul class="navbar-nav ">
		<li class="nav-item "><a class="nav-link text-white"
			href="admin">Home</a></li>
		<li class="nav-item"><a class="nav-link text-white"
			href="manageemployee">Manage Employee</a></li>
		<li class="nav-item  bg-secondary"><a class="nav-link text-white"
			href="#">Manage Patient</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="logout">Logout</a>
		</li>

	</ul>

	</nav>
	<br>
    <div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstname" /></td>
            </tr>
            <tr>
                <td>Middle Name:</td>
                <td><form:input path="middlename" /></td>
            </tr>
            <tr>
                <td>LastName:</td>
                <td><form:input path="lastname" /></td>
            </tr>
            <tr>
                <td>Profile:</td>
                <td>
                <form:select path="profile">
                <form:option value = "Admin"/>
                <form:option value = "Doctor"/>
                <form:option value = "Nurse"/>
                <form:option value = "Other"/>
                </form:select>
                </form>
                </td>
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
                <td>Password</td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>