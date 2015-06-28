<%@include file="..\libs.jsp"%>

<!DOCTYPE html>
<jsp:useBean id="facList" class="by.zhukova.uni.entity.Faculty" scope="session"></jsp:useBean>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

</head>
<body>

<%@include file="..\header.jsp"%>
<div class="choosefaculty">
		<form action="controller" method="POST"  accept-charset="UTF-8">
			<input type="hidden" name="command" value="chfac" /> 
			<label><fmt:message key="chfaculty.first_name" bundle="${rb}" /></label><br> 
			<input type="text" name="first_name" value=""   required /> <br/>
			<label><fmt:message key="chfaculty.middle_name" bundle="${rb}" /></label> 
			<br> <input type="text" name="middle_name" value="">  <br/>
			<label><fmt:message key="chfaculty.last_name" bundle="${rb}" /></label> <br>
			<input type="text" name="last_name" value=""   required /> <br/> <br/>
			<label><fmt:message key="chfaculty.choose_faculty" bundle="${rb}" /></label>
			<select name="faculty">
			<c:forEach var="faculty" items="${facList}">
			<option value="${faculty.id}">${faculty.name}</option>
			</c:forEach>
			</select>
			<br> 
				<input type="submit" value="<fmt:message key="chfaculty.next" bundle="${rb}" />"> <br>
				<span class="error">${errorMessage } </span>
				${param.first_name} ${param.middle_name} ${param.last_name}
		</form>
	</div>


</body>
</html>