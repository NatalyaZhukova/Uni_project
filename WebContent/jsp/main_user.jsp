<%@include file="libs.jsp"%>
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
			<div class="menu">
			<h2><fmt:message key="usermain.menu" bundle="${rb}" /></h2>
			<ul>
			<li><a href="/Uni_project/controller?command=fac"><fmt:message key="usermain.fac_list" bundle="${rb}" /></a></li>
			<c:if test="${application==null}">
			<li><a href="/Uni_project/controller?command=chfac"><fmt:message key="usermain.register_fac" bundle="${rb}" /></a></li>
			</c:if>
			<c:if test="${application!=null}">
			<li><a href="/Uni_project/controller?command=applic"><fmt:message key="usermain.application" bundle="${rb}" /></a></li>
			</c:if>
			</ul>		
			</div>
			<div class="content">
			</div>
		</div>
		
		<%@include file="footer.jsp" %>
	</body>
</html>