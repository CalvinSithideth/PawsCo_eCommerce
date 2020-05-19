<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testimonials</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link href="resources/css/testimonials.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<!-- <script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> -->
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="css/mdb.min.css" rel="stylesheet">

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<h3 style="text-align: center">"What our customers are saying"</h3>

	<div class="row row-cols-1 row-cols-md-3">

		<div class="col mb-4">
			<div class="card h-100">
				<div class="card testimonial-card h-100">

					<!-- Background color -->
					<div class="card-up indigo lighten-1"></div>

					<!-- Avatar -->
					<div class="avatar mx-auto white">
						<img src="<c:url value ="/resources/images/testppl1.jpg"/>"
							class="rounded-circle">
					</div>

					<!-- Content -->
					<div class="card-body">
						<!-- Name -->
						<h4 class="card-title">Anna Perry</h4>
						<hr>
						<!-- Quotation -->
						<p>
							<i class="fas fa-quote-left"></i> I took my dog in for her
							birthday and there were so many treat options and food options I
							didn't even know existed. They have all of the best brands and
							are well stocked. The staff are so helpful as well. I love this
							place!
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card h-100">
				<div class="card testimonial-card h-100">

					<!-- Background color -->
					<div class="card-up indigo lighten-1"></div>

					<!-- Avatar -->
					<div class="avatar mx-auto white">
						<img src="<c:url value ="/resources/images/testppl2.jpg"/>"
							class="rounded-circle">
					</div>

					<!-- Content -->
					<div class="card-body">
						<!-- Name -->
						<h4 class="card-title">Mr. and Mrs. Smith</h4>
						<hr>
						<!-- Quotation -->
						<p>
							<i class="fas fa-quote-left"></i> Super fun shop with so many
							choices! Staff is professional and extremely kind. Will be back
							for sure!!!
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card h-100">
				<div class="card testimonial-card h-100">

					<!-- Background color -->
					<div class="card-up indigo lighten-1"></div>

					<!-- Avatar -->
					<div class="avatar mx-auto white">
						<img src="<c:url value ="/resources/images/testppl3.jpg"/>"
							class="rounded-circle">
					</div>

					<!-- Content -->
					<div class="card-body">
						<!-- Name -->
						<h4 class="card-title">Shawn Bloom</h4>
						<hr>
						<!-- Quotation -->
						<p>
							<i class="fas fa-quote-left"></i> I heard, from other dog owners,
							how wonderful this store is. I agree, the staff is very friendly
							and helpful. Buddy has a new pet store... :-
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="col mb-4">
			<div class="card h-100">
				<div class="card testimonial-card h-100">

					<!-- Background color -->
					<div class="card-up indigo lighten-1"></div>

					<!-- Avatar -->
					<div class="avatar mx-auto white">
						<img src="<c:url value ="/resources/images/testppl4.jpg"/>"
							class="rounded-circle">
					</div>

					<!-- Content -->
					<div class="card-body">
						<!-- Name -->
						<h4 class="card-title">Michael Brown</h4>
						<hr>
						<!-- Quotation -->
						<p>
							<i class="fas fa-quote-left"></i> Wonderful customer service.
							Great prices. Couldn't get Mack out of there
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card h-100">
				<div class="card testimonial-card h-100">

					<!-- Background color -->
					<div class="card-up indigo lighten-1"></div>

					<!-- Avatar -->
					<div class="avatar mx-auto white">
						<img src="<c:url value ="/resources/images/testppl5.jpg"/>"
							class="rounded-circle">
					</div>

					<!-- Content -->
					<div class="card-body">
						<!-- Name -->
						<h4 class="card-title">Chris Evans</h4>
						<hr>
						<!-- Quotation -->
						<p>
							<i class="fas fa-quote-left"></i> Service was amazing and
							helpful! Friendly workers who really took the time with a
							customers needs, wants & questions! Going to revisit again (:
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card h-100">
				<div class="card testimonial-card h-100">

					<!-- Background color -->
					<div class="card-up #82b1ff blue accent-1"></div>

					<!-- Avatar -->
					<div class="avatar mx-auto white">
						<img src="<c:url value ="/resources/images/testppl6.jpg"/>"
							class="rounded-circle">
					</div>

					<!-- Content -->
					<div class="card-body">
						<!-- Name -->
						<h4 class="card-title">Keanu Reeves</h4>
						<hr>
						<!-- Quotation -->
						<p>
							<i class="fas fa-quote-left"></i> Visited the store for the first
							time today and it's absolutely amazing!! I don't even own a dog
							but it was fun to look at all the different products and buy a
							few things for our cat! I even witnessed you helping a customer
							out to her car with her purchases!!
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="resources/js/home.js"></script>
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>