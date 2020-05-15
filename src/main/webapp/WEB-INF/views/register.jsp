<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mma" uri="/WEB-INF/pawsco.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="Style/header.css" rel="stylesheet" type="text/css">
<link href="Style/login.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<div style="text-align: center">
		<div style="width: 80%; display: inline-block">
			<div class="login-box">
				<h5>Sign into your Pawsco.com account</h5>
				<form action="register" method="post">
				<input type="hidden" name="action" value="registerUser">
					<label for="email">Email Address</label>
					<input type="email" name="email" value="${user.email }" required>
					<label for="password">Password</label>
					<input type="password" name="password" value="${user.password }" required>
					<label for="firstName">First Name</label>
					<input type="text" name="firstName" value="${user.firstName }" required>
					<label for="lastName">Last Name</label>
					<input type="text" name="lastName" value="${user.lastName }" required>
					<input type="submit" value="Register">
				</form>
				<hr>
				<p><a href="view_cookies.jsp?action=viewCookies">View all cookies</a></p>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	
	<script src="../Javascript/home.js"></script>
</body>
</html>