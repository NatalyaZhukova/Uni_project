<%@include file="..\libs.jsp"%>
<c:set var="current" value="/jsp/admin/success_fac_delete.jsp" scope="session"></c:set>
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
<fmt:message key="faculty.success_del" bundle="${ rb }" /> 
</div>
<ctg:footer />
</body>
</html>
