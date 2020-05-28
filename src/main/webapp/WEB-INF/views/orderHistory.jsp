<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/product.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link href="resources/css/cart.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="resources/js/filter.js"></script>
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
<h4 id="orderHeader">${user.firstName }'s Orders</h4>
							<table style="width: 30%; display: block; margin-left: auto; margin-right: auto; margin-top: 10px">
								
									<c:forEach var="order" items="${order }">
											<tr align="center">
											<c:forEach var="lineItem" items="${order.lineItems }">
											
											<th style="padding: 2.5px; width: 10%;" rowspan="1">
												<img
													src="resources/images/${lineItem.product.imageFileName}"
													style="max-width: 150px; max-height: 250px; width: auto; height: auto; display: block; margin-left: auto; margin-right: auto; margin-top: 10px" />
												<c:out value="Product ID: ${lineItem.product.productID}" />
												<br>
												<c:out value="Name: ${lineItem.product.name}" />
												<br>
												<c:out value="Price: $${lineItem.product.price}" />
												<br>
												<c:out value="Quantiy: ${lineItem.quantity}" />
												<br>
												<c:out value="Order Price: ${lineItem.product.price * lineItem.quantity}" />
												<br>
												<c:out value="Date Ordered: ${order.date}" />
												<br>
												</th>
											</c:forEach>
												</tr>
										</c:forEach>
							</table>
						
	<!-- 	<div style="text-align: center"> -->
<!-- 	<h4>Orders</h4> -->
<!-- 	<div id ="orderTable" style="text-align: center width: 80%; display: inline-block; text-align: left"> -->
<!-- 	<table> -->
<!-- 		<tr> -->
<%-- 			<td><c:forEach var="order" items="${order }"> --%>
<%-- 					<c:forEach var="lineItem" items="${order.lineItems }"> --%>
<%-- 						<img src="resources/images/${lineItem.product.imageFileName}"  --%>
<!-- 						style="max-width: 300px; max-height: 250px; width: auto; height: auto; -->
<!-- 						 display: block; margin-left: auto; margin-right: auto; margin-top: 10px"/> -->
<%-- 						 <c:out value="Name: ${lineItem.product.name}" /><br> --%>
<%-- 						<c:out value="Price: $${lineItem.product.price}" /><br> --%>
<%-- 						<c:out value="Quantiy: ${lineItem.quantity}" /> --%>
<%-- 					</c:forEach> --%>
<%-- 				</c:forEach> --%>
<!-- 		</tr> -->

<!-- 	</table> -->
<!-- 	</div> -->
<!-- 	</div> -->

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>