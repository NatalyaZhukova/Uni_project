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
			<div class="menu">
			<h2><fmt:message key="usermain.menu" bundle="${rb}" /></h2>
			<ul>
			<li><a href="/Uni_project/controller?command=fac"><fmt:message key="usermain.fac_list" bundle="${rb}" /></a></li>
			<c:if test="${application==null}">
			<li><a href="/Uni_project/controller?command=chfac"><fmt:message key="usermain.register_fac" bundle="${rb}" /></a></li>
			</c:if>
			<c:if test="${application!=null}">
			<li><a href="/Uni_project/controller?command=applic"><fmt:message key="usermain.application" bundle="${rb}" /></a></li>
			</c:if>
			</ul>		
			</div>
			<div class="content">
		      	<h2>Факультеты</h2>
				
			<c:forEach var="faculty" items="${facList}" begin="">
			<div class="faculty">
			<h3>${faculty.name}</h3>
			<span class="">Подано заявлений / План приема - </span> <span class="applic-num">4/15</span>
			<h4>Сдаваемые дисциплины:</h4>
			<ul>
			<li>дисциплина 1</li>
			<li>дисциплина 2</li>
			<li>дисциплина 3</li>
			</ul>
			</div>
			</c:forEach>
			
			<div class="pages">
			<c:forEach var="i" begin="1" end="${numpage}">
			<a href="/Uni_project/controller?command=showfac&p=${i}">$i</a>
			</c:forEach>
			</div>
			</div>
		</div>
</body>
</html>