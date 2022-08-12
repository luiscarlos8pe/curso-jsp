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
		
		<h4 class="msg">${msg}</h4>
		
		<form action="ServletLogin" method="post" class="row g-3 needs-validation" novalidate>
		<input type="hidden" value="<%= request.getParameter("url") %>" name="url">
		
			<div class="col-md-6">
				<label class="form-label" >Login:</label>
				<input class="form-control" name="login" type="text" required="required">
				 <div class="invalid-feedback">
      				Obrigatorio.
    			</div>
    			<div class="valid-feedback">
      				ok.
    			</div>
			</div>
			<div class="col-md-6">
				<label class="form-label">Senha:</label>
			    <input class="form-control"  name="senha" type="password"  required="required">
			    <div class="invalid-feedback">
      				Obrigatorio.
    			</div>
    			<div class="valid-feedback">
      				ok.
    			</div>
			</div>
			<div class="col-12">
			      <button class="btn btn-primary" type="submit" >Acessar</button>
			</div>
		
		</form>
		
		
		
		 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
		 
		 <script type="text/javascript">
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		 (function () {
		   'use strict'

		   // Fetch all the forms we want to apply custom Bootstrap validation styles to
		   var forms = document.querySelectorAll('.needs-validation')

		   // Loop over them and prevent submission
		   Array.prototype.slice.call(forms)
		     .forEach(function (form) {
		       form.addEventListener('submit', function (event) {
		         if (!form.checkValidity()) {
		           event.preventDefault()
		           event.stopPropagation()
		         }

		         form.classList.add('was-validated')
		       }, false)
		     })
		 })()
		 
		 </script>
	</body>
</html>