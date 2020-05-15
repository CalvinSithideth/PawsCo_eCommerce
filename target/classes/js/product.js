$(document).ready(function(){
	//store user input to local storage
	$("#searchButton").on("click", function(){
		localStorage.setItem("searchInput", $("#searchProductInput").val());
		searchProduct();
		//clears out the search
		localStorage.setItem("searchInput", "");
		//refresh page on search button
		$("#searchButton").click(function(){
			location.reload();		
		})
	});
	
	$("#resetPage").click(function(){
		//clears out the search
		localStorage.setItem("searchInput", "");
		location.reload();		
	})
	$("#lessThanFive").on("click", function(){
		resetPage()
		var cardPrice = $(".price")
		console.log(cardPrice)
		for(var i=0; i<cardPrice.length; i++){
			var parsedPrice = parseFloat(cardPrice[i].innerText);
			console.log(parsedPrice)
			console.log(parsedPrice > 5)
			if(parsedPrice > 5) {
				var cards=$(cardPrice[i]).parentsUntil(".col");
				console.log(cards)
				$(cards[2]).hide();
			}	
		}
	})
	
	$("#tenToTwenty").on("click", function(){
		resetPage()
		var cardPrice = $(".price")
		console.log(cardPrice)
		for(var i=0; i<cardPrice.length; i++){
			var parsedPrice = parseFloat(cardPrice[i].innerText);
			console.log(parsedPrice)
			if(parsedPrice >20 || parsedPrice <10) {
					var cards=$(cardPrice[i]).parentsUntil(".col");
					console.log(cards)
					$(cards[2]).hide();		
			}	
		}
	})
	
	$("#twentyToFifty").on("click", function(){
		resetPage()
		var cardPrice = $(".price")
		console.log(cardPrice)
		for(var i=0; i<cardPrice.length; i++){
			var parsedPrice = parseFloat(cardPrice[i].innerText);
			console.log(parsedPrice)
			if(parsedPrice >50 || parsedPrice <20) {
					var cards=$(cardPrice[i]).parentsUntil(".col");
					console.log(cards)
					$(cards[2]).hide();		
			}	
		}
	})
	
	$("#fiftyToOneHundred").on("click", function(){
		resetPage()
		var cardPrice = $(".price")
		console.log(cardPrice)
		for(var i=0; i<cardPrice.length; i++){
			var parsedPrice = parseFloat(cardPrice[i].innerText);
			console.log(parsedPrice)
			if(parsedPrice >100 || parsedPrice <50) {
					var cards=$(cardPrice[i]).parentsUntil(".col");
					console.log(cards)
					$(cards[2]).hide();		
			}	
		}
	})
	
	function resetPage(){
		var cardPrice = $(".price")
		console.log(cardPrice)
		for(var i=0; i<cardPrice.length; i++){
			var parsedPrice = parseFloat(cardPrice[i].innerText);
			console.log(parsedPrice)
				var cards=$(cardPrice[i]).parentsUntil(".col");
				console.log(cards)
				$(cards[2]).show();
	
		}
	}
	//Called on page load
	searchProduct();
	//checks to see if user input in search matches anything in local storage
	function searchProduct(e){
		resetPage();
		var getInput = localStorage.getItem("searchInput");
		//if user input isnt null or empty it will iterate through the cards div array
		if(getInput != null || getInput != "" || getInput != undefined){
			var cardDivs = $(".card-title");
			for(var i=0; i<cardDivs.length; i++){
				//if the innertext doesnt have same input of user input it will hide all cards that doesn't contain the user input
				if(!cardDivs[i].innerText.toLowerCase().includes(getInput.toLowerCase())){
					var card=$(cardDivs[i]).parentsUntil(".col");
					console.log(card)
					$(card[2]).hide();
				}	
			}
		}e.preventDefault();
	}
	
	
});