<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Pawsco Wholesale</title>
<link href="Style/header.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/Style/myAccount.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/myAccount.js"></script>
<script src="${pageContext.request.contextPath}/scripts/wListToCart.js"></script>
<script src="${pageContext.request.contextPath}/Javascript/temp.js"></script>
<script src="${pageContext.request.contextPath}/Javascript/wishlist.js"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

</head>
<body>
	<%@ include file="/header.jsp"%>

	<div class="container padding-bottom-3x mb-2">
		<div class="row">
			<div class="col-lg-4">
			<h4>Profile Info</h4>
				<p id="profile">
				
					<label for="email">Email Address: ${user.email}</label><br>	
					<label for="email">Name: ${user.firstName} ${user.lastName}</label>	
				</p>
				<nav class="list-group">

					<a class="list-group-item with-badge" href="#"></a> <a
						class="list-group-item with-badge active" href="#"
						onclick="showHideWishList()"><i class="fa fa-heart"></i>Wishlist</a>

					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-info panel-shadow">
								<div class="panel-body">
									<div class="table-responsive" id="wishlistDiv"></div>
								</div>
							</div>
						</div>
					</div>
				</nav>
			</div>

		</div>
	</div>
	
	<%@ include file="/footer.jsp"%>
</body>
</html>