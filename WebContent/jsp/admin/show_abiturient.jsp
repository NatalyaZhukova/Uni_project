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
		
			<div class="status"><fmt:message key="status.status" bundle="${rb}" />: <span>${statusText}</span></div>
			<form action="controller">
			<input type="hidden" name="command" value="changestat">
			<input type="hidden" value="${abiturient.id }" name="application_id">
			<select name="status">
			<c:choose>
			<c:when test="${status=='approved'}">
			<option value="2">${statusList[1]}</option>
			<option value="3">${statusList[2]} </option>
			</c:when>
			<c:when test="${status=='waiting'}">
				<option value="1">${statusList[0]}</option>
			<option value="3">${statusList[2]} </option>
			</c:when>
			<c:when test="${status=='denied'}">
				<option value="2">${statusList[1]}</option>
			<option value="1">${statusList[0]} </option>
			</c:when>
			</c:choose>
			</select>
			<input type="submit" value="<fmt:message key="status.change" bundle="${rb}" />">
			</form>
			</div>
			
			</div>
		</div>
</body>
</html>
