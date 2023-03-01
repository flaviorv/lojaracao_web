<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">	
		<form action="/cliente/incluir" method="post">
			<h1 class="form-group">Cadastre um novo cliente</h1>
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" value="Flavio" class="form-control" id="nome">
			</div>
			<div class="form-group">
				<label for="cpf">Cpf:</label>
				<input type="text" name="cpf" value="123.123.123.123-12" class="form-control" id="cpf">
			</div>
			<div class="form-group">
				<label for="telefone">Telefone:</label>
				<input type="text" name="telefone" value="3211-1233" class="form-control" id="telefone">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
		</form>
	</div>
</body>
</html>