<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asignar Hobby</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	
	<div class="container">
		<h1> ${usuario.firstName} ${usuario.lastName} </h1>
		<h2>Mis Hobbies</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Hobby</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hobby" items="${usuario.hobbies}">
					<tr>
						<td> ${hobby.name}</td>
						<td> 
							<form action="/deleteHobby" method="post" >
								<input type="hidden" name="user_id" value="${usuario.id}">
								<input type="hidden" name="hobby_id" value="${hobby.id}">
								<input type="submit" value="Quitar Hobby" class="btn btn-danger">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>Todos los Hobbies Que no tengo</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Hobby</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hobby" items="${hobbiesNoPertenece}">
					<tr>
						<td> ${hobby.name}</td>
						<td> 
							<form action="/assignHobby" method="post" >
								<input type="hidden" name="user_id" value="${usuario.id}">
								<input type="hidden" name="hobby_id" value="${hobby.id}">
								<input type="submit" value="Agregar Hobby" class="btn btn-primary">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>