<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Произошла ошибка</title>
</head>
<body>
 Request from ${pageContext.errorData.requestURI} is failed
  <br/>
  Servlet name : <c:out value="${pageContext.errorData.servletName }"></c:out>
  ${pageContext.errorData.servletName}
  <br/>
  Status code : ${pageContext.errorData.statusCode}
  <br/>
  Exception: ${pageContext.exception}
  <br/>
    Message from exception: ${pageContext.exception.message}

</body>
</html>