<%@include file="../libs.jsp"%>
<jsp:useBean id="abiturients" class="by.zhukova.uni.entity.Abiturient" scope="session" ></jsp:useBean>
<jsp:useBean id="facList" class="by.zhukova.uni.entity.Faculty" scope="session" ></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
<%@include file="../header.jsp"%>
		<div class="content-wrapper">
			<%@include file="../menu_admin.jsp" %>
			<div class="content">
			<div class="abiturslist">
			<form action="controller" method="POST">
			<input type="hidden" name="command" value="abitur">
			<select name="faculty">
			<c:forEach var="faculty" items="${facList}" >
			<option value="${faculty.id}">${faculty.name}</option>
			</c:forEach>
			</select>
			<input type="submit" value="<fmt:message key="chfaculty.choose_faculty" bundle="${ rb }" />">
			</form>
			<hr>
			<h2>${facultyName }</h2>
			${message}
			<c:forEach var="abiturient" items="${abiturients}" begin="0" end="${stopLine-1}" varStatus="status">
			<div class="abiturient">
			<c:out value="${status.count}.">
			<span class="fio"><a href="/Uni_project/controller?command=showabitur&id=${abiturient.id}">
			 ${abiturient.firstName } ${abiturient.middleName } ${abiturient.lastName } </a></span>
			   <span class="score"> ${abiturient.overallScore }</span>
			</div>
			</c:forEach>
			
			<c:if test="${plan<applicNums}">
			<hr class="separator">
			<c:forEach var="abiturient" items="${abiturients}" begin="${stopLine}" >
			<div class="abiturient">
			 <span class="fio"><a href="/Uni_project/controller?command=showabitur&id=${abiturient.id}"> 
			 ${abiturient.firstName } ${abiturient.middleName } ${abiturient.lastName } </a> </span>
			  <span class="score"> ${abiturient.overallScore }</span>
			</div>
			</c:forEach>
			</c:if>
			
			</div>
			</div>
		</div>
		
		<%@include file="../footer.jsp" %>
	</body>
</html>
