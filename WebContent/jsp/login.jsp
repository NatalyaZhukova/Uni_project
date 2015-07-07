
<%@include file="libs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
</head>
<body>

<%@include file="header.jsp"%>
<div class="login">
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="login" /> <label class="required">
			<fmt:message key="login.user" bundle="${ rb }" />:
		</label><br> <input type="text" name="login"
			pattern="[A-Za-z0-9_-]{5,50}" title="<fmt:message key="validation.login" bundle="${ rb }" />"
			required> <br> <label class="required"><fmt:message
				key="login.password" bundle="${ rb }" />:</label><br> <input
			type="password" name="password" pattern=".{5,20}"
			title="<fmt:message
				key="login.password" bundle="${ rb }" />"
			required> <br> <input type="submit"
			value="<fmt:message key="login.submit" bundle="${ rb }" />">
		<a href="/Uni_project/controller?command=register"><fmt:message
				key="login.register" bundle="${ rb }" /></a> <br> <span
			class="error">${errorLoginPassMessage}</span>
	</form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
