<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<title>ADM -:- Productos</title>
</head>
<body>

	<div class="container">
		<h1>Productos</h1>
		<h2>Administración de lista de productos de la tienda</h2>
		
		<form:form action="/producto/crear" method="POST" modelAttribute="producto">
	
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
	
			
			<input type="submit" value="Crear Producto">
		</form:form>
		
		<hr>
		
		
		
		<h1>Lista de Productos</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Código</th>
					<th>Valor</th>
					<th>Stock</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista_productos}" var="producto">
					<tr>
						<td> <c:out value="${producto.id}"/> </td>
						<td> <c:out value="${producto.nombre}"></c:out> </td>
						<td> <c:out value="${producto.codigo}"/> </td>
						<td> <c:out value="${producto.valor}"/> </td>
						<td> <c:out value="${producto.stock}"/> </td>
	
						 <td> 
						 	<a href="/producto/actualizar/${producto.id}">Editar</a>
							<form action="/producto/eliminar" method="POST">
								<input type="hidden" name="id" value="<c:out value="${producto.id}" />">
								<input type="submit" value="Eliminar" >
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>