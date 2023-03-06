<%@ page language="java" contentType="text/html; charset=UTF-8" import="br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Loja de Ração - Acesso</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<h1><%= FuncionarioRepository.getFuncionarioStatus() %></h1>
		<form action="/funcionario/validar" method="post">
		    <div class="form-group">
		      <label for="email">Email:</label>
		      <input type="text" class="form-control" id="email" placeholder="Insira seu email" name="email">
		    </div>
		    <div class="form-group">
		      <label for="senha">Senha:</label>
		      <input type="password" class="form-control" id="senha" placeholder="Insira sua senha" name="senha">
		    </div>
		    <button type="submit" class="btn btn-primary">Acessar Conta</button>
		</form>
		<div class="form-group">
			<a href="/cadastro/funcionario" ><button class="btn btn-primary">Novo Funcionario</button></a>
		</div>
	</div>
</body>
</html>