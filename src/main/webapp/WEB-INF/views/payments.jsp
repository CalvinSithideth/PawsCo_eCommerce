<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payments</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="/Style/payments.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="Style/header.css" rel="stylesheet" type="text/css">
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

	<div class="container">
		<h1>Payment Methods</h1>
		<h4 id="options">Payment Options</h4>
		<h5>PaswCo.com accepts these payments types:</h5>
		<ul>
			<li>PawsCo Credit Card</li>
			<li>Pawsco Gift Card</li>
			<li>My PawsCo Visa</li>
			<li>PawsCo for Business Card</li>
			<li>American Express</li>
			<li>Discover</li>
			<li>MasterCard</li>
			<li>Visa</li>
			<li>JCB</li>
			<li>Diners Club</li>
			<li>My PawsCo reward certificates</li>
			<li>Pay With Points</li>
			<li>PayPal</li>
		</ul>
		<h5>PawsCo stores accept these payment types:</h5>
		<ul>
			<li>PawsCo Credit Card</li>
			<li>Pawsco Gift Card</li>
			<li>My PawsCo Visa</li>
			<li>PawsCo for Business Card</li>
			<li>American Express</li>
			<li>Discover</li>
			<li>MasterCard</li>
			<li>Visa</li>
			<li>JCB</li>
			<li>Diners Club</li>
			<li>My PawsCo reward certificates</li>
			<li>PawsCo Commercial Card</li>
			<li>Vendor coupons</li>
			<li>Personal checks, business checks or cashier's checks</li>
			<li>Cash</li>
		</ul>
		<h5>Combining Payments Methods on PawsCo.com Orders</h5>
		<ul>
			<li>You can't use more than one credit card/debit card on a
				single PawsCo.com order.</li>
			<li>You can't combine PayPal and a credit card/debit card.</li>
		</ul>
		<h4 id="process">Authorization Process</h4>
		<p>An authorization hold will be placed on your credit or debit
			card when you place an order. Your account will not actually be
			billed until your order is shipped or picked up at the store.</p><br>
		<p>If there's a problem authorizing your credit or debit card,
			we'll email you right away. Keep an eye on your spam folder, in case
			our emails end up there. If you don't take action to fix the problem
			within 24 hours, we'll cancel the order.</p>
	</div>

	<%@ include file="/footer.jsp"%>
</body>
</html>