<%@include file="../libs.jsp"%>
<jsp:useBean id="abiturients" class="by.zhukova.uni.entity.Abiturient" scope="session" ></jsp:useBean>
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
			
			<hr>
			<c:if test="${not empty message }">
			<fmt:message key="${message }" bundle="${rb }" />
			</c:if>
			<c:forEach var="abiturient" items="${abiturients}"  varStatus="status">
			<div class="abiturient">
			<span class="fio">
			<c:out value="${status.count}."></c:out>
			<a href="/Uni_project/controller?command=showabitur&id=${abiturient.id}">
			<c:out value=" ${abiturient.firstName} ${abiturient.middleName} ${abiturient.lastName } " /></a></span>
			
			</div>
			</c:forEach>
			
			<div class="pages">
				<c:forEach var="i" begin="1" end="${numpage}">
					<a href="controller?command=abitur&stat=${status}&p=${i}">${i}</a>
				</c:forEach>
			</div>
			</div>
			
			</div>
		</div>
		
		<ctg:footer />
	</body>
</html>
