<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="Style/faq.css" rel="stylesheet" type="text/css" />
<link href="Style/header.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="/header.jsp"%>
	
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Frequently Asked Questions</h1>
			<p class="lead">Your wish is my command.</p>
		</div>
	</div>

	<div class="accordion" id="accordionExample">
		<div class="card">
			<div class="card-header" id="headingOne">
				<h2 class="mb-0">
					<button class="btn btn-link" type="button" data-toggle="collapse"
						data-target="#collapseOne" aria-expanded="true"
						aria-controls="collapseOne">Can I order pets in bulk?</button>
				</h2>
			</div>

			<div id="collapseOne" class="collapse"
				aria-labelledby="headingOne" data-parent="#accordionExample">
				<div class="card-body">We are not a puppy mill. We obey the
					law.</div>
			</div>
		</div>
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h2 class="mb-0">
					<button class="btn btn-link collapsed" type="button"
						data-toggle="collapse" data-target="#collapseTwo"
						aria-expanded="false" aria-controls="collapseTwo">What is
						PawsCo return policy?</button>
				</h2>
			</div>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordionExample">
				<div class="card-body">Risk-Free 100% Satisfaction Guarantee
					On Membership: We guarantee your satisfaction on every product we
					sell, and will refund your purchase price.</div>
			</div>
		</div>
		<div class="card">
			<div class="card-header" id="headingThree">
				<h2 class="mb-0">
					<button class="btn btn-link collapsed" type="button"
						data-toggle="collapse" data-target="#collapseThree"
						aria-expanded="false" aria-controls="collapseThree">Is
						PawsCo the same as Petsmart &amp; Petco?</button>
				</h2>
			</div>
			<div id="collapseThree" class="collapse"
				aria-labelledby="headingThree" data-parent="#accordionExample">
				<div class="card-body">Yes, we are very similar but we are
					number 1. Our customers always return.</div>
			</div>
		</div>
		<div class="card">
			<div class="card-header" id="headingOne">
				<h2 class="mb-0">
					<button class="btn btn-link" type="button" data-toggle="collapse"
						data-target="#collapseFour" aria-expanded="true"
						aria-controls="collapseFour">Does PawsCo price match with
						other retailers?</button>
				</h2>
			</div>

			<div id="collapseFour" class="collapse"
				aria-labelledby="headingOne" data-parent="#accordionExample">
				<div class="card-body">Please rest assured that your
					satisfaction is our top priority-that's why we're always working to
					bring you brand-name items at the lowest possible prices. However,
					because we already offer competitive prices at the point of
					purchase, we do not price match with other retailers.</div>
			</div>
		</div>
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h2 class="mb-0">
					<button class="btn btn-link collapsed" type="button"
						data-toggle="collapse" data-target="#collapseFive"
						aria-expanded="false" aria-controls="collapseFive">Is the
						inventory on PawsCo.com live?</button>
				</h2>
			</div>
			<div id="collapseFive" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordionExample">
				<div class="card-body">The inventory on our website is
					real-time and updated frequently. If the item you’re looking for is
					not found on Costco.com, it's either not available online or
					currently out of stock. When the item is available for purchase
					again, it will re-appear on the site. The site is completely up to
					date, so we encourage you to check the site frequently for changes
					and updates.</div>
			</div>
		</div>

		<%@ include file="/footer.jsp"%>
		<script src="../Javascript/home.js"></script>
</body>
</html>