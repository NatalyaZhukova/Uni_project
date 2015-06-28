<%@include file="..\libs.jsp"%>
<!DOCTYPE html>
<jsp:useBean id="disciplines" class="by.zhukova.uni.entity.Discipline"
	scope="session"></jsp:useBean>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css\styles.css">
<title><fmt:message key="header.title" bundle="${rb}" /></title>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />

</head>
<body>

	<%@include file="..\header.jsp"%>
	<div class="choosefaculty">
		<form action="controller" method="POST">
			<input type="hidden" name="command" value="addscores" /> 
			<input type="hidden" name="first_name" value="${fName}"> 
			<input type="hidden" name="middle_name" value="${mName}"> 
			<input type="hidden" name="last_name" value="${lName}"> 
			<input type="hidden" name="faculty" value="${faculty}"> 
			<input type="hidden" name="faculty_name" value="${faculty_name}"> 
				${fName } ${mName } ${lName } ${faculty}
			<h2>
				${faculty_name}
			</h2>
			<br>
			<fmt:message key="scores.message" bundle="${rb}" />
			<br /> <br /> <label>${disciplines[0].name}:</label> <input
				type="text" name="disc1" pattern="([0-9]{1,2})|(100)"
				title="<fmt:message key="validation.test_score" bundle="${rb}" />"
				required><br /> <label>${disciplines[1].name}:</label> <input
				type="text" name="disc2" pattern="([0-9]{1,2})|(100)"
				title="<fmt:message key="validation.test_score" bundle="${rb}" />"
				required><br /> <label>${disciplines[2].name}:</label> <input
				type="text" name="disc3" pattern="([0-9]{1,2})|(100)"
				title="<fmt:message key="validation.test_score" bundle="${rb}" />"
				required><br /> <label><fmt:message
					key="scores.school" bundle="${rb}" />:</label><input type="text"
				name="school" pattern="(\d.\d)|(10.0)"
				title="<fmt:message key="validation.school_score" bundle="${rb}" />"
				required><br /> <br> <input type="submit"
				value="<fmt:message key="scores.submit" bundle="${rb}" />"><br />
				${errorMessage}
		</form>
	</div>
     <div>
     Путь к контексту : ${ pageContext.request.contextPath } <br/>
   Имя хоста : ${ header["host"] }<br/>
   Тип и кодировка контента : ${pageContext.response.contentType}<br/>
   Кодировка ответа : ${pageContext.response.characterEncoding}<br/>
   ID сессии : ${pageContext.request.session.id}<br/>
   Время создания сессии в мсек : ${pageContext.request.session.creationTime}<br/>
   Время последнего доступа к сессии : ${pageContext.request.session.lastAccessedTime}<br/> 
   Имя сервлета : ${pageContext.servletConfig.servletName}
    </div>
</body>
</html>