$(document).ready(function() {
	
	var wishlist = JSON.parse(sessionStorage.getItem("wishlist"));
	var wishlistDiv = $("#wishlistDiv");
	
	if (wishlist == null || wishlist.length == 0) {
		wishlistDiv.html(`<br><h4 style="text-align: center">Your wishlist is empty.</h4><br>`);
	} else {
		var wishlistTable = 
			`<br><h4 style="text-align:center">Your Wishlist</h4><br>
			<table class="table">
				<thead>
					<tr>
						<th></th>
						<th>Product</th>
						<th>Price</th>
						<th>Options</th>
					</tr>
				</thead>
				<tbody>`;
		
		var index = 0;
		wishlist.forEach(product => {
			wishlistTable = wishlistTable.concat(
					`<tr>
						<td><img src="${product.img}" class="img-cart" width="auto" height="100"></td>
						<td style="max-width:200px"><strong>${product.name}</strong></td>
						<td id="price">$${product.price}</td>
						<td>
						<form class="form-inline">
							<button class="btn btn-primary btnCart"
								style="background-color: #45c04f; border: none; 
								padding-left: 10px; padding-right: 10px;
								margin-right: 10px">
								<i class="fas fa-cart-plus"></i>
								</button>
							<button class="btn btn-primary btnDelete"
								style="background-color: #cc3318; border: none"
								value="${index++}">
								<i class="fas fa-trash-alt"></i>
								</button>
						</form>
						</td>
					</tr>`);
		});
		
		wishlistTable = wishlistTable.concat(`</tbody></table>`);

		wishlistDiv.html(wishlistTable);
	}
	
	$(".btnDelete").click(function() {
		var i = $(this).val();
		wishlist.splice(i, 1);
		sessionStorage.setItem("wishlist", JSON.stringify(wishlist));
		location.reload();
	});
	
	$(".btnCart").click(function(e) {
		e.preventDefault();
		var div = $(this).parentsUntil("tr").parent();
		var name = div.find("strong").html();
		var price = div.find("#price").html().replace('$', '');
		var qty = 1;
		var img = div.find("img").attr("src");
		
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
	
	$("#test").click(function() {
		wishlist = [];
		var testItem = {
				name: "Test Product",
				price: "9.95",
				img: "../Image/catcostume.jpg"
		};
		var testItem2 = {
				name: "Test Product",
				price: "9.95",
				img: "../Image/catcostume.jpg"
		};
		wishlist.push(testItem);
		wishlist.push(testItem2);
		sessionStorage.setItem("wishlist", JSON.stringify(wishlist));
		location.reload();
	});
});