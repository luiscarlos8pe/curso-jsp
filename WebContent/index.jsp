<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		 
		 <!-- Bootstrap CSS -->
		  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<title>Curso jsp</title>
		
		<style type="text/css">
			form{
			position: absolute;
			top: 40%;
			left: 30%;
			}
			
			h2{
			position: absolute;
			top: 30%;
			left: 36%;
			}
			
			.msg{
			position: absolute;
			top: 70%;
			left: 33%;
			}
		</style>
	</head>
	<body>
		<h2>Bem vindo ao curso jsp </h2>
		
		
		
		<form action="ServletLogin" method="post" class="row g-3">
		<input type="hidden" value="<%= request.getParameter("url") %>" name="url">
		
			<div class="col-md-6">
				<label class="form-label" >Login:</label>
				<input class="form-control" name="login" type="text">
			</div>
			<div class="col-md-6">
				<label class="form-label">Senha:</label>
			    <input class="form-control"  name="senha" type="password">
			</div>
			<div class="col-12">
			      <button class="btn btn-primary" type="submit" >Acessar</button>
			</div>
		
		</form>
		
		<h4 class="msg">${msg}</h4>
		
		 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</body>
</html>