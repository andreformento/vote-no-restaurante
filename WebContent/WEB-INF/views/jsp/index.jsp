<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><spring:message code="index.title" /></title>

<spring:url value="/resources/css/main.css" var="mainCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/normalize.css" var="normalizeCss" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${normalizeCss}" rel="stylesheet" />

</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h4>
					<spring:message code="index.explanation" />
				</h4>
				<h2>
					<spring:message code="index.title" />
				</h2>
			</div>
		</div>
	</section>

	<section class="container">
		<div id="categoryRestaurantList">
			<h1>...</h1>
		</div>
	</section>

	<spring:url value="/resources/js/main.js" var="mainJs" />
	<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryJs" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

	<script src="${mainJs}"></script>
	<script src="${jqueryJs}"></script>
	<script src="${bootstrapJs}"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			loadNextPage("#categoryRestaurantList","vote/listCategoryRestaurantByOrder?order=0");
		});
	</script>
</body>
</html>