$(document).ready(function() {
	var cart = JSON.parse(sessionStorage.getItem("cart"));
	var totals = JSON.parse(sessionStorage.getItem("totals"));
	
	$("#cartSize").html(cart.length);
	
	var cartListItems = "";
	cart.forEach(product => {
		cartListItems = cartListItems.concat(
			`<li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">${product.name}</h6>
                <small class="text-muted">Qty: ${product.qty}</small>
              </div>
              <span class="text-muted">$${(product.price * product.qty).toFixed(2)}</span>
            </li>`);
	});
	cartListItems = cartListItems.concat(
			`<br><li class="list-group-item d-flex justify-content-between">
              <span>Subtotal</span>
              <span id="subtotal">${totals.subtotal}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between">
              <span>Tax</span>
              <span id="tax">${totals.tax}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between">
              <strong>Total (USD)</strong>
              <strong id="total">${totals.total}</strong>
            </li>`);
	$("#cartItems").html(cartListItems);
});