<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salón</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		
		<h1 clas= "tex-primary"> <c:out value="${salon.name}"></c:out> </h1>
		
		<ul>
			<c:forEach var="usuario" items="${salon.usuarios}">
				<li> <c:out value="${usuario.firstName}"></c:out> </li>
			</c:forEach>
		
		</ul>
	</div>
</body>
</html>