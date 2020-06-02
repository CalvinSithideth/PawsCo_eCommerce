<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link rel="stylesheet" type="text/css" href="resources/css/admin.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<div style="text-align: center">
		<br><h3>Inventory</h3><br>
		<div style="display: inline-block">
			
			<table>
				<tr>
					<th class="prodName">Product Name</th>
					<th>Current Stock</th>
					<th>Reorder</th>
					<th>Add to Bulk Order</th>
				</tr>
				<c:forEach var="product" items="${products}">
						<tr>
							<td class="prodName">${product.name}</td>
							<c:choose>
								<c:when test="${product.stock <= 10}">
									<td style="color: red">${product.stock}</td>
								</c:when>
								<c:otherwise>
									<td>${product.stock}</td>
								</c:otherwise>
							</c:choose>
							<td>
								<form action="submitOrder">
									<input type="hidden" name="id" value="${product.productID}">
									<input type="number" name="quantity" step="1" min="0" value="0">
									<input type="submit">
								</form>
							</td>
							<td>
								<form action="adminCart" method="post" >
									<input type="hidden" name="id" value="${product.productID}">
									<input type="number" name="quantity" step="1" min="0" value="0">
									<input type="hidden" name="action" value="add">
									<input type="submit" value ="Add">
								</form>
							</td>
						</tr>
				</c:forEach>
			</table>
			<br>
		</div>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="resources/js/home.js"></script>
</body>
</html>