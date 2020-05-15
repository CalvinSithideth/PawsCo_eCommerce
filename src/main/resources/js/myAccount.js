function getFormData() {
	 var x = document.getElementById("sign-up");
	  var text = "";
	  var i;
	 
	 /* for (i = 0; i < x.length ; i++) {
			text += fname += x.elements[i].value  + "<br>";
	  }
	*/
	  /*document.getElementById("profile").innerHTML = text*/;
	  
	  //grabs elements of the sign-up page and prints them out based on the index specified
	  
	  /*document.getElementById("profile").innerHTML = "First Name: " + x.elements[0].value
	  + "<br>" + "Last Name: " + x.elements[1].value + "<br>" + "Email: " + x.elements[2].value;*/
	  document.getElementById("profile").innerHTML = "First Name: Jordan" + "<br>" + "Last Name: Johnston" + "<br>" + "Email: jordan@gmail.com";
};

function showHideWishList(){
	$("div").filter(".wishList").toggle();
};