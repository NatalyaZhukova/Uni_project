
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
<fmt:message key="register.successfull" bundle="${ rb }" /> 
<a href="/Uni_project/"><fmt:message key="register.log_in" bundle="${ rb }" /></a>
</div>
<%@include file="..\footer.jsp" %>
</body>
</html>
