<%@ taglib prefix="mma" uri="/WEB-INF/pawsco.tld" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="Style/header.css" rel="stylesheet" type="text/css">
<link href="Style/login.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="/header.jsp"%>

	<div style="text-align: center">
		<div style="width: 80%; display: inline-block">
			<div class="login-box">
				<h5>Sign into your Pawsco.com account</h5>
				<p id="login-error-msg" style="color: red; text-align: center;">Invalid email or password!</p>
				<form action="login" method="post">
				<input type="hidden" name="action" value="loginUser">
					<label for="email">Email Address</label>
					<input type="text" name="email" id="email" required>
					<label for="password">Password</label>
					<input type="password" name="password" id="password" required>
					<input type="submit" value="login">
					<div style="display: inline">
						<input type="checkbox" value="yes" name="remember" id="remember">
						<label for="remember">Remember Me</label>
					</div>
				</form>
				<hr>
				<a class="register-link" href="register.jsp">
					New to Pawsco.com? Register here!
				</a>
			</div>
		</div>
	</div>
	
    <%@ include file="/footer.jsp"%>
    <script src="../Javascript/home.js"></script>
</body>
</html>