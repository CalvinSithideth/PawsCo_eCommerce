<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Photos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="Style/header.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="/header.jsp"%>		
	<div style="text-align: center">
		<br>
		<h3>Photos</h3>
		<br>
		<div style="width: 50%; display: inline-block; text-align: left">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="2"></li></ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" src="Image/storefront.jpg"
						alt="First slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="Image/interior.jpg"
						alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="Image/customers.jpg"
						alt="Third slide">
				</div>
			</div> <a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
		</a>
			</div> <br> <br>
			</div>
			</div> <%@ include file="/footer.jsp"%> <script
				src="../Javascript/home.js"></script>
</body>
</html>