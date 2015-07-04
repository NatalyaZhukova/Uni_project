<%@include file="..\libs.jsp"%>
<jsp:useBean id="faculty" class="by.zhukova.uni.entity.Faculty" scope="session"></jsp:useBean>
<jsp:useBean id="discList" class="by.zhukova.uni.entity.Discipline" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

</head>
<body>

<%@include file="..\header.jsp"%>
<div class="content-wrapper">
			<%@include file="..\menu_user.jsp" %>
			<div class="content">
			<h2>${faculty.name}</h2>
			<h3><fmt:message key="faculty.disciplines" bundle="${rb}" />:</h3>
			<ul>
			<li>${discList[0].name }</li>
			<li>${discList[1].name }</li>
			<li>${discList[2].name }</li>
			</ul>
			<br/>
			
			<span class="applic">	<fmt:message key="application.num_appl" bundle="${rb}" /></span> <br/>
		<span class="applic-num">	${applications} / ${faculty.facultyPlan}</span> <br/>
		 
			</div>
		</div>
</body>
</html>