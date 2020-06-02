<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link href="resources/css/account.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div style="text-align: center">
		<br><h3>My Account</h3>
		<div class="account_div">
			<div class="account_info">
				<div class="inner_div">
					<h5>Account Information</h5>
					<hr>
					<table>
						<tr>
							<td class="table_label">Email Address:</td>
							<td><c:out value="${user.email}"/></td>
						</tr>
						<tr>
							<td class="table_label">First Name:</td>
							<td><c:out value="${user.firstName}"/></td>
						</tr>
						<tr>
							<td class="table_label">Last Name:</td>
							<td><c:out value="${user.lastName}"/></td>
						</tr>
					</table>
				</div>
				<div class="edit_div">
					<a href="orderHistory">Order History</a><br>
					<a href="wishlist">Wishlist</a><br>
					<c:if test="${user.isAdmin}">
						<a href="admin">Inventory</a>
					</c:if>
				</div>
			</div>
			<div class="vertical_line"></div>
			<div class="shipping_info">
				<div class="inner_div">
					<h5>Shipping Information</h5>
					<hr>
					<table>
						<tr>
							<td class="table_label">Street Address:</td>
							<td><c:out value="${address.street}"/></td>
						</tr>
						<tr>
							<td class="table_label">City:</td>
							<td><c:out value="${address.city}"/></td>
						</tr>
						<tr>
							<td class="table_label">State:</td>
							<td><c:out value="${address.state}"/></td>
						</tr>
						<tr>
							<td class="table_label">Zip Code:</td>
							<td><c:out value="${address.zip}"/></td>
						</tr>
					</table>
				</div>
				<div class="edit_div">
					<a href="addressForm">Edit</a>
				</div>
			</div>
		</div>
		<br><br>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<script src="resources/js/home.js"></script>
</body>
</html>