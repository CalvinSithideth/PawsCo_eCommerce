<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="Style/header.css" rel="stylesheet" type="text/css">
<link href="Style/cart.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="../Javascript/cart.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<%@ include file="/header.jsp"%>
	<h3>Shopping Cart</h3>

	<table>
		<tr>
			<th>Product</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Amount</th>
			<th>Remove Item</th>
		</tr>
		<c:forEach var="item" items="${sessionScope.cart}">
			<tr>
				<td><img style="width: 30%" class="card-img"
					src="<c:out value='Image/${item.product.imgFile}'/>"></td>
				<fmt:setLocale value="en_US" />
				<td><fmt:formatNumber value="${item.product.price}"
						type="currency" /></td>
				<td id="quantityTd">
					<form action="" method="post">
						<input type="hidden" name="productid"
							value="<c:out value='${item.product.id}'/>"> <input
							type=text name="quantity" value="<c:out value='${item.qty}'/>"
							id="quantity"> <input type="submit" value="Update">
					</form>
				</td>
				<fmt:setLocale value="en_US" />
				<td><fmt:formatNumber value="${item.product.price * item.qty}"
						type="currency" /></td>
				<td>
					<form action="" method="post">
						<input type="hidden" name="productid"
							value="<c:out value='${item.product.id}'/>"> <input
							type="hidden" name="quantity" value="0"> <input
							type="submit" value="Remove Item">
					</form>
				</td>
			</tr>
		</c:forEach>
		<td>
			<form action="" method="post">
				<input type="hidden" name="action" value="shop"> <input
					type="submit" value="Continue Shopping">
			</form>
		</td>
		<td></td>
		<td></td>
		<td></td>
		<td>
		<form action="" method="post">
			<input type="hidden" name="action" value="checkout"> <input
				type="submit" value="Checkout">
		</form>
		</td>
	</table>
	<br><br>


	<%@ include file="/footer.jsp"%>

	<script src="../Javascript/home.js"></script>
</body>
</html>
