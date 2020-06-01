<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mma" uri="/WEB-INF/pawsco.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link href="resources/css/login.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<div style="text-align: center">
		<div style="width: 80%; display: inline-block">
			<div class="login-box">
				<h5>Create a new Pawsco.com account</h5>
				<form action="register" method="post">
				<input type="hidden" name="action" value="registerUser">
					<label for="email">Email Address: </label>
					<input type="email" name="email" placeholder="Email" required>
					<label for="password">Password: </label>
					<input type="password" name="password" placeholder="Password" required>
					<label for="firstName">First Name: </label>
					<input type="text" name="firstName" placeholder="First Name" required>
					<label for="lastName">Last Name: </label>
					<input type="text" name="lastName" placeholder="Last Name" required>
					<label for="street">Street: </label>
					<input type="text" name="street" id="street" placeholder="Street" required>
					<label for="city">City: </label>
					<input type="text" name="city" id="city" placeholder="City" required>
					<label for="state">State: </label>
					<input type="text" name="state" id="state" placeholder="State" required>
					<label for="zip">Zip Code: </label>
					<input type="text" name="zip" id="zip" placeholder="Zip Code" required>
					<input type="submit" value="Register">
				</form>
				<hr>
				<p><a href="view_cookies?action=viewCookies">View all cookies</a></p>
			</div>
		</div>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="resources/js/home.js"></script>
</body>
</html>