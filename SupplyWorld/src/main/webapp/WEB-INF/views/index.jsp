<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<title>SupplyWorld</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<div class="body-div-main">
		<div class="div-login">
			<div class="login-header">
				<h3>SupplyWorld Admin Login</h3>
			</div>
			<form action="login" method="post">

				<span>Username</span>
				<input class="login-txt" type="text" name="username">
				<span>Password</span>
				<input class="login-txt" type="password" name="password">
				<button class="login-btn" type="submit">
					<i class="fas fa-sign-in-alt"></i>&nbsp;&nbsp;Log In
				</button>
			</form>
		</div>
	</div>
	<footer id="footer">
		<p>Copyright � 2020 All rights reserved.</p>
	</footer>
</body>
</html>
