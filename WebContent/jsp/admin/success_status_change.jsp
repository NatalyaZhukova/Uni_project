<%@include file="..\libs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
</head>
<body>
<%@include file="..\header.jsp" %>
<%@include file="..\menu_admin.jsp" %>
<div class = "content">
<fmt:message key="status.success_change" bundle="${ rb }" /> 
</div>
<ctg:footer />
</body>
</html>
