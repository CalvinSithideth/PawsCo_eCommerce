$(document).ready(function() {
	// search product and redirects to products page with the item you searched
	$("#searchButton").on("click", function() {
		localStorage.setItem("searchInput", $("#searchProductInput").val());
		$(window).attr('location', "/products.jsp");
		$(location).attr('href', "/products.jsp");		
	})
});
