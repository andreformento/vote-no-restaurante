<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Category Restaurant List</h2>

<c:if test="${not empty categoryRestaurantList}">

	<ul>
		<c:forEach var="categoryRestaurant" items="${categoryRestaurantList}">
			<li>${categoryRestaurant}</li>
		</c:forEach>
	</ul>

</c:if>
