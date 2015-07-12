
<%@include file="..\libs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
</head>
<body>
<%@include file="..\header.jsp" %>
<%@include file="..\menu_user.jsp" %>
<div class = "success">
<fmt:message key="scores.success" bundle="${ rb }" /> 
<a href="/Uni_project/controller?command=applic"><fmt:message key="scores.success_link" bundle="${ rb }" /></a>
</div>
<ctg:footer />
</body>
</html>
