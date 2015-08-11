<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="vote/save" modelAttribute="computationVote">
	<section class="container">
		<div class="container-fluid">
			<h2><spring:message code="vote.form.chosenOptions"/></h2>
			<c:forEach var="vote" varStatus="status" items="${computationVote.voteList}">
				<form:hidden path="voteList[${status.index}].restaurant.id" />
				<form:hidden path="voteList[${status.index}].restaurant.categoryRestaurant.id" />
				
				<div class="row">
					<div class="col-md-8 col-sm-6">
						<div class="col-md-4 col-xs-4">
							<div class="thumbnail"> 
								<img src="vote/showRestaurantIcon/${vote.restaurant.id}" alt="${vote.restaurant.description}">
							</div>
						</div>
			
						<div class="col-md-4 col-sm-6">
							<div class="caption">
								<h3>${vote.restaurant.description}</h3>
								<h4>${vote.restaurant.categoryRestaurant.description}</h4>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			
		</div>
	</section>
	<section class="container">
		<div class="container-fluid panel panel-default col-md-8 col-sm-6">
			<h2><spring:message code="vote.form"/></h2>
			<div class="row col-sm-12">
				
				<div class="form-group">
					<label for="inputName">
						<spring:message code="vote.form.name" />
					</label>
					<form:input path="userVoter.name" type="text" class="form-control" id="inputName" />
				</div>
				
				<div class="form-group">
					<label for="inputEmail">
						<spring:message code="vote.form.emailAddress"/>
					</label> 
					<form:input path="userVoter.email" type="email" class="form-control" id="inputEmail" />
				</div>
				
				<button type="submit" class="btn btn-default"><spring:message code="vote.form.send"/></button>
				<h2></h2>
			</div>
		</div>
	
	</section>
</form:form>
<h2></h2>