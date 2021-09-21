<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Producto</title>
</head>
<body>
	
	<!-- -->
		
	<form:form action="/producto/modificar" method="POST" modelAttribute="producto">
		<input type="hidden" name="_method" value="PUT"> 
		<form:hidden path="id"/>
		<form:label path="nombre">Nombre</form:label>
		<form:input type="text" path="nombre"/>
		<br>
		<form:label path="codigo">Codigo</form:label>
		<form:input type="text"	path="codigo"/>
		<br>
		<form:label path="valor">Valor</form:label>
		<form:input type="text"	path="valor"/>
		<br>
		<form:label path="stock">Stock</form:label>
		<form:input type="text"	path="stock"/>
		<br>
		
		<br>

		<input type="submit" value="Actualizar Producto">
	</form:form>
</body>
</html>