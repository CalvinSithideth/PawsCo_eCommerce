<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div style="text-align: center; background-color: #DDDDDD; padding: 5px;">
	<div style="display: inline">
		<form action="products.jsp" style="display: inline">
		<button type="submit" class="btn btn-primary" id="resetPage"
			style="padding: 10px">Show All</button></form>
		<div id="price" class=".nav-item dropdown" style="width: 5%">
			<a class="nav-link dropdown-toggle btn btn-success" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Price </a>

			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				<a class="dropdown-item" href="products.jsp?min=0&max=5">Less than $5</a>
				<a class="dropdown-item" href="products.jsp?min=10&max=20">$10-$20</a> <a
					class="dropdown-item" href="products.jsp?min=20&max=50">$20-$50</a> <a
					class="dropdown-item" href="products.jsp?min=50&max=100">$50-$100</a>
			</div>
		</div>
		<div id="filter" class=".nav-item dropdown">
			<a class="nav-link dropdown-toggle btn btn-danger" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Filter </a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				<a class="dropdown-item" href="products.jsp">Show All</a>
				<a class="dropdown-item" href="products.jsp?filter=Food">Food</a>
				<a class="dropdown-item" href="products.jsp?filter=Toys">Toys</a>
				<a class="dropdown-item" href="products.jsp?filter=Furniture">Beds &amp; Furniture</a>
				<a class="dropdown-item" href="products.jsp?filter=Grooming">Grooming</a>
				<a class="dropdown-item" href="products.jsp?filter=Apparel">Apparel</a>
			</div>
		</div>
	</div>
</div>
<div style="width: 100%; height: 10px; background-color: #3071A9; border-top: 1px solid black; border-bottom: 1px solid black"></div>