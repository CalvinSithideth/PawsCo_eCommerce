<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/order.css">
</head>
<%@ include file="header.jsp"%>
<body>
	<div style="width: 90%; text-align: center">
		<h3>Your Orders</h3>
		<span style="color: red"></span>
	</div>
	<table>
		<tr>
			<th>Order ID</th>
			<th>Customer</th>
			<th>Date</th>
			<th>Product ID</th>
			<th>Quantity</th>
			<th>Fulfill</th>
		</tr>
		<c:forEach var="order" items="${orderlist}">
			<c:if test="${order.fulfilledStatus == false}">
				<tr>
					<td>${order.orderID}</td>
					<td>${order.customer}</td>
					<td>${order.date}</td>
					<td>${order.productID}</td>
					<td>${order.quantity}</td>
					<td>
						<form action="Fulfill/${order.orderID}/${order.productID}/${order.quantity}" method="get">
							<input type="submit">
						</form>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<br>
	<footer id="footer">
		<p>Copyright © 2020 All rights reserved.</p>
	</footer>
</body>
</html>