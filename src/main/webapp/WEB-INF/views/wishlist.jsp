<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wishlist</title>
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
<link href="resources/css/wishlist.css" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div style="width: 90%; text-align: center">
		<h3>Your Wishlist</h3>
		<span style="color: red"></span>
	</div>
	<table>
		<tr>
			<th>Product</th>
			<th>Price</th>
			<th>Name</th>
			<th>Remove Item</th>
		</tr>
		<c:forEach var="wishlist" items="${wishlist }">
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
			<td>
				<form action="products" method="get">
					<input type="hidden" name="action" value="shop"> <input
						type="submit" value="Continue Shopping">
				</form>
			</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<br>

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="resources/js/home.js"></script>
</body>
</html>