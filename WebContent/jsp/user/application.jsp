<%@include file="..\libs.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="faculty" class="by.zhukova.uni.entity.Faculty" scope="session"></jsp:useBean>
<jsp:useBean id="appl" class="by.zhukova.uni.entity.Abiturient" scope="session"></jsp:useBean>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

</head>
<body>

<%@include file="..\header.jsp"%>
<div class="content-wrapper">
			<div class="menu">
			<h2><fmt:message key="usermain.menu" bundle="${rb}" /></h2>
			<ul>
			<li><a href="/Uni_project/controller?command=fac"><fmt:message key="usermain.fac_list" bundle="${rb}" /></a></li>
			<c:if test="${application==null}">
			<li><a href="/Uni_project/controller?command=chfac"><fmt:message key="usermain.register_fac" bundle="${rb}" /></a></li>
			</c:if>
			<c:if test="${application!=null}">
			<li><a href="/Uni_project/controller?command=applic"><fmt:message key="usermain.application" bundle="${rb}" /></a></li>
			</c:if>
			</ul>		
			</div>
			<div class="content">
		<span class="fio">	${appl.firstName } ${appl.middlName } ${appl.lastName } </span> <br>
			<fmt:message key="application.overall" bundle="${rb}" /><span class="score"> ${appl.overallScore} </span><br>
			<fmt:message key="application.faculty" bundle="${rb}" /><span class="faculty-name"> ${faculty.name}</span>. <br>
		<span class="applic">	<fmt:message key="application.num_appl" bundle="${rb}" /></span> <br/>
		<span class="applic-num">	${faculty_registered} / ${faculty.facultyPlan}</span> <br/>
			
			<a href="/Uni_project/controller?command=applic&act=del"><fmt:message key="application.delete" bundle="${rb}" /></a>
			
			</div>
		</div>
</body>
</html>
