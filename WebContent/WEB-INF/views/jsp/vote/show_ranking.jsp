<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head lang="en">
<jsp:include page="../template/header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../template/top.jsp"></jsp:include>

	<section class="container">
		<div class="container-fluid">
			<h2>
				<spring:message code="ranking.form.title" />
			</h2>
			<c:forEach var="categoryRow" varStatus="status"
				items="${ranking.list}">
				<div class="row">
					<div class="table-responsive">
						<table class="table">
							<caption>${categoryRow.value.categoryRestaurant.description}</caption>
							<thead>
								<tr>
									<th><spring:message code="ranking.form.votes" /></th>
									<th><spring:message code="ranking.form.name" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="restaurantRow" varStatus="status"
									items="${categoryRow.value.list}">
									<tr class="${categoryRow.value.restaurantChoice.id == restaurantRow.value.id ? 'info' : ''}">
										<td>${restaurantRow.key}</td>
										<td>${restaurantRow.value.description}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:forEach>

		</div>
	</section>
	<h2></h2>


	<jsp:include page="../template/footer.jsp"></jsp:include>

	<jsp:include page="../template/javaScriptLoad.jsp"></jsp:include>

</body>
</html>
