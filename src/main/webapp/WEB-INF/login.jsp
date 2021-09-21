<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<title>Iniciar Sesión</title>
</head>
<body>

	<div class="container">
		
		<c:if test="${not empty mensaje}">
			<div class="alert alert-primary" role="alert">
				<c:out value="${mensaje}"/>
			</div>
		</c:if>
		<form action="/ingresar" method="post">
			<br>
			<label for="usuario">Usuario</label>
			<input type="text" id="usuario" name="usuario"/>
			<br>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password"/>
	
			<br>
			<input type="submit" value="Login">
			<a href="/registro">Registrarse</a>
		</form>
	</div>
</body>
</html>