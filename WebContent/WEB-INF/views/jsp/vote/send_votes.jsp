<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-sm-6">
			<form:form method="post" action="#">
				<div class="form-group">
					<label for="inputName">
						<spring:message code="vote.form.name" />
					</label>
					<form:input path="firstName" />
					<input type="text" class="form-control" id="inputName"
						placeholder='<spring:message code="vote.form.name"/>'>
				</div>
				<div class="form-group">
					<label for="inputEmail">
						<spring:message code="vote.form.emailAddress"/>
					</label> 
					<input type="email" class="form-control" id="inputEmail"
						placeholder='<spring:message code="vote.form.emailAddress"/>'>
				</div>
				<button type="submit" class="btn btn-default"><spring:message code="vote.form.send"/></button>
			</form:form>
		</div>
	</div>
</div>