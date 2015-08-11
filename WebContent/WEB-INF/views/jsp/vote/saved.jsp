<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head lang="en">
	<jsp:include page="../template/header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../template/top.jsp"></jsp:include>
	
	<section class="container">
		<div class="container-fluid">
			<h4><spring:message code="vote.form.saved.processingVote"/></h4>
			<h2><spring:message code="vote.form.saved.youWillReceiveEmail"/></h2>
			
			<p><strong><spring:message code="vote.form.name"/></strong>: ${computationVote.userVoter.name}</p>
			<p><strong><spring:message code="vote.form.emailAddress"/></strong>: ${computationVote.userVoter.email}</p>
		</div>
	</section>

	
	<jsp:include page="../template/footer.jsp"></jsp:include>
	
	<jsp:include page="../template/javaScriptLoad.jsp"></jsp:include>

</body>
</html>
