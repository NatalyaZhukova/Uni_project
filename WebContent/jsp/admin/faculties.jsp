<%@include file="..\libs.jsp"%>
<jsp:useBean id="facList" class="by.zhukova.uni.entity.Faculty" scope="session"></jsp:useBean>
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
			<%@include file="..\menu_admin.jsp" %>
			<div class="content">
		      	<h2><fmt:message key="faculty.title" bundle="${rb}" /></h2>
				
			<c:forEach var="faculty" items="${facList}" begin="">
			<div class="faculty">
			<h3><a href="/Uni_project/controller?command=showfac&id=${faculty.id}">${faculty.name}</a></h3>
			<fmt:message key="faculty.plan" bundle="${rb}" /> - ${faculty.facultyPlan }<br/>
			
			</div>
			</c:forEach>
			
			<div class="pages">
			<c:forEach var="i" begin="1" end="${numpage}">
			<a href="/Uni_project/controller?command=fac&p=${i}">${i}</a>
			</c:forEach>
			</div>
			</div>
		</div>
</body>
</html>