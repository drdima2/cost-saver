<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
	<body>

		<form method="post" action="/product/add">
			<input type="text" name="barCode">
			<div>
				<form:errors path="product.barCode" />
			</div>
			<br>
			<input type="text" name="productName">
			<br>
			<input type="hidden" name="id" value="">
			<input type="submit">
		</form>




		<br>
		<br>
		<br>
		<br>

		<table border="1" cellpadding="8" cellspacing="0">
			<thead>
				<tr>
					<th>barCode</th>
					<th>productName</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${productList}" var="product">
				<jsp:useBean id="product" type="ca.costsaver.entity.Product"/>
				<tr>
					<td>${product.barCode}</td>
					<td>${product.productName}</td>
					<td><a href="/product/edit/${product.id}">Edit</a></td>
					<td><a href="/product/delete/${product.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>


	</body>
</html>