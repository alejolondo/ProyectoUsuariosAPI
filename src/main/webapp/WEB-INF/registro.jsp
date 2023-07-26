<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class= "container">
		<div class="row">
			<div class= "col-4">
				<h1>Crear Usuario</h1>
				<form action="/registrarUsuario" method="post">
					<div class="form-group">
						<label>Nombre: </label>
						<input type="text" name="nombre" class="form-control" />
					</div>
					<div class="form-group">
						<label>Email: </label>
						<input type="email" name="email" class="form-control" />
					</div>
					<input type="submit" value="Crear Usuario" class="btn btn-success">
				</form>
				<div class="text-danger">
					<c:out value="${Error }"></c:out>
				</div>
			</div>
		</div>
	</div>
</body>
</html>