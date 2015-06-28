<%@include file="../libs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<script type="text/javascript">
window.onload = function () {
    document.getElementById("password1").onchange = validatePassword;
    document.getElementById("password2").onchange = validatePassword;
}
function validatePassword(){
var pass2=document.getElementById("password2").value;
var pass1=document.getElementById("password1").value;
if(pass1!=pass2)
    document.getElementById("password2").setCustomValidity('<fmt:message key="validation.repeat" bundle="${ rb }" />');
else
    document.getElementById("password2").setCustomValidity('');
}
</script>

</head>
<body>

<%@include file="../header.jsp"%>

<div class="register">
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="register" /> <label>
			<fmt:message key="register.login" bundle="${ rb }" />:
		</label><br> <input type="text" name="reg_login"
			pattern="[A-Za-z0-9_-]{5,50}"
			title="<fmt:message key="validation.login" bundle="${ rb }" />"
			required> <br> <label><fmt:message
				key="register.password" bundle="${ rb }" />:</label><br> <input
			type="password" id="password1" name="reg_password" pattern=".{5,20}"
			title="<fmt:message key="validation.password" bundle="${ rb }" />"
			required> <br> <label><fmt:message
				key="register.repeat" bundle="${ rb }" />:</label><br> <input
			type="password" id="password2" name="repeat_password"
			pattern=".{5,20}"
			title="<fmt:message key="validation.repeat" bundle="${ rb }" />"
			required> <br> <input type="submit"
			value="<fmt:message key="register.submit" bundle="${ rb }" />"
			id="submit">
			<br> <span class="error">${errorUserMessage}</span> 
	</form>
</div>


</body>
</html>