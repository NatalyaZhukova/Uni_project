<%@include file="..\libs.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="faculty" class="by.zhukova.uni.entity.Faculty" scope="session"></jsp:useBean>
<jsp:useBean id="appl" class="by.zhukova.uni.entity.Abiturient" scope="session"></jsp:useBean>
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
		<span class="fio">	${appl.firstName } ${appl.middleName } ${appl.lastName } </span> <br>
			<fmt:message key="application.overall" bundle="${rb}" /><span class="score"> ${appl.overallScore} </span><br>
			<fmt:message key="application.faculty" bundle="${rb}" /><span class="faculty-name"> ${faculty.name}</span>. <br>
		<span class="applic">	<fmt:message key="application.num_appl" bundle="${rb}" /></span> <br/>
		<span class="applic-num">	${faculty_registered} / ${faculty.facultyPlan}</span> <br/>
			
			<a href="/Uni_project/controller?command=applic&act=del"><fmt:message key="application.delete" bundle="${rb}" /></a>
			
			</div>
		</div>
</body>
</html>
