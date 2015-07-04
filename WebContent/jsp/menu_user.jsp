<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>