<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Cart</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link href="resources/css/cart.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="resources/js/cart.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<c:choose>
		<c:when test="${cart == null || cart.size() == 0}">
			<br>
			<div style="width: 90%; text-align: center">
				<h3>Your cart is empty</h3>
			</div>
		</c:when>
		<c:otherwise>
			<div style="width: 90%; text-align: center">
				<h3>Shopping Cart</h3>
				<span style="color: red"><c:out
						value="${checkoutErrorMessage}" /></span>
			</div>
			<table>
				<tr>
					<th>Product</th>
					<th>Quantity</th>
					<th>Remove Item</th>
				</tr>
				<c:forEach var="item" items="${sessionScope.cart}">
					<tr>
						<td><img style="width: 30%" class="card-img"
							src="<c:url value='/resources/images/${item.product.imageFileName}'/>"></td>
						<td id="quantityTd">
							<form action="" method="post">
								<input type="hidden" name="productID"
									value="<c:out value='${item.product.productID}'/>"> <input
									type=text name="quantity"
									value="<c:out value='${item.quantity}'/>" id="quantity">
								<input type="hidden" name="action" value="edit"> <input
									type="submit" value="Update">
							</form>
						</td>
						<td>
							<form action="cart" method="post">
								<input type="hidden" name="productID"
									value="<c:out value='${item.product.productID}'/>"> <input
									type="hidden" name="action" value="remove"> <input
									type="submit" value="Remove Item">
							</form>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<form action="admin" method="get">
							<input type="hidden" name="action" value="shop"> <input
								type="submit" value="Continue Shopping">
						</form>
					</td>
					<td></td>
					<td>
						<form action="adminCheckout" method="get">
							<input type="submit" value="Checkout">
						</form>
					</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>

	<br>
	<br>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>