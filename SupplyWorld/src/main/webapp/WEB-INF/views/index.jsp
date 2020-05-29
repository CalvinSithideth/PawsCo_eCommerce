<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	<title>SupplyWorld</title>
</head>
<%@ include file="header.jsp" %>
<body>
	<div class="body-div-main">
		<div class="div-login">
			<div class="login-header">
				<h4>SupplyWorld Admin Login</h4>
			</div>
			<form action="login" method="post">
				<span>Username</span>
				<input class="login-txt" type="text" name="username">
				<span>Password</span>
				<input class="login-txt" type="password" name="password">
				<input class="login-btn" type="submit" value="Log In">
			</form>
		</div>
	</div>
</body>
</html>
