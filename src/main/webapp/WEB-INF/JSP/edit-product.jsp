<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
	<body>

		<form method="post">

			<input type="text" name="barCode" value="${product.barCode}">
			<br>
			<input type="text" name="productName" value="${product.productName}">
			<br>
			<input type="hidden" name="id" value="${product.id}">
			<input type="submit">
		</form>






	</body>
</html>