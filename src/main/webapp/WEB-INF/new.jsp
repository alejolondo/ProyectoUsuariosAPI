

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
      
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<form:form action="/create" method="post" modelAttribute="usuario"> 
			<h1>Nuevo Usuario</h1>
			
			<div class="form-group">
			
			<form:label path="firstName">Nombre:</form:label>
			<form:input path="firstName" class="form-control" />
			<form:errors path="firstName" class="text-danger" />
			
			</div>
			
			<div class="form-group">
			
			<form:label path="lastName">Apellido:</form:label>
			<form:input path="lastName" class="form-control" />
			<form:errors path="lastName" class="text-danger" />
			
			</div>
			
			<div class="form-group">
			
			<form:label path="email">email:</form:label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
			
			</div>
			
			<div class="form-group">
			
			<form:label path="password">password:</form:label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
			
			</div>
			
			<div class="form-group">
			<form:label path="salon">Salon:</form:label>
			<form:select path="salon" class="form-select">
				<c:forEach var="salon" items="${salones}">
				<option value=${salon.id}>${salon.name}</option> 
					
				</c:forEach>
			</form:select>
			<form:errors path="salon" class="text-danger" />
			</div>
			<input type="submit" value="Guardar" class="btn btn-success" />
		</form:form>
	</div>

</body>
</html>