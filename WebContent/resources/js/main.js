// local javascript

function loadNextPage(divName, link) {
	var loadHtml =
		'<section class="container">'+
		'	<div class="spinner">'+
		'		<div class="dot1"></div>'+
		'		<div class="dot2"></div>'+
		'	</div>'+
		'</section>';
	
	$(divName).html(loadHtml);
	
	$(divName).load(link);
}

function newVote(id, order){
	votes.push(id);
	
	var link = "vote/listCategoryRestaurantByOrder";
	link += "?order="+order;
	link += "&idRestaurantList="+votes;
	
	loadNextPage("#categoryRestaurantList",link);
}