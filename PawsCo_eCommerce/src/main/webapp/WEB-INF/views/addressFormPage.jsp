<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<div style="text-align: center">
		<br><h3>Edit Address</h3><br>
		<div style="width: 80%; display: inline-block; text-align: left">
			<form action="editAddress" method="post">
				<table>
					<tr>
						<td><label for="street">Street: </label></td>
						<td><input type="text" name="street" id="street"></td>
					</tr>
					<tr>
						<td><label for="city">City: </label></td>
						<td><input type="text" name="city" id="city"></td>
					</tr>
					<tr>
						<td><label for="state">State: </label></td>
						<td><input type="text" name="state" id="state"></td>
					</tr>
					<tr>
						<td><label for="zip">Zip Code: </label></td>
						<td><input type="text" name="zip" id="zip"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Save"></td>
					</tr>
				</table>
			</form>
			<br><br>
		</div>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="resources/js/home.js"></script>
</body>
</html>