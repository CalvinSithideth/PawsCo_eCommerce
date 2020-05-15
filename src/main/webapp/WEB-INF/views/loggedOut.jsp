<%@ taglib prefix="mma" uri="/WEB-INF/pawsco.tld" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Refresh" content="5;url=home.jsp">
<title>Logging Out</title>
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
		<div style="width: 80%; display: inline-block; padding: 50px">
			<h4>You have been successfully logged out.</h4>
			<p>Returning to the home page...</p>
		</div>
	</div>

    <%@ include file="/footer.jsp"%>
</body>
</html>