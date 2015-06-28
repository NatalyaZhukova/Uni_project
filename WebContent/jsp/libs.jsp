<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${param.locale==null}">
<fmt:setLocale value="${session.locale}" scope="session" />
</c:if>
<c:if test="${session.locale==null }">
<fmt:setLocale value="en_US" scope="session" />
</c:if>
<fmt:setLocale value="${param.locale}" scope="session" />
<fmt:setBundle basename="message" var="rb" />
