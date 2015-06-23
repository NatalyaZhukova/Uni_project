<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="ru_RU" scope="session" />
<fmt:setBundle basename="message" var="rb" />


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
</head>

<body>
	<div class="login">
		<form action="controller" method="POST">
			<input type="hidden" name="command" value="login" /> <label>
				<fmt:message key="login.user" bundle="${ rb }" />:
			</label><br> <input type="text" name="login"> <br> <label><fmt:message
					key="login.password" bundle="${ rb }" />:</label><br> <input
				type="password" name="password"> <br> <input
				type="submit"
				value="<fmt:message key="login.submit" bundle="${ rb }" />">
			<br><span class="error">${errorLoginPassMessage}</span>  <br />
			
			 ${wrongAction} <br />
			${nullPage} <br />
		</form>
	</div>
</body>
</html>
