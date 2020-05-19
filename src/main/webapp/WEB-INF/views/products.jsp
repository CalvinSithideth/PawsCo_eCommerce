<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/product.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="resources/js/filter.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/Javascript/temp.js"></script> --%>


</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="filterBar.jsp"></jsp:include>
	<br>
	<div style="text-align: center; margin-left: 10%">
		<div class="row row-cols-1 row-cols-md-3"
			style="width: 80%; text-align: left">
			<c:set var="results" value="0"/>
			<c:forEach var="product" items="${products}">
				<fmt:parseNumber var="min" value="${param.min}"/>
				<fmt:parseNumber var="max" value="${param.max}"/>
				<c:if test="${param.filter == null && param.min == null && param.max == null && param.search == null || param.search != null && fn:containsIgnoreCase(product.value.name, param.search) || product.value.category == param.filter || product.value.price >= min && product.value.price <= max}">
					<c:set var="results" value="${results + 1}"/>
					<div class="col mb-4 ${product.category}">
						<div class="card h-100 item-card">
							<!--Card image-->
							<div class="view overlay">
								<img class="card-img" src="resources/images/${product.imageFileName}"
									alt="Card image cap"
									style="max-width: 300px; max-height: 250px; width: auto; height: auto; display: block; margin-left: auto; margin-right: auto; margin-top: 10px">
							</div>
							<!--Card content-->
							<div class="card-body">
								<div class="collapse-content">
									<!--Title-->
									<h4 class="card-title">
										<c:out value="${product.name}" />
									</h4>
									<h4 class="price">
										<c:out value="$${product.price}" />
									</h4>
									<form action="cart" method="post">
										<input type="hidden" name="productID" value="${product.productID}">
										<input type="hidden" name="action" value="add">
										<label for="qty">Qty</label> <input type="number"
											id="quantity" name="quantity" min="1" max="10" value="1">
										<input type="submit"
											class="cartBtn btn btn-outline-primary waves-effect"
											value="Add To Cart"><input type="submit"
											id="wishlist"
											class="wishlistBtn btn btn-outline-primary waves-effect"
											value="+Wish List">
									</form>
									<!--Text-->
									<p class="card-text collapse"
										id="collapseContent${product.productID}">
										<c:out value="${product.description}" />
									</p>
									<a
										class="btn btn-primary red-text p-1 my-1 mr-0 mml-1 collapsed read-more"
										data-toggle="collapse" href="#collapseContent${product.productID}"
										aria-expanded="false"
										aria-controls="collapseContent${product.productID}">Read More</a>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<c:if test="${results == 0}">
		<div style="text-align: center">
			<div style="width: 80%; display: inline-block; padding: 50px">
				<h4>0 results found for '<c:out value="${param.search}"/>'</h4>
			</div>
		</div>
	</c:if>
	<script src="resources/js/home.js"></script>
	<script src="resources/js/product.js"></script>


<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>