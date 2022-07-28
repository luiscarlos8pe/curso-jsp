<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Curso jsp</title>
	</head>
	<body>
		<h1>Bem vindo ao curso jsp </h1>
		
		<!-- <%
		out.print("Bem vindo ao curso jsp");
		%>*/ -->
		
		<form action="ServletLogin" method="post">
		<table>
			<tr>
				<td><label>Login:</label></td>
				<td><input name="login" type="text"></td>
			</tr>
			<tr>
				<td><label>Senha:</label></td>
			    <td><input name="senha" type="password"></td>
			</tr>
			<tr>
				<td></td>
			    <td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
		</form>
		
		<h4>${msg}</h4>
	</body>
</html>