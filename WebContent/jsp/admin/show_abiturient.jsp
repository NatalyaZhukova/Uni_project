<%@include file="..\libs.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="faculty" class="by.zhukova.uni.entity.Faculty" scope="session"></jsp:useBean>
<jsp:useBean id="abiturient" class="by.zhukova.uni.entity.Abiturient" scope="session"></jsp:useBean>
<jsp:useBean id="discList" class="by.zhukova.uni.entity.Discipline" scope="session"></jsp:useBean>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

</head>
<body>

<%@include file="..\header.jsp"%>
<div class="content-wrapper">
		 <%@include file="..\menu_admin.jsp" %>
			<div class="content">
			<div class="abiturslist">
		<span class="fio">	${abiturient.firstName } ${abiturient.middleName } ${abiturient.lastName } </span> <br/><br/>
			<fmt:message key="abiturient.overall" bundle="${rb}" /> - <span class="score"> ${abiturient.overallScore} </span><br/><br/>
			<fmt:message key="abiturient.faculty" bundle="${rb}" />: <span class="faculty-name"> ${faculty.name}</span>. <br/><br/>
			<fmt:message key="abiturient.disciplines" bundle="${rb}" />:
			<ul>
			<li>${discList[0].name} - ${abiturient.firstScore }</li>
			<li>${discList[1].name} - ${abiturient.secondScore }</li>
			<li>${discList[2].name} - ${abiturient.secondScore }</li>
			</ul>
            <fmt:message key="abiturient.school_score" bundle="${rb}" /> - ${schoolScore }
		
			
			</div>
			
			</div>
		</div>
</body>
</html>
