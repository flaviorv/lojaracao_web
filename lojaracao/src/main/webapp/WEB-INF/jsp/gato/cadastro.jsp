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
		<form action="/gato/incluir" method="post">
			<h1 class="form-group">Cadastre uma nova ração de gato</h1>			
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" value="Ração de Gato 1" class="form-control">
			</div>
			<div class="form-group">
				<label for="codigo">Código:</label>
				<input type="number"  min="0" max="999999" name="codigo" value="11" class="form-control">
			</div>
			<div class="form-group">
				<label for="preco">Preço:</label>
				<input type="number" step="0.01" min="0.01" max="999999" name="preco" value="23" class="form-control">
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
				<label>Gato castrado: </label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="castrado" value="true" class="form-check-input">Sim
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="castrado" value="false" class="form-check-input" checked>Não
					</label>
				</div>
			</div>
			<div class="form-group">
				<label >Sabor:</label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="sabor" value="<%= Constantes.SABOR1 %>" class="form-check-input" checked >
						<%= Constantes.SABOR1 %>
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="sabor" value="<%= Constantes.SABOR2 %>" class="form-check-input" >
						<%= Constantes.SABOR2 %>
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="sabor" value="<%= Constantes.SABOR3 %>" class="form-check-input" >
						<%= Constantes.SABOR3 %>
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