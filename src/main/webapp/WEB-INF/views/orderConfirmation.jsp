<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirmation</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<div style="text-align: center">
		<br><h3>Order Confirmation</h3><br>
		<div style="width: 80%; display: inline-block; text-align: left">
			<span>Your order has been successfully placed!</span>
			<span>Order #: <c:out value="${orderID}"/></span>
			<br><br>
		</div>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="resources/js/home.js"></script>
</body>
</html>