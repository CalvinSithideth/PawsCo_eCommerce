<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wishlist</title>
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
<script src="../Javascript/wishlist.js"></script>

</head>
<body>
	<%@ include file="/header.jsp"%>

	<div class="container bootstrap snippet" style="padding-bottom: 40px">
		<div class="col-md-9 col-sm-8 content">

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-info panel-shadow">
						<div class="panel-body">
							<div class="table-responsive" id="wishlistDiv"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 	<button id="test">TEST</button> -->


	<%@ include file="/footer.jsp"%>
	
	<script src="../Javascript/home.js"></script>
</body>
</html>