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
			<th>Product</th>
			<th>Price</th>
			<th>Name</th>
			<th>Quantity</th>
			<th>Remove Item</th>
		</tr>
		<c:forEach var="product" items="${product }">
			<tr>
				<td><img style="width: 30%" class="card-img"
					src="<c:url value='/resources/images/${wishlist.product.imageFileName}'/>"></td>
				<fmt:setLocale value="en_US" />
				<td><fmt:formatNumber value="${wishlist.product.price}"
						type="currency" /></td>
				<td><c:out value="${wishlist.product.name}" /></td>
				<td>
					<form action="wishlist" method="post">
						<input type="hidden" name="productID"
							value="<c:out value='${wishlist.product.productID}'/>"><input
							type="submit" name="action" value="Remove Item">
					</form>
				</td>
			</tr>
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