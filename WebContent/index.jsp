<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Curso jsp</title>
	</head>
	<body>
		Bem vindo ao curso jsp /- 
		
		<%
		out.print("Bem vindo ao curso jsp");
		%>
		
		<form action="receber-nome.jsp" >
		<input name="nome">
		<input name="idade">
		<input type="submit" value="Enviar">
		</form>
	</body>
</html>