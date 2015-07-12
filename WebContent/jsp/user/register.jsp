<%@include file="../libs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#register').submit(function(){

		 var text1 = $('#password1').val();
		 var text2 = $('#password2').val();
		
		 if (text1!=text2){
		     $('#password1').css('background-color','#FF7171')
		     $('#password2').css('background-color','#FF7171')
		     $('#submit').after('<br/><span class="error"><fmt:message key="validation.repeat" bundle="${ rb }" /></span>');
		     return false;}
		 else{
		    $('#password1').css('background-color','white')
		    $('#password2').css('background-color','white')}
	});
});
</script>
</head>
<body>

<%@include file="../header.jsp"%>

<div class="register">
	<form action="controller" method="POST" id="register">
		<input type="hidden" name="command" value="register" /> 
		<label class="required">
			<fmt:message key="register.login" bundle="${ rb }" />:
		</label><br> <input type="text" name="reg_login"
			pattern="[A-Za-z0-9_-]{5,50}"
			title="<fmt:message key="validation.login" bundle="${ rb }" />" 
			required> <br> 
			<label class="required"><fmt:message
				key="register.password" bundle="${ rb }" />:</label><br> <input
			type="password" id="password1" name="reg_password" pattern=".{5,20}"
			title="<fmt:message key="validation.password" bundle="${ rb }" />"
			required> <br> 
			<label class="required"><fmt:message
				key="register.repeat" bundle="${ rb }" />:</label><br> <input
			type="password" id="password2" name="repeat_password"
			pattern=".{5,20}"
			title="<fmt:message key="validation.repeat" bundle="${ rb }" />"
			required> <br> <input type="submit"
			value="<fmt:message key="register.submit" bundle="${ rb }" />"
			id="submit">
			<br>
			<c:if test="${not empty errorUserMessage }">
			 <span class="error"><fmt:message key="${errorUserMessage }" bundle="${rb}" /></span>
			 </c:if>
	</form>
</div>
<ctg:footer />

</body>
</html>