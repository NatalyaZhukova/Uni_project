<%@include file="..\libs.jsp"%>

<!DOCTYPE html>
<jsp:useBean id="facList" class="by.zhukova.uni.entity.Faculty" scope="session"></jsp:useBean>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" >
$(document).ready(function(){
	$('#choosefaculty').submit(function(){
		 var middleName = $('input[name=middle_name]').val();
		var pattern = new RegExp("[\u0410-\u042F\u0401\][\u0430-\u044F\u0451]{1,20}");
		 if ((middleName!="") && (!pattern.test(middleName))) {
			 $('#submit').after('<br/><span class="error"><fmt:message key="validation.middle_name" bundle="${ rb }" /></span>');
		     return false;
		 }
	});
});
</script>
</head>
<body>

<%@include file="..\header.jsp"%>
<div class="choosefaculty">
		<form action="controller" method="POST" id="choosefaculty">
			<input type="hidden" name="command" value="chfac" /> 
			<label class="required"><fmt:message key="chfaculty.first_name" bundle="${rb}" />:</label><br> 
			<input type="text" name="first_name" pattern="[\u0410-\u042F\u0401\][\u0430-\u044F\u0451]{1,20}"
			 title="<fmt:message key="validation.rus" bundle="${rb}" />" required /> <br/>
			<label><fmt:message key="chfaculty.middle_name" bundle="${rb}" />:</label> 
			<br> <input type="text" name="middle_name" value="" 
			title="<fmt:message key="validation.rus" bundle="${rb}" />">  <br/>
			<label class="required"><fmt:message key="chfaculty.last_name" bundle="${rb}" />:</label> <br>
			<input type="text" name="last_name" value="" 
			pattern="[\u0410-\u042F\u0401\][\u0430-\u044F\u0451]{1,20}" 
			title="<fmt:message key="validation.rus" bundle="${rb}" />"  required /> <br/> <br/>
			<label class="required"><fmt:message key="chfaculty.choose_faculty" bundle="${rb}" />:</label>
			<select name="faculty">
			<c:forEach var="faculty" items="${facList}">
			<option value="${faculty.id}">${faculty.name}</option>
			</c:forEach>
			</select>
			<br> 
				<input type="submit" value="<fmt:message key="chfaculty.next" bundle="${rb}" />" id="submit"> <br>
				<c:if test="${not empty errorMessage }">
				<span class="error"><fmt:message key="${errorMessage }" bundle="${rb}" /></span>
				</c:if>
		</form>
	</div>
<ctg:footer />

</body>
</html>