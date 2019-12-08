<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="brand" tagdir="/WEB-INF/tags" %>



<html>
	<body>

		<form:form name="input" method="post" action="/store/add" modelAttribute="newStore">
			<form:input type="text" path="name"/>
			<form:errors path="name"/>

			<br>
			<form:input type="text" path="address"/>
			<br>
			<%--<brand:brand-list />--%>
			<form:select path="brand.id" items="${brandList}" itemLabel="name" itemValue="id">
			</form:select>
			<form:errors path="brand"/>
			<input type="submit">
		</form:form>




		<br>
		<br>
		<br>
		<br>

		<table border="1" cellpadding="8" cellspacing="0">
			<thead>
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>BrandName</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${storeList}" var="store">
				<jsp:useBean id="store" type="ca.costsaver.entity.Store"/>
				<tr>
					<td>${store.name}</td>
					<td>${store.address}</td>
					<td>${store.brand.name}</td>
					<td><a href="/product/edit/${store.id}">Edit</a></td>
					<td><a href="/product/delete/${store.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>


	</body>
</html>