
<%@include file="..\libs.jsp"%>
<c:set var="current" value="/jsp/admin/success_faculty.jsp" scope="session"></c:set>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
</head>
<body>
<%@include file="..\header.jsp" %>
<div class = "success">
<fmt:message key="faculty.success" bundle="${ rb }" /> 
<a href="/Uni_project/controller?command=fac"><fmt:message key="faculty.success_link" bundle="${ rb }" /></a>
</div>
<ctg:footer />
</body>
</html>
