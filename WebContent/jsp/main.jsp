<%@include file="libs.jsp"%>
<c:set var="current" value="index" scope="session"></c:set>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
<%@include file="header.jsp"%>
		<div class="content-wrapper">
			<c:choose>
			<c:when  test="${role=='admin'}">
			<%@include file="menu_admin.jsp" %>
			</c:when>
			<c:when test="${role=='abiturient' }">
			<%@include file="menu_user.jsp" %>
			</c:when>
			</c:choose>
			<div class="content">
		
				<c:choose>
			<c:when  test="${role=='admin'}">
		<fmt:message key="message.admin" bundle="${rb}" />
			</c:when>
			<c:when test="${role=='abiturient' }">
		<fmt:message key="message.abiturient" bundle="${rb}" />
			</c:when>
			</c:choose>
		
			
			
			</div>
		</div>
		
		<ctg:footer />
	</body>
</html>
