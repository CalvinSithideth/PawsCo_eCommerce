$(document).ready(function() {
	$(".cartBtn").click(function(e) {
		e.preventDefault();
		
		var prodDiv = $(this).parent().parent();
		var name = prodDiv.find(".card-title").html();
		var price = prodDiv.find(".price").html().replace('$', '');
		var qty = parseInt(prodDiv.find("#quantity").val());
		var img = prodDiv.parent().parent().find("img").attr("src");
		
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


	$(document).ready(function() {
		$(".wishlistBtn").click(function(e) {
			e.preventDefault();
			
			var prodDiv = $(this).parent().parent();
			var name = prodDiv.find(".card-title").html();
			var price = prodDiv.find(".price").html().replace('$', '');
			var qty = parseInt(prodDiv.find("#quantity").val());
			var img = prodDiv.parent().parent().find("img").attr("src");
			
			var wishlist = JSON.parse(sessionStorage.getItem("wishlist"));
			var exists = false;
			
	        if (wishlist == null) {
	            wishlist = [];
	        } else {
	        	wishlist.forEach(product => {
	        		if (product.name == name) {
	        			exists = true;
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
	    		
	    		wishlist.push(item);
	    		sessionStorage.setItem("wishlist", JSON.stringify(wishlist));
	    	}
	        
	        window.location.href = "wishlist.jsp";
		});
	});
