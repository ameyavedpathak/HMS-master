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
<link href="styles/FrontDeskHomePage.css" rel="stylesheet">
<title>FrontDesk : HomePage</title>
</head>

<body>


	<h2 class="text-info">HMS System : Front Desk</h2>
	<h6 class="text-info">Logged in as - ${E.firstname}
		${E.middlename} ${E.lastname}</h6>

	<!-- Nav bar -->
	<nav class="navbar navbar-expand-sm bg-info">

	<ul class="navbar-nav ">
		<li class="nav-item bg-secondary"><a class="nav-link text-white"
			href="#">Home</a></li>
		<li class="nav-item"><a class="nav-link text-white"
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


	<h5 class="text-primary">DashBoard</h5>



	<div class="jumbotron">
		<h6>List of Checked-in Patients :</h6>
		<table class=" table table-bordered table-sm">
			<thead>
				<th>Patient Name</th>
				<th>Check-in Time</th>
			</thead>
			<tbody>
				<c:forEach var="r" items="${prl}" varStatus="status">

					<tr>
						<td>${patlist[status.index].firstname} ${patlist[status.index].middlename} ${patlist[status.index].lastname}</td>
						<td>${r.visitdatetime}</td>
					</tr>

				</c:forEach>
			</tbody>


		</table>
	</div>

</body>
</html>
