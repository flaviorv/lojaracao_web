<%@ page language="java" import="br.edu.infnet.lojaracao.model.auxiliary.Constantes" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração - Cadastro</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">	
		<form action="/cao/incluir" method="post">
			<h1 class="form-group">Cadastre uma nova ração de cão</h1>			
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" value="Ração de Cachorro 1" class="form-control">
			</div>
			<div class="form-group">
				<label for="codigo">Código:</label>
				<input type="number"  min="0" max="999999" name="codigo" value="1108" class="form-control">
			</div>
			<div class="form-group">
				<label for="preco">Preço:</label>
				<input type="number" step="0.01" min="0.01" max="999999" name="preco" value="21" class="form-control">
			</div>
			<div class="form-group">
				<label>Para Filhotes: </label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="filhotes" value="true" class="form-check-input">Sim
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="filhotes" value="false" class="form-check-input" checked>Não
					</label>
				</div>
			</div>
			<div class="form-group">
				<label>Sem Corante: </label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="semCorante" value="true" class="form-check-input">Sim
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="semCorante" value="false" class="form-check-input" checked>Não
					</label>
				</div>
			</div>
			<div class="form-group">
				<label >Porte:</label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="porte" value="<%= Constantes.PORTE1 %>" class="form-check-input" checked >
						<%= Constantes.PORTE1 %>
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="porte" value="<%= Constantes.PORTE2 %>" class="form-check-input" >
						<%= Constantes.PORTE2 %>
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="porte" value="<%= Constantes.PORTE3 %>" class="form-check-input" >
						<%= Constantes.PORTE3 %>
					</label>
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
		</form>
	</div>
</body>
</html>