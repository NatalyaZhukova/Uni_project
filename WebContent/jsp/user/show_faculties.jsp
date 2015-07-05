<%@include file="..\libs.jsp"%>
<jsp:useBean id="facList" class="by.zhukova.uni.entity.Faculty"
	scope="session"></jsp:useBean>
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
		<c:if test="${role=='admin'}">
			<%@include file="../menu_admin.jsp"%>
		</c:if>
		<c:if test="${role=='abiturient' }">
			<%@include file="../menu_user.jsp"%>
		</c:if>
		<div class="content">
			<h2>
				<fmt:message key="faculty.title" bundle="${rb}" />
			</h2>
			<c:if test="${role=='admin'}">
			<a class="addbutton" href="/Uni_project/controller?command=createfac"><fmt:message key="faculty.create" bundle="${rb}" /></a>
			</c:if>
			<c:forEach var="faculty" items="${facList}" begin="">
				<div class="faculty">
					<h3>
						<a href="/Uni_project/controller?command=showfac&id=${faculty.id}">${faculty.name}</a>
					</h3>
					<c:if test="${role=='abiturient' }">
						<fmt:message key="faculty.plan" bundle="${rb}" /> - ${faculty.facultyPlan }<br />
					</c:if>
					<c:if test="${role=='admin'}">
						<a href="/Uni_project/controller?command=editfac?id=${faculty.id}"
							class="act"><fmt:message key="faculty.edit" bundle="${rb}" /></a>
						<a href="/Uni_project/controller?command=delfac?id=${faculty.id}"
							class="act"><fmt:message key="faculty.delete" bundle="${rb}" /></a>
					</c:if>
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