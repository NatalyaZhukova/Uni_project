<%@include file="..\libs.jsp"%>
<jsp:useBean id="discList" class="by.zhukova.uni.entity.Discipline"
	scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" >
$(document).ready(function(){
	$('#createfac').submit(function(){
		 var disc1 = $('select[name=disc1]').val();
		 var disc2 = $('select[name=disc2]').val();
		 var disc3 = $('select[name=disc3]').val();
		 if ((disc1==disc2) || (disc1==disc3) || (disc2==disc3)) {
			 $('#submit').after('<br/><span class="error"><fmt:message key="validation.no_repeat" bundle="${ rb }" /></span>');
		     return false;}

	});
});
</script>
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
				<form action="controller" method="POST" id="createfac">
					<input type="hidden" name="command" value="createfac" /> <label><fmt:message
							key="faculty.name" bundle="${ rb }" />:</label> <input type="text"
						name="faculty_name" pattern="[\u0410-\u042F\u0401\][\u0430-\u044F\u0451]{1,20}" 
						title="<fmt:message key="validation.rus" bundle="${rb}" />"
						required> <label><fmt:message
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
						id="submit"> <br> 
						<c:if test="${not empty errorMessage }">
						<span class="error"><fmt:message key="${errorMessage}" bundle="${rb }" /></span>
						</c:if>
			
			</form>
			</div>

		</div>
	</div>
	<ctg:footer />
</body>
</html>