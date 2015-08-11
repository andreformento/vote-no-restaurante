<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head lang="en">
	<jsp:include page="template/header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="template/top.jsp"></jsp:include>
	<jsp:include page="template/javaScriptLoad.jsp"></jsp:include>
	
	<div id="categoryRestaurantList"></div>

	<script type="text/javascript">
		var votes = new Array();
	
		$(document).ready(function() {
			loadNextPage("#categoryRestaurantList","vote/listCategoryRestaurantByOrder");
		});
	</script>
	
	<jsp:include page="template/footer.jsp"></jsp:include>

</body>
</html>