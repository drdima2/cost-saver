<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<div>
	<select name="brand">
	<c:forEach items="${brandList}" var="brand">
		<jsp:useBean id="brand" type="ca.costsaver.entity.Brand"/>
		<option value="${brand.id}">${brand.name}</option>
	</c:forEach>
	</select>
</div>