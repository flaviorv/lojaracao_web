<%@ page language="java" import="br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"
 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<form action="" method="get">
		<div class="container">
			<h1 class="form-group">Loja de Ração</h1>
			<% if(FuncionarioRepository.isFuncionarioLogado()){%>
				<h3><%= FuncionarioRepository.getFuncionarioStatus() %></h3>
			<% }else{ %>
				<div>
					<h3 class="form-group">Funcionário:</h3>
					<h2><a href="/cadastro/funcionario">Criar Conta</a></h2>
					<h2><a href="/acesso/funcionario">Acessar Conta</a></h2>	
				</div>
			<% } %>
			
			<div>
				<h3 class="form-group">Listar: </h3>
				<h2><a href="/lista/racao">Todas as rações</a></h2>
				<h2><a href="/lista/ave">Rações de Ave</a></h2>
				<h2><a href="/lista/cao">Rações de Cão</a></h2>
				<h2><a href="/lista/gato">Rações de Gato</a></h2>
				<% if(FuncionarioRepository.isFuncionarioLogado()){%>
					<h2><a href="/lista/cliente">Clientes</a></h2>
				<% }else{ %>
					<h2><a href="/acesso/funcionario">Clientes</a></h2>
				<% } %>
			</div>
			
			<% if(FuncionarioRepository.isFuncionarioLogado()){%>
				<div>
					<h3 class="form-group">Cadastrar: </h3>
					<h2><a href="/cadastro/cliente">Cliente</a></h2>
					<h2><a href="/cadastro/ave">Ave</a></h2>
					<h2><a href="/cadastro/cao">Cão</a></h2>
					<h2><a href="/cadastro/gato">Gato</a></h2>
				</div>
			<% }else{ %>
				<div>
					<h3 class="form-group">Cadastrar: </h3>
					<h2><a href="/acesso/funcionario">Cliente</a></h2>
					<h2><a href="/acesso/funcionario">Ave</a></h2>
					<h2><a href="/acesso/funcionario">Cão</a></h2>
					<h2><a href="/acesso/funcionario">Gato</a></h2>
				</div>					
			<% } %>
		</div>
	</form>
</body>
</html>