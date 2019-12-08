<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="brand" tagdir="/WEB-INF/tags" %>



<html>
	<body>
		Please select brand:<br>
		<div>
			<table>
				<c:forEach items="${brandList}" var="brand">
				<tr>

						<jsp:useBean id="brand" type="ca.costsaver.entity.Brand"/>
						<%--<td><a href="${brand.id}">${brand.name}</a></td>--%>
					<td><a href="${brand.id}"><img src="/resources/i/brand-logo/${brand.logoImg}" width="100" height="100"></a></td>

				</tr>
				</c:forEach>
			</table>
		</div>



	</body>
</html>