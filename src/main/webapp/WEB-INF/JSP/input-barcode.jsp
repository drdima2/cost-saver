<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
	<body>

		<form method="post" action="/barcode/barcode">
			<input type="text" name="barCodeStr">
			<div>
				<%--<form:errors path="product.barCode" />--%>
			</div>
			<br>

			<input type="submit">
		</form>


		Product Info:<br>
		${productInfo}


		<form method="post" action="/barcode/price">
			<input type="text" name="price">
			<div>
				<%--<form:errors path="product.barCode" />--%>
			</div>
			<br>

			<input type="submit">
		</form>











	</body>
</html>