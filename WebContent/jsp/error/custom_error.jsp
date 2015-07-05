<%@include file="../libs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
<%@include file="../header.jsp"%>
		<div class="content-wrapper">
			<c:if test="${role=='admin'}">
			<%@include file="../menu_admin.jsp" %>
			</c:if>
			<c:if test="${role=='abiturient' }" >
			<%@include file="../menu_user.jsp" %>
			</c:if>
			<div class="content">
			${errorMessage}
			</div>
		</div>
		
		<%@include file="../footer.jsp" %>
	</body>
</html>