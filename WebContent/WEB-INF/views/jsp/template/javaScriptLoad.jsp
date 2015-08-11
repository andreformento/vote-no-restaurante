<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/js/main.js" var="mainJs" />
<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

<script src="${mainJs}"></script>
<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>