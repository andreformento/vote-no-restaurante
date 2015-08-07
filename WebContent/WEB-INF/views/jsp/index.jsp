<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head lang="en">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	<title><spring:message code="index.welcome"/></title>
	
	<spring:url value="/resources/css/main.css" var="mainCss" />
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	
	<link href="${mainCss}" rel="stylesheet" />
	<link href="${bootstrapCss}" rel="stylesheet" />
    
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2><spring:message code="application.language"/></h2>
				<h3>${count}</h3>
			</div>
		</div>
	</section>

	<section class="container">
		<a href="vote"><spring:message code="index.doVote"/></a>
	</section>
	
	<spring:url value="/resources/js/main.js" var="mainJs" />
	<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryJs" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	
	<script src="${mainJs}"></script>
	<script src="${jqueryJs}"></script>
	<script src="${bootstrapJs}"></script>
</body>
</html>