<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${param.locale==null}">
<fmt:setLocale value="ru_RU" scope="session" />
</c:if>
<fmt:setLocale value="${param.locale}" scope="session" />
<fmt:setBundle basename="message" var="rb" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
</head>

<body>
	<div class="header">
		<h1>
			<fmt:message key="header.title" bundle="${ rb }" />
		</h1>
		<div class="locale">
			<a href="/Uni_project/controller?command=lang&locale=ru_RU">RU</a> | <a
				href="/Uni_project/controller?command=lang&locale=en_US">EN</a>
		</div>
		<div class="lg">
			<c:if test="${user!=null}">
				<br>${user} <a href="/Uni_project/controller?command=logout"><fmt:message
						key="header.logout" bundle="${ rb }" /> </a>
			</c:if>

		</div>
	</div>