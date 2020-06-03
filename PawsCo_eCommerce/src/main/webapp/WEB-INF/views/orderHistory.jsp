<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<style>
		td {padding: 5px}
		th {padding: 5px}
	</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div style="width: 100%; text-align: center">
		<div style="width: 80%; display: inline-block; text-align: center">
			<br>
			<h3>Order History</h3>
			<br>
			<div style="text-align: left; width: 600px; display: inline-block">

				<c:forEach items="${order}" var="order">
					<div style="display: block; width: 100%; box-shadow: 2px 2px 4px #BBBBBB">
						<div style="background-color: #3071A9; color: white; padding: 5px; border: 1px solid black">
							<span>Order #: ${order.orderID}</span>
							<br>
							<span>Order Date: <fmt:formatDate value="${order.date}"/></span>
						</div>
						<table style="width: 100%; border: 1px solid black; border-top: none">
							<tr style="background-color: #CCCCCC; border-bottom: 1px solid black">
								<th style="width: 400px">Product</th>
								<th>Quantity</th>
								<th>Price</th>
							</tr>
							<c:forEach items="${order.lineItems}" var="item">
								<tr style="border-top: 1px solid #CCCCCC">
									<td>${item.product.name}</td>
									<td>${item.quantity}</td>
									<td>$${item.product.price}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<br>
				</c:forEach>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>