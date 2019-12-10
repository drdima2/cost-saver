<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="brand" tagdir="/WEB-INF/tags" %>



<html>
	<body>
		Please select Store:<br>
		<div>
			<table>
				<c:forEach items="${storeList}" var="store">
				<tr>

						<jsp:useBean id="store" type="ca.costsaver.entity.Store"/>
						<%--<td><a href="${brand.id}">${brand.name}</a></td>--%>
					<td><a href="${store.id}">${store.name}</a></td>

				</tr>
				</c:forEach>
			</table>
		</div>



	</body>
</html>