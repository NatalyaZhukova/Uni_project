<%@include file="..\libs.jsp"%>
<jsp:useBean id="discList" class="by.zhukova.uni.entity.Discipline"
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
			<div class="register">
				<form action="controller" method="POST">
					<input type="hidden" name="command" value="createfac" /> <label><fmt:message
							key="faculty.name" bundle="${ rb }" />:</label> <input type="text"
						name="faculty_name" required> <label><fmt:message
							key="faculty.plan" bundle="${ rb }" /></label>: <input type="text"
						name="faculty_plan" pattern="\d{1,3}" required> <label><fmt:message
							key="faculty.disciplines" bundle="${ rb }" /></label> <select
						name="disc1">
						<c:forEach var="discipline" items="${discList}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</select> <select name="disc2">
						<c:forEach var="discipline" items="${discList}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</select> <select name="disc3">
						<c:forEach var="discipline" items="${discList}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</select> <input type="submit"
						value="<fmt:message key="faculty.add" bundle="${ rb }" />"
						id="submit"> <br> <span class="error">${errorMessage}</span>
			
			</form>
			</div>

		</div>
	</div>
</body>
</html>