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
			<c:if test="${role=='admin'}">
			<%@include file="../menu_admin.jsp" %>
			</c:if>
			<c:if test="${role=='abiturient' }" >
			<%@include file="../menu_user.jsp" %>
			</c:if>
			<div class="content">
			<div class="register">
				<form action="controller" method="POST">
					<input type="hidden" name="command" value="editfac" /> 
					<input type="hidden" name="id" value="${faculty.id}">
					<label><fmt:message key="faculty.name" bundle="${ rb }" />:</label> 
					<input type="text" name="faculty_name" value="${faculty.name}" required> 
					<label><fmt:message key="faculty.plan" bundle="${ rb }" /></label>: 
					<input type="text" name="faculty_plan" pattern="\d{1,3}" value="${faculty.facultyPlan}" required> <label>
					<fmt:message key="faculty.disciplines" bundle="${ rb }" /></label> 
					
					<select name="disc1">
					<option value="${discList[faculty.firstDiscipline-1].id}" selected>${discList[faculty.firstDiscipline-1].name}</option>
					<c:if test="${faculty.firstDiscipline==1}" > 
					<c:forEach var="discipline" items="${discList}" begin="0" end="${faculty.firstDiscipline-1}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</c:if>
					<c:if test="${faculty.firstDiscipline!=1}">
					    <c:forEach var="discipline" items="${discList}" begin="0" end="${faculty.firstDiscipline-2}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
						</c:if>
						<c:forEach var="discipline" items="${discList}" begin="${faculty.firstDiscipline}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</select> 
					
					
					<select name="disc2">
						<option value="${discList[faculty.secondDiscipline-1].id}" selected>${discList[faculty.secondDiscipline-1].name}</option>
					<c:if test="${faculty.secondDiscipline==1}" > 
					<c:forEach var="discipline" items="${discList}" begin="0" end="${faculty.secondtDiscipline-1}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</c:if>
					<c:if test="${faculty.secondDiscipline!=1}">
					    <c:forEach var="discipline" items="${discList}" begin="0" end="${faculty.secondDiscipline-2}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
						</c:if>
						<c:forEach var="discipline" items="${discList}" begin="${faculty.secondDiscipline}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</select> 
					 
					
					<select name="disc3">
						<option value="${discList[faculty.thirdDiscipline-1].id}" selected>${discList[faculty.thirdDiscipline-1].name}</option>
					<c:if test="${faculty.thirdDiscipline==1}" > 
					<c:forEach var="discipline" items="${discList}" begin="0" end="${faculty.thirdDiscipline-1}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</c:if>
					<c:if test="${faculty.thirdDiscipline!=1}">
					    <c:forEach var="discipline" items="${discList}" begin="0" end="${faculty.thirdDiscipline-2}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
						</c:if>
						<c:forEach var="discipline" items="${discList}" begin="${faculty.thirdDiscipline}">
							<option value="${discipline.id}">${discipline.name}</option>
						</c:forEach>
					</select> 
					
					<input type="submit" value="<fmt:message key="faculty.save" bundle="${ rb }" />"
						id="submit"> <br> <span class="error">${errorMessage}</span>
			
			</form>
			</div>
		 
			</div>
		</div>
</body>
</html>