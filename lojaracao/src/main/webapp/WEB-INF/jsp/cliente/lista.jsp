<%@ page language="java" 
import="br.edu.infnet.lojaracao.model.repository.ClienteRepository, br.edu.infnet.lojaracao.model.domain.Cliente"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Loja de Ração - Lista</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="form-group">
			<h1>Lista de Clientes</h1>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="table-info">Nome</th>
						<th class="table-info">Cpf</th>
						<th class="table-info">Telefone</th>
					</tr>
				</thead>
				<tbody>
					<%for(Cliente lista: ClienteRepository.obterLista()){%>
				 		<tr>
				 			<td><%= lista.getNome() %></td>
				 			<td><%= lista.getCpf() %></td>
				 			<td><%= lista.getTelefone() %></td>
				 		</tr>
					<%}%>
				</tbody>
			</table>
		</div>
		<div class="form-group">
			<a href="/cadastro/cliente" ><button class="btn btn-primary">Novo Cliente</button></a>
			<a href="/" ><button class="btn btn-primary">Página inicial</button></a>
		</div>
	</div>
</body>
</html>