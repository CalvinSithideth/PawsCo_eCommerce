<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Welcome to Pawsco Wholesale</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="Style/header.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<%@ include file="/header.jsp"%>

	<div id="carouselExampleCaptions"
		class="carousel slide mx-auto d-block" data-ride="carousel"
		style="width: 60%;">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleCaptions" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
			<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<a href="${pageContext.request.contextPath}/products.jsp"> <img
					src="${pageContext.request.contextPath}/Image/dogfood.jpg"
					class="d-block w-100" style alt="..." style="width:auto;">
				</a>
				<div class="carousel-caption d-none d-md-block">
					<h2>NULO FOR DOGS</h2>
					<p>Every dog has their dish.</p>
				</div>
			</div>
			<div class="carousel-item">
				<a href="${pageContext.request.contextPath}/products.jsp"> <img
					src="${pageContext.request.contextPath}/Image/dogtoy.jpg"
					class="d-block w-100" alt="..." style="width: auto; height: 570px">
				</a>
				<div class="carousel-caption d-none d-md-block">
					<h2>KONG</h2>
					<p>Because dogs need to play...</p>
				</div>
			</div>
			<div class="carousel-item">
				<a href="${pageContext.request.contextPath}/products.jsp"> <img
					src="${pageContext.request.contextPath}/Image/dogshampoo.jpg"
					class="d-block w-100" alt="..." style="width: auto; height: 570px">
				</a>
				<div class="carousel-caption d-none d-md-block">
					<h2>Burt's Bee Shampoo</h2>
					<p>So fresh so clean!</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleCaptions"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<%@ include file="/footer.jsp"%>

	<script src="${pageContext.request.contextPath}/Javascript/home.js"></script>
</body>
</html>