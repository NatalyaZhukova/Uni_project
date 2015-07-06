<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:if test="${session.locale==null }">
<fmt:setLocale value="ru_RU" scope="session" />
</c:if>
<c:if test="${param.locale!=null}">
<fmt:setLocale value="${param.locale}" scope="session" />
</c:if>
<c:if test="${session.locale!=null }">
<fmt:setLocale value="${session.locale}" scope="session" />
</c:if>

<fmt:setBundle basename="message" var="rb" />
