<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/product.css" rel="stylesheet" type="text/css" />
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link href="resources/css/cart.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/filter.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<table>


		<c:forEach var="order" items="${order }">
			<tr align="center">
				<c:forEach var="lineItem" items="${order.lineItems }">
					<th style="padding: 2.5px; width: 10%;" rowspan="1"><img
						src="resources/images/${lineItem.product.imageFileName}"
						style="max-width: 300px; max-height: 250px; width: auto; height: auto; display: block; margin-left: auto; margin-right: auto; margin-top: 10px" />
						<c:out value="Name: ${lineItem.product.name}" /> <br> <c:out
							value="Price: $${lineItem.product.price}" /> <br> <c:out
							value="Quantiy: ${lineItem.quantity}" /></th>
				</c:forEach>
			</tr>
		</c:forEach>



	</table>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>