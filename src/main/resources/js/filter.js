function showAll(){
	$("div").filter(".dog-food").show();
	$("div").filter(".dog-toy").show();
	$("div").filter(".dog-furniture").show();
	$("div").filter(".dog-grooming").show();
	$("div").filter(".dog-apparel").show();
};
function showFood(){
	$("div").filter(".dog-food").show();
	$("div").filter(".dog-toy").hide();
	$("div").filter(".dog-furniture").hide();
	$("div").filter(".dog-grooming").hide();
	$("div").filter(".dog-apparel").hide();
};
function showToys(){
	$("div").filter(".dog-food").hide();
	$("div").filter(".dog-toy").show();
	$("div").filter(".dog-furniture").hide();
	$("div").filter(".dog-grooming").hide();
	$("div").filter(".dog-apparel").hide();
};
function showFurniture(){
	$("div").filter(".dog-food").hide();
	$("div").filter(".dog-toy").hide();
	$("div").filter(".dog-furniture").show();
	$("div").filter(".dog-grooming").hide();
	$("div").filter(".dog-apparel").hide();
};
function showGrooming(){
	$("div").filter(".dog-food").hide();
	$("div").filter(".dog-toy").hide();
	$("div").filter(".dog-furniture").hide();
	$("div").filter(".dog-grooming").show();
	$("div").filter(".dog-apparel").hide();
};
function showApparel(){
	$("div").filter(".dog-food").hide();
	$("div").filter(".dog-toy").hide();
	$("div").filter(".dog-furniture").hide();
	$("div").filter(".dog-grooming").hide();
	$("div").filter(".dog-apparel").show();
};
/*
dog-food
dog-toy
dog-furniture
dog-grooming
dog-apparel*/