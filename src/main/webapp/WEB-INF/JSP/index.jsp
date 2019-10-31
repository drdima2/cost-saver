<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
	<body>

		<form name="products" method="post">
			<input type="text" name="barCode">
			<br>
			<input type="text" name="productName">
			<br>
			<input type="hidden" name="id" value="">
			<input type="submit">
			<br>
			<a href="/?action=stores">Stores</a>
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
					<td><a href="/?id=${product.id}&action=edit">Edit</a></td>
					<td><a href="/?id=${product.id}&action=delete">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

		<br>
		<br>
		<br>
		<br>

	</body>
</html>