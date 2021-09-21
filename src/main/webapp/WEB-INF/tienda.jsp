<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<title>Tienda - Revisa nuestros productos</title>
</head>
<body>
	
	<div class="container"><!-- Container general -->
	
		<h1>Tienda</h1>
		
		<h2>Bienvenido <strong><%= session.getAttribute("user") %></strong></h2>
		<a href="/logout">Cerrar Sesion</a>
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
						 	<a class="btn btn-primary" href="/carrito/${id_carrito}/agregar/${producto.id}">Agregar a Carrito</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<hr>
		<h1>Productos en Carrito (Total:  <c:out value="${cantidad_carrito}"/> ) </h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Código</th>
					<th>Valor</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
	
				<c:forEach items="${lista_carrito}" var="producto_carro">
				<tr>
					<td> <c:out value="${producto_carro.id}"></c:out></td>
					<td> <c:out value="${producto_carro.producto.nombre}"></c:out> </td>
					<td> <c:out value="${producto_carro.producto.codigo}"/> </td>
					<td> <c:out value="${producto_carro.producto.valor}"/> </td>
					<td> 
						<a class="btn btn-primary" href="/carrito/${id_carrito}/agregar/${producto_carro.producto.id}">Agregar a Carrito</a>
						<a class="btn btn-danger" href="/carrito/eliminar/${producto_carro.id}">Eliminar</a>
					</td>
						
				</tr>
	
			</c:forEach>
			</tbody>
		</table>
		<h2> Valor total : $ <c:out value="${carrito.valor_total}"></c:out> </h2>
		
	</div><!-- Fin Container -->
	
	
</body>
</html>