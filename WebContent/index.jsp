<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <c:choose>
    <c:when test="${user!=null }">
    <jsp:forward page="jsp/main.jsp"></jsp:forward>
    </c:when>
    <c:otherwise>
    <jsp:forward page="jsp/login.jsp"></jsp:forward>
    </c:otherwise>
    </c:choose>
	
</body>
</html>