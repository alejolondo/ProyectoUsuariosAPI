<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Boot </title>
<link rel= "stylesheet" href="/css/style.css">
</head>
<body>
	
	<h1> <c:out value="${titulo }"/></h1>
	
	<h2>Hobbies</h2>
	
	<ul>
		<c:forEach  var="hobby" items="${hobbies}" > 
		 	<li> <c:out value="${hobby}"> </c:out> </li>
		</c:forEach>
	</ul>
	
	<h2>Paises</h2>
	<ol>
		<c:forEach var="pais" items="${countries}">
			<li> <c:out value="${pais.key }"/> - <c:out value="${pais.value}"/></li>
		</c:forEach>
	</ol>
	
	<h2>Usuarios</h1>
	
	<c:forEach var="user" items="${usuarios}">
		<h3> <c:out value="${user.name}"></c:out></h3>
		<h4> <c:out value="${user.lastName }"></c:out></h2>
	</c:forEach>
	
</body>
</html>