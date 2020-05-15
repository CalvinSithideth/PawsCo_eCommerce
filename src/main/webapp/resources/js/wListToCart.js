$(document).ready(function() {
	$("input:submit").click(function(e) {
		e.preventDefault();
		
		var prodDiv = $(this).parent().parent().parent();
		var name = prodDiv.find(".card-title").html();
		var price = prodDiv.find(".price").html().replace('$', '');
		var qty = parseInt(prodDiv.find("#quantity").val());
		var img = prodDiv.closest(".view").find("img").attr("src");
		  alert(img);
		var cart = JSON.parse(sessionStorage.getItem("cart"));
		var exists = false;
		
        if (cart == null) {
            cart = [];
        } else {
        	cart.forEach(product => {
        		if (product.name == name) {
        			exists = true;
        			product.qty += qty;
        			sessionStorage.setItem("cart", JSON.stringify(cart));
        		}
        	});
        }
        
        if (!exists) {
    		var item = {
    			name:name,
    			price:price,
    			qty:qty,
    			img:img
    		};
    		cart.push(item);
    		sessionStorage.setItem("cart", JSON.stringify(cart));
    	}
        
        window.location.href = "myCart.jsp";
       
        
	});
	
});
