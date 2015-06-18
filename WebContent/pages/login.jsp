<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="css\styles.css">
	</head>
	
	<body>
		<div class="login">
			<form action="Login" method="POST">
			<label>Имя пользователя:</label><br>
			<input type="text" name="username"> <br>
			<label>Пароль:</label><br>
			<input type="password" name="password"> <br>
			<input type="submit" value="Войти"> <br>
			
			
			
			</form>
		</div>
	</body>
</html>