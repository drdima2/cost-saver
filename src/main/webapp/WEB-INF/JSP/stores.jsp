<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
	<body>

		<br>
		<br>
		<br>
		<br>

		<form name="Stores" method="post">
			<input type="text" name="storeName">
			<br>
			<input type="hidden" name="storeId" value="">
			<input type="submit">
		</form>


		<br>
		<br>
		<br>
		<br>

		<table border="1" cellpadding="8" cellspacing="0">
			<thead>
			<tr>
				<th>storeName</th>
				<th></th>
				<th></th>
			</tr>
			</thead>
			<c:forEach items="${storeList}" var="store">
				<jsp:useBean id="store" type="ca.costsaver.entity.Store"/>
				<tr>
					<td>${store.productName}</td>
					<td><a href="/?id=${store.storeId}&action=edit">Edit</a></td>
					<td><a href="/?id=${store.storeId}&action=delete">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>