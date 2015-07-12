<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ctg" uri="customtags" %>

<c:choose>

<c:when test="${not empty locale }">
<fmt:setLocale value="${locale}" />
</c:when>
<c:otherwise>
<fmt:setLocale value="ru_RU" />
</c:otherwise>
</c:choose>

<fmt:setBundle basename="message" var="rb" />