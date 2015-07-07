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
		<c:choose>
			<c:when  test="${role=='admin'}">
			<%@include file="../menu_admin.jsp" %>
			</c:when>
			<c:when test="${role=='abiturient' }">
			<%@include file="../menu_user.jsp" %>
			</c:when>
			</c:choose>
		<div class="content">
			<h2>
				<fmt:message key="faculty.title" bundle="${rb}" />
			</h2>
			<c:if test="${role=='admin'}">
			<a class="addbutton" href="controller?command=createfac"><fmt:message key="faculty.create" bundle="${rb}" /></a>
			</c:if>
			<c:forEach var="faculty" items="${facList}" begin="">
				<div class="faculty">
					<h3>
						<a href="controller?command=showfac&id=${faculty.id}">${faculty.name}</a>
					</h3>
					<c:choose>
			<c:when  test="${role=='admin'}">
			<a href="controller?command=editfac&id=${faculty.id}"
							class="act"><fmt:message key="faculty.edit" bundle="${rb}" /></a>
						<a href="controller?command=delfac&id=${faculty.id}"
							class="act"><fmt:message key="faculty.delete" bundle="${rb}" /></a>
			</c:when>
			<c:when test="${role=='abiturient' }">
				<fmt:message key="faculty.plan" bundle="${rb}" /> - ${faculty.facultyPlan }<br />
			</c:when>
			</c:choose>
				</div>
			</c:forEach>

			<div class="pages">
				<c:forEach var="i" begin="1" end="${numpage}">
					<a href="controller?command=fac&p=${i}">${i}</a>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
