<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">
	<h4><spring:message code="vote.categoryRestaurant"/></h4>
	<h2>${formChoiceRestaurant.categoryRestaurant.description}</h2>
	
	<c:if test="${not empty formChoiceRestaurant.restaurantList}">
		<div class="container-fluid">
			<c:forEach var="restaurant" items="${formChoiceRestaurant.restaurantList}">
				<div class="row">
					<div class="col-md-8 col-sm-6">
						<div class="col-md-4 col-xs-4">
							<a href="#" onclick="newVote(${restaurant.id}, ${formChoiceRestaurant.categoryRestaurant.exhibitionOrder});" 
								class="thumbnail"> 
								<img src="vote/showRestaurantIcon/${restaurant.id}" alt="${restaurant.description}">
							</a>
						</div>
			
						<div class="col-md-4 col-sm-6">
							<div class="caption">
								<h3>${restaurant.description}</h3>
								<p>
									<a href="#" onclick="newVote(${restaurant.id}, ${formChoiceRestaurant.categoryRestaurant.exhibitionOrder});"
										class="btn btn-primary" role="button">
										<spring:message code="vote.doVote"/>
									</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>

</section>