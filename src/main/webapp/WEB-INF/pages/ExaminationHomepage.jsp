<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<body>


	<h2 class="text-info">HMS System : Diagnosis Portal</h2>
	<h6 class="text-info">Logged in as - ${E.firstname}
		${E.middlename} ${E.lastname}</h6>

	<!-- Nav bar -->
	<nav class="navbar navbar-expand-sm bg-info">

	<ul class="navbar-nav ">
		<li class="nav-item bg-secondary"><a class="nav-link text-white"
			href="#">Home</a></li>
		<li class="nav-item"><a class="nav-link text-white" href="logout">Logout</a>
		</li>

	</ul>

	</nav>
	<br>

	<center>
		<h6>Checked-in Patient</h6>
	</center>
	<br>
	<div class="jumbotron">

		<table class="table table-bordered">
			<thead>
				<th>Patient Name</th>
				<th>Checkin Status</th>
				<th>Prescription</th>
				<th>Imaging</th>
				<th>Testing</th>
				<th>Taken Care By Nurse</th>
				<th>Taken Care By Doctor</th>
<!-- 				<th>Operation</th> -->
			</thead>
			<tbody>
				<c:forEach var="r" items="${checkinlist}" varStatus="status">
					<tr>
						<td><a href="vitals?id=${r.visitid}">${patlist[status.index].firstname}
								${patlist[status.index].middlename}
								${patlist[status.index].lastname}</a></td>
						<td>${r.checkinstate}</td>
						<td></td>
						<td></td>
						<td></td>
						<td>${nurse[status.index].firstname} ${nurse[status.index].middlename} ${nurse[status.index].lastname} </td>
						<td>${doctor[status.index].firstname}
							${doctor[status.index].middlename}
							${doctor[status.index].lastname}</td>
<%-- 							<td><a href="editvitals?id=${r.visitid}">View/Edit Vitals</a></td> --%>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>





</body>
</html>