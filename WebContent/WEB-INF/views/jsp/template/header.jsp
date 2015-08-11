<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><spring:message code="index.title" /></title>

<spring:url value="/resources/css/main.css" var="mainCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/normalize.css" var="normalizeCss" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${normalizeCss}" rel="stylesheet" />