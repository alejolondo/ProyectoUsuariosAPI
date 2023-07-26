<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
		<h1> ¡Bienvenid@! <c:out value="${name}"/>  </h1>
		<a href="/new" class="btn btn-success">Agregar Usuario</a>
		</header>
		
		
		<table class="table table-hover">
			<thead>
				<tr>
				 	<th>Nombre</th>
				 	<th>Apellido</th>
				 	<th>Email</th>
				 	<th>Salón</th>
				 	<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
					 	<td><c:out value="${usuario.firstName}"/> </td>
					 	<td><c:out value="${usuario.lastName}"/> </td>
					 	<td><c:out value="${usuario.email}"/> </td>
					 	<td><c:out value="${usuario.salon.name}"/> </td>
					 	<td> 
					 		<a href="/edit/${usuario.id }" class="btn btn-warning">Editar</a>
					 		<form action="/delete/${usuario.id }" method="post">
					 			<input type="hidden" name="_method" value="DELETE">
					 			<input type="submit" value="Borar" class="btn btn-danger">
					 		</form>
					 		<a href="/asignar/${usuario.id}" class="btn btn-info">Asignar Hobbies</a>
					 	</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<h2 class="text-primary">Usuarios sin salón</h2>
		
		<table class="table table-hover">
			<thead>
				<tr>
				 	<th>Nombre</th>
				 	<th>Apellido</th>
				 	<th>Email</th>
				 	<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuariosSinSalon}">
					<tr>
					 	<td><c:out value="${usuario.firstName}"/> </td>
					 	<td><c:out value="${usuario.lastName}"/> </td>
					 	<td><c:out value="${usuario.email}"/> </td>
					 	<td> 
					 		<a href="/edit/${usuario.id }" class="btn btn-warning">Editar</a>
					 		<form action="/delete/${usuario.id }" method="post">
					 			<input type="hidden" name="_method" value="DELETE">
					 			<input type="submit" value="Borar" class="btn btn-danger">
					 		</form>
					 	</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	
</body>
</html>